package intermediate.generator;

import frontend.GodFatherBaseVisitor;
import frontend.GodFatherParser;
import intermediate.inter.*;
import intermediate.lexer.*;
import intermediate.lexer.Number;
import intermediate.symbol.Environment;
import intermediate.symbol.Type;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * This class extends GodFatherBaseVisitor class. It will read the parse tree and generate corresponding
 * intermediate code during visiting each grammar node.
 */
public class InterCodeGenerator extends GodFatherBaseVisitor<Node> {
    private Environment env;
    private ReserveSymbolTable wordsTable;

    /**
     * Init global environment and symbol table
     */
    public InterCodeGenerator() {
        env = new Environment();
        wordsTable = new ReserveSymbolTable();
    }

    /**
     * Provide the Parse Tree and file name. It will generate the .inter file with the same path
     * with your source code
     * @param pt
     * @param fileName
     * @throws FileNotFoundException
     */
    public void printIntermediateCode(ParseTree pt, String fileName) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName + ".inter");
        Statement statements = (Statement) visit(pt);
        int begin = statements.newLabel();
        int end = statements.newLabel();
        statements.printLabel(begin, writer);
        statements.generateInterCode(begin, end, writer);
        statements.printLabel(end, writer);
        writer.flush();
        writer.close();
    }

    /**
     * Visit 'Program' node on parse tree.
     * It will firstly visit Decls part and then get statements linked list later.
     * @param ctx
     * @return
     */
    @Override
    public Node visitProgram(GodFatherParser.ProgramContext ctx) {
        visitDecls(ctx.decls());
        Statement statements = (Statement) visitStmts(ctx.stmts());
        return statements;
    }

    /**
     * Add all declared identifiers to global env
     * @param ctx
     * @return
     */
    @Override
    public Node visitDecls(GodFatherParser.DeclsContext ctx) {
        for (GodFatherParser.DeclContext decl : ctx.decl()) {
            visitDecl(decl);
        }

        return super.visitDecls(ctx);
    }

    /**
     * Visit each decl statement and add it in to env
     * @param ctx
     * @return
     */
    @Override
    public Node visitDecl(GodFatherParser.DeclContext ctx) {
        String typeName = ctx.type.getText();
        String identifier = ctx.ID().getText();
        Type p;
        if (typeName.equals("int")) {
            p = Type.Int;
        } else {
            p = Type.Bool;
        }


        Word idWord = wordsTable.get(identifier);
        if (idWord == null) {
            idWord = new Word(identifier, Tag.ID);
            wordsTable.reserve(idWord);
        }

        env.put(idWord, new Expression(idWord, p));
        return super.visitDecl(ctx);
    }

    /**
     * Link two statements
     * @param s1
     * @param s2
     * @return
     */
    private Statement linkStatements(Statement s1, Statement s2) {
        if (s1 == null) {
            return s2;
        } else {
            return new Sequence(s1, s2);
        }
    }

    /**
     * Throw exception (e.g. Undeclared Exception)
     * @param str
     */
    private void error(String str) {
        throw new Error(str);
    }

    /**
     * Visit Stmts Parse Tree node.
     * It will visit each specific stmt node iteratively.
     * @param ctx
     * @return
     */
    @Override
    public Node visitStmts(GodFatherParser.StmtsContext ctx) {
        Statement head = null;
        for (GodFatherParser.StmtContext stmt : ctx.stmt()) {
            if (stmt instanceof GodFatherParser.StmtArithAssignContext) {
                head = linkStatements(head, (Statement) visitStmtArithAssign((GodFatherParser.StmtArithAssignContext) stmt));
                continue;
            }

            if (stmt instanceof GodFatherParser.StmtBoolAssignContext) {
                head = linkStatements(head, (Statement) visitStmtBoolAssign((GodFatherParser.StmtBoolAssignContext) stmt));
                continue;
            }

            if (stmt instanceof GodFatherParser.StmtIfContext) {
                head = linkStatements(head, (Statement) visitStmtIf((GodFatherParser.StmtIfContext) stmt));
                continue;
            }

            if (stmt instanceof GodFatherParser.StmtIfElseContext) {
                head = linkStatements(head, (Statement) visitStmtIfElse((GodFatherParser.StmtIfElseContext) stmt));
                continue;
            }

            if (stmt instanceof GodFatherParser.StmtWhileContext) {
                head = linkStatements(head, (Statement) visitStmtWhile((GodFatherParser.StmtWhileContext) stmt));
                continue;
            }

            if (stmt instanceof GodFatherParser.StmtPrintContext) {
                head = linkStatements(head, (Statement) visitStmtPrint((GodFatherParser.StmtPrintContext) stmt));
            }

        }

        return head;
    }

    /**
     * Process Arithmetic node.
     * @param ctx
     * @return
     */
    @Override
    public Node visitStmtArithAssign(GodFatherParser.StmtArithAssignContext ctx) {
        String idStr = ctx.ID().getText();
        Word idWord = wordsTable.get(idStr);
        Expression id = env.getId(idWord);
        if (id == null) {
            error(idStr + " undeclared");
        }

        return new Assign(id, (Expression) visitArith_expr(ctx.arith_expr()));
    }

    /**
     * Process bool assignment node
     * @param ctx
     * @return
     */
    @Override
    public Node visitStmtBoolAssign(GodFatherParser.StmtBoolAssignContext ctx) {
        String idStr = ctx.ID().getText();
        Word idWord = wordsTable.get(idStr);
        Expression id = env.getId(idWord);
        if (id == null) {
            error(idStr + " undeclared");
        }

        if (ctx.bool_expr() instanceof GodFatherParser.BoolExprCmpContext) {
            return new Assign(id, (Expression) visitBoolExprCmp((GodFatherParser.BoolExprCmpContext) ctx.bool_expr()));
        } else {
            return new Assign(id, (Expression) visitBoolExprValue((GodFatherParser.BoolExprValueContext) ctx.bool_expr()));
        }

    }


    /**
     * process if control flow node
     * @param ctx
     * @return
     */
    @Override
    public Node visitStmtIf(GodFatherParser.StmtIfContext ctx) {
        Expression condition;
        if (ctx.bool_expr() instanceof GodFatherParser.BoolExprValueContext) {
            condition = (Expression) visitBoolExprValue((GodFatherParser.BoolExprValueContext) ctx.bool_expr());
        } else {
            condition = (Expression) visitBoolExprCmp((GodFatherParser.BoolExprCmpContext) ctx.bool_expr());
        }

        Statement trueStatement = (Statement) visitStmts(ctx.stmts());
        return new If(condition, trueStatement);
    }

    /**
     * Process if + else control flow node
     * @param ctx
     * @return
     */
    @Override
    public Node visitStmtIfElse(GodFatherParser.StmtIfElseContext ctx) {
        Expression condition;
        if (ctx.bool_expr() instanceof GodFatherParser.BoolExprValueContext) {
            condition = (Expression) visitBoolExprValue((GodFatherParser.BoolExprValueContext) ctx.bool_expr());
        } else {
            condition = (Expression) visitBoolExprCmp((GodFatherParser.BoolExprCmpContext) ctx.bool_expr());
        }

        Statement trueStatement = (Statement) visitStmts(ctx.stmts(0));
        Statement falseStatement = (Statement) visitStmts(ctx.stmts(1));
        return new Else(condition, trueStatement, falseStatement);
    }

    /**
     * Process while loop node
     * @param ctx
     * @return
     */
    @Override
    public Node visitStmtWhile(GodFatherParser.StmtWhileContext ctx) {
        While whileNode = new While();
        Statement savedStatement = Statement.enclosing;
        Statement.enclosing = whileNode;

        Expression condition;
        if (ctx.bool_expr() instanceof GodFatherParser.BoolExprValueContext) {
            condition = (Expression) visitBoolExprValue((GodFatherParser.BoolExprValueContext) ctx.bool_expr());
        } else {
            condition = (Expression) visitBoolExprCmp((GodFatherParser.BoolExprCmpContext) ctx.bool_expr());
        }

        Statement trueStatement = (Statement) visitStmts(ctx.stmts());
        whileNode.configLoop(condition, trueStatement);
        Statement.enclosing = savedStatement;
        return whileNode;
    }

    /**
     * Process print node
     * @param ctx
     * @return
     */
    @Override
    public Node visitStmtPrint(GodFatherParser.StmtPrintContext ctx) {
        Expression printBody = (Expression) visitArith_expr(ctx.arith_expr());
        return new Print(printBody);
    }

    /**
     * Process bool expression compare node
     * @param ctx
     * @return
     */
    @Override
    public Node visitBoolExprCmp(GodFatherParser.BoolExprCmpContext ctx) {
        Expression leftExpr = (Expression) visitArith_expr(ctx.arith_expr(0));
        Token op;
        switch (ctx.op.getText()) {
            default:
            case "==":
                op = Word.eq;
                break;
            case "!=":
                op = Word.ne;
                break;
            case "<":
                op = Word.lt;
                break;
            case "<=":
                op = Word.le;
                break;
            case ">":
                op = Word.gt;
                break;
            case ">=":
                op = Word.ge;
                break;
        }

        return new Relation(op, leftExpr, (Expression) visitArith_expr(ctx.arith_expr(1)));
    }

    /**
     * Process bool constant value node
     * @param ctx
     * @return
     */
    @Override
    public Node visitBoolExprValue(GodFatherParser.BoolExprValueContext ctx) {
        if (ctx.value.getText().equals("true")) {
            return Constant.True;
        } else {
            return Constant.False;
        }

    }

    /**
     * Process Arithmetic expression node (Priority: + and -)
     * @param ctx
     * @return
     */
    @Override
    public Node visitArith_expr(GodFatherParser.Arith_exprContext ctx) {
        Expression expr = (Expression) visitTerm(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            ParseTree opNode = ctx.getChild(i * 2 - 1);
            Token op = null;
            switch (opNode.getText()) {
                case "+":
                    op = Operator.add;
                    break;
                case "-":
                    op = Operator.sub;
                    break;
                default:
                    error("unknown operator!!!");
            }

            expr = new Arithmetic(op, expr, (Expression) visitTerm(ctx.term(i)));
        }

        return expr;
    }

    /**
     * Process term node (Priority: * and / and %)
     * @param ctx
     * @return
     */
    @Override
    public Node visitTerm(GodFatherParser.TermContext ctx) {
        Expression expr = (Expression) visitFactor(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            ParseTree opNode = ctx.getChild(i * 2 - 1);
            Token op = null;
            switch (opNode.getText()) {
                case "*":
                    op = Operator.mul;
                    break;
                case "/":
                    op = Operator.div;
                    break;
                case "%":
                    op = Operator.rem;
                    break;
                default:
                    error("unknown operator!!!");
            }

            expr = new Arithmetic(op, expr, (Expression) visitFactor(ctx.factor(i)));
        }

        return expr;
    }

    /**
     * Process factor node (Priority: '(' and ')' or simple id or number)
     * @param ctx
     * @return
     */
    @Override
    public Node visitFactor(GodFatherParser.FactorContext ctx) {
        if (ctx.ID() != null) {
            String idName = ctx.ID().getText();
            Word idWord = wordsTable.get(idName);
            Expression id = env.getId(idWord);
            if (id == null) {
                error(idName + " undeclared");
            }

            return id;
        } else if (ctx.NUMBER() != null) {
            int num = Integer.parseInt(ctx.NUMBER().getText());
            Number number = new Number(num);
            return new Constant(number, Type.Int);
        } else {
            return visitArith_expr(ctx.arith_expr());
        }
    }
}

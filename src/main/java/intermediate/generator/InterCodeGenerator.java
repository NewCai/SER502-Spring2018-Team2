package intermediate.generator;

import LexerAndParser.GodFatherBaseVisitor;
import LexerAndParser.GodFatherParser;
import intermediate.inter.*;
import intermediate.lexer.Number;
import intermediate.lexer.Tag;
import intermediate.lexer.Word;
import intermediate.symbol.Environment;
import intermediate.symbol.Type;
import intermediate.lexer.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class InterCodeGenerator extends GodFatherBaseVisitor<Node> {
    private Environment env;
    private ReserverSymbolTable wordsTable;

    public InterCodeGenerator() {
        env = new Environment();
        wordsTable = new ReserverSymbolTable();
    }

    public void testPrintIntermediateCode(ParseTree pt) {
        Statement statements = (Statement) visit(pt);
        int begin = statements.newLabel();
        int end = statements.newLabel();
        statements.printLabel(begin);
        statements.generateInterCode(begin, end);
        statements.printLabel(end);
    }

    @Override
    public Node visitProgram(GodFatherParser.ProgramContext ctx) {
        visitDecls(ctx.decls());
        Statement statements = (Statement) visitStmts(ctx.stmts());
        return statements;
    }

    @Override
    public Node visitDecls(GodFatherParser.DeclsContext ctx) {
        for (GodFatherParser.DeclContext decl : ctx.decl()) {
            visitDecl(decl);
        }

        return super.visitDecls(ctx);
    }

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

    private Statement linkStatements(Statement s1, Statement s2) {
        if (s1 == null) {
            return s2;
        } else {
            return new Sequence(s1, s2);
        }
    }

    private void error(String str) {
        throw new Error(str);
    }

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
        whileNode.init(condition, trueStatement);
        Statement.enclosing = savedStatement;
        return whileNode;
    }

    @Override
    public Node visitStmtPrint(GodFatherParser.StmtPrintContext ctx) {
        Expression printBody = (Expression) visitArith_expr(ctx.arith_expr());
        Print printStmt = new Print(printBody);
        return printStmt;
    }

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

    @Override
    public Node visitBoolExprValue(GodFatherParser.BoolExprValueContext ctx) {
        if (ctx.value.getText().equals("true")) {
            return Constant.True;
        } else {
            return Constant.False;
        }

    }

    @Override
    public Node visitArith_expr(GodFatherParser.Arith_exprContext ctx) {
        Expression expr = (Expression) visitTerm(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            ParseTree opNode = ctx.getChild(i * 2 - 1);
            Token op = new Token(opNode.getText().charAt(0));
            expr = new Arithmetic(op, expr, (Expression) visitTerm(ctx.term(i)));
        }

        return expr;
    }

    @Override
    public Node visitTerm(GodFatherParser.TermContext ctx) {
        Expression expr = (Expression) visitFactor(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            ParseTree opNode = ctx.getChild(i * 2 - 1);
            Token op = new Token(opNode.getText().charAt(0));
            expr = new Arithmetic(op, expr, (Expression) visitFactor(ctx.factor(i)));
        }

        return expr;
    }

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

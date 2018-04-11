package intermediate.generator;

import intermediate.lexer.*;
import intermediate.inter.*;
import intermediate.symbol.*;

public class CodeGenerator {
    private Token head;
    private Environment top;
    private Lexer lexer;

    public CodeGenerator(Lexer lex) {
        this.lexer = lex;
        top = new Environment();
        move();
    }

    private void move() {
        head = lexer.scan();
    }

    private void error(String err) {
        throw new Error(err);
    }

    private void match(int t) {
        if (head.tag == t) {
            move();
        } else {
            error("Error! required tag is not matched");
        }

    }

    public void generateIntermediateCode() {
        generateDeclarations();
        Statement statements = generateStatementsLinkedList();
        int begin = statements.newLabel();
        int after = statements.newLabel();
        statements.printLabel(begin);
        statements.generateInterCode(begin, after);
        statements.printLabel(after);
    }

    private Statement block() {
        match('{');
        Statement stmtList = generateStatementsLinkedList();
        match('}');
        return stmtList;
    }

    private void generateDeclarations() {
        while (head.tag == Tag.BASIC) {
            Type p = type();
            Token tok = head;
            match(Tag.ID);
            match(';');

            Expression id = new Expression(tok, p);
            top.put(tok, id);
        }

    }

    private Type type() {
        Type p = (Type) head;
        match(Tag.BASIC);
        return p;
    }

    private Statement generateStatementsLinkedList() {
        if (head == null || head.tag == '}') {
            return Statement.Null;
        }

        return new Sequence(generateStmt(), generateStatementsLinkedList());
    }

    private Statement generateStmt() {
        Expression expr;
        Statement s1, s2;
        Statement savedStmt;

        switch (head.tag) {
            case ';':
                move();
                return Statement.Null;

            case Tag.IF:
                match(Tag.IF);
                match('(');
                expr = boolExpr();
                match(')');

                s1 = generateStmt();
                if (head.tag != Tag.ELSE) {
                    return new If(expr, s1);
                }

                match(Tag.ELSE);
                s2 = generateStmt();
                return new Else(expr, s1, s2);

            case Tag.WHILE:
                While whileNode = new While();
                savedStmt = Statement.enclosing;
                Statement.enclosing = whileNode;

                match(Tag.WHILE);
                match('(');
                expr = boolExpr();
                match(')');

                s1 = generateStmt();
                whileNode.init(expr, s1);
                Statement.enclosing = savedStmt;
                return whileNode;

            case '{':
                return block();

            default:
                return assign();
        }

    }

    private Statement assign() {
        Statement stmt;
        Token t = head;
        match(Tag.ID);
        Expression id = top.getId(t);
        if (id == null) {
            error(t.toString() + " undeclared");
        }

        move();
        stmt = new Assign(id, boolExpr());
        match(';');
        return stmt;
    }

    private Expression boolExpr() {
        Expression expr = relation();
        while (head.tag == Tag.EQ || head.tag == Tag.NE) {
            Token tok = head;
            move();
            expr = new Relation(tok, expr, relation());
        }

        return expr;
    }

    private Expression relation() {
        Expression expr = expr();
        switch (head.tag) {
            case Tag.LT:
            case Tag.LE:
            case Tag.GT:
            case Tag.GE:
                Token tok = head;
                move();
                return new Relation(tok, expr, expr());
            default:
                return expr;
        }
    }

    private Expression expr() {
        Expression expr = term();
        while (head.tag == '+' || head.tag == '-') {
            Token tok = head;
            move();
            expr = new Arithmatic(tok, expr, term());
        }

        return expr;
    }

    private Expression term() {
        Expression expr = factor();
        while (head.tag == '*' || head.tag == '/') {
            Token tok = head;
            move();
            expr = new Arithmatic(tok, expr, factor());
        }

        return expr;
    }

    private Expression factor() {
        Expression expr = null;
        switch (head.tag) {
            case '(':
                move();
                expr = boolExpr();
                match(')');
                break;

            case Tag.NUM:
                expr = new Constant(head, Type.Int);
                move();
                break;

            case Tag.TRUE:
                expr = Constant.True;
                move();
                break;

            case Tag.FALSE:
                expr = Constant.False;
                break;

            case Tag.ID:
                expr = top.getId(head);
                if (expr == null) {
                    error(head.toString() + " undeclared");
                }

                move();
                break;
            default:
                error("syntax error");
                break;
        }

        return expr;
    }

}

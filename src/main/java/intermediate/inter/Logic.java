package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

import java.io.PrintWriter;

/**
 * Logic class. expression1 is the left part, expression2 is the right part.
 * E.g. expr1 < expr2
 */
public class Logic extends Expression {
    Expression expr1, expr2;

    /**
     * Init members. Token is the operator
     * @param tok
     * @param x1
     * @param x2
     */
    Logic(Token tok, Expression x1, Expression x2) {
        super(tok, null);
        expr1 = x1;
        expr2 = x2;
        type = check(expr1.type, expr2.type);
        if (type == null) {
            error("type error");
        }

    }

    /**
     * Assert both left and right types are the same.
     * @param p1
     * @param p2
     * @return
     */
    public Type check(Type p1, Type p2) {
        if (p1 == Type.Bool && p2 == Type.Bool) {
            return Type.Bool;
        } else {
            return null;
        }

    }

    /**
     * Generate intermediate code
     * @param writer
     * @return
     */
    @Override
    public Expression generateInterCode(PrintWriter writer) {
        int falseTarget = newLabel();
        int trueTarget = newLabel();
        Temporary tmp = new Temporary(type);
        this.jump(0, falseTarget, writer);
        print("move " + tmp.toString() + " 1", writer);
        print("j L" + trueTarget, writer);
        printLabel(falseTarget, writer);
        print("move " + tmp.toString() + " 0", writer);
        printLabel(trueTarget, writer);
        return tmp;
    }

}

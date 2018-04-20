package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

import java.io.PrintWriter;

/**
 * Relation class.
 */
public class Relation extends Logic {
    /**
     * Init super members. tok is operator. x1 is left expression. x2 is right expression
     * @param tok
     * @param x1
     * @param x2
     */
    public Relation(Token tok, Expression x1, Expression x2) {
        super(tok, x1, x2);
    }

    /**
     * Assert both left and right type are the same
     * @param p1
     * @param p2
     * @return
     */
    public Type check(Type p1, Type p2) {
        if (p1 == p2) {
            return Type.Bool;
        } else {
            return null;
        }

    }

    /**
     * Generate intermediate code
     * @param trueTarget
     * @param falseTarget
     * @param writer
     */
    @Override
    public void jump(int trueTarget, int falseTarget, PrintWriter writer) {
        Expression e1 = expr1.reduce(writer);
        Expression e2 = expr2.reduce(writer);
        String test = op.toString() + " " + e1.toString() + " " + e2.toString();
        printJumps(test, trueTarget, falseTarget, writer);
    }

}

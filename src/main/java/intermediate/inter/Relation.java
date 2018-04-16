package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

import java.io.PrintWriter;

public class Relation extends Logic {
    public Relation(Token tok, Expression x1, Expression x2) {
        super(tok, x1, x2);
    }

    public Type check(Type p1, Type p2) {
        if (p1 == p2) {
            return Type.Bool;
        } else {
            return null;
        }

    }

    @Override
    public void jump(int trueTarget, int falseTarget, PrintWriter writer) {
        Expression e1 = expr1.reduce(writer);
        Expression e2 = expr2.reduce(writer);
        String test = op.toString() + " " + e1.toString() + " " + e2.toString();
        printJumps(test, trueTarget, falseTarget, writer);
    }

}

package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

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
    public void jump(int trueTarget, int falseTarget) {
        Expression e1 = expr1.reduce();
        Expression e2 = expr2.reduce();
        String test = e1.toString() + " " + op.toString() + " " + e2.toString();
        printJumps(test, trueTarget, falseTarget);
    }

}

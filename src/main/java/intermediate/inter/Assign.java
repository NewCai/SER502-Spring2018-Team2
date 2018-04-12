package intermediate.inter;

import intermediate.symbol.Type;

import java.io.PrintWriter;

public class Assign extends Statement {
    public Expression id;
    public Expression expr;

    public Assign(Expression i, Expression x) {
        id = i;
        expr = x;
        if (check(id.type, expr.type) == null) {
            error("type error");
        }

    }

    public Type check(Type p1, Type p2) {
        if (Type.isNumeric(p1) && Type.isNumeric(p2)) {
            return p2;
        } else if (p1 == Type.Bool && p2 == Type.Bool) {
            return p2;
        } else {
            return null;
        }

    }

    @Override
    public void generateInterCode(int trueTarget, int falseTarget, PrintWriter writer) {
        print(id.toString() + " = " + expr.generateInterCode(writer).toString(), writer);
    }

}

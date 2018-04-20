package intermediate.inter;

import intermediate.symbol.Type;

import java.io.PrintWriter;

/**
 * Assignment class. id is identifier. expression is right expression.
 */
public class Assign extends Statement {
    public Expression id;
    private Expression expr;

    /**
     * Init members.
     * @param i
     * @param x
     */
    public Assign(Expression i, Expression x) {
        id = i;
        expr = x;
        if (check(id.type, expr.type) == null) {
            error("type error");
        }

    }

    /**
     * check two types are the same
     * @param p1
     * @param p2
     * @return
     */
    private Type check(Type p1, Type p2) {
        if (Type.isNumeric(p1) && Type.isNumeric(p2)) {
            return p2;
        } else if (p1 == Type.Bool && p2 == Type.Bool) {
            return p2;
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
    public void generateInterCode(int trueTarget, int falseTarget, PrintWriter writer) {
        if (expr instanceof Arithmetic) {
            String[] toks = expr.generateInterCode(writer).toString().split(" ");
            if (toks.length == 3) {
                StringBuilder sb = new StringBuilder();
                sb.append(toks[0]).append(" ");
                sb.append(id.toString()).append(" ");
                for (int i = 1; i < toks.length; i++) {
                    sb.append(toks[i]).append(" ");
                }

                print(sb.toString(), writer);
                return;
            }
        }

        print("move " + id.toString() + " " + expr.generateInterCode(writer).toString(), writer);
    }

}

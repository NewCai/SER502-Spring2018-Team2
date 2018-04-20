package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

import java.io.PrintWriter;

/**
 * Arithmetic class. expr1 is left part and expr2 is right part.
 * E.g. expr1 + expr2
 */
public class Arithmetic extends Operation {
    public Expression expr1, expr2;

    /**
     * Init the members. Token is the operator and expressions are two (left and right) parts
     * in arithmetic expression
     * @param token
     * @param x1
     * @param x2
     */
    public Arithmetic(Token token, Expression x1, Expression x2) {
        super(token, null);
        this.expr1 = x1;
        this.expr2 = x2;
        boolean isNum = Type.isNumeric(x1.type) && Type.isNumeric(x2.type);
        if (!isNum) {
            error("type error");
        } else {
            type = Type.Int;
        }

    }

    /**
     * generate intermediate code in reduce (May use temp symbol)
     * @param writer
     * @return
     */
    @Override
    public Expression generateInterCode(PrintWriter writer) {
        return new Arithmetic(op, expr1.reduce(writer), expr2.reduce(writer));
    }

    @Override
    public String toString() {
        return op.toString() + " " + expr1.toString() + " " + expr2.toString();
    }

}

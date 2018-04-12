package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

import java.io.PrintWriter;

public class Arithmetic extends Operation {
    public Expression expr1, expr2;

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

    @Override
    public Expression generateInterCode(PrintWriter writer) {
        return new Arithmetic(op, expr1.reduce(writer), expr2.reduce(writer));
    }

    @Override
    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString();
    }

}

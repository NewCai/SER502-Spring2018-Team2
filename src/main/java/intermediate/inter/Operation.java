package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

import java.io.PrintWriter;

public class Operation extends Expression {
    public Operation(Token tok, Type p) {
        super(tok, p);
    }

    @Override
    public Expression reduce(PrintWriter writer) {
        Expression expr = generateInterCode(writer);
        Temporary tmp = new Temporary(type);
        print(tmp.toString() + " = " + expr.toString(), writer);
        return tmp;
    }

}

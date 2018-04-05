package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

public class Operation extends Expression {
    public Operation(Token tok, Type p) {
        super(tok, p);
    }

    public Expression reduce() {
        Expression expr = getAddress();
        Temporary tmp = new Temporary(type);
        print(tmp.toString() + " = " + expr.toString());
        return tmp;
    }

}

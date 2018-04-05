package intermediate.symbol;

import intermediate.inter.Expression;
import intermediate.lexer.Token;

import java.util.HashMap;

public class Environment {
    private HashMap<Token, Expression> table;
    protected Environment prev;

    public Environment(Environment n) {
        table = new HashMap<>();
        prev = n;
    }

    public void put(Token token, Expression id) {
        table.put(token, id);
    }

    public Expression getId(Token t) {
        for (Environment e = this; e != null; e = e.prev) {
            if (e.table.containsKey(t)) {
                return e.table.get(t);
            }
        }

        return null;
    }

}

package intermediate.symbol;

import intermediate.inter.Expression;
import intermediate.lexer.Token;

import java.util.HashMap;

public class Environment {
    private HashMap<Token, Expression> table;

    public Environment() {
        table = new HashMap<>();
    }

    public void put(Token token, Expression id) {
        table.put(token, id);
    }

    public Expression getId(Token t) {
        if (table.containsKey(t)) {
            return table.get(t);
        }

        return null;
    }

}

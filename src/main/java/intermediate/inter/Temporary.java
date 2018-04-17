package intermediate.inter;

import intermediate.lexer.Word;
import intermediate.symbol.Type;

public class Temporary extends Expression {
    static int count = 0;
    int number = 0;

    public Temporary(Type p) {
        super(Word.temp, p);
        number = ++count;
    }

    @Override
    public String toString() {
        return "t" + number;
    }

    public static void cleanCount() {
        count = 0;
    }
}

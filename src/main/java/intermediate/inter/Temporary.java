package intermediate.inter;

import intermediate.lexer.Word;
import intermediate.symbol.Type;

/**
 * Temporary class.
 * count is the current number of temp var
 * number is copy of count
 */
public class Temporary extends Expression {
    private static int count = 0;
    private int number;

    /**
     * Init members.
     * @param p
     */
    Temporary(Type p) {
        super(Word.temp, p);
        number = ++count;
    }

    @Override
    public String toString() {
        return "t" + number;
    }

    /**
     * Clean count. (Mainly used in debug/test)
     * @return
     */
    public static void cleanCount() {
        count = 0;
    }
}

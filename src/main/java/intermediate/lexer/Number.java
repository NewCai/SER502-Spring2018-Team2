package intermediate.lexer;

/**
 * Number class. value is the number
 */
public class Number extends Token {
    public final int value;

    /**
     * Init member
     * @param v
     */
    public Number(int v) {
        super(Tag.NUM);
        value = v;
    }

    public String toString() {
        return "" + value;
    }

}

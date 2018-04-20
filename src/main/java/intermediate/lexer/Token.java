package intermediate.lexer;

/**
 * Token class. store tag info
 */
public class Token {
    private final int tag;

    /**
     * Init member
     * @param t
     */
    public Token(int t) {
        this.tag = t;
    }

    @Override
    public String toString() {
        return "" + (char) tag;
    }

}

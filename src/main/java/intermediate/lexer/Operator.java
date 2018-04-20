package intermediate.lexer;

/**
 * Operator class. str is String of the operator
 * Mainly used to store math operator
 */
public class Operator extends Token {
    private String str;

    /**
     * Init member
     * @param s
     * @param tag
     */
    private Operator(String s, int tag) {
        super(tag);
        str = s;
    }

    @Override
    public String toString() {
        return str;
    }

    public static final Operator
            add = new Operator("add", '+'),
            sub = new Operator("sub", '-'),
            mul = new Operator("mul", '*'),
            div = new Operator("div", '/'),
            rem = new Operator("rem" , '%');
}

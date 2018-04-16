package intermediate.lexer;

public class Operator extends Token {
    public String str;

    public Operator(String s, int tag) {
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

package intermediate.lexer;

public class Word extends Token {
    private String str;

    public Word(String s, int tag) {
        super(tag);
        str = s;
    }

    @Override
    public String toString() {
        return str;
    }

    public static final Word
        eq = new Word("==", Tag.EQ), ne = new Word("!=", Tag.NE),
        le = new Word("<=", Tag.LE), ge = new Word(">=", Tag.GE),
        lt = new Word("<" , Tag.LT), gt = new Word(">" , Tag.GT),

        True  = new Word("true",  Tag.TRUE ),
        False = new Word("false", Tag.FALSE),
        temp  = new Word("t",     Tag.TEMP );

}

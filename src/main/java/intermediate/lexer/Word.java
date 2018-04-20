package intermediate.lexer;

/**
 * Word class. str is String of word info
 */
public class Word extends Token {
    private String str;

    /**
     * Init members
     * @param s
     * @param tag
     */
    public Word(String s, int tag) {
        super(tag);
        str = s;
    }

    @Override
    public String toString() {
        return str;
    }

    public static final Word
        eq = new Word("bneq", Tag.EQ), ne = new Word("beq", Tag.NE),
        le = new Word("bnle", Tag.LE), ge = new Word("bnge", Tag.GE),
        lt = new Word("bnlt" , Tag.LT), gt = new Word("bngt" , Tag.GT),

        True  = new Word("1",  Tag.TRUE ),
        False = new Word("0", Tag.FALSE),
        temp  = new Word("t",     Tag.TEMP );

}

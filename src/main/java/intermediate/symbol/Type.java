package intermediate.symbol;

import intermediate.lexer.Tag;
import intermediate.lexer.Word;

public class Type extends Word {
    public Type(String s, int tag) {
        super(s, tag);
    }

    public static final Type
        Int  = new Type("int", Tag.BASIC),
        Bool = new Type("bool", Tag.BASIC);

    public static boolean isNumeric(Type p) {
        if (p == Type.Int) {
            return true;
        } else {
            return false;
        }

    }

}

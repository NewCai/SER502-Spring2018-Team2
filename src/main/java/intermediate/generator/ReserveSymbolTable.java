package intermediate.generator;

import intermediate.lexer.Tag;
import intermediate.lexer.Word;
import intermediate.symbol.Type;

import java.util.HashMap;

/**
 *  Reserved Symbol table and constants
 */
public class ReserveSymbolTable {
    private HashMap<String, Word> table = new HashMap<>();

    /**
     * Add custom symbol
     * @param w
     */
    public void reserve(Word w) {
        table.put(w.toString(), w);
    }

    /**
     * Init 'built-in' symbol
     */
    public ReserveSymbolTable() {
        reserve(new Word("if",    Tag.IF));
        reserve(new Word("else",  Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));

        reserve(Word.True);
        reserve(Word.False);

        reserve(Type.Int);
        reserve(Type.Bool);
    }

    /**
     * Get a symbol
     * @param str
     * @return
     */
    public Word get(String str) {
        return table.get(str);
    }

}

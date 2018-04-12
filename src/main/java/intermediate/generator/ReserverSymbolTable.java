package intermediate.generator;

import intermediate.lexer.Tag;
import intermediate.lexer.Word;
import intermediate.symbol.Type;

import java.util.HashMap;

public class ReserverSymbolTable {
    private HashMap<String, Word> table = new HashMap<>();

    public void reserve(Word w) {
        table.put(w.toString(), w);
    }

    public ReserverSymbolTable() {
        reserve(new Word("if",    Tag.IF));
        reserve(new Word("else",  Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));

        reserve(Word.True);
        reserve(Word.False);

        reserve(Type.Int);
        reserve(Type.Bool);
    }

    public Word get(String str) {
        return table.get(str);
    }

}

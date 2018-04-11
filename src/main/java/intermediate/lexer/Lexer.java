package intermediate.lexer;

import LexerAndParser.GodFatherLexer;
import LexerAndParser.GodFatherParser;
import intermediate.symbol.Type;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;

public class Lexer {
    private HashMap<String, Word> words = new HashMap<>();
    private LinkedList<Token> tokenList;

    private void reserve(Word w) {
        words.put(w.toString(), w);
    }

    private void initKeyWords() {
        reserve(new Word("if",    Tag.IF));
        reserve(new Word("else",  Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));

        reserve(Word.True);
        reserve(Word.False);

        reserve(Type.Int);
        reserve(Type.Bool);
    }

    public Lexer(String filePath) {
        initKeyWords();

        try {
            InputStream is = new FileInputStream(filePath);
            ANTLRInputStream input = new ANTLRInputStream(is);
            GodFatherLexer gfl = new GodFatherLexer(input);
            CommonTokenStream tokenStream = new CommonTokenStream(gfl);
            GodFatherParser parse = new GodFatherParser(tokenStream);
            ParseTree syntaxTree = parse.program();
            generateTokenList(syntaxTree);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException eio) {
            eio.printStackTrace();
        }

    }

    private void generateTokenList(ParseTree tree) {
        tokenList = new LinkedList<>();
        dfs(tokenList, tree);
    }

    private void dfs(LinkedList<Token> list, ParseTree node) {
        for (int i = 0; i < node.getChildCount(); i++) {
            ParseTree next = node.getChild(i);
            if (next.getChildCount() == 0) {
                list.addLast(translate(next.getText()));
            } else {
                dfs(list, next);
            }

        }

    }

    private Token translate(String str) {
        Token ret = null;

        try {
            int num = Integer.parseInt(str);
            ret = new Number(num);
        } catch (NumberFormatException nfe) {
            switch (str) {
                case "=":
                    ret = new Token('=');
                    break;
                case "==":
                    ret = Word.eq;
                    break;
                case "!=":
                    ret = Word.ne;
                    break;
                case "<":
                    ret = Word.lt;
                    break;
                case "<=":
                    ret = Word.le;
                    break;
                case ">":
                    ret = Word.gt;
                    break;
                case ">=":
                    ret = Word.ge;
                    break;
            }
        }

        if (ret == null) {
            if (str.length() > 0 && Character.isLetter(str.charAt(0))) {
                ret = words.get(str);
                if (ret == null) {
                    Word w = new Word(str, Tag.ID);
                    words.put(str, w);
                    ret = w;
                }

            } else {
                ret = new Token(str.charAt(0));
            }

        }

        return ret;
    }

    public Token scan() {
        if (tokenList.size() == 0) {
            return null;
        }

        Token tok = tokenList.removeFirst();
        return tok;
    }

}

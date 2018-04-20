package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

import java.io.PrintWriter;

/**
 * Operation class.
 */
public class Operation extends Expression {
    /**
     * Init super members. Include operator and type
     * @param tok
     * @param p
     */
    public Operation(Token tok, Type p) {
        super(tok, p);
    }

    /**
     * Reduce operation. Used to split a long expression to three-address format sub-expressions
     * @param writer
     * @return
     */
    @Override
    public Expression reduce(PrintWriter writer) {
        Expression expr = generateInterCode(writer);
        Temporary tmp = new Temporary(type);
        String[] toks = expr.toString().split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(toks[0]).append(" ");
        sb.append(tmp.toString()).append(" ");
        for (int i = 1; i < toks.length; i++) {
            sb.append(toks[i]).append(" ");
        }

        print(sb.toString(), writer);
        return tmp;
    }

}

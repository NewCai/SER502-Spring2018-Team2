package intermediate.inter;

import java.io.PrintWriter;

/**
 * Print class. Content is the message will be printed
 */
public class Print extends Statement {
    Expression content;

    /**
     * Init members.
     * @param c
     */
    public Print(Expression c) {
        content = c;
    }

    /**
     * Generate intermediate code
     * @param trueTarget
     * @param falseTarget
     * @param writer
     */
    @Override
    public void generateInterCode(int trueTarget, int falseTarget, PrintWriter writer) {
        Expression finalId = content.generateInterCode(writer);
        String[] toks = finalId.toString().split(" ");
        if (toks.length > 1) {
            StringBuilder sb = new StringBuilder();
            Temporary t = new Temporary(null);
            sb.append(toks[0]).append(" ");
            sb.append(t.toString()).append(" ");
            for (int i = 1; i < toks.length; i++) {
                sb.append(toks[i]).append(" ");
            }

            print(sb.toString(), writer);
            print("print " + t.toString(), writer);
        } else {
            print("print " + finalId.toString(), writer);
        }

    }
}

package intermediate.inter;

import java.io.PrintWriter;

public class Print extends Statement {
    Expression content;

    public Print(Expression c) {
        content = c;
    }

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

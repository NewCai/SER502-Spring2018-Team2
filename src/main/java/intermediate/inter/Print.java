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
        Temporary t = new Temporary(null);
        print(t.toString() + " = " + finalId.toString(), writer);
        print("print: " + t.toString(), writer);
    }
}

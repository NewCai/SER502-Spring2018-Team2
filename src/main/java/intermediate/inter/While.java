package intermediate.inter;

import intermediate.symbol.Type;

import java.io.PrintWriter;

/**
 * While class. expression is the condition. statement is the body of the loop
 */
public class While extends Statement {
    Expression expression;
    Statement statement;

    /**
     * Init members.
     */
    public While() {
        expression = null;
        statement = null;
    }

    /**
     * Config loop condition and body
     * @param x
     * @param s
     */
    public void configLoop(Expression x, Statement s) {
        expression = x;
        statement = s;
        if (expression.type != Type.Bool) {
            expression.error("boolean required in while");
        }

    }

    /**
     * Generate intermediate code
     * @param trueTarget
     * @param falseTarget
     * @param writer
     */
    @Override
    public void generateInterCode(int trueTarget, int falseTarget, PrintWriter writer) {
        expression.jump(0, falseTarget, writer);
        int label = newLabel();
        printLabel(label, writer);
        statement.generateInterCode(label, trueTarget, writer);
        print("j L" + trueTarget, writer);
    }

}

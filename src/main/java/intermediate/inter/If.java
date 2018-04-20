package intermediate.inter;

import intermediate.symbol.Type;

import java.io.PrintWriter;

/**
 * If class. expr is condition. statement is the statement is true condition
 */
public class If extends Statement {
    Expression expr;
    Statement statement;

    /**
     * Init members
     * @param x
     * @param s
     */
    public If(Expression x, Statement s) {
        expr = x;
        statement = s;
        if (expr.type != Type.Bool) {
            expr.error("boolean expression is required in if");
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
        int label = newLabel();
        expr.jump(0, falseTarget, writer);
        printLabel(label, writer);
        statement.generateInterCode(label, falseTarget, writer);
    }

}

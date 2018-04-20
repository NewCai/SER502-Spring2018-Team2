package intermediate.inter;

import java.io.PrintWriter;

/**
 * Sequence class. LinkedList.
 * statement1 is previous statement.
 * statement2 is next statement
 */
public class Sequence extends Statement {
    Statement statement1;
    Statement statement2;

    /**
     * Init members
     * @param s1
     * @param s2
     */
    public Sequence(Statement s1, Statement s2) {
        statement1 = s1;
        statement2 = s2;
    }

    /**
     * Generate intermediate code
     * @param trueTarget
     * @param falseTarget
     * @param writer
     */
    @Override
    public void generateInterCode(int trueTarget, int falseTarget, PrintWriter writer) {
        if (statement1 == Statement.Null) {
            statement2.generateInterCode(trueTarget, falseTarget, writer);
        } else if (statement2 == Statement.Null) {
            statement1.generateInterCode(trueTarget, falseTarget, writer);
        } else {
            int label = newLabel();
            statement1.generateInterCode(trueTarget, label, writer);
            printLabel(label, writer);
            statement2.generateInterCode(label, falseTarget, writer);
        }

    }

}

package intermediate.inter;

public class Sequence extends Statement {
    Statement statement1;
    Statement statement2;

    public Sequence(Statement s1, Statement s2) {
        statement1 = s1;
        statement2 = s2;
    }

    @Override
    public void generateInterCode(int trueTarget, int falseTarget) {
        if (statement1 == Statement.Null) {
            statement2.generateInterCode(trueTarget, falseTarget);
        } else if (statement2 == Statement.Null) {
            statement1.generateInterCode(trueTarget, falseTarget);
        } else {
            int label = newLabel();
            statement1.generateInterCode(trueTarget, label);
            printLabel(label);
            statement2.generateInterCode(label, falseTarget);
        }

    }

}

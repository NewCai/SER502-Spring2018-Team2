package intermediate.inter;

public class Sequence extends Statement {
    Statement statement1;
    Statement statement2;

    public Sequence(Statement s1, Statement s2) {
        statement1 = s1;
        statement2 = s2;
    }

    @Override
    public void generateIntelCode(int trueTarget, int falseTarget) {
        if (statement1 == Statement.Null) {
            statement2.generateIntelCode(trueTarget, falseTarget);
        } else if (statement2 == Statement.Null) {
            statement1.generateIntelCode(trueTarget, falseTarget);
        } else {
            int label = newLabel();
            statement1.generateIntelCode(trueTarget, label);
            printLabel(label);
            statement2.generateIntelCode(label, falseTarget);
        }

    }

}

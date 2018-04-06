package intermediate.inter;

public class While extends Statement {
    Expression expression;
    Statement statement;

    public While() {
        expression = null;
        statement = null;
    }

    @Override
    public void generateInterCode(int trueTarget, int falseTarget) {
        after = falseTarget;
        expression.jump(0, falseTarget);
        int label = newLabel();
        printLabel(label);
        statement.generateInterCode(label, trueTarget);
        print("goto L" + trueTarget);
    }

}

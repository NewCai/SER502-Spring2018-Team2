package intermediate.inter;

import intermediate.symbol.Type;

public class While extends Statement {
    Expression expression;
    Statement statement;

    public While() {
        expression = null;
        statement = null;
    }

    public void init(Expression x, Statement s) {
        expression = x;
        statement = s;
        if (expression.type != Type.Bool) {
            expression.error("boolean required in while");
        }

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

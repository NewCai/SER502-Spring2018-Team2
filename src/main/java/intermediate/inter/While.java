package intermediate.inter;

import intermediate.symbol.Type;

import java.io.PrintWriter;

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
    public void generateInterCode(int trueTarget, int falseTarget, PrintWriter writer) {
        after = falseTarget;
        expression.jump(0, falseTarget, writer);
        int label = newLabel();
        printLabel(label, writer);
        statement.generateInterCode(label, trueTarget, writer);
        print("j L" + trueTarget, writer);
    }

}

package intermediate.inter;

import intermediate.symbol.Type;

public class Else extends Statement {
    Expression expr;
    Statement statement1, statement2;

    public Else(Expression x, Statement s1, Statement s2) {
        expr = x;
        statement1 = s1;
        statement2 = s2;
        if (expr.type != Type.Bool) {
            expr.error("boolean type is required in 'if'");
        }

    }

    @Override
    public void generateInterCode(int trueTarget, int falseTarget) {
        int label1 = newLabel();
        int label2 = newLabel();
        expr.jump(0, label2);

        printLabel(label1);
        statement1.generateInterCode(label1, falseTarget);
        print("goto L" + falseTarget);

        printLabel(label2);
        statement2.generateInterCode(label2, falseTarget);
    }

}

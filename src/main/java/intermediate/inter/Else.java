package intermediate.inter;

import intermediate.symbol.Type;

import java.io.PrintWriter;

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
    public void generateInterCode(int trueTarget, int falseTarget, PrintWriter writer) {
        int label1 = newLabel();
        int label2 = newLabel();
        expr.jump(0, label2, writer);

        printLabel(label1, writer);
        statement1.generateInterCode(label1, falseTarget, writer);
        print("j L" + falseTarget, writer);

        printLabel(label2, writer);
        statement2.generateInterCode(label2, falseTarget, writer);
    }

}

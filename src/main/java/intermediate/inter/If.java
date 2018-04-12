package intermediate.inter;

import intermediate.symbol.Type;

import java.io.PrintWriter;

public class If extends Statement {
    Expression expr;
    Statement statement;

    public If(Expression x, Statement s) {
        expr = x;
        statement = s;
        if (expr.type != Type.Bool) {
            expr.error("boolean expression is required in if");
        }

    }

    @Override
    public void generateInterCode(int trueTarget, int falseTarget, PrintWriter writer) {
        int label = newLabel();
        expr.jump(0, falseTarget, writer);
        printLabel(label, writer);
        statement.generateInterCode(label, falseTarget, writer);
    }

}

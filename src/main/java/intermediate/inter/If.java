package intermediate.inter;

import intermediate.symbol.Type;

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
    public void generateIntelCode(int trueTarget, int falseTarget) {
        int label = newLabel();
        expr.jump(0, falseTarget);
        printLabel(label);
        statement.generateIntelCode(label, falseTarget);
    }

}

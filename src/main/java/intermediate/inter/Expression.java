package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

public class Expression extends Node {
    public Token op;
    public Type type;

    Expression(Token tok, Type p) {
        op = tok;
        type = p;
    }

    public Expression getAddress() {
        return this;
    }

    public Expression reduce() {
        return this;
    }

    public void jump (int trueTarget, int falseTarget) {
        printJumps(toString(), trueTarget, falseTarget);
    }

    public void printJumps(String condition, int trueTarget, int falseTarget) {
        if (trueTarget != 0 && falseTarget != 0) {
            print("if " + condition + " goto L" + trueTarget);
            print("goto L" + falseTarget);
        } else if (falseTarget != 0) {
            print("iffalse " + condition + " goto L" + falseTarget);
        } else if (trueTarget != 0) {
            print("if " + condition + " goto L" + trueTarget);
        }

    }

    @Override
    public String toString() {
        return op.toString();
    }

}

package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

import java.io.PrintWriter;

/**
 * Expression class. op is the operator, type is the data type
 */
public class Expression extends Node {
    public Token op;
    public Type type;

    /**
     * Init members
     * @param tok
     * @param p
     */
    public Expression(Token tok, Type p) {
        op = tok;
        type = p;
    }

    /**
     * generate intermediate code. (Expression is the base class. No reduce manipulation)
     * @param writer
     * @return
     */
    public Expression generateInterCode(PrintWriter writer) {
        return this;
    }

    /**
     * Reduce manipulation. Since expression is the base class. No reduce manipulation
     * @param writer
     * @return
     */
    public Expression reduce(PrintWriter writer) {
        return this;
    }

    /**
     * Generate intermediate code interface
     * @param trueTarget
     * @param falseTarget
     * @param writer
     */
    public void jump (int trueTarget, int falseTarget, PrintWriter writer) {
        printJumps(toString(), trueTarget, falseTarget, writer);
    }

    /**
     * Generate intermediate code
     * @param condition
     * @param trueTarget
     * @param falseTarget
     * @param writer
     */
    void printJumps(String condition, int trueTarget, int falseTarget, PrintWriter writer) {
        if (trueTarget != 0 && falseTarget != 0) {
            print(condition + " L" + trueTarget, writer);
            print(" " + falseTarget, writer);
        } else if (falseTarget != 0) {
            print(condition + " L" + falseTarget, writer);
        } else if (trueTarget != 0) {
            print(condition + " L" + trueTarget, writer);
        } else {
            print("", writer);
        }

    }

    @Override
    public String toString() {
        return op.toString();
    }

}

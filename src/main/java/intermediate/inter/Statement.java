package intermediate.inter;

import java.io.PrintWriter;

/**
 * Statement class. Base class
 * Null is empty statement
 * enclosing is used to define end of the While loop
 */
public class Statement extends Node {
    static Statement Null = new Statement();
    public static Statement enclosing = Statement.Null;

    /**
     * Base method. Print empty
     * Mainly used to handle Null node
     * @param trueTarget
     * @param falseTarget
     * @param writer
     */
    public void generateInterCode(int trueTarget, int falseTarget, PrintWriter writer) { }

}

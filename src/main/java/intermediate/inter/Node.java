package intermediate.inter;

import java.io.PrintWriter;

/**
 * Node class. Base class. Label is the tag for each expression
 */
public class Node {
    private static int labels = 0;

    /**
     * Throw semantic error
     * @param s
     */
    void error(String s) {
        throw new Error("Semantic Error found: " + s);
    }

    /**
     * Increase label number
     * @return
     */
    public int newLabel() {
        return ++labels;
    }

    /**
     * Print label
     * @param i
     * @param writer
     */
    public void printLabel(int i, PrintWriter writer) {
        System.out.print("L" + i + ":");
        writer.print("L" + i + ":");
    }

    /**
     * Print generate intermediate code
     * @param s
     * @param writer
     */
    public void print(String s, PrintWriter writer) {
        System.out.println("\t" + s);
        writer.println("\t" + s);
    }

    /**
     * Clean count. (Mainly used in debug/test mode)
     */
    public static void cleanCount() {
        labels = 0;
    }

}

package intermediate.inter;

import java.io.PrintWriter;

public class Node {
    private static int labels = 0;

    void error(String s) {
        throw new Error("Semantic Error found: " + s);
    }

    public int newLabel() {
        return ++labels;
    }

    public void printLabel(int i, PrintWriter writer) {
        System.out.print("L" + i + ":");
        writer.print("L" + i + ":");
    }

    public void print(String s, PrintWriter writer) {
        System.out.println("\t" + s);
        writer.println("\t" + s);
    }

    public static void cleanCount() {
        labels = 0;
    }

}

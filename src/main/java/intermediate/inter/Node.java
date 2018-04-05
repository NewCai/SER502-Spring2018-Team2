package intermediate.inter;

public class Node {
    static int labels = 0;

    void error(String s) {
        throw new Error("Semantic Error found: " + s);
    }

    public int newLabel() {
        return ++labels;
    }

    public void printLabel(int i) {
        System.out.println("L" + i + ":");
    }

    public void print(String s) {
        System.out.println("\t" + s);
    }
}

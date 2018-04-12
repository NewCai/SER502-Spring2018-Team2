package intermediate.inter;

public class Print extends Statement {
    Expression content;

    public Print(Expression c) {
        content = c;
    }

    @Override
    public void generateInterCode(int trueTarget, int falseTarget) {
        Expression finalId = content.generateInterCode();
        Temporary t = new Temporary(null);
        print(t.toString() + " = " + finalId.toString());
        print("print: " + t.toString());
    }
}

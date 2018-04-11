package intermediate.inter;

import intermediate.lexer.Token;
import intermediate.symbol.Type;

public class Logic extends Expression{
    public Expression expr1, expr2;

    Logic(Token tok, Expression x1, Expression x2) {
        super(tok, null);
        expr1 = x1;
        expr2 = x2;
        type = check(expr1.type, expr2.type);
        if (type == null) {
            error("type error");
        }

    }

    public Type check(Type p1, Type p2) {
        if (p1 == Type.Bool && p2 == Type.Bool) {
            return Type.Bool;
        } else {
            return null;
        }

    }

    @Override
    public Expression generateInterCode() {
        int falseTarget = newLabel();
        int trueTarget = newLabel();
        Temporary tmp = new Temporary(type);
        this.jump(0, falseTarget);
        print(tmp.toString() + " = true");
        print("goto L" + trueTarget);
        printLabel(falseTarget);
        print(tmp.toString() + " = false");
        printLabel(trueTarget);
        return tmp;
    }

}

package intermediate.inter;

import intermediate.lexer.Number;
import intermediate.lexer.Token;
import intermediate.lexer.Word;
import intermediate.symbol.Type;

public class Constant extends Expression {
    public static final Constant
        True  = new Constant(Word.True,  Type.Bool),
        False = new Constant(Word.False, Type.Bool);

    public Constant(Token token, Type p) {
        super(token, p);
    }

    public Constant(int i) {
        super(new Number(i), Type.Int);
    }

    @Override
    public void jump(int trueTarget, int falseTarget) {
        if (this == True && trueTarget != 0) {
            print("goto L" + trueTarget);
        } else if (this == False && falseTarget != 0) {
            print("goto L" + falseTarget);
        }

    }

}

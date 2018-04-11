import intermediate.generator.CodeGenerator;
import intermediate.lexer.Lexer;

public class GFInterGenTester {
    public static void main(String[] args) {
        String filePath = "data/interCodeTestCases/complexWhileControlFlow.gf";
        Lexer lexer = new Lexer(filePath);
        CodeGenerator generator = new CodeGenerator(lexer);
        generator.generateIntermediateCode();
    }
}

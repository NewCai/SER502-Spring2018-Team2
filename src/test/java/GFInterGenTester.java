import LexerAndParser.GodFatherLexer;
import LexerAndParser.GodFatherParser;
import intermediate.generator.InterCodeGenerator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class GFInterGenTester {
    public static void main(String[] args) {
        String filePath = "data/interCodeTestCases/whileControlFlow.gf";
        InterCodeGenerator icg = new InterCodeGenerator();
        try {
            InputStream is = new FileInputStream(filePath);
            ANTLRInputStream input = new ANTLRInputStream(is);
            GodFatherLexer lexer = new GodFatherLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            GodFatherParser parser = new GodFatherParser(tokens);
            ParseTree tree = parser.program();
            icg.testPrintIntermediateCode(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

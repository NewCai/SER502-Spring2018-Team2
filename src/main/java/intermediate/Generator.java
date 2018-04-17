package intermediate;

import LexerAndParser.GodFatherLexer;
import LexerAndParser.GodFatherParser;
import intermediate.generator.InterCodeGenerator;
import intermediate.inter.Node;
import intermediate.inter.Temporary;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

public class Generator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please run as java -jar Generator.jar example.gf");
            return;
        }

        String fileName = args[0];
        if (!isValidFile(fileName)) {
            return;
        }

        InterCodeGenerator icg = new InterCodeGenerator();
        try {
            InputStream is = new FileInputStream(fileName);
            ANTLRInputStream input = new ANTLRInputStream(is);
            GodFatherLexer lexer = new GodFatherLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            GodFatherParser parser = new GodFatherParser(tokens);
            ParseTree tree = parser.program();
            Node.cleanCount();
            Temporary.cleanCount();
            icg.printIntermediateCode(tree, fileName.substring(0, fileName.length() - 3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            System.out.println("File name cannot be emptied");
            return false;
        }

        int pos = fileName.lastIndexOf('.');
        if (pos < 0) {
            System.out.println("Please provide a file with '.gf' extension");
            return false;
        }

        String extension = fileName.substring(pos + 1);
        if (!extension.equals("gf")) {
            System.out.println("Please provide a file with '.gf' extension");
            return false;
        }

        return true;
    }
}

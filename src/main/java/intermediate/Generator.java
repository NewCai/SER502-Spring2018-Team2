package intermediate;

import frontend.GodFatherLexer;
import frontend.GodFatherParser;
import intermediate.generator.InterCodeGenerator;
import intermediate.inter.Node;
import intermediate.inter.Temporary;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;

import java.io.*;

/**
 * Main class of Generator
 */
public class Generator {
    /**
     * Main class
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please run as java -jar Generator.jar example.gf");
            return;
        }

        String fileName = args[0];
        if (!isValidFile(fileName)) {
            return;
        }

        InterCodeGenerator icg = new InterCodeGenerator();
        try {
            InputStream is = new FileInputStream(fileName);
            CharStream input = CharStreams.fromStream(is);
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

    /**
     * Check input file extension and name
     * @param fileName
     * @return
     */
    private static boolean isValidFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            System.err.println("File name cannot be emptied");
            return false;
        }

        int pos = fileName.lastIndexOf('.');
        if (pos < 0) {
            System.err.println("Please provide a file with '.gf' extension");
            return false;
        }

        String extension = fileName.substring(pos + 1);
        if (!extension.equals("gf")) {
            System.err.println("Please provide a file with '.gf' extension");
            return false;
        }

        return true;
    }
}

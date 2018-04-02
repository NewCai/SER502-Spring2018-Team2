 /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/
import LexerAndParser.GodFatherBaseListener;
import LexerAndParser.GodFatherLexer;
import LexerAndParser.GodFatherParser;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

 public class GodFatherTester {
    public static void main(String[] args) throws Exception {
        //String inputFile = null;
        //if ( args.length>0 ) inputFile = args[0];
        //test
        String inputFile = "C:\\Users\\hcw95\\Desktop\\test.txt";//define your own file path
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        GodFatherLexer lexer = new GodFatherLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GodFatherParser parser = new GodFatherParser(tokens);
        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        GodFatherBaseListener b = new GodFatherBaseListener();
        walker.walk(b, tree);


        //show AST in console
        System.out.println(tree.toStringTree(parser));

        //show AST in GUI
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        viewr.setScale(1.5);//scale a little
        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(300,300);
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        frame.setLocation( (int) (width - frame.getWidth()) / 2,(int) (height - frame.getHeight()) / 2);
        frame.setVisible(true);


     //   ParseTree tree = parser.prog(); // parse
     //   EvalVisitor eval = new EvalVisitor();
     //   eval.visit(tree);
    }
}

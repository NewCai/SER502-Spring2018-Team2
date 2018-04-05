 /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/
import LexerAndParser.*;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import javax.imageio.*;
import java.io.IOException;


 public class GodFatherTester {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        //test

        String inputFile = "data\\testcase3\\testcase3.txt";//define your own file path

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
        frame.setSize(3000,1000);
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        frame.setLocation( (int) (width - frame.getWidth()) / 2,(int) (height - frame.getHeight()) / 2);
        frame.setVisible(true);

        Container content=frame.getContentPane();
        BufferedImage img=new BufferedImage(
                frame.getWidth(),frame.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        content.printAll(g2d);
        File f=new File("saveScreen.jpg");
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.dispose();
        //   ParseTree tree = parser.prog(); // parse
     //   EvalVisitor eval = new EvalVisitor();
     //   eval.visit(tree);
    }
}

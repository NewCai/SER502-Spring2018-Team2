package frontend;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
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


 public class GFParserTester {
    public static void main(String[] args) throws Exception {
        String filePath;
        if (args.length != 1) {
            System.err.println("No input file");
            return;
        } else {
            filePath = args[0];
        }

        InputStream is = new FileInputStream(filePath);
        CharStream input = CharStreams.fromStream(is);
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
        viewr.setScale(1);//scale a little
        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1800,400);
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        frame.setLocation( (int) (width - frame.getWidth()) / 2,(int) (height - frame.getHeight()) / 2);
        frame.setVisible(true);

        Container content=frame.getContentPane();
        BufferedImage img=new BufferedImage(
                frame.getWidth(),frame.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        content.printAll(g2d);

        File f=new File(filePath.split("\\.")[0] + ".jpg");
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.dispose();
    }
}

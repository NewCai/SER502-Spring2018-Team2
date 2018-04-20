package intermediate;

import frontend.GodFatherLexer;
import frontend.GodFatherParser;
import intermediate.generator.InterCodeGenerator;


import intermediate.inter.Node;
import intermediate.inter.Temporary;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GFInterGenTesterTest {
    private String declsAssignTestFile;
    private String whileLoopTestFile;
    private String ifControlFlowTestFile;
    private String calculationTestFile;

    @Before
    public void setUp() throws Exception {
        declsAssignTestFile = "data/interCodeTestCases/declsAndAssignTest/case.gf";
        whileLoopTestFile = "data/interCodeTestCases/whileLoopTest/case.gf";
        ifControlFlowTestFile = "data/interCodeTestCases/ifControlFlowTest/case.gf";
        calculationTestFile = "data/interCodeTestCases/calculationTest/case.gf";
    }


    private List<String> generateInterCode(String filePath) {
        InterCodeGenerator icg = new InterCodeGenerator();
        List<String> res = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(filePath);
            CharStream input = CharStreams.fromStream(is);
            GodFatherLexer lexer = new GodFatherLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            GodFatherParser parser = new GodFatherParser(tokens);
            ParseTree tree = parser.program();
            Node.cleanCount();
            Temporary.cleanCount();
            icg.printIntermediateCode(tree, filePath.substring(0, filePath.length() - 3));
            int pos = filePath.lastIndexOf('.');
            String generateFilePath = filePath.substring(0, pos + 1);
            generateFilePath += "inter";
            BufferedReader br = new BufferedReader(new FileReader(new File(generateFilePath)));
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Test
    public void declsAndAssignTest() {
        List<String> lines = generateInterCode(declsAssignTestFile);
        String line1 = lines.get(0).trim();
        String line2 = lines.get(1).trim();
        String line3 = lines.get(2).trim();
        String line4 = lines.get(3).trim();

        assertEquals(line1, "L1:\tmove x 1");
        assertEquals(line2, "L5:\tmove y 2");
        assertEquals(line3, "L4:\tmove x y");
        assertEquals(line4, "L3:\tprint x");
    }

    @Test
    public void calculationTest() {
        List<String> lines = generateInterCode(calculationTestFile);
        String line1 = lines.get(0).trim();
        String line2 = lines.get(1).trim();
        String line3 = lines.get(2).trim();
        String line4 = lines.get(3).trim();
        String line5 = lines.get(4).trim();
        String line6 = lines.get(5).trim();
        String line7 = lines.get(6).trim();
        String line8 = lines.get(7).trim();
        String line9 = lines.get(8).trim();
        String line10 = lines.get(9).trim();
        String line11 = lines.get(10).trim();
        String line12 = lines.get(11).trim();
        String line13 = lines.get(12).trim();
        String line14 = lines.get(13).trim();
        String line15 = lines.get(14).trim();
        String line16 = lines.get(15).trim();

        assertEquals(line1, "L1:\tmove x 1");
        assertEquals(line2, "L7:\tmove y 2");
        assertEquals(line3, "L6:\tadd x y 2");
        assertEquals(line4, "L5:\tadd t1 y 6");
        assertEquals(line5, "sub t2 t1 5");
        assertEquals(line6, "add t3 t2 2");
        assertEquals(line7, "sub y t3 1");
        assertEquals(line8, "L4:\tsub t4 6 5");
        assertEquals(line9, "mul t5 y t4");
        assertEquals(line10, "add t6 x t5");
        assertEquals(line11, "div t7 3 1");
        assertEquals(line12, "add sum t6 t7");
        assertEquals(line13, "L3:\tadd t8 sum x");
        assertEquals(line14, "mul t9 y 2");
        assertEquals(line15, "sub t10 t8 t9");
        assertEquals(line16, "print t10");
    }

    @Test
    public void ifControlFlowTest() {
        List<String> lines = generateInterCode(ifControlFlowTestFile);
        String line1 = lines.get(0).trim();
        String line2 = lines.get(1).trim();
        String line3 = lines.get(2).trim();
        String line4 = lines.get(3).trim();
        String line5 = lines.get(4).trim();
        String line6 = lines.get(5).trim();
        String line7 = lines.get(6).trim();
        String line8 = lines.get(7).trim();

        assertEquals(line1, "L1:\tmove sum 0");
        assertEquals(line2, "L5:\tmove i 5");
        assertEquals(line3, "L4:\tbnlt i 6 L7");
        assertEquals(line4, "L6:\tmul x i 2");
        assertEquals(line5, "j L3");
        assertEquals(line6, "L7:\tsub x i 2");
        assertEquals(line7, "L3:\tmul t1 x x");
        assertEquals(line8, "add sum t1 1");
    }

    @Test
    public void whileLoopTest() {
        List<String> lines = generateInterCode(whileLoopTestFile);
        String line1 = lines.get(0).trim();
        String line2 = lines.get(1).trim();
        String line3 = lines.get(2).trim();
        String line4 = lines.get(3).trim();
        String line5 = lines.get(4).trim();
        String line6 = lines.get(5).trim();
        String line7 = lines.get(6).trim();
        String line8 = lines.get(7).trim();
        String line9 = lines.get(8).trim();
        String line10 = lines.get(9).trim();

        assertEquals(line1, "L1:\tmove i 0");
        assertEquals(line2, "L6:\tmove x 0");
        assertEquals(line3, "L5:\tmove sum x");
        assertEquals(line4, "L4:\tbnlt i 10 L3");
        assertEquals(line5, "L7:\tadd i i 1");
        assertEquals(line6, "L9:\tmul x i i");
        assertEquals(line7, "L8:\tsub t1 x i");
        assertEquals(line8, "add sum sum t1");
        assertEquals(line9, "j L4");
        assertEquals(line10, "L3:\tsub sum sum 1");
    }
}
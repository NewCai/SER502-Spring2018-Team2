package runtime;

import org.junit.Test;

import static org.junit.Assert.*;

public class VirtualMachineTest {

    @Test
    public void arithTest() {
        VirtualMachine machine = new VirtualMachine();
        machine.addInstruction("move t1 1");
        machine.addInstruction("move t2 2");
        machine.addInstruction("nop");
        machine.addInstruction("add t1 t1 t2"); // 3 2
        machine.addInstruction("mul t1 3 t2"); // 6 2
        machine.addInstruction("div t1 t1 t2"); // 3 2
        machine.addInstruction("rem t2 t1 t2"); // 3 1
        machine.addInstruction("print t1"); // 3 1
        machine.addInstruction("print t2"); // 3 1
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertSame(3, machine.getValueFromSymbolTable("t1"));
        assertSame(1, machine.getValueFromSymbolTable("t2"));
    }

    @Test
    public void branchTest() {
        VirtualMachine machine = new VirtualMachine();
        machine.addInstruction("j end1");
        machine.addInstruction("begin:");
        machine.addInstruction("beq 1 1 LB1");
        machine.addInstruction("add t1 t1 100");
        machine.addInstruction("LB1:bneq 2 1 LB2");
        machine.addInstruction("add t1 t1 100");
        machine.addInstruction("LB2:bnge 1 3 LB3");
        machine.addInstruction("add t1 t1 100");
        machine.addInstruction("LB3:bngt 1 1 LB4");
        machine.addInstruction("add t1 t1 100");
        machine.addInstruction("LB4:bnle 2 1 LB5");
        machine.addInstruction("add t1 t1 100");
        machine.addInstruction("LB5:bnlt 2 2 final");
        machine.addInstruction("add t1 t1 100");
        machine.addInstruction("final: j end2");
        machine.addInstruction("   end1  : move t1 1");
        machine.addInstruction("j begin");
        machine.addInstruction("end2:");
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertEquals(1, machine.getValueFromSymbolTable("t1"));
    }

    @Test
    public void testcase1() {
        VirtualMachine machine = new VirtualMachine();
        machine.loadProgramFromFile( "data/testcase1/testcase1.inter");
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertEquals(11, machine.getValueFromSymbolTable("x"));
        assertEquals(10, machine.getValueFromSymbolTable("y"));
        assertEquals(2, machine.getValueFromSymbolTable("q"));
    }

    @Test
    public void testcase2() {
        VirtualMachine machine = new VirtualMachine();
        machine.loadProgramFromFile( "data/testcase2/testcase2.inter");
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertEquals(11, machine.getValueFromSymbolTable("x"));
        assertEquals(0, machine.getValueFromSymbolTable("y"));
    }

    @Test
    public void testcase3() {
        VirtualMachine machine = new VirtualMachine();
        machine.loadProgramFromFile( "data/testcase3/testcase3.inter");
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertEquals(66, machine.getValueFromSymbolTable("x"));
        assertEquals(66, machine.getValueFromSymbolTable("y"));
    }

    @Test
    public void testcase4() {
        VirtualMachine machine = new VirtualMachine();
        machine.loadProgramFromFile( "data/testcase4/testcase4.inter");
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertEquals(89, machine.getValueFromSymbolTable("x"));
        assertEquals(144, machine.getValueFromSymbolTable("xx"));
        assertEquals(144, machine.getValueFromSymbolTable("xxx"));
    }


    @Test
    public void testcase5() {
        VirtualMachine machine = new VirtualMachine();
        machine.loadProgramFromFile( "data/testcase5/testcase5.inter");
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertEquals(10, machine.getValueFromSymbolTable("j"));
        assertEquals(10, machine.getValueFromSymbolTable("i"));
        assertEquals(55, machine.getValueFromSymbolTable("sum"));
        assertEquals(0, machine.getValueFromSymbolTable("count"));
    }

    @Test
    public void testcase6() {
        VirtualMachine machine = new VirtualMachine();
        machine.loadProgramFromFile( "data/testcase6/testcase6.inter");
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertEquals(3, machine.getValueFromSymbolTable("inputtwo"));
        assertEquals(2, machine.getValueFromSymbolTable("inputone"));
    }

    @Test
    public void testcase7() {
        VirtualMachine machine = new VirtualMachine();
        machine.loadProgramFromFile( "data/testcase7/testcase7.inter");
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertEquals(11, machine.getValueFromSymbolTable("x"));
        assertEquals(12, machine.getValueFromSymbolTable("y"));
        assertEquals(120, machine.getValueFromSymbolTable("z"));
    }

    @Test
    public void testcase8() {
        VirtualMachine machine = new VirtualMachine();
        machine.loadProgramFromFile( "data/testcase8/testcase8.inter");
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertEquals(40, machine.getValueFromSymbolTable("cal"));
    }
}
package runtime;

import org.junit.Test;

import static org.junit.Assert.*;

public class VirtualMachineTest {

    @Test
    public void addInstructionTest() {
        VirtualMachine machine = new VirtualMachine();
        machine.addInstruction("move a1 23");
        machine.addInstruction("LB1: add t1 t2 123");
        machine.addInstruction("sub t1 t2 123");
        machine.addInstruction("div t1 t2 123");
        machine.addInstruction("rem t1 t2 123");
        machine.addInstruction("LB4: bneq t1 321 LB1");
        machine.addInstruction("beq t1 t4 LB1");
        machine.addInstruction("bnlt t1 t4 LB1");
        machine.addInstruction("bnge t1 t4 LB1");
        machine.addInstruction("bngt t1 t4 LB1");
        machine.addInstruction("bnle t1 t4 LB1");
        machine.addInstruction("j LB1");
        machine.addInstruction("LB3:");
        machine.addInstruction("print t1");
        machine.addInstruction("print 1");
        machine.addInstruction("nop");

        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
    }

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
        assertSame(3, machine.getValueFromSysbolTable("t1"));
        assertSame(1, machine.getValueFromSysbolTable("t2"));
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
        machine.addInstruction("end2");
        machine.executeProgram();
        System.out.print(machine.getInstructionsString());
        System.out.print(machine.getLabelTableString());
        System.out.print(machine.getSymbolTabelString());
        assertSame(1, machine.getValueFromSysbolTable("t1"));
    }
}
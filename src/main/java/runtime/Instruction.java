package runtime;

/**
 * An instruction is a three-address-code, which consists of
 * one opcode and no more than three operands
 */
public class Instruction {

    private Opcode opcode;
    private Operand operand1;
    private Operand operand2;
    private Operand operand3;

    public static Instruction createNopInstruction() {
        return new Instruction("nop", null, null, null);
    }

    public Instruction(String strOc, String strOr1, String strOr2, String strOr3) {
        opcode = new Opcode(strOc);
        if (strOr1 != null && !strOr1.isEmpty()) {
            operand1 = Operand.createViaRawStr(strOr1);
        }
        if (strOr2 != null && !strOr2.isEmpty()) {
            operand2 = Operand.createViaRawStr(strOr2);
        }
        if (strOr3 != null && !strOr3.isEmpty()) {
            operand3 = Operand.createViaRawStr(strOr3);
        }
    }

    public Opcode getOpcode() {
        return opcode;
    }

    public Operand getOperand1() {
        return operand1;
    }

    public Operand getOperand2() {
        return operand2;
    }

    public Operand getOperand3() {
        return operand3;
    }

    @Override
    public String toString() {
        String str = "Instruction: Opcode: " + opcode.toString() + " ";
        if (operand1 != null) str += " Oprand1:" + operand1.toString();
        if (operand2 != null) str += " Oprand2:" + operand2.toString();
        if (operand3 != null) str += " Oprand3:" + operand3.toString();
        return str;
    }
}

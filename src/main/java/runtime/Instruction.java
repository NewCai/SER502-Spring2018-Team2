package runtime;

public class Instruction {

    private Opcode opcode;
    private Oprand oprand1;
    private Oprand oprand2;
    private Oprand oprand3;

    public static Instruction createNopInstruction() {
        return new Instruction("nop", null, null, null);
    }

    public Instruction(String strOc, String strOr1, String strOr2, String strOr3) {
        opcode = new Opcode(strOc);
        if (strOr1 != null && !strOr1.isEmpty()) {
            oprand1 = Oprand.createViaRawStr(strOr1);
        }
        if (strOr2 != null && !strOr2.isEmpty()) {
            oprand2 = Oprand.createViaRawStr(strOr2);
        }
        if (strOr3 != null && !strOr3.isEmpty()) {
            oprand3 = Oprand.createViaRawStr(strOr3);
        }
    }

    public Opcode getOpcode() {
        return opcode;
    }

    public Oprand getOprand1() {
        return oprand1;
    }

    public Oprand getOprand2() {
        return oprand2;
    }

    public Oprand getOprand3() {
        return oprand3;
    }

    @Override
    public String toString() {
        String str = "Instruction: Opcode: " + opcode.toString() + " ";
        if (oprand1 != null) str += " Oprand1:" + oprand1.toString();
        if (oprand2 != null) str += " Oprand2:" + oprand2.toString();
        if (oprand3 != null) str += " Oprand3:" + oprand3.toString();
        return str;
    }
}

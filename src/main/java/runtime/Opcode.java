package runtime;

import java.util.HashMap;

public class Opcode {

    public enum OpType {
        NONE,
        MOVE,
        ADD,
        SUB,
        MUL,
        DIV,
        REM,
        BNEQ,
        BEQ,
        BNGE,
        BNGT,
        BNLE,
        BNLT,
        JUMP,
        PRINT,
        NOP
    }

    private static final HashMap<String, OpType> OP_DIC = new HashMap<String, OpType>() {{
        put("move", OpType.MOVE);
        put("add", OpType.ADD);
        put("sub", OpType.SUB);
        put("mul", OpType.MUL);
        put("div", OpType.DIV);
        put("rem", OpType.REM);
        put("bneq", OpType.BNEQ);
        put("beq", OpType.BEQ);
        put("bnge", OpType.BNGE);
        put("bngt", OpType.BNGT);
        put("bnle", OpType.BNLE);
        put("bnlt", OpType.BNLT);
        put("j", OpType.JUMP);
        put("print", OpType.PRINT);
        put("nop", OpType.NOP);
    }};

    private OpType opType;

    public static OpType getOpType(String scr) {
        return OP_DIC.getOrDefault(scr, OpType.NONE);
    }

    public static boolean isBranchOpcode(OpType type) {
        return type == OpType.BNEQ
                || type == OpType.BEQ
                || type == OpType.BNGE
                || type == OpType.BNGT
                || type == OpType.BNLE
                || type == OpType.BNLT;
    }

    public static boolean isArithmaticOpcode(OpType type) {
        return type == OpType.ADD
                || type == OpType.SUB
                || type == OpType.MUL
                || type == OpType.DIV
                || type == OpType.REM;
    }

    public Opcode(String scr) {
        opType = getOpType(scr);
        if (opType == OpType.NONE) {
            System.err.println(scr + " is not a supported OpType");
        }
    }

    @Override
    public String toString() {
        return opType.toString();
    }

    public OpType getOpType() {
        return opType;
    }

    public Opcode(OpType type) {
        opType = type;
    }
}

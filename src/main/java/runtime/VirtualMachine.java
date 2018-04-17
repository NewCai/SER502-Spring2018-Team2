package runtime;

import java.util.ArrayList;
import java.util.Hashtable;

public class VirtualMachine {

    private ArrayList<Instruction> instructionList = new ArrayList<Instruction>();
    private Hashtable<String, Integer> symbolTabel = new Hashtable<String, Integer>();
    private Hashtable<String, Integer> instructionLabelTabel = new Hashtable<String, Integer>();
    private int instructionPtr;

    public void loadProgramFromFile(String path) {
        instructionList.clear();
    }

    public void executeProgram() {
        initEnvironment();
        executeInstructions();
    }

    public String getInstructionsString() {
        String str = "************************Instrunctions************************\n";
        for (int i = 0; i < instructionList.size(); ++i) {
            str += i + ": " + instructionList.get(i) + "\n";
        }
        return str;
    }

    public String getLabelTableString() {
        String str = "************************Labels************************\n";
        for (String key : instructionLabelTabel.keySet()) {
            str += key + ": " + instructionLabelTabel.get(key) + "\n";
        }
        return str;
    }

    public String getSymbolTabelString() {
        String str = "************************SymbolTabel************************\n";
        for (String key : symbolTabel.keySet()) {
            str += key + ": " + symbolTabel.get(key) + "\n";
        }
        return str;
    }

    protected void addInstruction(String scr) {
        scr = scr.trim();
        String[] splited = scr.split("[\\s:]+");
        int index = 0;
        if (Opcode.getOpType(splited[0]) == Opcode.OpType.NONE) {
            addLabel(splited[0], instructionList.size());
            ++index;
        }

        if (splited.length == 1) { // empty instruction
            instructionList.add(Instruction.createNopInstruction());
        } else {
            String opcode = splited[index++];
            String or1 = null, or2 = null, or3 = null;
            if (index < splited.length) or1 = splited[index++];
            if (index < splited.length) or2 = splited[index++];
            if (index < splited.length) or3 = splited[index++];
            instructionList.add(new Instruction(opcode, or1, or2, or3));
        }
    }

    protected int getLabelIndex(String label) {
        return instructionLabelTabel.get(label);
    }

    protected int getValueFromSysbolTable (String name) {
        if (!symbolTabel.containsKey(name)) {
            symbolTabel.put(name, 0);
        }
        int test = symbolTabel.get(name);
        return symbolTabel.get(name);
    }

    protected void setValueToSysbolTabel(String name, int value) {
        symbolTabel.put(name, value);
    }

    protected int getOprandValue(Oprand oprand) {
        if (oprand.getOprandType() == Oprand.OprandType.VALUE) {
            return oprand.getValue();
        } else {
            return getValueFromSysbolTable(oprand.getName());
        }
    }

    private void initEnvironment() {
        instructionPtr = 0;
        symbolTabel.clear();
    }

    private void executeInstructions() {
        while (instructionPtr < instructionList.size()) {
            Instruction ins = instructionList.get(instructionPtr);
            ++instructionPtr;
            Opcode.OpType opType = ins.getOpcode().getOpType();
            if (Opcode.isBranchOpcode(opType)) {
                executeBranchInstuction(ins);
            } else if (Opcode.isArithmaticOpcode(opType)) {
                executeArithmaticInstuction(ins);
            } else {
                switch (opType) {
                    case MOVE: executeMoveInstuction(ins);break;
                    case JUMP: executeJumpInstuction(ins);break;
                    case PRINT: executePrintInstuction(ins);break;
                    case NOP: break;
                }
            }
        }
    }

    private void executeBranchInstuction(Instruction ins) {
        boolean res = false;
        int or1 = getOprandValue(ins.getOprand1());
        int or2 = getOprandValue(ins.getOprand2());

        switch (ins.getOpcode().getOpType()) {
            case BNEQ: res = or1 == or2; break;
            case BEQ: res = or1 != or2; break;
            case BNGE: res = or1 >= or2; break;
            case BNGT: res = or1 > or2; break;
            case BNLE: res = or1 <= or2; break;
            case BNLT: res = or1 < or2; break;
            default: System.err.print("Unsuported branch opration: " + ins.getOpcode().getOpType()); return;
        }
        if (!res) {
            instructionPtr = getLabelIndex(ins.getOprand3().getName());
        }
    }

    private void executeArithmaticInstuction(Instruction ins) {
        int res = 0;
        int or1 = getOprandValue(ins.getOprand2());
        int or2 = getOprandValue(ins.getOprand3());
        switch (ins.getOpcode().getOpType()) {
            case ADD: res = or1 + or2; break;
            case SUB: res = or1 - or2; break;
            case DIV: res = or1 / or2; break;
            case MUL: res = or1 * or2; break;
            case REM: res = or1 % or2; break;
            default: System.err.println("Unsuported arithmatic opration: " + ins.getOpcode().getOpType()); return;
        }
        setValueToSysbolTabel(ins.getOprand1().getName(), res);
    }

    private void executeMoveInstuction(Instruction ins) {
        setValueToSysbolTabel(ins.getOprand1().getName(), getOprandValue(ins.getOprand2()));
    }

    private void executeJumpInstuction(Instruction ins) {
        instructionPtr = getLabelIndex(ins.getOprand1().getName());
    }

    private void executePrintInstuction(Instruction ins) {
        System.out.println(getOprandValue(ins.getOprand1()));
    }

    private void addLabel(String label, int instructionIndex) {
        instructionLabelTabel.put(label, instructionIndex);
    }
}

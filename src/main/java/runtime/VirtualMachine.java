package runtime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Runtime implementation. An virtual machine parses instructions from a file, and
 * then execute the instructions.
 */
public class VirtualMachine {

    // instructions are stored in a list
    private ArrayList<Instruction> instructionList = new ArrayList<Instruction>();
    // work as an environment which stores all variables at runtime
    private Hashtable<String, Integer> symbolTabel = new Hashtable<String, Integer>();
    // use to store <LabelName, index of instruction>
    private Hashtable<String, Integer> instructionLabelTabel = new Hashtable<String, Integer>();
    // points the index of next instruction at runtime
    private int instructionPtr;

    public void loadProgramFromFile(String path) {
        instructionList.clear();

        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;
            while ((line = in.readLine()) != null) {
                addInstruction(line);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error occur when executing the intermediate code");
            System.out.println(e.getMessage());

        }
    }

    public void executeProgram() {
        initEnvironment();
        executeInstructions();
    }

    /* Debug:print all loaded instructions */
    public String getInstructionsString() {
        String str = "************************Instrunctions************************\n";
        for (int i = 0; i < instructionList.size(); ++i) {
            str += i + ": " + instructionList.get(i) + "\n";
        }
        return str;
    }

    /* Debug:print all labels */
    public String getLabelTableString() {
        String str = "************************Labels************************\n";
        for (String key : instructionLabelTabel.keySet()) {
            str += key + ": " + instructionLabelTabel.get(key) + "\n";
        }
        return str;
    }

    /* Debug:print all variables in the symbol table */
    public String getSymbolTableString() {
        String str = "************************SymbolTabel************************\n";
        for (String key : symbolTabel.keySet()) {
            str += key + ": " + symbolTabel.get(key) + "\n";
        }
        return str;
    }

    protected void addInstruction(String scr) {
        scr = scr.trim();
        boolean hasLabel = scr.contains(":");

        String[] splited = scr.split("[\\s:]+");
        int index = 0;
        if (hasLabel) {
            addLabel(splited[0], instructionList.size()); // save label
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

    protected int getValueFromSymbolTable(String name) {
        if (!symbolTabel.containsKey(name)) {
            symbolTabel.put(name, 0);
        }
        return symbolTabel.get(name);
    }

    protected void setValueToSysbolTabel(String name, int value) {
        symbolTabel.put(name, value);
    }

    protected int getOprandValue(Operand operand) {
        if (operand.getOprandType() == Operand.OprandType.VALUE) {
            return operand.getValue();
        } else {
            return getValueFromSymbolTable(operand.getName());
        }
    }

    private void initEnvironment() {
        instructionPtr = 0;
        symbolTabel.clear();
    }

    private void executeInstructions() {
        while (instructionPtr < instructionList.size()) {
            Instruction ins = instructionList.get(instructionPtr++);
            Opcode.OpType opType = ins.getOpcode().getOpType();
            if (Opcode.isBranchOpcode(opType)) {
                executeBranchInstuction(ins);
            } else if (Opcode.isArithmaticOpcode(opType)) {
                executeArithmaticInstuction(ins);
            } else {
                switch (opType) {
                    case MOVE: executeMoveInstuction(ins); break;
                    case JUMP: executeJumpInstuction(ins); break;
                    case PRINT: executePrintInstuction(ins); break;
                    case NOP: break;
                }
            }
        }
    }

    private void executeBranchInstuction(Instruction ins) {
        boolean res = false;
        int or1 = getOprandValue(ins.getOperand1());
        int or2 = getOprandValue(ins.getOperand2());

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
            instructionPtr = getLabelIndex(ins.getOperand3().getName());
        }
    }

    private void executeArithmaticInstuction(Instruction ins) {
        int res = 0;
        int or1 = getOprandValue(ins.getOperand2());
        int or2 = getOprandValue(ins.getOperand3());
        switch (ins.getOpcode().getOpType()) {
            case ADD: res = or1 + or2; break;
            case SUB: res = or1 - or2; break;
            case DIV: res = or1 / or2; break;
            case MUL: res = or1 * or2; break;
            case REM: res = or1 % or2; break;
            default: System.err.println("Unsuported arithmatic opration: " + ins.getOpcode().getOpType()); return;
        }
        setValueToSysbolTabel(ins.getOperand1().getName(), res);
    }

    private void executeMoveInstuction(Instruction ins) {
        setValueToSysbolTabel(ins.getOperand1().getName(), getOprandValue(ins.getOperand2()));
    }

    private void executeJumpInstuction(Instruction ins) {
        instructionPtr = getLabelIndex(ins.getOperand1().getName());
    }

    private void executePrintInstuction(Instruction ins) {
        System.out.println(getOprandValue(ins.getOperand1()));
    }

    private void addLabel(String label, int instructionIndex) {
        instructionLabelTabel.put(label, instructionIndex);
    }
}

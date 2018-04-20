package runtime;

/**
 * wrapper class for operand in three-address-code
 * A operand can be a value or a name
 */
public class Operand {

    public enum OprandType {
        NONE,
        VALUE,
        NAME, // name can be a label or a lvalue
    }

    private OprandType oprandType;
    private int value;
    private String name;

    public static Operand createNameOperand(String name) {
        Operand or = new Operand();
        or.oprandType = OprandType.NAME;
        or.name = name;
        return or;
    }

    public static Operand createValueOperand(int value) {
        Operand or = new Operand();
        or.oprandType = OprandType.VALUE;
        or.value = value;
        return or;
    }

    public static Operand createViaRawStr(String raw) {
        if (isNumber(raw)) {
            return createValueOperand(Integer.parseInt(raw));
        } else {
            return createNameOperand(raw);
        }
    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+");
    }

    private Operand() {}

    @Override
    public String toString() {
        String str = "{";
        str += "Type: " + oprandType + ", ";
        if (oprandType == OprandType.VALUE) {
            str += "Value: " + value;
        } else if (oprandType == OprandType.NAME) {
            str += "Name: " + name;
        }
        str += "}";
        return str;
    }

    public OprandType getOprandType() {
        return oprandType;
    }

    public int getValue() {
        if (oprandType == OprandType.VALUE) {
            return this.value;
        } else {
            System.err.print("Name does not have a value");
            return 0;
        }
    }

    public String getName() {
        if (oprandType == OprandType.VALUE) {
            System.err.print("Value does not have a name");
            return "";
        } else {
            return name;
        }
    }
}

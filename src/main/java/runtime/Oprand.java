package runtime;

public class Oprand {

    public enum  OprandType {
        NONE,
        VALUE,
        NAME,
    }

    private OprandType oprandType;
    private int value;
    private String name;

    public static Oprand createNameOprand(String name) {
        Oprand or = new Oprand();
        or.oprandType = OprandType.NAME;
        or.name = name;
        return or;
    }

    public static Oprand createValueOprand(int value) {
        Oprand or = new Oprand();
        or.oprandType = OprandType.VALUE;
        or.value = value;
        return or;
    }

    public static Oprand createViaRawStr(String raw) {
        if (isNumber(raw)) {
            return createValueOprand(Integer.parseInt(raw));
        } else {
            return createNameOprand(raw);
        }
    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+");
    }

    private Oprand() {}

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

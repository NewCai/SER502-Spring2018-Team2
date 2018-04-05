package intermediate.lexer;

public class Tag {
    public final static int
        BASIC = 0x01, IF    = 0X02, ELSE = 0X03, EQ    = 0X04,
        TRUE  = 0X05, FALSE = 0X06, GE   = 0X07, LE    = 0X08,
        NE    = 0X09, GT    = 0X10, LT   = 0X11, WHILE = 0X12,
        NUM   = 0X13, TEMP  = 0x14;
}

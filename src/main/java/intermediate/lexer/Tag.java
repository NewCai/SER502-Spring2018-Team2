package intermediate.lexer;

/**
 * Store tag hex number
 */
public class Tag {
    public final static int
        BASIC = 0x01, IF    = 0X02, ELSE = 0X03, EQ    = 0X04,
        TRUE  = 0X05, FALSE = 0X06, GE   = 0X07, LE    = 0X08,
        NE    = 0X09, GT    = 0X0A, LT   = 0X0B, WHILE = 0X0C,
        NUM   = 0X0D, TEMP  = 0x0E, ID   = 0x0F;

}

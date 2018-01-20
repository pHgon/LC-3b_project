package constants;

/**
 *
 * @author pHgon
 */
public class Constants {
    public static final int MEM_SIZE = 65535; // Tamanho da Memória = 2^16
    
    // OPCODE INSTRUÇÕES
    public static final String I_ADD = "0001";
    public static final String I_AND = "0101";
    public static final String I_BR  = "0000";
    public static final String I_JMP = "1100";
    public static final String I_JSR = "0100";
    public static final String I_LDB = "0010";
    public static final String I_LDI = "1010";
    public static final String I_LDR = "0110";
    public static final String I_LEA = "1110";
    public static final String I_NOT = "1001";
    public static final String I_RET = "1100";
    public static final String I_SHF = "1101";
    public static final String I_STB = "0011";
    public static final String I_STI = "1011";
    public static final String I_STR = "0111";
}

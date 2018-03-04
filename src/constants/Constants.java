package constants;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pHgon
 */
public class Constants {
    public static final int MEM_SIZE = 65535; // Tamanho da Memória = 2^16
    
    public static Map<String, String> instructions = new HashMap<>();
    public static Map<String, String> registers = new HashMap<>();
    
    public Constants(){
        // OPCODE INSTRUÇÕES
        this.instructions.put("ADD", "0001");
        this.instructions.put("AND", "0101");
        this.instructions.put("BR",  "0000");
        this.instructions.put("JMP", "1100");
        this.instructions.put("JSR", "0100");
        this.instructions.put("LDB", "0010");
        this.instructions.put("LDI", "1010");
        this.instructions.put("LDR", "0110");
        this.instructions.put("LEA", "1110");
        this.instructions.put("NOT", "1001");
        this.instructions.put("RET", "1100");
        this.instructions.put("SHF", "1101");
        this.instructions.put("STB", "0011");
        this.instructions.put("STI", "1011");
        this.instructions.put("STR", "0111");
    
        // REGISTRADORES BINÁRIOS
        this.registers.put("R0", "000");
        this.registers.put("R1", "001");
        this.registers.put("R2", "010");
        this.registers.put("R3", "011");
        this.registers.put("R4", "100");
        this.registers.put("R5", "101");
        this.registers.put("R6", "110");
        this.registers.put("R7", "111");
    }
}

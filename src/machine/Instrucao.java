package machine;

/**
 *
 * @author mateu
 */
public class Instrucao {
    
    private String opcode;
    private String bits12;
    private int endereco;
    
    Instrucao(String opcode, String bits12, int endereco)
    {
        this.opcode = opcode;
        this.bits12 = bits12;
        this.endereco = endereco;
    }
    
    public String getOpcode()
    {
        return this.opcode;
    }
    public String getBits12()
    {
        return this.bits12;
    }
    public int getEndereco()
    {
        return this.endereco;
    }
    
    @Override
    public String toString()
    {
        return "endereço: |"+ this.endereco + "| opcode: |" + this.opcode + "| (11 - 0) bits: |" + this.bits12 + "|";
    }
}

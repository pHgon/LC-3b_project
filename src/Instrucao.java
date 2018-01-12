/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programcreator;

/**
 *
 * @author mateu
 */
public class Instrucao {
    
    public String opcode;
    public String bits12;
    public int endereco;
    
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

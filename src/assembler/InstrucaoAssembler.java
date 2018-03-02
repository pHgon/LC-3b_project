/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

/**
 *
 * @author mateus
 */
public class InstrucaoAssembler {
    
    private String label;
    private String Operator;
    private String OP1;
    private String OP2;
    private String OP3;
    
    /**
     * 
     * @param l Label
     * @param Oper Operador
     * @param OP1 Operando 1
     * @param OP2 Operando 2
     * @param OP3  Operando 3
     */
    public InstrucaoAssembler(String l, String Oper, String OP1, String OP2, String OP3)
    {
        this.label = l;
        this.Operator = OP1;
        this.OP1 = OP1;
        this.OP2 = OP2;
        this.OP3 = OP3;
    }
    /**
     * getInstrucao
     * 
     * @return retorna Instrucao concatenada no formato da saida
     */
    public  String getInstrucaoFULL()
    {
        return this.label + "\t" + this.Operator + "\t" + this.OP1 + ",\t" + this.OP2 + ",\t" + this.OP3;
    }
    
}

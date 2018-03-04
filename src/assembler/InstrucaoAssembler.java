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
    private String OP4;
    private String OP5;
    
    /**
     * 
     * @param l Label
     * @param Oper Operador
     * @param OP1  Operando 1
     * @param OP2  Operando 2
     * @param OP3  Operando 3
     * @param OP4  Operando 4
     * @param OP5  Operando 5
     */
    public InstrucaoAssembler(String l, String Oper, String OP1, String OP2, String OP3)
    {
        this.label = l;
        this.Operator = Oper;
        this.OP1 = OP1;
        this.OP2 = OP2;
        this.OP3 = OP3;
        this.OP4 = OP4;
        this.OP5 = OP5;
    }
    /**
     * getInstrucao
     * 
     * @return retorna Instrucao concatenada no formato da saida
     */
    public  String getInstrucaoFULL()
    {   
        if(getLabel() == "" && getOperator() != "" && getOP1() == "" && getOP2() == "" && getOP3() == "" && getOP4() == "" && getOP5() == "")
            return "\t" + getOperator();
        if(getLabel() == "" && getOperator() != "" && getOP1() != "" && getOP2() == "" && getOP3() == "" && getOP4() == "" && getOP5() == "")
            return "\t" + getOperator() + "\t" + getOP1();
        if(getLabel() == "" && getOperator() != "" && getOP1() != "" && getOP2() != "" && getOP3() == "" && getOP4() == "" && getOP5() == "")
            return "\t" + getOperator() + "\t" + getOP1() + "\t" + getOP2();
        if(getLabel() == "" && getOperator() != "" && getOP1() != "" && getOP2() != "" && getOP3() != "" && getOP4() == "" && getOP5() == "")
            return "\t" + getOperator()+ "\t" + getOP1() + "\t" + getOP2() + "\t" + getOP3();
        if(getLabel() == "" && getOperator() != "" && getOP1() != "" && getOP2() != "" && getOP3() != "" && getOP4() != "" && getOP5() == "")
            return "\t" + getOperator()+ "\t" + getOP1() + "\t" + getOP2() + "\t" + getOP3() + "\t" + getOP4();   
        if(getLabel() == "" && getOperator() != "" && getOP1() != "" && getOP2() != "" && getOP3() != "" && getOP4() != "" && getOP5() != "")
            return "\t" + getOperator()+ "\t" + getOP1() + "\t" + getOP2() + "\t" + getOP3() + "\t" + getOP4() + "\t" + getOP5();   
        
        if(getLabel() != "" && getOperator() != "" && getOP1() == "" && getOP2() == "" && getOP3() == "" && getOP4() == "" && getOP5() == "")
            return getLabel() + "\t" + getOperator();
        if(getLabel() != "" && getOperator() != "" && getOP1() != "" && getOP2() == "" && getOP3() == "" && getOP4() == "" && getOP5() == "")
            return getLabel() +"\t" + getOperator() + "\t" + getOP1();
        if(getLabel() != "" && getOperator() != "" && getOP1() != "" && getOP2() != "" && getOP3() == "" && getOP4() == "" && getOP5() == "")
            return getLabel() +"\t" + getOperator() + "\t" + getOP1() + "\t" + getOP2();
        if(getLabel() != "" && getOperator() != "" && getOP1() != "" && getOP2() != "" && getOP3() != "" && getOP4() == "" && getOP5() == "")
            return getLabel() +"\t" + getOperator()+ "\t" + getOP1() + "\t" + getOP2() + "\t" + getOP3();
        if(getLabel() != "" && getOperator() != "" && getOP1() != "" && getOP2() != "" && getOP3() != "" && getOP4() != "" && getOP5() == "")
            return getLabel() +"\t" + getOperator()+ "\t" + getOP1() + "\t" + getOP2() + "\t" + getOP3() + "\t" + getOP4();
        if(getLabel() != "" && getOperator() != "" && getOP1() != "" && getOP2() != "" && getOP3() != "" && getOP4() != "" && getOP5() != "")
            return getLabel() +"\t" + getOperator()+ "\t" + getOP1() + "\t" + getOP2() + "\t" + getOP3() + "\t" + getOP4() + "\t" + getOP5();
        
        return getLabel();
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the Operator
     */
    public String getOperator() {
        return Operator;
    }

    /**
     * @param Operator the Operator to set
     */
    public void setOperator(String Operator) {
        this.Operator = Operator;
    }

    /**
     * @return the OP1
     */
    public String getOP1() {
        return OP1;
    }

    /**
     * @param OP1 the OP1 to set
     */
    public void setOP1(String OP1) {
        this.OP1 = OP1;
    }

    /**
     * @return the OP2
     */
    public String getOP2() {
        return OP2;
    }

    /**
     * @param OP2 the OP2 to set
     */
    public void setOP2(String OP2) {
        this.OP2 = OP2;
    }

    /**
     * @return the OP3
     */
    public String getOP3() {
        return OP3;
    }

    /**
     * @param OP3 the OP3 to set
     */
    public void setOP3(String OP3) {
        this.OP3 = OP3;
    }
    /**
     * @return the OP4
     */
    public String getOP4() {
        return OP4;
    }

    /**
     * @param OP4 the OP4 to set
     */
    public void setOP4(String OP4) {
        this.OP4 = OP4;
    }
    /**
     * @return the OP5
     */
    public String getOP5() {
        return OP5;
    }

    /**
     * @param OP5 the OP5 to set
     */
    public void setOP5(String OP5) {
        this.OP5 = OP5;
    }
    
}

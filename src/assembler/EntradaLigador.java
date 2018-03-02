/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author lorenzo
 */
public class EntradaLigador {
    private ArrayList <InstrucaoAssembler> saida;
    private Map<String, Integer> tabelaDeSimbolo;
    private Integer numEnderecos;
    
    public void contarEnderecos(){
        numEnderecos = 0;
        for(int i = 0; i < this.saida.size(); i++){
            String label = saida.get(i).getLabel();
            String operator = saida.get(i).getOperator();
            String OP1 = saida.get(i).getOP1();
            String OP2 = saida.get(i).getOP2();
            String OP3 = saida.get(i).getOP3();            
                        
            if(label != null && !label.isEmpty()){
                numEnderecos++;
            }
            if(operator != null && !operator.isEmpty()){
                numEnderecos++;
            }
            if(OP1 != null && !OP1.isEmpty()){
                numEnderecos++;
            }
            if(OP2 != null && !OP2.isEmpty()){
                numEnderecos++;
            }
            if(OP3 != null && !OP3.isEmpty()){
                numEnderecos++;
            }
        }
        setNumEnderecos(numEnderecos);
    }

    /**
     * @return the saida
     */
    public ArrayList <InstrucaoAssembler> getSaida() {
        return saida;
    }

    /**
     * @param saida the saida to set
     */
    public void setSaida(ArrayList <InstrucaoAssembler> saida) {
        this.saida = saida;
    }

    /**
     * @return the tabelaDeSimbolo
     */
    public Map<String, Integer> getTabelaDeSimbolo() {
        return tabelaDeSimbolo;
    }

    /**
     * @param tabelaDeSimbolo the tabelaDeSimbolo to set
     */
    public void setTabelaDeSimbolo(Map<String, Integer> tabelaDeSimbolo) {
        this.tabelaDeSimbolo = tabelaDeSimbolo;
    }

    /**
     * @return the numEnderecos
     */
    public Integer getNumEnderecos() {
        return numEnderecos;
    }

    /**
     * @param numEnderecos the numEnderecos to set
     */
    public void setNumEnderecos(Integer numEnderecos) {
        this.numEnderecos = numEnderecos;
    }
    
    
}

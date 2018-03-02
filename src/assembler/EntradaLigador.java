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
    
    
}

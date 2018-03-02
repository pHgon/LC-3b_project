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
public class EntradaCarregador {
    private ArrayList <InstrucaoAssembler> saida;
    private Map<String, Integer> tabelaDeSimboloGlobal;
    private Map<String, Integer> tabelaDeDefinicoes;
    private Map<String, Integer> tabelaDeUsoGlobal;

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
     * @return the tabelaDeSimboloGlobal
     */
    public Map<String, Integer> getTabelaDeSimboloGlobal() {
        return tabelaDeSimboloGlobal;
    }

    /**
     * @param tabelaDeSimboloGlobal the tabelaDeSimboloGlobal to set
     */
    public void setTabelaDeSimboloGlobal(Map<String, Integer> tabelaDeSimboloGlobal) {
        this.tabelaDeSimboloGlobal = tabelaDeSimboloGlobal;
    }

    /**
     * @return the tabelaDeDefinicoes
     */
    public Map<String, Integer> getTabelaDeDefinicoes() {
        return tabelaDeDefinicoes;
    }

    /**
     * @param tabelaDeDefinicoes the tabelaDeDefinicoes to set
     */
    public void setTabelaDeDefinicoes(Map<String, Integer> tabelaDeDefinicoes) {
        this.tabelaDeDefinicoes = tabelaDeDefinicoes;
    }

    /**
     * @return the tabelaDeUsoGlobal
     */
    public Map<String, Integer> getTabelaDeUsoGlobal() {
        return tabelaDeUsoGlobal;
    }

    /**
     * @param tabelaDeUsoGlobal the tabelaDeUsoGlobal to set
     */
    public void setTabelaDeUsoGlobal(Map<String, Integer> tabelaDeUsoGlobal) {
        this.tabelaDeUsoGlobal = tabelaDeUsoGlobal;
    }
}

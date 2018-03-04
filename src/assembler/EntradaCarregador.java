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
    private Map<String, String> tabelaDeDefinicoesGlobal;        
    private Integer enderecoInicial;
    
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
     * @return the tabelaDeDefinicoes
     */
    public Map<String, String> getTabelaDeDefinicoes() {
        return getTabelaDeDefinicoesGlobal();
    }

    /**
     * @param tabelaDeDefinicoes the tabelaDeDefinicoes to set
     */
    public void setTabelaDeDefinicoes(Map<String, String> tabelaDeDefinicoes) {
        this.setTabelaDeDefinicoesGlobal(tabelaDeDefinicoes);
    }    

    /**
     * @return the tabelaDeDefinicoesGlobal
     */
    public Map<String, String> getTabelaDeDefinicoesGlobal() {
        return tabelaDeDefinicoesGlobal;
    }

    /**
     * @param tabelaDeDefinicoesGlobal the tabelaDeDefinicoesGlobal to set
     */
    public void setTabelaDeDefinicoesGlobal(Map<String, String> tabelaDeDefinicoesGlobal) {
        this.tabelaDeDefinicoesGlobal = tabelaDeDefinicoesGlobal;
    }    

    /**
     * @return the enderecoInicial
     */
    public Integer getEnderecoInicial() {
        return enderecoInicial;
    }

    /**
     * @param enderecoInicial the enderecoInicial to set
     */
    public void setEnderecoInicial(Integer enderecoInicial) {
        this.enderecoInicial = enderecoInicial;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.util.ArrayList;


/**
 *
 * @author mateus
 */
public class Macro {
    
    private String nome;
   
    private ArrayList<String> parametros;
    private ArrayList<String> instrucoes;
    
    /**
     * Construtor
     * @param nome Nome da Macro
     * @param op   Vetor de Strings contendo os operadores
     */
    public Macro(String[] op)
    {
        this.nome = op[1];
        this.parametros = new ArrayList<>();
        this.instrucoes = new ArrayList<>();
        
        for(int i = 2  ; i< op.length   ; i++)
        {
            parametros.add(op[i]);
        }        
    }
    
    /**
     * Adiciona instrucao
     * @param linha 
     */
    public void addInstrucao(String linha)
    {
        instrucoes.add(linha);    
    }
    /**
     * 
     * @param nome
     * @return  true se for igual
     */
    public boolean checkNome(String nome)
    {
        if(nome.equals(this.nome)) return true;
        return false;   
    }
    /**
     * Retorna true caso parametro esteja na lista
     * senao false
     * @param param
     * @return 
     */
    public boolean checkParam(String param)
    {
        for(String a : parametros)
        {
            if(a.equals(param)) return true;
        }
        return false;
    }
    
    /**
     * pop na lista
     * @return 
     */
    public String getInstruct()
    {
        if(this.instrucoes.size() != 0) return this.instrucoes.remove(0);
        
        return null;
    }
    /**
     * Retorna true caso nome esteja nas intrucoes
     * @param nome
     * @return 
     */
    public boolean findNome(String nome)
    {
        for(String a : instrucoes)
        {
            if(a.compareTo(nome) == 0) return true;
        }
        return false;
    }
    /**
     * Retorna parametro[i]
     * @param i
     * @return 
     */
    public String getParam(int i)
    {
        return parametros.get(i);
    }
    /**
     * Retorna index do parametro nome
     * @param nome
     * @return 
     */
    public int getParamIndex(String nome)
    {
        for(String s : parametros)
        {
            if(s.equals(nome)) return parametros.indexOf(nome);
        }
        return -1;
    }
}

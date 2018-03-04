/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public class ProcessadorMacro {
    
    public ArrayList <InstrucaoAssembler> saida; // Publico para uso no MONTADOR
    private ArrayList<Macro> macros;
    private String nomeArquivo;
    
    /**
     * Cria Processador 
     * e processa entrada do nomeArquivo
     * @param nomeArquivo 
     */
    public ProcessadorMacro(String nomeArquivo)
    {
        saida =  new ArrayList<>();
        macros = new ArrayList<>();
        this.nomeArquivo = nomeArquivo;
        
        //ler arquivo.
        try(BufferedReader br =  new BufferedReader(new FileReader(nomeArquivo)))
        {
            String linha = br.readLine(); 
            while(linha != null)
            {
                String partes[] = linha.split("\\t");

                switch(partes[0])
                {
                    case ".ORIG":
                        InstrucaoAssembler comeco = new InstrucaoAssembler(linha,"","","","", "", "");
                        saida.add(comeco);
                        break;
                    case ".END":
                        InstrucaoAssembler fim = new InstrucaoAssembler(linha,"","","","", "", "");
                        saida.add(fim);
                        break;
                    case "":
                        if(partes[1].equals("MCDEFN"))
                        {
                           linha = br.readLine(); // leio proxima linha
                           Macro temp = DefinitionMode(linha); // entrei em definicao
                           linha  = br.readLine(); // pego proxima linha
                           while(linha.compareTo("\tMCEND") != 0) // até o fim da macro adiciono a lista de instrucoes da macro
                            {
                               temp.addInstrucao(linha);
                               linha = br.readLine();
                            }    
                           macros.add(temp); // defino macro
                        }else if(verifyMacroName(partes[1])) // macro ja foi definida TA NA HORA DE EXPADIRRRRR
                        {
                            ExpantionMode(linha);
                        }else
                        {   
                            String[] copia = new String[5];
                            String[] splitOut = linha.split("\\t");
                            for(int i = 0; i<copia.length; i++) copia[i] = "";
                                  
                             for(int i  = 0 ; i<splitOut.length; i++)
                            {
                                copia[i] = splitOut[i];
                            }
                            InstrucaoAssembler expndedMacro = new InstrucaoAssembler(copia[0],copia[1],copia[2],copia[3],copia[4], "", "");
                            saida.add(expndedMacro); 
                        }                                                        
                       break;
                }
                linha = br.readLine();
            
            }
            
        }catch(IOException ioe)
        {
            System.out.println("\n\n Erro Ao abrir arquivo de leitura Processador de Macros \n\n");
        }    
        
        
    }
    /**
     * Função de retorno de saida
     * @return arraylist < instrucaoAssembler>
     */
    public ArrayList getEntradaMontador()
    {
        return this.saida;
    }
    /**
     * 
     * @param nome
     * @return true se macro ja foi definida
     */
    private boolean verifyMacroName(String nome)
    {
        for(Macro m : macros)
        {
            if(m.checkNome(nome)) return true;
        }
        return false;
    }
    
    /**
     * Printa saida
     */
    public void printExpanded()
    {
        for(InstrucaoAssembler a : saida)
        {
            System.out.println(a.getInstrucaoFULL());
        }
    }
    /**
     * 
     * @param linha entrada de uma linha completa
     * NOME Op1 Op2 Op3 Op4 .... Opn
     * @return 
     */
    private Macro DefinitionMode(String linha)
    {   
        String[] op = linha.split("\\t");
        
        Macro macro =  new Macro(op);
        
        return macro;    
    }
    
    /**
     * 
     * @param nome
     * @return Procura Macro em lista de macros definidas 
     */
    private Macro FindMacro(String nome)
    {
        for(Macro m: macros)
        {
            if (m.checkNome(nome)) return m;
        }
        return null;
    }
    /**
     * Expande macro
     * @param linha contendo chamada da macro e operadores
     */
    private void ExpantionMode(String linha)
    {
        //System.out.println("entrou expation");
        String[] temp = linha.split("\\t");
        Macro aux = FindMacro(temp[1]);
        if(aux != null)
        {
            String out = aux.getInstruct();
            while(out != null)
            {
                String[] splitOut = out.split("\\t");
                //System.out.println("splitou macro");
                for(int i = 2 ; i < splitOut.length ;  i++)
                {
                    if(aux.checkParam(splitOut[i]))
                    {
                        int j = aux.getParamIndex(splitOut[i]);
                        splitOut[i] = temp[j+2];
                    }
                    continue;
                    
                }
                String[] copia = new String[5];
                for(int i = 0; i<copia.length; i++) copia[i] = "";
                                  
                for(int i  = 0 ; i<splitOut.length; i++)
                {
                    copia[i] = splitOut[i];
                }
                InstrucaoAssembler expndedMacro = new InstrucaoAssembler(copia[0],copia[1],copia[2],copia[3],copia[4],"","");
                saida.add(expndedMacro);
                    
                out = aux.getInstruct();
            }
        }    
    }
}

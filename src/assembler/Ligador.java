/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lorenzo
 */
public class Ligador {
    public Ligador(){}

    /**
     *
     * @return
     */
    public EntradaCarregador liga(ArrayList<EntradaLigador> entradasLigador){
        EntradaCarregador entradaCarregador = new EntradaCarregador();
        ArrayList<InstrucaoAssembler> intrucoesAssemblerGeral = new ArrayList<>();
        int offsetModulos = 0;
        Map<String, String> tabelaDefinicaoGlobal = new HashMap<>();
        
        //percorre todos os modulos 
        for(int i = 0; i < entradasLigador.size(); i++){
            //pega as instrucoes do modulo
            ArrayList<InstrucaoAssembler> saida = entradasLigador.get(i).getSaida();            
            
            //pega a tabela de simbolos
            Map tabelaDeSimbolos = entradasLigador.get(i).getTabelaDeSimbolo();
            
            //copia as instrucoes
            for(int j = 0; j < saida.size(); j++){
                intrucoesAssemblerGeral.add(saida.get(j));
            }
            
            //percorre a tabela de simbolos e vê se existem novos simbolos e atribui o endereco correto
            System.out.println("\nTabela de Definição do Modulo " + i + ":\n");            
            for (String temp : entradasLigador.get(i).getTabelaDeSimbolo().keySet()) {
                System.out.println(temp + " " + tabelaDeSimbolos.get(temp));
                if(tabelaDeSimbolos.get(temp) != "null"){
                    int address = Integer.parseInt((String) tabelaDeSimbolos.get(temp));
                    tabelaDefinicaoGlobal.put(temp, Integer.toString(address + offsetModulos));   
                }                                
            }
            offsetModulos += entradasLigador.get(i).getNumEnderecos();            
        }
        
        
        System.out.println("\nTabela de Definições Global:\n");            
        for (String temp : tabelaDefinicaoGlobal.keySet()) {
            System.out.println(temp + " " + tabelaDefinicaoGlobal.get(temp));                
        }
        System.out.println();

        
        entradaCarregador.setSaida(intrucoesAssemblerGeral);
        entradaCarregador.setTabelaDeDefinicoes(tabelaDefinicaoGlobal);
        return entradaCarregador;
    }
}

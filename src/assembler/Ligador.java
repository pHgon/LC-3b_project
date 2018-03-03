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
        System.out.println();

        for(int i = 0; i < intrucoesAssemblerGeral.size(); i++){
            System.out.println(intrucoesAssemblerGeral.get(i).getInstrucaoFULL());            
        }
        System.out.println();

        
        for(int i = 0; i < intrucoesAssemblerGeral.size(); i++){
            InstrucaoAssembler inst = intrucoesAssemblerGeral.get(i);
            if(tabelaDefinicaoGlobal.get(inst.getOP1()) != null ){
                //existe o simbolo                
                Integer pos = Integer.parseInt(tabelaDefinicaoGlobal.get(inst.getOP1()));
                pos = this.contarLinhas(intrucoesAssemblerGeral, pos);

                if(".INTDEF".equals(intrucoesAssemblerGeral.get(pos).getOperator())){
                    //eh constante
                    intrucoesAssemblerGeral.get(i).setOP1(intrucoesAssemblerGeral.get(pos).getOP1());
                }
                else{
                    //eh label
                    intrucoesAssemblerGeral.get(i).setOP1(Integer.toString(pos));
                }
            }
            if(tabelaDefinicaoGlobal.get(inst.getOP2()) != null ){
                //existe o simbolo                
                Integer pos = Integer.parseInt(tabelaDefinicaoGlobal.get(inst.getOP2()));
                pos = this.contarLinhas(intrucoesAssemblerGeral, pos);
                //System.out.println("OP2: " + inst.getOP2() + " Valor na Tabela: " + tabelaDefinicaoGlobal.get(inst.getOP2()) + " linha: " + pos);
                if(".INTDEF".equals(intrucoesAssemblerGeral.get(pos).getOperator())){
                    //eh constante
                    intrucoesAssemblerGeral.get(i).setOP2(intrucoesAssemblerGeral.get(pos).getOP1());
                }
                else{
                    //eh label
                    intrucoesAssemblerGeral.get(i).setOP2(Integer.toString(pos));
                }
            }
            if(tabelaDefinicaoGlobal.get(inst.getOP3()) != null ){
                //existe o simbolo                
                Integer pos = Integer.parseInt(tabelaDefinicaoGlobal.get(inst.getOP3()));
                pos = this.contarLinhas(intrucoesAssemblerGeral, pos);

                if(".INTDEF".equals(intrucoesAssemblerGeral.get(pos).getOperator())){
                    //eh constante
                    intrucoesAssemblerGeral.get(i).setOP3(intrucoesAssemblerGeral.get(pos).getOP1());
                }
                else{
                    //eh label
                    intrucoesAssemblerGeral.get(i).setOP3(Integer.toString(pos));
                }
            }
            
            System.out.println(intrucoesAssemblerGeral.get(i).getInstrucaoFULL());            
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

    private Integer contarLinhas(ArrayList<InstrucaoAssembler> intrucoesAssemblerGeral, Integer pos) {
        int temp = 0, contador = 0;
        for(int i = 0; i < intrucoesAssemblerGeral.size(); i++){            
            contador++;
            if(intrucoesAssemblerGeral.get(i).getOP1() != null && !intrucoesAssemblerGeral.get(i).getOP1().isEmpty()){
                contador++;
            }
            if(intrucoesAssemblerGeral.get(i).getOP2() != null && !intrucoesAssemblerGeral.get(i).getOP2().isEmpty()){
                contador++;
            }
            if(intrucoesAssemblerGeral.get(i).getOP3() != null && !intrucoesAssemblerGeral.get(i).getOP3().isEmpty()){
                contador++;
            }
            temp++;
            if(contador >= pos){
                break;
            }
        }
        return temp;
    }
}

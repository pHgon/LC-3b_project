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
            entradasLigador.get(i).contarEnderecos();
            
            //pega as instrucoes do modulo
            ArrayList<InstrucaoAssembler> saida = entradasLigador.get(i).getSaida();            
            
            //pega a tabela de simbolos
            Map tabelaDeSimbolos = entradasLigador.get(i).getTabelaDeSimbolo();
            
            //copia as instrucoes
            for(int j = 0; j < saida.size(); j++){
                if(!"HALT".equals(saida.get(j).getOperator())){
                    intrucoesAssemblerGeral.add(saida.get(j));
                }
            }
            
            //percorre a tabela de simbolos e vê se existem novos simbolos e atribui o endereco correto
            System.out.println("\nTabela de Definição do Modulo " + i + ":\n");            
            for (String temp : entradasLigador.get(i).getTabelaDeSimbolo().keySet()) {
                System.out.println(temp + " " + tabelaDeSimbolos.get(temp));
                if(tabelaDeSimbolos.get(temp) != "null"){
                    String value = (String) tabelaDeSimbolos.get(temp);
                    if(value.indexOf('#') >= 0){
                        tabelaDefinicaoGlobal.put(temp, value);      
                    }
                    else{
                        int address = Integer.parseInt((String) value);                    
                        tabelaDefinicaoGlobal.put(temp, Integer.toString(address + offsetModulos));      
                    }                    
                }                                
            }
            offsetModulos += entradasLigador.get(i).getNumEnderecos();            
        }
        System.out.println();
        
        System.out.println("instrucoes geral:");            
        for(int i = 0; i < intrucoesAssemblerGeral.size(); i++){
            System.out.println(intrucoesAssemblerGeral.get(i).getInstrucaoFULL());            
        }
        System.out.println();

        
        for(int i = 0; i < intrucoesAssemblerGeral.size(); i++){
            InstrucaoAssembler inst = intrucoesAssemblerGeral.get(i);
            if(tabelaDefinicaoGlobal.get(inst.getOP1()) != null ){
                //existe o simbolo                
                if((tabelaDefinicaoGlobal.get(inst.getOP1())).indexOf('#') >= 0){
                    //eh constante
                    intrucoesAssemblerGeral.get(i).setOP1(tabelaDefinicaoGlobal.get(inst.getOP1()));
                }
                else{
                    //eh label
                    Integer pos = Integer.parseInt(tabelaDefinicaoGlobal.get(inst.getOP1()));
                    //pos = this.contarLinhas(intrucoesAssemblerGeral, pos);
                    intrucoesAssemblerGeral.get(i).setOP1(Integer.toString(pos));
                }
            }
            if(tabelaDefinicaoGlobal.get(inst.getOP2()) != null ){
                //existe o simbolo                                                                
                if((tabelaDefinicaoGlobal.get(inst.getOP2())).indexOf('#') >= 0){
                    //eh constante
                    intrucoesAssemblerGeral.get(i).setOP2(tabelaDefinicaoGlobal.get(inst.getOP2()));
                }
                else{
                    //eh label
                    Integer pos = Integer.parseInt(tabelaDefinicaoGlobal.get(inst.getOP2()));
                    //pos = this.contarLinhas(intrucoesAssemblerGeral, pos);
                    intrucoesAssemblerGeral.get(i).getInstrucaoFULL();
                    intrucoesAssemblerGeral.get(i).setOP2(Integer.toString(pos));
                    intrucoesAssemblerGeral.get(i).getInstrucaoFULL();
                }
            }
            if(tabelaDefinicaoGlobal.get(inst.getOP3()) != null ){
                //existe o simbolo                
                if((tabelaDefinicaoGlobal.get(inst.getOP3())).indexOf('#') >= 0){
                    //eh constante
                    intrucoesAssemblerGeral.get(i).setOP3(tabelaDefinicaoGlobal.get(inst.getOP3()));
                }
                else{
                    //eh label
                    Integer pos = Integer.parseInt(tabelaDefinicaoGlobal.get(inst.getOP3()));
                    //pos = this.contarLinhas(intrucoesAssemblerGeral, pos);
                    intrucoesAssemblerGeral.get(i).setOP3(Integer.toString(pos));
                }
            }
            if(tabelaDefinicaoGlobal.get(inst.getOP4()) != null ){
                //existe o simbolo                
                if((tabelaDefinicaoGlobal.get(inst.getOP4())).indexOf('#') >= 0){
                    //eh constante
                    intrucoesAssemblerGeral.get(i).setOP4(tabelaDefinicaoGlobal.get(inst.getOP4()));
                }
                else{
                    //eh label
                    Integer pos = Integer.parseInt(tabelaDefinicaoGlobal.get(inst.getOP4()));
                    //pos = this.contarLinhas(intrucoesAssemblerGeral, pos);
                    intrucoesAssemblerGeral.get(i).setOP4(Integer.toString(pos));
                }
            }
            if(tabelaDefinicaoGlobal.get(inst.getOP5()) != null ){
                //existe o simbolo                
                if((tabelaDefinicaoGlobal.get(inst.getOP5())).indexOf('#') >= 0){
                    //eh constante
                    intrucoesAssemblerGeral.get(i).setOP5(tabelaDefinicaoGlobal.get(inst.getOP5()));
                }
                else{
                    //eh label
                    Integer pos = Integer.parseInt(tabelaDefinicaoGlobal.get(inst.getOP5()));
                    //pos = this.contarLinhas(intrucoesAssemblerGeral, pos);
                    intrucoesAssemblerGeral.get(i).setOP5(Integer.toString(pos));
                }
            }
            
            System.out.println(intrucoesAssemblerGeral.get(i).getInstrucaoFULL());            
        }
                                
        entradaCarregador.setSaida(intrucoesAssemblerGeral);
        entradaCarregador.setTabelaDeDefinicoes(tabelaDefinicaoGlobal);
        entradaCarregador.setEnderecoInicial(entradasLigador.get(0).getEnderecoInicial());
        
        return entradaCarregador;        
    }

    private Integer contarLinhas(ArrayList<InstrucaoAssembler> intrucoesAssemblerGeral, Integer pos) {
        int temp = 0, contador = 0;
        for(int i = 0; i < intrucoesAssemblerGeral.size(); i++){            
            contador++;            
                        
            switch(intrucoesAssemblerGeral.get(i).getOperator()){
                case "0001":
                    contador += 4;
                    break;
                case "0101":
                    contador += 4;
                    break;
                case "0000":
                    contador += 3;
                    break;
                case "1100":
                    if(!"111".equals(intrucoesAssemblerGeral.get(i).getOP2())){
                        //jmp
                        contador += 2;
                    }
                    else{
                        //ret
                        contador += 1;
                    }                    
                    break;
                case "0100":
                    contador += 2;
                    break;                    
                case "1001":
                    contador += 3;
                    break;            
                case "0010":
                    contador += 4;
                    break;      
                case "1010":
                    contador += 4;
                    break;  
                case "0110":
                    contador += 4;
                    break;  
                case "1110":
                    contador += 3;
                    break;              
                case "1101":
                    contador += 4;
                    break; 
                case "0011":
                    contador += 4;
                    break; 
                case "1011":
                    contador += 4;
                    break;                 
                case "0111":
                    contador += 4;
                    break;           
            }        
            
            temp++;
            if(contador >= pos){
                break;
            }
        }
        return temp;
    }
}

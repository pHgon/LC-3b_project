/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import machine.ProgramList;

/**
 *
 * @author lorenzo
 */
public class Carregador {
    private EntradaCarregador  entradaCarregador;
    private int enderecoInicial;
    public Carregador(EntradaCarregador _entradaCarregador) {
        this.entradaCarregador = _entradaCarregador;
        this.enderecoInicial = this.entradaCarregador.getEnderecoInicial();
    }

    public void carrega(String arquivo) {
        try {
            PrintWriter out = new PrintWriter(arquivo);
            ArrayList<InstrucaoAssembler> saida = this.entradaCarregador.getSaida();
            String output = "";
            String temp = "";
            
            for(int i = 0; i < saida.size(); i++){ 
                InstrucaoAssembler inst = saida.get(i);
                output += inst.getOperator();
                switch(saida.get(i).getOperator()){
                    case "0001":
                        output += inst.getOP1();
                        output += inst.getOP2();
                        output += inst.getOP3();
                        if("0".equals(saida.get(i).getOP3())){
                            output += "00" + inst.getOP4();
                        }
                        else{
                            output += this.extend(this.removeHashtag(inst.getOP4()), 5);
                        }                        
                        break;
                    case "0101":
                        output += inst.getOP1();
                        output += inst.getOP2();
                        output += inst.getOP3();
                        if("0".equals(saida.get(i).getOP3())){
                            output += "00" + inst.getOP5();
                        }
                        else{                            
                            output += this.extend(this.removeHashtag(inst.getOP4()), 5);
                        }                        
                        break;
                    case "0000":
                        output += inst.getOP1();                      
                        
                        temp = Integer.toString(Integer.parseInt(inst.getOP2()) + this.enderecoInicial);
                        output += this.extend(this.removeHashtag(temp), 9);
                        break;
                    case "1100":
                        output += "000";
                        if(!"111".equals(inst.getOP2())){
                            //jmp
                            output += inst.getOP2();
                        }
                        else{
                            //ret
                            output += "111";
                        }
                        output += "000000";                        
                        break;
                    case "0100":
                        if("1".equals(inst.getOP1())){
                            //jsr
                            output += "1";
                            temp = Integer.toString(Integer.parseInt(inst.getOP2()) + this.enderecoInicial);                            
                            output += this.extend(this.removeHashtag(temp), 11);
                        }
                        else{
                            //jrr
                            output += "000";
                            output += inst.getOP3();
                            output += "000000";
                        }                        
                        break;                    
                    case "1001":
                        output += inst.getOP1();
                        output += inst.getOP2();
                        output += "111111";                        
                        break;            
                    case "0010":                        
                        output += inst.getOP1();
                        output += inst.getOP2();
                        
                        temp = Integer.toString(Integer.parseInt(inst.getOP3()) + this.enderecoInicial);                            
                        output += this.extend(this.removeHashtag(temp), 6);                        
                        break;      
                    case "1010":
                        output += inst.getOP1();
                        output += inst.getOP2();
                        temp = Integer.toString(Integer.parseInt(inst.getOP3()) + this.enderecoInicial);                            
                        output += this.extend(this.removeHashtag(temp), 6);                        
                        //offsetPC = this.ldi(instruction, pc, mem);
                        break;  
                    case "0110":
                        output += inst.getOP1();
                        output += inst.getOP2();
                        temp = Integer.toString(Integer.parseInt(inst.getOP3()) + this.enderecoInicial);                            
                        output += this.extend(this.removeHashtag(temp), 6);                        
                        //offsetPC = this.ldr(instruction, pc, mem);
                        break;  
                    case "1110":
                        output += this.extend(this.removeHashtag(inst.getOP1()), 3);                                                                             
                        output += this.extend(this.removeHashtag(inst.getOP2()), 9);                        
                        //offsetPC = this.lea(instruction, pc, mem);
                        break;              
                    case "1101":
                        output += inst.getOP1();
                        output += inst.getOP2();
                        output += inst.getOP3();
                        output += inst.getOP4();                        
                        output += this.extend(this.removeHashtag(inst.getOP5()), 4);
                        //offsetPC = this.shf(instruction, pc, mem);
                        break; 
                    case "0011":
                        output += inst.getOP1();
                        output += inst.getOP2();                        
                        temp = Integer.toString(Integer.parseInt(inst.getOP3()) + this.enderecoInicial);                            
                        output += this.extend(this.removeHashtag(temp), 6);                        
                        //offsetPC = this.stb(instruction, pc, mem);
                        break; 
                    case "1011":
                        output += inst.getOP1();
                        output += inst.getOP2();
                        temp = Integer.toString(Integer.parseInt(inst.getOP3()) + this.enderecoInicial);                            
                        output += this.extend(this.removeHashtag(temp), 6);                        
                        //offsetPC = this.sti(instruction, pc, mem);
                        break;                 
                    case "0111":
                        output += inst.getOP1();
                        output += inst.getOP2();
                        //temp = Integer.toString(Integer.parseInt(inst.getOP3()) + this.enderecoInicial);                            
                        output += this.extend(this.removeHashtag(inst.getOP3()), 6);                        
                        //offsetPC = this.str(instruction, pc, mem);
                        break;
                }         
                //System.out.println(output);                
                System.out.println(inst.getInstrucaoFULL() + " ??: " + output);
                //output += "\n";                                
                out.println(output);                
                output = "";
            }                                
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Carregador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the entradaCarregador
     */
    public EntradaCarregador getEntradaCarregador() {
        return entradaCarregador;
    }

    /**
     * @param entradaCarregador the entradaCarregador to set
     */
    public void setEntradaCarregador(EntradaCarregador entradaCarregador) {
        this.entradaCarregador = entradaCarregador;
    }
    
    private String removeHashtag(String value){
        int temp;
        if(value.contains("#")){
            temp = Integer.parseInt(value.replace("#", ""));         
        }
        else {
            temp = Integer.parseInt(value);         
        }        
        return Integer.toBinaryString(temp);
    }
    private String stringToBin(String value){        
        int temp = Integer.parseInt(value);                        
        return Integer.toBinaryString(temp);
    }
    private String extend(String value, int number ){
        String result = value.substring(0);
        
        if(value.length() > number){
            return result.substring(result.length() - number);
        }
        
        System.out.println("Size velus: " + value.length() + " - " + number);        
                
        for (int i = value.length(); i < number; i++) {
            result =  "0" + result;
        }
        System.out.println(value + "- Result: " + result);        

        return result;
    }
}

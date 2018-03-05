package assembler;

import constants.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import assembler.InstrucaoAssembler;
import assembler.EntradaLigador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author pHgon
 */
public class Assembler {
    Constants c = new Constants(); // Classe com as constantes
    
    private EntradaLigador linkdate;
    private ArrayList <InstrucaoAssembler> instList;
    private Map<String, String> symTable;
    private Integer actAddress;
    private Integer lineAddress;
    
    
    public Assembler(){
        this.linkdate = new EntradaLigador();
        this.instList = new ArrayList();
        this.symTable = new HashMap<>();
        this.actAddress = 0;
        this.lineAddress = 0;
        
        try{
            BufferedReader file = new BufferedReader(new FileReader("../LC3Monted.txt"));
            
            String line = file.readLine();
            while(line != null){
                setModule(line.split("\t"));
                line = file.readLine();
            }
            
            file.close();
            
            for(int i=0; i<instList.size(); i++){
                System.out.println(instList.get(i).getInstrucaoFULL());
            }
            System.out.println();
            for(Map.Entry<String, String> entry : this.symTable.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
           
        }
        catch(IOException e){
            System.err.printf("ERROR: %s\n", e.getMessage());
        }
    }
    
    public Assembler(ArrayList<InstrucaoAssembler> input){
        this.linkdate = new EntradaLigador();
        this.instList = new ArrayList();
        this.symTable = new HashMap<>();
        this.actAddress = 0;
        this.lineAddress = -1;

        for(int i=0; i<input.size(); i++){
            setModule(input.get(i).getInstrucaoFULL().split("\t"));
            this.lineAddress += 1;            
        }
            
        for(int i=0; i<instList.size(); i++){
            System.out.println(instList.get(i).getInstrucaoFULL());
        }
        System.out.println();
        for(Map.Entry<String, String> entry : this.symTable.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }
    
    
    private void setModule(String[] line){
        if(line[0].equals(".ORIG")){
            this.linkdate.setEnderecoInicial(Integer.parseInt(line[1]));
            return;
        }
        
        if(line[0].equals(".END")){
            return;
        }
        
        if(!line[0].equals("")){
            //System.out.println("LABEL: " + line[0] + " - " + Integer.toString(this.lineAddress));
            //this.symTable.put(line[0], Integer.toString(this.actAddress));
            this.symTable.put(line[0], Integer.toString(this.lineAddress));
        }
        
        if(line.length>2){
            if(line[2].equals(".INTDEF")){
                this.symTable.put(line[1], line[3]);
                return;
            }
            if(line[2].equals(".INTUSE")){
                this.symTable.put(line[1], "null");
                return;
            }
        }
        
        for(Map.Entry<String, String> entry : c.instructions.entrySet()){
            if(line[1].equals(entry.getKey())){
                line[1] = entry.getValue();
                break;
            }
        }
            
        boolean isSymbol;
        for(int i=2; i<line.length; i++){
            isSymbol = true;
            for(Map.Entry<String, String> entry : c.registers.entrySet()){
                if(line[i].equals(entry.getKey())){
                    line[i] = entry.getValue();
                    isSymbol = false;
                    break;
                }
            }
            if(isSymbol){
                for(Map.Entry<String, String> entry : symTable.entrySet()){
                    if(line[i].equals(entry.getKey())){
                        isSymbol = false;
                    }
                }
                if(isSymbol){
                    if(line[i].charAt(0) != '#'){
                        this.symTable.put(line[i], "null");
                    }
                }
            }
        }

        switch(line.length){
            case 2:
                this.instList.add(new InstrucaoAssembler(line[0], line[1], "", "", "","",""));
                break;
            case 3:
                this.instList.add(new InstrucaoAssembler(line[0], line[1], line[2], "", "", "", ""));
                this.actAddress+=1;
                break;
            case 4:
                if(line[1].equals("0000")){
                    switch(line[2].charAt(1)){
                        case '0':
                            this.instList.add(new InstrucaoAssembler(line[0], line[1], "000", line[3], "", "", ""));
                            break;
                        case '1':
                            this.instList.add(new InstrucaoAssembler(line[0], line[1], "001", line[3], "", "", ""));
                            break;
                        case '2':
                            this.instList.add(new InstrucaoAssembler(line[0], line[1], "010", line[3], "", "", ""));
                            break;
                        case '3':
                            this.instList.add(new InstrucaoAssembler(line[0], line[1], "011", line[3], "", "", ""));
                            break;
                        case '4':
                            this.instList.add(new InstrucaoAssembler(line[0], line[1], "100", line[3], "", "", ""));
                            break;
                        case '5':
                            this.instList.add(new InstrucaoAssembler(line[0], line[1], "101", line[3], "", "", ""));
                            break;
                        case '6':
                            this.instList.add(new InstrucaoAssembler(line[0], line[1], "110", line[3], "", "", ""));
                            break;
                        case '7':
                            this.instList.add(new InstrucaoAssembler(line[0], line[1], "111", line[3], "", "", ""));
                            break;
                        default:
                            this.instList.add(new InstrucaoAssembler(line[0], line[1], "000", line[3], "", "", ""));
                            break;
                    }
                }
                else{
                    this.instList.add(new InstrucaoAssembler(line[0], line[1], line[2], line[3], "", "", ""));
                }
                this.actAddress+=2;
                break;
            default:
                if(line[1].equals("0001") || line[1].equals("0101")){ // ADD ou AND
                    if(line[4].charAt(0) == '#'){
                        this.instList.add(new InstrucaoAssembler(line[0], line[1], line[2], line[3], "1", line[4], ""));
                    }
                    else{
                        this.instList.add(new InstrucaoAssembler(line[0], line[1], line[2], line[3], "0", line[4], ""));
                    }
                }
                else{
                    this.instList.add(new InstrucaoAssembler(line[0], line[1], line[2], line[3], line[4], "", ""));
                }
                this.actAddress+=3;
        }
        
    }
    
    public String geTableSymb()
    {
        String saida = "";
        for(Map.Entry<String, String> a : symTable.entrySet())
        {
            saida =  saida + "\t" +a.getKey() + "\t|"+ "\t" + a.getValue() + "\t|\n";
        }
        return saida;
    }
    
    
    public EntradaLigador getOutput(){
        this.linkdate.setSaida(this.instList);
        this.linkdate.setTabelaDeSimbolo(this.symTable);
        return this.linkdate;
    }
}

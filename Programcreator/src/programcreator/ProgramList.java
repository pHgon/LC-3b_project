/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programcreator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mateu
 */
public class ProgramList {
    
    public ArrayList <Instrucao> programa;
    public int offset;
    
    public ProgramList (int offset) 
    {
        this.offset = offset;
        this.programa = new ArrayList<>();                
    }
    
    public void geraPrograma(String arquivo)
    {
        int i = 0;
        String opcode;
        String bits12;
               
        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine();
            while(linha != null)
            {                
                if(i != 0)
                {
                    opcode = linha.substring(0, 3);
                    bits12 = linha.substring(4,15);
                    Instrucao atual = new Instrucao(opcode,bits12,offset+i);
                    programa.add(atual);
                    i+=1;                    
                }else
                {
                    this.offset = Integer.parseInt(linha,2);
                    i+=1;
                }
                linha = br.readLine();
            }
        }catch(IOException ioe)
        {
        }
    }
    
    public Instrucao getInstrucao(int endereco)
    {
        for(Instrucao temp : programa)
        {
            if(temp.getEndereco() == endereco) return temp;
        }
        
        return null;
    } 
    
    void PrintIntrucao()
    {
        for(Instrucao temp : programa)
        {
            System.out.println(temp);
        }
    }
 
    
}

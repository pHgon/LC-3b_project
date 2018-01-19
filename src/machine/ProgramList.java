package machine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mateu
 */
public class ProgramList {
    
    private ArrayList <Instrucao> programa;
    private int offset;
    
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
                    opcode = linha.substring(0, 4);
                    bits12 = linha.substring(4,16);
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
            System.out.println("\n\n ERRO AO ABRIR ARQUIVO ");
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
    
    public void PrintIntrucao()
    {
        for(Instrucao temp : programa)
        {
            System.out.println(temp);
        }
    }
 
    public int getNInstructions (){
        return this.programa.size();
    }
}

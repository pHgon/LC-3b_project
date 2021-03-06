package machine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public class ProgramList {
    
    private ArrayList <Instrucao> programa;
    private int offset;
    
    public ProgramList () 
    {        
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
                    Instrucao atual = new Instrucao(opcode,bits12,getOffset()+i);
                    programa.add(atual);
                    i+=1;                    
                }else
                {
                    this.setOffset(Integer.parseInt(linha,2));
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
    
    public String PrintIntrucao()
    {
        String stream = "";


        for(Instrucao temp : programa)
        {
            stream = stream + temp.toString() + "\n";
            
        }
        return stream;
    }
 
    public int getNInstructions (){
            return this.programa.size();
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }
}

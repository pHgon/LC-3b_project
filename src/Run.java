import assembler.EntradaCarregador;
import assembler.EntradaLigador;
import assembler.InstrucaoAssembler;
import assembler.Ligador;
import assembler.ProcessadorMacro;
import assembler.Assembler;
import assembler.Carregador;
import machine.*;
import constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mateus
 */
public class Run {
    public static final class c extends Constants{} // Classe com as constantes

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args)
    {
    
        // chama duas vezes o processador de macros, uma para cada modulo e retorna entrada para MONTADOR
        ProcessadorMacro pr1 = new ProcessadorMacro("LC3EntradaProcMacro.txt");
        //pr1.printExpanded();
        ArrayList<InstrucaoAssembler> entradaMontador1 = pr1.getEntradaMontador();
        /*for(InstrucaoAssembler a : entradaMontador1)
        {
           System.out.println(a.getInstrucaoFULL());
        }*/
        
        ProcessadorMacro pr2 = new ProcessadorMacro("LC3EntradaProcMacro2.txt");
        //pr1.printExpanded();
        //System.out.println(pr1.getSaidaDef());
        //System.out.println(pr1.getSaidaExp());
        //pr2.printExpanded();

        ArrayList<InstrucaoAssembler> entradaMontador2 = pr2.getEntradaMontador();
        /*for(InstrucaoAssembler a : entradaMontador2)
        {
           System.out.println(a.getInstrucaoFULL());
        }*/
        
        
        Assembler ass1 = new Assembler(entradaMontador1);
        //System.out.println(ass1.geTableSymb());
        Assembler ass2 = new Assembler(entradaMontador2);
        //System.out.println(ass2.geTableSymb());
        ArrayList<EntradaLigador> entradaLigador = new ArrayList();
        
        entradaLigador.add(ass1.getOutput());
        entradaLigador.add(ass2.getOutput());                
                
        for(InstrucaoAssembler a : ass1.getOutput().getSaida())
        {           
           System.out.println(a.getInstrucaoFULL());
        }
        System.out.println();
        for(String a : ass1.getOutput().getTabelaDeSimbolo().keySet())
        {           
           System.out.println(a + " " + ass1.getOutput().getTabelaDeSimbolo().get(a));
        }
        
        
        //  QUERIDO LORENZO, entradaLigador É O ARRAY QUE TU PEDIU, VAI LÁ!!!!
        
        Ligador ligador = new Ligador();
        EntradaCarregador entradaCarregador = ligador.liga(entradaLigador);
        
        /*for(String a : entradaCarregador.getTabelaDeDefinicoesGlobal().keySet())
        {           
           System.out.println(a + " " + entradaCarregador.getTabelaDeDefinicoesGlobal().get(a));
        }*/
        
        Carregador carregador = new Carregador(entradaCarregador);
        carregador.carrega("file.bin");
        

        String arquivo = "file.bin";
        int offset, pc; // definido pelo carregador
        ProgramList lista = new ProgramList();
        lista.geraPrograma(arquivo);
        offset = lista.getOffset();
        
        System.out.println(lista.PrintIntrucao());
               
        // Inicia Memória e testa alguns valores        
        Memory mem = new Memory(c.MEM_SIZE);
        mem.setByte(0, 127);
        mem.setByte(1, -128);
        mem.setWord(2, 32767);
        mem.setWord(4, -32768);
        System.out.println("\n" + mem.getByte(0) + " " + mem.getByte(1));
        System.out.println(mem.getWord(2) + " " + mem.getWord(4) + "\n");

        
        pc = offset + 1;

        Processor proc = new Processor();
        
        while(pc >= offset && pc <= offset + lista.getNInstructions()){
            System.out.println("PC: " + pc);
            pc += proc.executar(lista.getInstrucao(pc), mem, pc); 
        }        
                
        System.out.println("PC: " + pc);
        System.out.println(proc);

   }
}

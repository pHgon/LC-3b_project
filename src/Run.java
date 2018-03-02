import machine.*;
import constants.Constants;

/**
 *
 * @author mateu
 */
public class Run {
    public static final class c extends Constants{} // Classe com as constantes

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args)
    {
        String arquivo = "/home/mateus/Área de Trabalho/semestre/ps/PSGIT/LC-3b_project/program.bin";
        int offset = 500, pc; // definido pelo carregador
        ProgramList lista = new ProgramList(offset);
        lista.geraPrograma(arquivo);
        lista.PrintIntrucao();
        
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
            pc += proc.executar(lista.getInstrucao(pc), mem, pc); 
        }        
                
        System.out.println("PC: " + pc);
        System.out.println(proc);

   }
}

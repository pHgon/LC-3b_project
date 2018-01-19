import machine.*;

/**
 *
 * @author mateu
 */
public class Run {
    private static final class c extends Constants{} // Classe com as constantes

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args)
    {
        String arquivo = "program.bin";
        int offset = 500, pc; // definido pelo carregador
        ProgramList lista = new ProgramList(offset);
        lista.geraPrograma(arquivo);
        lista.PrintIntrucao();
        
        // Inicia Memória e testa alguns valores
        System.out.println("MEM SIZE: " + c.MEM_SIZE);
        Memory mem = new Memory(c.MEM_SIZE);
        mem.setByte(0, 127);
        mem.setByte(1, -128);
        mem.setWord(2, 32767);
        mem.setWord(4, -32768);
        System.out.println(mem.getByte(0) + " " + mem.getByte(1));
        System.out.println(mem.getWord(2) + " " + mem.getWord(4));

        
        pc = 0;

        Processor proc = new Processor();
        
        pc += proc.executar(lista.getInstrucao(offset+1), mem, pc); 
        pc += proc.executar(lista.getInstrucao(offset+2), mem, pc); 
        pc += proc.executar(lista.getInstrucao(offset+3), mem, pc); 
        pc += proc.executar(lista.getInstrucao(offset+4), mem, pc); 
        pc += proc.executar(lista.getInstrucao(offset+5), mem, pc); 
        pc += proc.executar(lista.getInstrucao(offset+6), mem, pc); 
        pc += proc.executar(lista.getInstrucao(offset+7), mem, pc); 
        pc += proc.executar(lista.getInstrucao(offset+8), mem, pc); 
        pc += proc.executar(lista.getInstrucao(offset+9), mem, pc); 
        pc += proc.executar(lista.getInstrucao(offset+10), mem, pc);         
                
        System.out.println("PC: " + pc);
        System.out.println(proc);

   }
}

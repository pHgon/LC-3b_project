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
        
        pc = 0;

        Processor proc = new Processor();
        pc += proc.executar(lista.getInstrucao(offset+1), null, pc); //add
        pc += proc.executar(lista.getInstrucao(offset+2), null, pc); //addi
        pc += proc.executar(lista.getInstrucao(offset+3), null, pc); //and
        pc += proc.executar(lista.getInstrucao(offset+4), null, pc); //andi
        pc += proc.executar(lista.getInstrucao(offset+5), null, pc); //br
        pc += proc.executar(lista.getInstrucao(offset+6), null, pc); //jmp
        pc += proc.executar(lista.getInstrucao(offset+7), null, pc); //jsrr
        pc += proc.executar(lista.getInstrucao(offset+8), null, pc); //ret
        pc += proc.executar(lista.getInstrucao(offset+9), null, pc); //jsr
        pc += proc.executar(lista.getInstrucao(offset+10), null, pc); //ret
        pc += proc.executar(lista.getInstrucao(offset+11), null, pc); //not
        System.out.println("PC: " + pc);
        System.out.println(proc);

        Memory mem = new Memory(c.MEM_SIZE);
   }
}

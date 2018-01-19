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
        pc += proc.executar(lista.getInstrucao(offset+1), mem, pc); //add
        pc += proc.executar(lista.getInstrucao(offset+2), mem, pc); //addi
        pc += proc.executar(lista.getInstrucao(offset+3), mem, pc); //and
        pc += proc.executar(lista.getInstrucao(offset+4), mem, pc); //andi
        pc += proc.executar(lista.getInstrucao(offset+5), mem, pc); //br
        pc += proc.executar(lista.getInstrucao(offset+6), mem, pc); //jmp
        pc += proc.executar(lista.getInstrucao(offset+7), mem, pc); //jsrr
        pc += proc.executar(lista.getInstrucao(offset+8), mem, pc); //ret
        pc += proc.executar(lista.getInstrucao(offset+9), mem, pc); //jsr
        pc += proc.executar(lista.getInstrucao(offset+10), mem, pc); //ret
        pc += proc.executar(lista.getInstrucao(offset+11), mem, pc); //not
        pc += proc.executar(lista.getInstrucao(offset+12), mem, pc); //ldb load byte
        pc += proc.executar(lista.getInstrucao(offset+13), mem, pc); //ldi load word indirect
        pc += proc.executar(lista.getInstrucao(offset+14), mem, pc); //ldr load word
        pc += proc.executar(lista.getInstrucao(offset+15), mem, pc); //lea load effective address
        pc += proc.executar(lista.getInstrucao(offset+16), mem, pc); //shf
        pc += proc.executar(lista.getInstrucao(offset+17), mem, pc); //stb
        pc += proc.executar(lista.getInstrucao(offset+18), mem, pc); //sti
        pc += proc.executar(lista.getInstrucao(offset+19), mem, pc); //str
        System.out.println("PC: " + pc);
        System.out.println(proc);

   }
}

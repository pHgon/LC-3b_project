import machine.*;

/**
 *
 * @author mateu
 */
public class Run {

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
        pc += proc.executar(lista.getInstrucao(offset+1), null, 0); //add
        //proc.executar(lista.getInstrucao(offset+2), null, 0); //addi
        //proc.executar(lista.getInstrucao(offset+3), null, 0); //and
        //proc.executar(lista.getInstrucao(offset+4), null, 0); //andi
        //proc.executar(lista.getInstrucao(offset+5), null, 0); //br
        //pc += proc.executar(lista.getInstrucao(offset+6), null, pc); //jmp
        pc += proc.executar(lista.getInstrucao(offset+7), null, pc); //jsrr
        pc += proc.executar(lista.getInstrucao(offset+8), null, pc); //ret
        pc += proc.executar(lista.getInstrucao(offset+9), null, pc); //jsr
        pc += proc.executar(lista.getInstrucao(offset+10), null, pc); //ret
        System.out.println("PC: " + pc);
        System.out.println(proc);
   }
}

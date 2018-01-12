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
        int offset = 500; // definido pelo carregador
        ProgramList lista = new ProgramList(offset);
        lista.geraPrograma(arquivo);
        lista.PrintIntrucao();
        
        Processor proc = new Processor();
        /*proc.executar(lista.getInstrucao(offset+1), null); //add
        proc.executar(lista.getInstrucao(offset+2), null); //addi
        proc.executar(lista.getInstrucao(offset+3), null); //and
        proc.executar(lista.getInstrucao(offset+4), null); //andi*/
        proc.executar(lista.getInstrucao(offset+5), null); //br
        
        System.out.println(proc);
   }
}

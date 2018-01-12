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
        String arquivo = "programa.bin";
        int offset = 500; // definido pelo carregador
        ProgramList lista = new ProgramList(offset);
        lista.geraPrograma(arquivo);
        lista.PrintIntrucao();
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programcreator;

/**
 *
 * @author mateu
 */
public class run {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args)
    {
        String arquivo = "C:\\Users\\mateu\\Desktop\\programa.bin";
        int offset = 500; // definido pelo carregador
        ProgramList lista = new ProgramList(offset);
        lista.geraPrograma(arquivo);
        lista.PrintIntrucao();
   }
    
}

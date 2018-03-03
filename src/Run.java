import assembler.EntradaCarregador;
import assembler.EntradaLigador;
import assembler.InstrucaoAssembler;
import assembler.Ligador;
import machine.*;
import constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        InstrucaoAssembler mod1Inst1 = new InstrucaoAssembler("label1", "LD", "R0", "X", "");
        InstrucaoAssembler mod1Inst2 = new InstrucaoAssembler("label2", "LD", "R1", "Y", "");
        InstrucaoAssembler mod1Inst3 = new InstrucaoAssembler("Z", ".INTDEF", "33", "", "");
        
        InstrucaoAssembler mod2Inst1 = new InstrucaoAssembler("label3", "NOT", "R2", "R1", "");
        InstrucaoAssembler mod2Inst2 = new InstrucaoAssembler("label4", "ADD", "R2", "R2", "Z");  
        InstrucaoAssembler mod2Inst3 = new InstrucaoAssembler("X", ".INTDEF", "10", "", "");  
        InstrucaoAssembler mod2Inst4 = new InstrucaoAssembler("Y", ".INTDEF", "40", "", "");  
        
        ArrayList<InstrucaoAssembler> mod1 = new ArrayList();
        ArrayList<InstrucaoAssembler> mod2 = new ArrayList();
        
        mod1.add(mod1Inst1);
        mod1.add(mod1Inst2);
        mod1.add(mod1Inst3);
        
        mod2.add(mod2Inst1);
        mod2.add(mod2Inst2);
        mod2.add(mod2Inst3);
        mod2.add(mod2Inst4);
        
        Map<String, String> tabelaDeSimbolo1 = new HashMap<>();
        Map<String, String> tabelaDeSimbolo2 = new HashMap<>();
        
        tabelaDeSimbolo1.put("label1", Integer.toString(0));
        tabelaDeSimbolo1.put("X", "null");
        tabelaDeSimbolo1.put("label2", Integer.toString(3));
        tabelaDeSimbolo1.put("Z", Integer.toString(6));
        
        
        tabelaDeSimbolo2.put("label3", Integer.toString(0));
        tabelaDeSimbolo2.put("label4", Integer.toString(3));
        tabelaDeSimbolo2.put("Z", "null");
        tabelaDeSimbolo2.put("X", Integer.toString(7));
        tabelaDeSimbolo2.put("Y", Integer.toString(9));
        
        
        EntradaLigador entradaLigador1 = new EntradaLigador();
        EntradaLigador entradaLigador2 = new EntradaLigador();       
        entradaLigador1.setSaida(mod1);
        entradaLigador1.setTabelaDeSimbolo(tabelaDeSimbolo1);
        entradaLigador2.setSaida(mod2);
        entradaLigador2.setTabelaDeSimbolo(tabelaDeSimbolo2);
        entradaLigador1.contarEnderecos();
        entradaLigador2.contarEnderecos();
        
        ArrayList<EntradaLigador> entradasLigador = new ArrayList();
        entradasLigador.add(entradaLigador1);
        entradasLigador.add(entradaLigador2);
                
        
        Ligador ligador = new Ligador();
        EntradaCarregador entradaCarregador = ligador.liga(entradasLigador);
        
        /*String arquivo = "/home/mateus/Área de Trabalho/semestre/ps/PSGIT/LC-3b_project/program.bin";
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
        System.out.println(proc);*/

   }
}

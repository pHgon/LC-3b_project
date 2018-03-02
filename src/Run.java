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
        InstrucaoAssembler mod2Inst1 = new InstrucaoAssembler("label1", "NOT", "R2", "R1", "");
        InstrucaoAssembler mod2Inst2 = new InstrucaoAssembler("label2", "ADDI", "R2", "R2", "#1");  
        
        ArrayList<InstrucaoAssembler> mod1 = new ArrayList();
        ArrayList<InstrucaoAssembler> mod2 = new ArrayList();
        
        mod1.add(mod1Inst1);
        mod1.add(mod1Inst2);
        mod2.add(mod2Inst1);
        mod2.add(mod2Inst2);
        
        Map<String, Integer> tabelaDeSimbolo1 = new HashMap<>();
        Map<String, Integer> tabelaDeSimbolo2 = new HashMap<>();
        tabelaDeSimbolo1.put("label1", 0);
        tabelaDeSimbolo1.put("label2", 3);
        tabelaDeSimbolo1.put("X", -1);
        tabelaDeSimbolo1.put("label1", 0);
        tabelaDeSimbolo1.put("label2", 3);
        tabelaDeSimbolo1.put("X", 33);
        
        
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

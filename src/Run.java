import assembler.EntradaCarregador;
import assembler.EntradaLigador;
import assembler.InstrucaoAssembler;
import assembler.Ligador;
import assembler.ProcessadorMacro;
import assembler.Assembler;
import assembler.Carregador;
import machine.*;
import constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mateus
 */
public class Run {
    public static final class c extends Constants{} // Classe com as constantes

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args)
    {
    
        // chama duas vezes o processador de macros, uma para cada modulo e retorna entrada para MONTADOR
        ProcessadorMacro pr1 = new ProcessadorMacro("/home/mateus/Área de Trabalho/semestre/ps/PSGIT/LC-3b_project/LC3EntradaProcMacro.txt");
        pr1.printExpanded();
        ArrayList<InstrucaoAssembler> entradaMontador1 = pr1.getEntradaMontador();
        for(InstrucaoAssembler a : entradaMontador1)
        {
           System.out.println(a.getInstrucaoFULL());
        }
        
        ProcessadorMacro pr2 = new ProcessadorMacro("/home/mateus/Área de Trabalho/semestre/ps/PSGIT/LC-3b_project/LC3EntradaProcMacro.txt");
        pr2.printExpanded();
        ArrayList<InstrucaoAssembler> entradaMontador2 = pr2.getEntradaMontador();
        for(InstrucaoAssembler a : entradaMontador2)
        {
           System.out.println(a.getInstrucaoFULL());
        }
        
        
        /*Assembler ass1 = new Assembler(entradaMontador1);
        Assembler ass2 = new Assembler(entradaMontador1);
        ArrayList<EntradaLigador> entradaLigador = new ArrayList();
        entradaLigador.add(ass1.getOutput());
        entradaLigador.add(ass2.getOutput());
        System.out.println(entradaLigador.get(0).getSaida().get(0).getInstrucaoFULL());
        System.out.println(entradaLigador.get(0).getSaida().get(1).getInstrucaoFULL());*/
        
        
        InstrucaoAssembler mod1Inst1 = new InstrucaoAssembler("label1", "LD", "R0", "X", "", "", "");
        InstrucaoAssembler mod1Inst2 = new InstrucaoAssembler("label2", "LD", "R1", "Y", "", "", "");        
        
        InstrucaoAssembler mod2Inst1 = new InstrucaoAssembler("label3", "NOT", "R2", "R1", "", "", "");
        InstrucaoAssembler mod2Inst2 = new InstrucaoAssembler("label4", "ADD", "R2", "R2", "Z", "", "");          
        
        ArrayList<InstrucaoAssembler> mod1 = new ArrayList();
        ArrayList<InstrucaoAssembler> mod2 = new ArrayList();
        
        mod1.add(mod1Inst1);
        mod1.add(mod1Inst2);
              
        mod2.add(mod2Inst1);
        mod2.add(mod2Inst2);       
        
        Map<String, String> tabelaDeSimbolo1 = new HashMap<>();
        Map<String, String> tabelaDeSimbolo2 = new HashMap<>();
        
        tabelaDeSimbolo1.put("label1", Integer.toString(0));
        tabelaDeSimbolo1.put("X", "null");
        tabelaDeSimbolo1.put("label2", Integer.toString(3));
        tabelaDeSimbolo1.put("Z", "#33");
        
        
        tabelaDeSimbolo2.put("label3", Integer.toString(0));
        tabelaDeSimbolo2.put("label4", Integer.toString(3));
        tabelaDeSimbolo2.put("Z", "null");
        tabelaDeSimbolo2.put("X", "#10");
        tabelaDeSimbolo2.put("Y", "#40");
        
        
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
        
        Carregador carregador = new Carregador(entradaCarregador);
        carregador.carrega("file.bin");
        //ProgramList lista = new ProgramList(carregador.getEntradaCarregador().getEnderecoInicial());
        
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

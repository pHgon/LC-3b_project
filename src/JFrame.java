/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import assembler.Carregador;
import assembler.EntradaCarregador;
import assembler.EntradaLigador;
import assembler.InstrucaoAssembler;
import assembler.Ligador;
import assembler.ProcessadorMacro;
import machine.*;
import constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author patri
 */
public class JFrame extends javax.swing.JFrame {
    public static final class c extends Constants{} // Classe com as constantes

    /**
     * Creates new form JFrame
     */
    public JFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LC3bLabel = new javax.swing.JLabel();
        btnRun = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2Macros = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        MacroDefinidaTextArea = new javax.swing.JTextArea();
        registrerLabel1 = new javax.swing.JLabel();
        registrerLabel2 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        MacroDefinidaTextArea2 = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        MacroExpandidaTextArea2 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        MacroExpandidaTextArea = new javax.swing.JTextArea();
        jPanelMaquina = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inicialMemoryTextArea = new javax.swing.JTextArea();
        memoryLabel = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        regsTextArea = new javax.swing.JTextArea();
        consoleLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        log2TextArea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        finalMemoryTextArea = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        mem1 = new javax.swing.JTextArea();
        memFinalLabel = new javax.swing.JLabel();
        memInicialLabel = new javax.swing.JLabel();
        jPanelLigadorCarregador = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LC3bLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LC3bLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LC3bLabel.setText("Simulador LC3-b");
        LC3bLabel.setPreferredSize(new java.awt.Dimension(164, 29));

        btnRun.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnRun.setText("Executar");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnClear.setText("Limpar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        MacroDefinidaTextArea.setColumns(20);
        MacroDefinidaTextArea.setRows(5);
        jScrollPane8.setViewportView(MacroDefinidaTextArea);

        registrerLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        registrerLabel1.setText("Macros Definidas");

        registrerLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        registrerLabel2.setText("Macros Expandidas");

        MacroDefinidaTextArea2.setColumns(20);
        MacroDefinidaTextArea2.setRows(5);
        jScrollPane9.setViewportView(MacroDefinidaTextArea2);

        MacroExpandidaTextArea2.setColumns(20);
        MacroExpandidaTextArea2.setRows(5);
        jScrollPane11.setViewportView(MacroExpandidaTextArea2);

        MacroExpandidaTextArea.setColumns(20);
        MacroExpandidaTextArea.setRows(5);
        jScrollPane12.setViewportView(MacroExpandidaTextArea);

        javax.swing.GroupLayout jPanel2MacrosLayout = new javax.swing.GroupLayout(jPanel2Macros);
        jPanel2Macros.setLayout(jPanel2MacrosLayout);
        jPanel2MacrosLayout.setHorizontalGroup(
            jPanel2MacrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2MacrosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2MacrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registrerLabel1)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel2MacrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2MacrosLayout.createSequentialGroup()
                        .addComponent(registrerLabel2)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2MacrosLayout.createSequentialGroup()
                        .addGroup(jPanel2MacrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
        );
        jPanel2MacrosLayout.setVerticalGroup(
            jPanel2MacrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2MacrosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2MacrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registrerLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(registrerLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2MacrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(jScrollPane8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2MacrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Processador de Macros", jPanel2Macros);

        inicialMemoryTextArea.setColumns(20);
        inicialMemoryTextArea.setRows(5);
        jScrollPane1.setViewportView(inicialMemoryTextArea);

        memoryLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        memoryLabel.setText("Memória teste");

        registerLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        registerLabel.setText("Registradores");

        regsTextArea.setColumns(20);
        regsTextArea.setRows(5);
        jScrollPane3.setViewportView(regsTextArea);

        consoleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        consoleLabel.setText("Console Log");

        logTextArea.setColumns(20);
        logTextArea.setRows(5);
        jScrollPane2.setViewportView(logTextArea);

        log2TextArea.setColumns(20);
        log2TextArea.setRows(5);
        jScrollPane4.setViewportView(log2TextArea);

        finalMemoryTextArea.setColumns(20);
        finalMemoryTextArea.setRows(5);
        jScrollPane5.setViewportView(finalMemoryTextArea);

        mem1.setColumns(20);
        mem1.setRows(5);
        jScrollPane6.setViewportView(mem1);

        memFinalLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        memFinalLabel.setText("Memória Final");

        memInicialLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        memInicialLabel.setText("Memória Inicial");

        javax.swing.GroupLayout jPanelMaquinaLayout = new javax.swing.GroupLayout(jPanelMaquina);
        jPanelMaquina.setLayout(jPanelMaquinaLayout);
        jPanelMaquinaLayout.setHorizontalGroup(
            jPanelMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquinaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanelMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registerLabel)
                    .addComponent(memInicialLabel)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addGap(18, 18, 18)
                .addGroup(jPanelMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(memFinalLabel)
                    .addGroup(jPanelMaquinaLayout.createSequentialGroup()
                        .addGroup(jPanelMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(memoryLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(consoleLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        jPanelMaquinaLayout.setVerticalGroup(
            jPanelMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquinaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerLabel)
                    .addComponent(consoleLabel)
                    .addComponent(memoryLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanelMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memInicialLabel)
                    .addComponent(memFinalLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanelMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane6))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Máquina", jPanelMaquina);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Apenas Um teste");

        javax.swing.GroupLayout jPanelLigadorCarregadorLayout = new javax.swing.GroupLayout(jPanelLigadorCarregador);
        jPanelLigadorCarregador.setLayout(jPanelLigadorCarregadorLayout);
        jPanelLigadorCarregadorLayout.setHorizontalGroup(
            jPanelLigadorCarregadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLigadorCarregadorLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(811, Short.MAX_VALUE))
        );
        jPanelLigadorCarregadorLayout.setVerticalGroup(
            jPanelLigadorCarregadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLigadorCarregadorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(609, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ligador/Carregador", jPanelLigadorCarregador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(LC3bLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnRun, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LC3bLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRun, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("ProcessadorMacros");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        // TODO add your handling code here:
       
        
        String arquivo = "D:/Biblioteca/Documentos/ProjetosJava/LC-3b_project/program.bin";
        int offset = 500, pc; // definido pelo carregador
        ProgramList lista = new ProgramList(offset);
        lista.geraPrograma(arquivo);
        
        // chama duas vezes o processador de macros, uma para cada modulo e retorna entrada para MONTADOR
        ProcessadorMacro pr1 = new ProcessadorMacro("D:/Biblioteca/Documentos/ProjetosJava/LC-3b_project/LC3EntradaProcMacro.txt");
        pr1.printExpanded();
        ArrayList<InstrucaoAssembler> entradaMontador1 = pr1.getEntradaMontador();
        System.out.println(pr1.getSaidaDef());
        System.out.println(pr1.getSaidaExp());
        ProcessadorMacro pr2 = new ProcessadorMacro("D:/Biblioteca/Documentos/ProjetosJava/LC-3b_project/LC3EntradaProcMacro2.txt");
        pr2.printExpanded();
        ArrayList<InstrucaoAssembler> entradaMontador2 = pr2.getEntradaMontador();
        
        MacroDefinidaTextArea.setText( pr2.getSaidaDef() );
        MacroExpandidaTextArea.setText( pr2.getSaidaExp() );
        MacroDefinidaTextArea2.setText("Apenas um teste");
        MacroExpandidaTextArea2.setText("Apenas um teste");
        
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
       //----------------------------------------------------------------- 
       
        String saida = null;
        saida = lista.PrintIntrucao();
        logTextArea.setText( saida + "\n" );
        
        // Inicia Memória e testa alguns valores        
        Memory mem;
        mem = new Memory(Run.c.MEM_SIZE);
        mem.setByte(0, 127);
        mem.setByte(1, -128);
        mem.setWord(2, 32767);
        mem.setWord(4, -32768);
        
        mem1.setText( mem.printMemory(0,100) );
        
        inicialMemoryTextArea.setText(mem.getByte(0) + "\n" 
                                    + mem.getByte(1) + "\n" 
                                    + mem.getWord(2) + "\n"
                                    + mem.getWord(4) + "\n");        
        pc = offset + 1;
        Processor proc = new Processor();
        
        //mostrando no log2
        while(pc >= offset && pc <= offset + lista.getNInstructions()){
            pc += proc.executar(lista.getInstrucao(pc), mem, pc); 
            //System.out.println(proc.streamProcessor());
            log2TextArea.setText(proc.streamProcessor() + "\n");
        }        
        
        //mostrando os reg
        regsTextArea.setText(""+proc );
        
        finalMemoryTextArea.setText( mem.printMemory(0,100) );
        
    }//GEN-LAST:event_btnRunActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        inicialMemoryTextArea.setText("");
        logTextArea.setText("");
        regsTextArea.setText("");
        log2TextArea.setText("");
        finalMemoryTextArea.setText("");
        mem1.setText("");
        MacroDefinidaTextArea.setText("");
        MacroExpandidaTextArea.setText("");
        MacroDefinidaTextArea2.setText("");
        MacroExpandidaTextArea2.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LC3bLabel;
    private javax.swing.JTextArea MacroDefinidaTextArea;
    private javax.swing.JTextArea MacroDefinidaTextArea2;
    private javax.swing.JTextArea MacroExpandidaTextArea;
    private javax.swing.JTextArea MacroExpandidaTextArea2;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRun;
    private javax.swing.JLabel consoleLabel;
    private javax.swing.JTextArea finalMemoryTextArea;
    private javax.swing.JTextArea inicialMemoryTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2Macros;
    private javax.swing.JPanel jPanelLigadorCarregador;
    private javax.swing.JPanel jPanelMaquina;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea log2TextArea;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JTextArea mem1;
    private javax.swing.JLabel memFinalLabel;
    private javax.swing.JLabel memInicialLabel;
    private javax.swing.JLabel memoryLabel;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel registrerLabel1;
    private javax.swing.JLabel registrerLabel2;
    private javax.swing.JTextArea regsTextArea;
    // End of variables declaration//GEN-END:variables
}

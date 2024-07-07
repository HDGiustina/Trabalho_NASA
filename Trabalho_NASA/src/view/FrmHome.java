/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controller.*;
import Model.Asteroide;
import Model.AsteroidesPorPeriodo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.Date;
import java.text.SimpleDateFormat;

import Model.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author m131548
 */
public class FrmHome extends javax.swing.JFrame {

    private final MenuController menu;

    /**
     * Creates new form FrmHome
     */
    public FrmHome() {
        initComponents();
        menu = new MenuController(this);
        BarChartPanel barChartPanel = new BarChartPanel(new ArrayList<>()); // Inicialmente vazio
        panelGrafico.setLayout(new BorderLayout());
        panelGrafico.add(barChartPanel, BorderLayout.CENTER);
        panelGrafico.validate();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Atualizar a data atual
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                DateNowText.setText(dateFormat.format(now));

                // Atualizar o horário atual
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH : mm : ss");
                HorarioText.setText(timeFormat.format(now));
            }
        });
        timer.start();
        AsteroideController asteroideControler = new AsteroideController();
        ConfiguracoesController config = new ConfiguracoesController();
        Integer objetosProximoATerra = asteroideControler.getNumeroAsteroidesProximosATerra();
        contadorText.setText(objetosProximoATerra.toString());
        ArrayList<AsteroidesPorPeriodo> arrayDeNumeros = new ArrayList<>();
        String periodo = config.consultarPeridoDoGrafico();
        arrayDeNumeros = asteroideControler.getNumeroAsteroidesProximosATerraPorMes(periodo);
        barChartPanel.atualizarDados(arrayDeNumeros);
        populateAsteroidTable();

        //filtro string
        /*ArrayList<String> arrayTeste = new ArrayList<>();
        UtilsController utilController = new UtilsController();
        arrayTeste = utilController.getFiltrosColuna("potencialmente_perigoso");
        for (int i = 0; i < arrayTeste.size(); i++) {
            System.out.println(arrayTeste.get(i));  
        }*/
        //UtilsController utilController = new UtilsController();
        //filtro string
        /*ArrayList<Utils> arrayTesteDouble = new ArrayList<>();
        arrayTesteDouble = utilController.getFiltrosColunaDouble("distancia_min_da_terra_em_km");
        for (Utils util : arrayTesteDouble) {
            System.out.println(util.getColuna());
            System.out.println(util.getMax());
            System.out.println(util.getMin());
        }*/
        
        
        
        
        //pegar asteroides
       /* ArrayList<Asteroide> asteroides = new ArrayList<>();
        AsteroideController asteroideController = new AsteroideController();
        
        asteroides = asteroideController.getAsteroidesFiltroEOrdenacao("data_aproximacao_maxima", "nivel_ameaca", "Nenhuma");
        for (Asteroide asteroide : asteroides) {
            System.out.println(asteroide.getData_aproximacao_maxima());
            System.out.println(asteroide.getNivel_ameaca());
            System.out.println("//");
        }*/
        
        ArrayList<Asteroide> asteroides = new ArrayList<>();
        AsteroideController asteroideController = new AsteroideController();
        
        asteroides = asteroideController.getAsteroidesFiltroEOrdenacao("data_aproximacao_maxima", "velocidade_relativa_em_kms", 8.0, 12.0);
        for (Asteroide asteroide : asteroides) {
            System.out.println(asteroide.getData_aproximacao_maxima());
            System.out.println(asteroide.getVelocidade_relativa_em_kms());
            System.out.println("//");
        }
    }

    private void populateAsteroidTable() {
        DefaultTableModel model = (DefaultTableModel) ListaAproximacoes.getModel();
        model.setRowCount(0); // Clear previous data

        // Fetch asteroid data from AsteroideController
        AsteroideController controller = new AsteroideController();
        ArrayList<Asteroide> asteroides = controller.getAteroidesFuturo();

        // Populate the table with asteroid data
        for (Asteroide asteroide : asteroides) {
            Object[] row = {
                asteroide.getNome(),
                asteroide.getData_aproximacao_maxima(),
                asteroide.getDistancia_min_da_terra_em_km(),
                asteroide.getNivel_ameaca()};
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DateNowText = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaAproximacoes = new javax.swing.JTable();
        contadorObjetos = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        contadorText = new java.awt.Label();
        panelGrafico = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        HorarioText = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuDashboard = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        menuDados = new javax.swing.JMenu();
        menuAtualizar = new javax.swing.JMenuItem();
        menuResultados = new javax.swing.JMenuItem();
        menuConfiguracaoPai = new javax.swing.JMenu();
        menuConfiguracao = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(250, 125, 0, 0));

        DateNowText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DateNowText.setText("06/07/2024");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Lista de próximas aproximações:");

        ListaAproximacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data da aproximação", "Distância mínima ", "Risco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ListaAproximacoes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        contadorObjetos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contadorObjetos.setLayout(new javax.swing.BoxLayout(contadorObjetos, javax.swing.BoxLayout.PAGE_AXIS));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label1.setText("Contador de objetos próximos:");
        contadorObjetos.add(label1);

        contadorText.setAlignment(java.awt.Label.CENTER);
        contadorText.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        contadorText.setText("10");
        contadorObjetos.add(contadorText);

        panelGrafico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        jLabel3.setText("Data:");

        jLabel4.setText("Horário:");

        HorarioText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HorarioText.setText("00 : 00 : 00");

        menuArquivo.setText("Arquivo");

        menuDashboard.setText("Dashboard");
        menuDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDashboardActionPerformed(evt);
            }
        });
        menuArquivo.add(menuDashboard);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuArquivo.add(menuSair);

        jMenuBar1.add(menuArquivo);

        menuDados.setText("Dados");

        menuAtualizar.setText("Atualizar dados");
        menuAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAtualizarActionPerformed(evt);
            }
        });
        menuDados.add(menuAtualizar);

        menuResultados.setText("Resultados");
        menuResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuResultadosActionPerformed(evt);
            }
        });
        menuDados.add(menuResultados);

        jMenuBar1.add(menuDados);

        menuConfiguracaoPai.setText("Configurações");

        menuConfiguracao.setText("Configurações");
        menuConfiguracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConfiguracaoActionPerformed(evt);
            }
        });
        menuConfiguracaoPai.add(menuConfiguracao);

        jMenuBar1.add(menuConfiguracaoPai);

        menuAjuda.setText("Ajuda");

        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(menuSobre);

        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DateNowText))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(HorarioText))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contadorObjetos, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DateNowText)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HorarioText)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contadorObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDashboardActionPerformed
        menu.telaAtualiza(this);
    }//GEN-LAST:event_menuDashboardActionPerformed

    private void menuResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuResultadosActionPerformed
        menu.telaAtualiza(new FrmResultados());
    }//GEN-LAST:event_menuResultadosActionPerformed

    private void menuConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfiguracaoActionPerformed
        menu.telaAtualiza(new FrmConfiguracao());
    }//GEN-LAST:event_menuConfiguracaoActionPerformed

    private void menuAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAtualizarActionPerformed
        menu.telaAtualiza(new FrmAtualizar());
    }//GEN-LAST:event_menuAtualizarActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        menu.telaAtualiza(new FrmSobre());
    }//GEN-LAST:event_menuSobreActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        menu.Sair();
    }//GEN-LAST:event_menuSairActionPerformed

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
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateNowText;
    private javax.swing.JLabel HorarioText;
    private javax.swing.JTable ListaAproximacoes;
    private javax.swing.JPanel contadorObjetos;
    private java.awt.Label contadorText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuAtualizar;
    private javax.swing.JMenuItem menuConfiguracao;
    private javax.swing.JMenu menuConfiguracaoPai;
    private javax.swing.JMenu menuDados;
    private javax.swing.JMenuItem menuDashboard;
    private javax.swing.JMenuItem menuResultados;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JPanel panelGrafico;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controller.*;
import DAL.*;
import Model.*;
import java.awt.Cursor;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Imply
 */
public class FrmAtualizar extends javax.swing.JFrame {

    private final MenuController menu;
    ArrayList<Asteroide> lstAsteroides;
    AsteroideController controller = new AsteroideController();
    
    /**
     * Creates new form FrmAtualizar
     */
    public FrmAtualizar() {
        initComponents();
         menu = new MenuController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        atualizaButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dtInicio = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dtFim = new javax.swing.JFormattedTextField();
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
        setBounds(new java.awt.Rectangle(350, 200, 0, 0));
        setMinimumSize(new java.awt.Dimension(600, 350));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Atualizar Dados");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Insira a data inicial e final do período que deseja atualizar sua base de dados");

        atualizaButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        atualizaButton.setText("Atualizar");
        atualizaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaButtonActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        jLabel1.setText("Data de ínicio:");
        jPanel2.add(jLabel1);

        try {
            dtInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dtInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtInicioActionPerformed(evt);
            }
        });
        jPanel2.add(dtInicio);

        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        jLabel2.setText("Data de fim:");
        jPanel3.add(jLabel2);

        try {
            dtFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dtFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtFimActionPerformed(evt);
            }
        });
        jPanel3.add(dtFim);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(143, Short.MAX_VALUE))
        );

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(atualizaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizaButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dtInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtInicioActionPerformed

    private void dtFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtFimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtFimActionPerformed

    private void menuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDashboardActionPerformed
        menu.telaAtualiza(new FrmHome());
    }//GEN-LAST:event_menuDashboardActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        menu.Sair();
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAtualizarActionPerformed
        menu.telaAtualiza(new FrmAtualizar());
    }//GEN-LAST:event_menuAtualizarActionPerformed

    private void menuResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuResultadosActionPerformed
        menu.telaAtualiza(new FrmResultados());
    }//GEN-LAST:event_menuResultadosActionPerformed

    private void menuConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfiguracaoActionPerformed
        menu.telaAtualiza(new FrmConfiguracao());
    }//GEN-LAST:event_menuConfiguracaoActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        menu.telaAtualiza(new FrmSobre());
    }//GEN-LAST:event_menuSobreActionPerformed

    private void atualizaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaButtonActionPerformed
        // Formato de entrada
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate dt_inicio = LocalDate.parse(dtInicio.getText(), formatoEntrada);
        LocalDate dt_fim = LocalDate.parse(dtFim.getText(), formatoEntrada);
        
        try {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            
            // Consulta na API
            lstAsteroides = controller.consultarAsteroidesAPI(dt_inicio, dt_fim);
            
            // Guarda os dados no banco
            AsteroideDAO DAO = new AsteroideDAO();
            DAO.insertLstAsteroides(lstAsteroides);
            
            //Voltando o icone do cursor ao normal
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            
            Object[] opcoes = {"Sim", "Não"};

            // Dando a opção do usuário redireciona para a tela de dashboard
            int resposta = JOptionPane.showOptionDialog(null, 
                "Dados atualizados com sucesso! Deseja abrir a página de Dashboard?", 
                "Dados atualizados", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opcoes, 
                opcoes[0]
            );
            
            if (resposta == JOptionPane.YES_OPTION) {
                menu.telaAtualiza(new FrmHome());
            } 
        } catch (IOException | InterruptedException | SQLException ex) {
            Logger.getLogger(FrmAtualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_atualizaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAtualizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizaButton;
    private javax.swing.JFormattedTextField dtFim;
    private javax.swing.JFormattedTextField dtInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    // End of variables declaration//GEN-END:variables
}

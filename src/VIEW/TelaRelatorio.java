
package VIEW;

import DAO.ConexaoGipDAO;
import DTO.RelatorioGipDTO;
import DAO.RelatorioGipDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileSystemView;


public class TelaRelatorio extends javax.swing.JFrame {

    
    public TelaRelatorio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        VoltarBtn = new javax.swing.JButton();
        MesRefTxt = new javax.swing.JTextField();
        AnoTxt = new javax.swing.JTextField();
        TipoTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaTxt = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BuscarBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        AuditoriaTxt = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Relatórios");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("RELATÓRIOS");

        VoltarBtn.setText("VOLTAR");
        VoltarBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        VoltarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBtnActionPerformed(evt);
            }
        });

        TabelaTxt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Instalação", "Mês", "Valor", "Kw", "Ano"
            }
        ));
        jScrollPane1.setViewportView(TabelaTxt);

        jLabel3.setText("Mês Ref:");

        jLabel4.setText("Ano:");

        jLabel5.setText("Tipo:");

        BuscarBtn.setText("Buscar");
        BuscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBtnActionPerformed(evt);
            }
        });

        jButton3.setText("EXPORTAR ");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        AuditoriaTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        jLabel2.setText("Auditoria:");

        jButton1.setText("RELATÓRIO INFORMATIVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VoltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(TipoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(MesRefTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(AuditoriaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(BuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MesRefTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarBtn)
                    .addComponent(AuditoriaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
        TelaMenu telaMenu = new TelaMenu();
        telaMenu.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void BuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBtnActionPerformed
        
        try{ 
             listarValores();
         }catch(Exception erro){
             JOptionPane.showMessageDialog(null, "erro listagem" + erro);
             }
         try {
            chamarProcedure(); // Chama a procedure no DAO
            // Lógica para a inserção de dados na sua tabela, se necessário
        } catch (SQLException e) {
            // Trate exceções aqui
            e.printStackTrace();
        }
         
    }//GEN-LAST:event_BuscarBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       exportarParaPlanilha (TipoTxt.getText(), MesRefTxt.getText(), AnoTxt.getText(), (String) AuditoriaTxt.getSelectedItem());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      RelatorioInformativo relatorioInformativo = new RelatorioInformativo();
      relatorioInformativo.setVisible(true);
      
      this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnoTxt;
    private javax.swing.JComboBox<String> AuditoriaTxt;
    private javax.swing.JButton BuscarBtn;
    private javax.swing.JTextField MesRefTxt;
    private javax.swing.JTable TabelaTxt;
    private javax.swing.JTextField TipoTxt;
    private javax.swing.JButton VoltarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void listarValores() {
        try {
            RelatorioGipDAO relatoriogipdao = new RelatorioGipDAO();

            DefaultTableModel model = (DefaultTableModel) TabelaTxt.getModel();
            model.setNumRows(0);

            String Tipo = TipoTxt.getText();

            String MesRef = MesRefTxt.getText();

            String Ano = AnoTxt.getText();
            
            String Auditoria = (String ) AuditoriaTxt.getSelectedItem();

            List<RelatorioGipDTO> lista = relatoriogipdao.RelatorioPesq(Tipo, MesRef, Ano, Auditoria);

            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
                    lista.get(i).getInstalacao_faturanova(),
                   
                    lista.get(i).getMesReferente_cadastroConsumoFatura(),
                     lista.get(i).getValor_cadastroConsumoFatura(),
                     lista.get(i).getKw_cadastroConsumoFatura(),
                    lista.get(i).getAno_cadastroConsumoFatura(),
                    
                    lista.get(i).getAuditoria_cadastroConsumoFatura(),});
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores" + erro);
        }
    }

    private void exportarParaPlanilha(String Tipo, String MesRef,
        String Ano, String Auditoria) {

    try {

        RelatorioGipDAO dao = new RelatorioGipDAO();

        List<RelatorioGipDTO> listaConsultas =
                dao.RelatorioPesq(Tipo, MesRef, Ano, Auditoria);

        // 📁 Área de Trabalho oficial do sistema
        File desktop = FileSystemView.getFileSystemView().getHomeDirectory();

        Path pasta = Paths.get(desktop.getAbsolutePath(), "Planilhas_Exportadas");

        // ✅ Cria a pasta se não existir
        Files.createDirectories(pasta);

        // 📅 Data e hora no nome (evita sobrescrever)
        String dataHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm"));

        String nomeArquivo = "relatorio_gip_" + dataHora + ".xlsx";

        Path arquivo = pasta.resolve(nomeArquivo);

        // 💾 Exporta
        dao.exportarParaPlanilha(listaConsultas, arquivo.toString());

        JOptionPane.showMessageDialog(null,
                "EXPORTADO COM SUCESSO!\nSalvo em:\n" + arquivo);

        // 📂 Abre a pasta automaticamente
        Desktop.getDesktop().open(pasta.toFile());

    } catch (IOException e) {

        JOptionPane.showMessageDialog(null,
                "Erro ao exportar:\n" + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }
}
    public void chamarProcedure() throws SQLException {
        Connection conn = null;
        CallableStatement callableStatement = null;

        try {
            conn = new ConexaoGipDAO().conectaBD();
            // Assume que você tem uma classe de conexão separada
            
            // Chama a procedure usando CallableStatement
            String sqlProcedure = "{CALL MediaeAuditoria}";
            callableStatement = (CallableStatement) conn.prepareCall(sqlProcedure);
            callableStatement.execute();
        } finally {
            // Fecha o CallableStatement e a conexão
            if (callableStatement != null) {
                callableStatement.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
                //esse código é para fazer o calculo automático do kw 
            }
    
}
    }
}







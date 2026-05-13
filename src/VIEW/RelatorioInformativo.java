
package VIEW;

import DAO.ConexaoGipDAO;
import DAO.RelatorioInformativoDAO;
import DTO.RelatorioInformativoDTO;
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
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;


public class RelatorioInformativo extends javax.swing.JFrame {

    
    public RelatorioInformativo() {
       
        initComponents();
         this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        VoltarBtn = new javax.swing.JButton();
        BuscarBtn = new javax.swing.JButton();
        AnoTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaInformativo = new javax.swing.JTable();
        AuditoriaSimNao = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        VoltarBtn.setText("VOLTAR");
        VoltarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBtnActionPerformed(evt);
            }
        });

        BuscarBtn.setText("BUSCAR");
        BuscarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBtnActionPerformed(evt);
            }
        });

        AnoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnoTxtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("ANO:");

        TabelaInformativo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Barras Red", "Jan", "Fev", "Mar", "Abril", "Maio", "Jun", "Jul", "Ago", "Setem", "Out", "Nov", "Dez", "Media Final", "Auditoria"
            }
        ));
        jScrollPane1.setViewportView(TabelaInformativo);

        AuditoriaSimNao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sim", "Não" }));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("AUDITORIA:");

        jButton1.setText("EXPORTAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("MÊS REF:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(AuditoriaSimNao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                                        .addComponent(BuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(VoltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AuditoriaSimNao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarBtn)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBtn)
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBtnActionPerformed
        
        try{ 
             chamarProcedure(AnoTxt.getText());
         }catch(Exception erro){
             JOptionPane.showMessageDialog(null, "erro listagem1" + erro);
             }    
               
        try{ 
             listarValores();
         }catch(Exception erro){
             JOptionPane.showMessageDialog(null, "erro listagem2" + erro);
             }    
    }//GEN-LAST:event_BuscarBtnActionPerformed

    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
     TelaRelatorio telaRelatorio = new TelaRelatorio();
     telaRelatorio.setVisible(true);
      
      this.dispose();
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void AnoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnoTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        exportarParaPlanilha1(AnoTxt.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(RelatorioInformativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioInformativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioInformativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioInformativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioInformativo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnoTxt;
    private javax.swing.JComboBox<String> AuditoriaSimNao;
    private javax.swing.JButton BuscarBtn;
    private javax.swing.JTable TabelaInformativo;
    private javax.swing.JButton VoltarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
private void listarValores() {
    
        try {
            RelatorioInformativoDAO relatorioInformativodao = new RelatorioInformativoDAO();

            DefaultTableModel model = (DefaultTableModel) TabelaInformativo.getModel();
            model.setNumRows(0);

            String Ano_cadastroConsumoFatura = AnoTxt.getText();

            List<RelatorioInformativoDTO> lista = relatorioInformativodao.RelatorioInfo(Ano_cadastroConsumoFatura);

            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
               //  lista.get(i).getCodigoBarrasCon_cadastroConsumoFatura(),
                 lista.get(i).getCodigo_barras_reduzido(),
                 lista.get(i).getJaneiro(),
                 lista.get(i).getFevereiro(),
                 
                 lista.get(i).getMarco(),
                 lista.get(i).getAbril(),
                 lista.get(i).getMaio(),
                 
                 lista.get(i).getJunho(),
                 lista.get(i).getJulho(),
                 lista.get(i).getAgosto(),
                 
                 lista.get(i).getSetembro(),
                 lista.get(i).getOutubro(),
                 lista.get(i).getNovembro(),
                 
                 lista.get(i).getDezembro(),
                 lista.get(i).getMedia(),
                 
                 lista.get(i).getAuditoria(),
                });
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores3" + erro);
        }
        
}
    public void chamarProcedure(String Ano_cadastroConsumoFatura) throws SQLException {
    Connection conn = null;
    CallableStatement callableStatement = null;

    try { 
        conn = new ConexaoGipDAO().conectaBD();
        
        // Chama a procedure
        String sqlProcedure = "{call faturasgip.InserirConsumoAuditoria()}";
        
        callableStatement = (CallableStatement) conn.prepareCall(sqlProcedure);
        
        // Se a procedure **não retorna** dados, use executeUpdate()
        callableStatement.executeUpdate();  

    } finally {
        if (callableStatement != null) {
            callableStatement.close();
        }
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
    }
private void exportarParaPlanilha1(String Ano_cadastroConsumoFatura) {

    try {

        RelatorioInformativoDAO dao = new RelatorioInformativoDAO();

        List<RelatorioInformativoDTO> listaConsultas =
                dao.RelatorioInfo(Ano_cadastroConsumoFatura);

        // 📁 Área de Trabalho oficial do sistema
        File desktop = FileSystemView.getFileSystemView().getHomeDirectory();

        Path pasta = Paths.get(desktop.getAbsolutePath(), "Planilhas_Exportadas");

        // ✅ Cria pasta automaticamente se não existir
        Files.createDirectories(pasta);

        // 📅 Data e hora no nome (evita sobrescrever)
        String dataHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm"));

        String nomeArquivo = "relatorio_informativo_auditoria_" 
                + dataHora + ".xlsx";

        Path arquivo = pasta.resolve(nomeArquivo);

        // 💾 Exporta
        dao.exportarParaPlanilha1(listaConsultas, arquivo.toString());

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
}}


package VIEW;

import DAO.ConsultarConsumoGipDAO;
import DTO.ConsultarConsumoGipDTO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;


public class TelaConsultaConsumo extends javax.swing.JFrame {

    
    public TelaConsultaConsumo() {
        initComponents();
        setLocationRelativeTo(null);
       
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ConsumoTxt = new javax.swing.JTable();
        MesRefTxt = new javax.swing.JTextField();
        ConsultarBtn = new javax.swing.JButton();
        VoltarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TodosTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AnoTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        DataTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ValorTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        KwTxt = new javax.swing.JTextField();
        ExportarBtn = new javax.swing.JButton();
        InstalacaoTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TiposTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        EditarBtn = new javax.swing.JButton();
        MesVencTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        AtrasadasCheck = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela consumo fatura ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ConsumoTxt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Instalacao", "Cod.Barras", "Valor", "Kw", "Mes venc.", "Mes ref.", "Data cad.", "Ano", "barras red.", "tipo", "Atrasadas", "Observações"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ConsumoTxt);

        ConsultarBtn.setText("CONSULTAR");
        ConsultarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConsultarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarBtnActionPerformed(evt);
            }
        });

        VoltarBtn.setText("VOLTAR");
        VoltarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("ANO:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("MÊS REF :");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("TODOS:");

        AnoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnoTxtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("DATA:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("VALOR:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("KW:");

        ExportarBtn.setText("EXPORTAR");
        ExportarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExportarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportarBtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("INSTALAÇÃO:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("TIPOS:");

        EditarBtn.setText("EDITAR CONSUMO");
        EditarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("MÊS VENC :");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("ATRASADAS:");

        AtrasadasCheck.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sim", "Não" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ExportarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(336, 336, 336)
                        .addComponent(EditarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(329, 329, 329)
                        .addComponent(VoltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(MesRefTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(AnoTxt))
                                .addComponent(jLabel5)
                                .addComponent(DataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(54, 54, 54)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(ValorTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(MesVencTxt))
                                .addComponent(jLabel6)
                                .addComponent(jLabel3)
                                .addComponent(TiposTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(60, 60, 60)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(InstalacaoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(KwTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(AtrasadasCheck, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TodosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(ConsultarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MesRefTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KwTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MesVencTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ValorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InstalacaoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TiposTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AtrasadasCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ConsultarBtn)
                    .addComponent(TodosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExportarBtn)
                    .addComponent(EditarBtn)
                    .addComponent(VoltarBtn))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarBtnActionPerformed
         try{
            listarValores();//TENTATIVA DE LISTAR VALORES
        }  
         
        catch (Exception erro){
            JOptionPane.showMessageDialog(null, "não há registros identificados" + erro);
        }
         
    }//GEN-LAST:event_ConsultarBtnActionPerformed
//////
    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
        TelaMenu telaMenu = new TelaMenu();
        telaMenu.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void AnoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnoTxtActionPerformed

    private void ExportarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportarBtnActionPerformed
    exportarParaPlanilha (InstalacaoTxt.getText(), MesRefTxt.getText(), MesVencTxt.getText(), AnoTxt.getText(), ValorTxt.getText(), DataTxt.getText(),KwTxt.getText(), TiposTxt.getText(), (String) AtrasadasCheck.getSelectedItem(),InstalacaoTxt.getText(),  MesRefTxt.getText(), MesVencTxt.getText(), AnoTxt.getText(), ValorTxt.getText(), DataTxt.getText(), KwTxt.getText(),TiposTxt.getText(), (String) AtrasadasCheck.getSelectedItem());
    }//GEN-LAST:event_ExportarBtnActionPerformed

    private void EditarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBtnActionPerformed
        TelaEdicaoConsumo telaEdicaoConsumo = new TelaEdicaoConsumo();
        telaEdicaoConsumo.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_EditarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(TelaConsultaConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaConsumo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnoTxt;
    private javax.swing.JComboBox<String> AtrasadasCheck;
    private javax.swing.JButton ConsultarBtn;
    private javax.swing.JTable ConsumoTxt;
    private javax.swing.JTextField DataTxt;
    private javax.swing.JButton EditarBtn;
    private javax.swing.JButton ExportarBtn;
    private javax.swing.JTextField InstalacaoTxt;
    private javax.swing.JTextField KwTxt;
    private javax.swing.JTextField MesRefTxt;
    private javax.swing.JTextField MesVencTxt;
    private javax.swing.JTextField TiposTxt;
    private javax.swing.JTextField TodosTxt;
    private javax.swing.JTextField ValorTxt;
    private javax.swing.JButton VoltarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    
    private void listarValores() {
        try {
            ConsultarConsumoGipDAO objconsultarConsumogipdao = new ConsultarConsumoGipDAO();
             
            DefaultTableModel model = (DefaultTableModel) ConsumoTxt.getModel();
            model.setNumRows(0);
            
            String Instalacao = InstalacaoTxt.getText();
            String Mesref = MesRefTxt.getText();
            String MesVenc = MesVencTxt.getText();
            String AnoRef = AnoTxt.getText();
          
            String Kw = KwTxt.getText();
            String Data = DataTxt.getText();
            
            String Valor = ValorTxt.getText();
            String Tipos = TiposTxt.getText();
            String Atrasadas  = (String) AtrasadasCheck.getSelectedItem();
            String PesqGeral = TodosTxt.getText();
            
            String Filtroinstalacao = InstalacaoTxt.getText();
            String FiltroMesRef = MesRefTxt.getText();
            String FiltroMesVenc = MesVencTxt.getText();
            String FiltroAnoRef = AnoTxt.getText();
            String FiltroValor = ValorTxt.getText();
            String FiltroData = DataTxt.getText();
            String FiltroKw = KwTxt.getText();
            String FiltroTipos = TiposTxt.getText();
            String FiltroAtrasadas =(String) AtrasadasCheck.getSelectedItem();
            
            
            
            List<ConsultarConsumoGipDTO> lista = objconsultarConsumogipdao.consultarConsumo(Instalacao, Mesref, MesVenc, AnoRef, Valor, Data, Kw, Tipos, Atrasadas, PesqGeral, Filtroinstalacao, FiltroMesRef, FiltroMesVenc, FiltroAnoRef, FiltroValor, FiltroData, FiltroKw, FiltroTipos, FiltroAtrasadas);
                    
                 
                for(int i = 0; i < lista.size(); i ++){
                    model.addRow(new Object[]{
                        lista.get(i).getInstalacao_faturanova(),
                        lista.get(i).getCodigoBarrasCon_cadastroConsumoFatura(),
                        lista.get(i).getValor_cadastroConsumoFatura(),
                        lista.get(i).getKw_cadastroConsumoFatura(),
                        lista.get(i).getMesVencimento_cadastroConsumoFatura(),
                        lista.get(i).getMesReferente_cadastroConsumoFatura(),
                        lista.get(i).getDataCadastro_cadastroConsumoFatura(),
                        lista.get(i).getAno_cadastroConsumoFatura(),
                        lista.get(i).getCodBarrasRed_cadastroConsumoFatura(),
                        lista.get(i).getTipos_faturanova(),
                        lista.get(i).getAtrasadas_cadastroConsumoFatura(),
                        lista.get(i).getObservacao(),
                        
                        
                    });
                }
            
            
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"listarValores" + erro);
        }
    }
    private void exportarParaPlanilha(String Instalacao, String Mesref, String MesVenc,
        String AnoRef, String Valor, String Data, String Kw, String Tipos,
        String Atrasadas, String Filtroinstalacao, String FiltroMesRef,
        String FiltroMesVenc, String FiltroAnoRef, String FiltroValor,
        String FiltroData, String FiltroKw, String FiltroTipos,
        String FiltroAtrasadas) {

    try {

        ConsultarConsumoGipDAO dao = new ConsultarConsumoGipDAO();

        List<ConsultarConsumoGipDTO> listaConsultas = dao.consultarConsumo(
                Instalacao, Mesref, MesVenc, AnoRef, Valor, Data, Kw, Tipos,
                Atrasadas, "", Filtroinstalacao, FiltroMesRef, FiltroMesVenc,
                FiltroAnoRef, FiltroValor, FiltroData, FiltroKw,
                FiltroTipos, FiltroAtrasadas
        );

        // 📁 Pega a Área de Trabalho real do sistema
        File desktop = FileSystemView.getFileSystemView().getHomeDirectory();

        Path pasta = Paths.get(desktop.getAbsolutePath(), "Planilhas_Exportadas");

        // Cria pasta se não existir
        Files.createDirectories(pasta);

        // Nome do arquivo
        Path arquivo = pasta.resolve("consumo_faturas.xls");

        dao.exportarParaPlanilha(listaConsultas, arquivo.toString());

        JOptionPane.showMessageDialog(null,
                "EXPORTADO COM SUCESSO!\nSalvo em:\n" + arquivo);

    } catch (IOException e) {

        JOptionPane.showMessageDialog(null,
                "Erro ao exportar:\n" + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }
}}

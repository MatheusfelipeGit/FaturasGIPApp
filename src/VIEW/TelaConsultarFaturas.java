/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.ConsultarFaturasGipDAO;
import DTO.ConsultarFaturasGipDTO;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;


public class TelaConsultarFaturas extends javax.swing.JFrame{

    public TelaConsultarFaturas() {
        initComponents();
        setLocationRelativeTo(null);
        //esse códgio serve para centralizar a tela 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CodInstaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ConsultarBtn = new javax.swing.JButton();
        VoltarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ConsultarTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        AllTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TiposTxt = new javax.swing.JTextField();
        RuaTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        NumeroTxt = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        MedidorTxt = new javax.swing.JTextField();
        BairroTxt = new javax.swing.JTextField();
        CargaLevTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ExportBtn = new javax.swing.JButton();
        EditarFaturasTxt = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela De Consulta");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        CodInstaTxt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                CodInstaTxtCaretUpdate(evt);
            }
        });
        CodInstaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodInstaTxtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("INSTALAÇÃO:");

        ConsultarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ConsultarBtn.setText("CONSULTAR");
        ConsultarBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
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

        ConsultarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CodigoBarra", "Instalacao", "Carga Levantada", "Medidor inst.", "Rua", "Numero", "Bairro", "Tipos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ConsultarTable);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("TODOS:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("TIPOS:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("RUA:");

        jTextField2.setText("jTextField2");

        MedidorTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedidorTxtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("NÚMERO:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("BAIRRO:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("MEDIDOR INST:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("CARGA LEVANTADA:");

        ExportBtn.setText("EXPORTAR");
        ExportBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportBtnActionPerformed(evt);
            }
        });

        EditarFaturasTxt.setText("EDITAR FATURAS");
        EditarFaturasTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditarFaturasTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarFaturasTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(357, 357, 357)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AllTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ConsultarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(CodInstaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(MedidorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CargaLevTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(644, 644, 644))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260)
                        .addComponent(EditarFaturasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(346, 346, 346)
                        .addComponent(VoltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(BairroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(RuaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(NumeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TiposTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RuaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodInstaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(NumeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MedidorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BairroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TiposTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CargaLevTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AllTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConsultarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExportBtn)
                    .addComponent(VoltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarFaturasTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(123, 123, 123))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
        TelaMenu telaMenu = new TelaMenu();
        telaMenu.setVisible(true);
            
        this.dispose();
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void ConsultarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarBtnActionPerformed
        try{
            listarValores();
        }
        catch (Exception erro){
            JOptionPane.showMessageDialog(null, "não há registros identificados" + erro);
        }

    }//GEN-LAST:event_ConsultarBtnActionPerformed

    private void CodInstaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodInstaTxtActionPerformed

    }//GEN-LAST:event_CodInstaTxtActionPerformed

    private void CodInstaTxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_CodInstaTxtCaretUpdate

    }//GEN-LAST:event_CodInstaTxtCaretUpdate

    private void MedidorTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedidorTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedidorTxtActionPerformed

    private void ExportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportBtnActionPerformed
        exportarParaPlanilha(CodInstaTxt.getText(), TiposTxt.getText(), RuaTxt.getText(), CargaLevTxt.getText(), MedidorTxt.getText(),NumeroTxt.getText(),BairroTxt.getText());
    }//GEN-LAST:event_ExportBtnActionPerformed

    private void EditarFaturasTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarFaturasTxtActionPerformed
        TelaEdicaoFatura telaEdicao = new TelaEdicaoFatura();
        telaEdicao.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_EditarFaturasTxtActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultarFaturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AllTxt;
    private javax.swing.JTextField BairroTxt;
    private javax.swing.JTextField CargaLevTxt;
    private javax.swing.JTextField CodInstaTxt;
    private javax.swing.JButton ConsultarBtn;
    private javax.swing.JTable ConsultarTable;
    private javax.swing.JButton EditarFaturasTxt;
    private javax.swing.JButton ExportBtn;
    private javax.swing.JTextField MedidorTxt;
    private javax.swing.JTextField NumeroTxt;
    private javax.swing.JTextField RuaTxt;
    private javax.swing.JTextField TiposTxt;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void listarValores() {
        try {
            ConsultarFaturasGipDAO objconsultarfaturasgipdao = new ConsultarFaturasGipDAO();
             
            DefaultTableModel model = (DefaultTableModel) ConsultarTable.getModel();
            model.setNumRows(0);
            
            String inst = CodInstaTxt.getText();
            String Tipos = TiposTxt.getText();
            String rua = RuaTxt.getText();
            String Medidor = MedidorTxt.getText();
            String CargaLev = CargaLevTxt.getText();
            
            String Numero = NumeroTxt.getText();
            String Bairro = BairroTxt.getText();
            String PesqGeral = AllTxt.getText();
            
            List<ConsultarFaturasGipDTO> lista = objconsultarfaturasgipdao.consultarFatura(inst,Tipos, rua, CargaLev, Medidor, Numero, Bairro, PesqGeral);
                    
                 
                for(int i = 0; i < lista.size(); i ++){
                    model.addRow(new Object[]{
                        lista.get(i ).getCodigoBarras_faturanova(),
                        lista.get(i).getInstalacao_faturanova(),
                        lista.get(i).getCargaLevantada_faturanova(),
                        lista.get(i).getMedidorInstalacao_faturanova(),
                        
                        lista.get(i).getRua_faturanova(),
                        lista.get(i).getNumero_faturanova(),
                        lista.get(i).getBairro_faturanova(),
                        lista.get(i).getTipos_faturanova()
                    });
                }
            
            
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"listarValores" + erro);
        }
    }
     private void exportarParaPlanilha(String inst, String Tipos, String rua,
        String CargaLev, String Medidor, String Numero, String Bairro) {

    try {

        ConsultarFaturasGipDAO dao = new ConsultarFaturasGipDAO();

        List<ConsultarFaturasGipDTO> listaConsultas =
                dao.consultarFatura(inst, Tipos, rua, CargaLev,
                        Medidor, Numero, Bairro, "");

        // 📁 Pega a Área de Trabalho oficial do sistema
         File desktop = FileSystemView.getFileSystemView().getHomeDirectory();

        Path pasta = Paths.get(desktop.getAbsolutePath(), "Planilhas_Exportadas");

        // ✅ Cria pasta automaticamente se não existir
        Files.createDirectories(pasta);

        // 📅 Data e hora no nome (evita sobrescrever)
        String dataHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm"));

        String nomeArquivo = "faturas_" + dataHora + ".xlsx";

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
}}
/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE LEITE JANUÁRIO
*/

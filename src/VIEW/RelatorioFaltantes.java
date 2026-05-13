
package VIEW;

import DAO.RelatorioFaltantesDAO;
import DTO.RelatorioFaltantesDTO;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import DAO.ConexaoGipDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.filechooser.FileSystemView;


public class RelatorioFaltantes extends javax.swing.JFrame {

    
    public RelatorioFaltantes() {
        initComponents();
        AutoCompleteDecorator.decorate(MesBox); //serve para ele dar a opção das letras que vc vai digitando
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MesBox = new javax.swing.JComboBox<>();
        BuscaBtn = new javax.swing.JButton();
        VoltarBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        AnoRef = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("FALTANTES");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Reduzido", "StatusMensal", "Instalacao"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        MesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro", "Diversas Atrasadas" }));

        BuscaBtn.setText("BUSCAR");
        BuscaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaBtnActionPerformed(evt);
            }
        });

        VoltarBtn.setText("VOLTAR");
        VoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBtnActionPerformed(evt);
            }
        });

        jButton1.setText("EXPORTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ano:");

        jLabel3.setText("Mês:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(102, 102, 102)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(AnoRef, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(VoltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(MesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BuscaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscaBtn)
                    .addComponent(AnoRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBtn)
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
       RelatorioMensal relatorioMensal = new RelatorioMensal();
       relatorioMensal.setVisible(true);
       
       this.dispose();
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void BuscaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaBtnActionPerformed
         try {
             chamarProcedure((String)MesBox.getSelectedItem(), AnoRef.getText()); // Chama a procedure no DAO
            //COMO TEM CONDIÇÃO, MES REFERENTE SERVE COMO VARIAVEL DE PESQUISA E JOGA PRO BANCO TUDO QUE ENTRA NO TXTMESREF
        } catch (Exception e) {
            // Trate exceções aqui
            e.printStackTrace();
        }
     
        try{ 
             listarValores();
         }catch(Exception erro){
             JOptionPane.showMessageDialog(null, "erro listagem" + erro);
             }
    }//GEN-LAST:event_BuscaBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       exportarParaPlanilha();
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioFaltantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnoRef;
    private javax.swing.JButton BuscaBtn;
    private javax.swing.JComboBox<String> MesBox;
    private javax.swing.JButton VoltarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
private void listarValores() {
        try {
            RelatorioFaltantesDAO relatoriofaltantes = new RelatorioFaltantesDAO();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            

            List<RelatorioFaltantesDTO> lista = relatoriofaltantes.RelatorioFaltantes();

            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
                    lista.get(i).getID(),
                     lista.get(i).getReduzido(),
                     lista.get(i).getStatusMensal(),
                     lista.get(i).getInstalacao(),});
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores" + erro);
        }
    }
private void exportarParaPlanilha() {

    try {

        RelatorioFaltantesDAO dao = new RelatorioFaltantesDAO();
        List<RelatorioFaltantesDTO> listaConsultas = dao.RelatorioFaltantes();

        // 📁 Pega a Área de Trabalho oficial do sistema
        File desktop = FileSystemView.getFileSystemView().getHomeDirectory();

        Path pasta = Paths.get(desktop.getAbsolutePath(), "Planilhas_Exportadas");

        // ✅ Cria pasta se não existir
        Files.createDirectories(pasta);

        // 📅 Data e hora para não sobrescrever arquivos
        String dataHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm"));

        String nomeArquivo = "relatorio_faltantes_" + dataHora + ".xlsx";

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

public void chamarProcedure(String MesRef, String Anoref) throws SQLException {
        java.sql.Connection conn = null;
        CallableStatement callableStatement = null;

        try { 
            conn = new ConexaoGipDAO().conectaBD();
            // Assume que você tem uma classe de conexão separada
            
            // Chama a procedure usando CallableStatement
            String sqlProcedure = "{call testeStatusMensal(?, ?)}";
            
            callableStatement = (CallableStatement) conn.prepareCall(sqlProcedure);
            callableStatement.setString(1, MesRef);
            callableStatement.setString(2, Anoref);
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

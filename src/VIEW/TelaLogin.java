
package VIEW;

import DAO.LoginGipDAO;
import DTO.LoginGipDTO;
import static VIEW.Sessao.nomeUsuario;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        IfTxt = new javax.swing.JTextField();
        SenhaPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SairBtn = new javax.swing.JButton();
        LogBtn = new javax.swing.JButton();
        ExibirSenhaCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Login");

        IfTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SenhaPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SenhaPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SenhaPasswordKeyPressed(evt);
            }
        });

        jLabel2.setText("IF:");

        jLabel3.setText("SENHA:");

        SairBtn.setBackground(new java.awt.Color(255, 255, 255));
        SairBtn.setForeground(new java.awt.Color(0, 0, 0));
        SairBtn.setText("SAIR");
        SairBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SairBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SairBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairBtnActionPerformed(evt);
            }
        });

        LogBtn.setBackground(new java.awt.Color(255, 255, 255));
        LogBtn.setForeground(new java.awt.Color(0, 0, 0));
        LogBtn.setText("LOGAR");
        LogBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LogBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogBtnActionPerformed(evt);
            }
        });

        ExibirSenhaCheckBox.setText("Exibir Senha");
        ExibirSenhaCheckBox.setBorder(null);
        ExibirSenhaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExibirSenhaCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SairBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(SenhaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(ExibirSenhaCheckBox))
                                        .addComponent(LogBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(IfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SenhaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ExibirSenhaCheckBox))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SairBtn)
                    .addComponent(LogBtn))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogBtnActionPerformed
        
        try {

            String If_usuario, Senha_usuario, NomeCompleto_usuario;

            If_usuario = IfTxt.getText();

            Senha_usuario = String.valueOf(SenhaPassword.getPassword());
            
            

            LoginGipDTO objlogingipdto = new LoginGipDTO();

            objlogingipdto.setIf_login(If_usuario);
            objlogingipdto.setSenha_login(Senha_usuario);

            LoginGipDAO objlogingipdao = new LoginGipDAO();
            ResultSet rslogingipdao = objlogingipdao.autenticacaoUsuario(objlogingipdto);

            if (rslogingipdao.next()) { // código .next deu certo pq usei o resultset para fazer a 'validação' 
                //esse código serve para chamar tela que quero abrir 

                 String nomeUsuario = rslogingipdao.getString("NomeCompleto_usuario");

                 Sessao.nomeUsuario = nomeUsuario;
    JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO!");
    JOptionPane.showMessageDialog(null, "BEM VINDO(A)   " + nomeUsuario);

    TelaMenu telaMenu = new TelaMenu();
    telaMenu.setVisible(true);

    this.dispose();

            } else {
                // enviar mensagem falando que algo está incorreto 
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorrretos!!!");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "TelaLogin" + erro);

        }
    }//GEN-LAST:event_LogBtnActionPerformed

    private void SairBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_SairBtnActionPerformed

    private void ExibirSenhaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExibirSenhaCheckBoxActionPerformed

        //esse código do check box serve para mandar uma função qnd ele é selecionado 
        if (ExibirSenhaCheckBox.isSelected()) {
            SenhaPassword.setEchoChar((char) 0);
        } else {
            SenhaPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_ExibirSenhaCheckBoxActionPerformed

    private void SenhaPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SenhaPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            try {

                String If_usuario, Senha_usuario, NomeCompleto_usuario;

                If_usuario = IfTxt.getText();

                Senha_usuario = String.valueOf(SenhaPassword.getPassword());

                LoginGipDTO objlogingipdto = new LoginGipDTO();

                objlogingipdto.setIf_login(If_usuario);
                objlogingipdto.setSenha_login(Senha_usuario);

                LoginGipDAO objlogingipdao = new LoginGipDAO();
                ResultSet rslogingipdao = objlogingipdao.autenticacaoUsuario(objlogingipdto);

                if (rslogingipdao.next()) {
                    Sessao.nomeUsuario = rslogingipdao.getString("NomeCompleto_usuario");

                    // Define o texto do campo nomeUser com o nome do usuário

                    JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO!" );
                    JOptionPane.showMessageDialog(null, "BEM VINDO(A)    "+ nomeUsuario );

                    TelaMenu telaMenu = new TelaMenu();
                    telaMenu.setVisible(true);

                    this.dispose();

                } else {
                    // enviar mensagem falando que algo está incorreto 
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorrretos!!!");
                }

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "TelaLogin" + erro);

            }
        }

    }//GEN-LAST:event_SenhaPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ExibirSenhaCheckBox;
    private javax.swing.JTextField IfTxt;
    private javax.swing.JButton LogBtn;
    private javax.swing.JButton SairBtn;
    private javax.swing.JPasswordField SenhaPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
//código de recuperação, segurança.

/*private void Logar(){
        try{
        
        String If_usuario, Senha_usuario;
        
        If_usuario = IfTxt.getText();
        Senha_usuario = String.valueOf(SenhaPassword.getPassword());
        
        LoginGipDTO objlogingipdto = new LoginGipDTO();
        
        objlogingipdto.setIf_login(If_usuario);
        objlogingipdto.setSenha_login(Senha_usuario);
        
        LoginGipDAO objlogingipdao = new LoginGipDAO();
        ResultSet rslogingipdao = objlogingipdao.autenticacaoUsuario(objlogingipdto);
        
        if(rslogingipdao.next()){
            //esse código serve para chamar tela que quero abrir 
            TelaMenu telaMenu = new TelaMenu();
            telaMenu.setVisible(true);
            
            this.dispose();
                    
        }else{
            // enviar mensagem falando que algo está incorreto 
            JOptionPane.showMessageDialog(null,"Usuário ou senha incorrretos!!!");
        }
        
      }
      catch(Exception erro){
          JOptionPane.showMessageDialog(null,"TelaLogin" + erro);
          
      }
    }*/ //codigo de recuperação 


/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE lEITE JANUÁRIO
*/

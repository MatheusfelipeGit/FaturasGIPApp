
package DAO;

import DTO.LoginGipDTO;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class LoginGipDAO {
    
    Connection conn; //Declara o item que puxa a conexao
 
    public ResultSet autenticacaoUsuario(LoginGipDTO objlogingipdto){
        conn = new ConexaoGipDAO().conectaBD(); //realiza a conexão com o banco de dados 
        
        try{
           String sql = "SELECT *, NomeCompleto_usuario FROM usuario WHERE If_usuario = ? AND Senha_usuario = ?"; 
           //codigo de conversação com o banco de dados na linguagem do banco de dados 
           
            PreparedStatement pstm = conn.prepareStatement(sql);
           //chama a conexao e prepara para enviar ao banco de dados 
           
           pstm.setString(1, objlogingipdto.getIf_login());
           pstm.setString(2, objlogingipdto.getSenha_login());
       
           ResultSet rs = pstm.executeQuery();
          //decalra o resultset e retorna o resultset
           return rs;
           
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"LoginGipDAO: " + erro);
            //caso haja erro, envia essa mensagem de erro
            return null;
        }
        
    }
 
}
/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE lEITE JANUÁRIO
*/ 
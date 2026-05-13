
package DAO;

import DTO.CadastroUsuarioGipDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import necessario para a realização de uma função/retorno especifico 

public class CadastroUsuarioGipDAO {
     
    Connection conn; //conection conn
    PreparedStatement pstm; //prepared é pstm 
    
    
    public void cadastrarUsuario(CadastroUsuarioGipDTO objcadastrarusuariogipdto) {
        String sql = "insert into usuario (If_usuario,NomeCompleto_usuario, Senha_usuario) values (?,?,?)"  ;
        //inserir dados no banco de dados com tabela e colunas especificas
        conn = new ConexaoGipDAO().conectaBD(); //chama a conexao com o banco de dados 
        
        //função de cadastro
        try {
            
            pstm = conn.prepareStatement(sql);
    
            pstm.setString(1, objcadastrarusuariogipdto.getIf_usuario());          
            pstm.setString(2, objcadastrarusuariogipdto.getNomeCompleto_usuario());   
            pstm.setString(3, objcadastrarusuariogipdto.getSenha_usuario());  
            
           
            pstm.execute();
           
            JOptionPane.showMessageDialog(null, "CADASTRO DE USUARIO REALIZADO COM SUCESSO!");
            
            
            
        } 
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "CadastroUsuarioGipDAO" + erro);
            
        }
        
    
    }
}
/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE lEITE JANUÁRIO
*/ 
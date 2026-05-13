
package DAO;


import DTO.ImpostosGipDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import necessario para a realização de uma função/retorno especifico

public class ImpostosGipDAO {
    Connection conn; //define conn Connection
    PreparedStatement pstm; //define pstm como preparedstatement
    
    public void cadastrarImposto(ImpostosGipDTO objimpostosgipdto) {

        conn = new ConexaoGipDAO().conectaBD();//realiza conexao
        
        try{
            
            String sql = "insert into impostos (Im_TUSD_impostos_PP, Im_TE_impostos_PP,Resultado_impostos_PP, Im_TUSD_impostos_IP,Im_TE_impostos_IP ,Resultado_impostos_IP ,Pis_impostos,Cofins_impostos, Ajuste_impostos, Icms_impostos, MesReferente_impostos, Ano_impostos) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            //codigo de conversação com o banco de dados na linguagem do banco de dados 
             pstm = conn.prepareStatement(sql);
             
             pstm.setString(1, objimpostosgipdto.getIm_TUSD_impostos_PP());
          
             pstm.setString(2, objimpostosgipdto.getIm_TE_impostos_PP());
             
             pstm.setString(3, objimpostosgipdto.getResultado_impostos_PP());
             
             pstm.setString(4, objimpostosgipdto.getIm_TUSD_impostos_IP());
          
             pstm.setString(5, objimpostosgipdto.getIm_TE_impostos_IP());
             
             pstm.setString(6, objimpostosgipdto.getResultado_impostos_Ip());
             
             pstm.setString(7, objimpostosgipdto.getPis_impostos());
             
             pstm.setString(8, objimpostosgipdto.getCofins_impostos());
             
             pstm.setString(9, objimpostosgipdto.getAjuste_impostos());
            
             pstm.setString(10, objimpostosgipdto.getAjuste_impostos());
             
             pstm.setString(11, objimpostosgipdto.getMesReferente_impostos());
             
             pstm.setString(12, objimpostosgipdto.getAno_impostos());
             
             pstm.execute();
             pstm.close();
             
             JOptionPane.showMessageDialog(null, "CADASTRO DE IMPOSTO REALIZADO!!");
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"impostosdao" + erro);
        }
    
    
    
    }
    
    }
/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE lEITE JANUÁRIO
*/ 
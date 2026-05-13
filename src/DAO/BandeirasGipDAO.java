
package DAO;

import DTO.BandeirasGipDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//import necessario para a realização de uma função/retorno especifico 

public class BandeirasGipDAO {
    Connection conn; //conection é conn
    PreparedStatement pstm; //prepared é pstm
    
    
    //aqui é a função de inserir dados no banco de dados, com a tabela e colunas definidas/ chamando tb a conexao
    public void cadastrarBandeira(BandeirasGipDTO objbandeirasgipdto) {
        String sql = "insert into bandeiras (CorBandeiras_bandeiras, Valor1_bandeiras, Valor2_bandeiras, Valor3_bandeiras, Valor4_bandeiras, Valor5_bandeiras, Valor6_bandeiras, MesReferente_bandeiras, Ano_bandeiras) values (?,?,?,?,?,?,?,?,?)";
        conn = new ConexaoGipDAO().conectaBD();
        
        
        try {
            
            pstm = conn.prepareStatement(sql);
    
            pstm.setString(1, objbandeirasgipdto.getCorBandeiras_bandeiras());          
            pstm.setString(2, objbandeirasgipdto.getValor1_bandeiras());          
            pstm.setString(3, objbandeirasgipdto.getValor2_bandeiras());          
            pstm.setString(4, objbandeirasgipdto.getValor3_bandeiras());          
            pstm.setString(5, objbandeirasgipdto.getValor4_bandeiras());          
            pstm.setString(6, objbandeirasgipdto.getValor5_bandeiras());          
            pstm.setString(7, objbandeirasgipdto.getValor6_bandeiras());                    
            pstm.setString(8, objbandeirasgipdto.getMesReferente_bandeiras());          
            pstm.setString(9, objbandeirasgipdto.getAno_bandeiras());    
            //esse código de cima faz o get e set
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "CADASTRO DE BANDEIRA REALIZADO COM SUCESSO!!");
            
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "CONFIRA SE TODOS OS CAMPOS ESTÃO CORRETAMENTE PREENCHIDOS!");
            JOptionPane.showMessageDialog(null, "BandeirasGipDAO" + erro);
            
        }
    }    
 //esse código chama a procedure feita no banco de dados 
    public void chamarProcedure() throws SQLException {
        Connection conn = null;
        CallableStatement callableStatement = null;

        try {
            conn = new ConexaoGipDAO().conectaBD();
            // Assume que você tem uma classe de conexão separada
            
            // Chama a procedure usando CallableStatement
            String sqlProcedure = "{CALL calcular_media_bandeiras_mes_ano(?, ?)}";
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
/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE lEITE JANUÁRIO
*/ 
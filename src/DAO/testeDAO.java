
package DAO;

import DTO.testedto;
import DTO.testedto;
import java.sql.CallableStatement;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testeDAO {
    
     Connection conn; //atribui valor de conn
    PreparedStatement pstm;//atribui valor de pstm
    ResultSet rs;//atribui valor de rs
    
    List<testedto> lista = new ArrayList<>(); //declara uma nova Lista, ou um tipo de lista 
    
    public List<testedto> RelatorioPesq (String Red) {
        
          conn = new ConexaoGipDAO().conectaBD();//puxa a conexão da classe de conexão 
          
          try{
            //função de busca por instalação
              String sql = " SELECT AVG(valor_cadastroConsumoFatura) "
                      + " FROM faturasgip.cadastroconsumofatura "
                      + " WHERE CodBarrasRed_cadastroConsumoFatura = '900859' ";
                         //"AND cadastroConsumoFatura.Auditoria_cadastroConsumoFatura = Sim"
            //inicia a construção da consulta do SQL
            
            pstm = conn.prepareStatement(sql);
            
          //  pstm.setString(1, Red);//parametro de pesquisa 
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                testedto testedtoo = new testedto();
                
                testedtoo.setValor_cadastroConsumoFatura(rs.getString("Valor_cadastroConsumoFatura"));
                testedtoo.setCodBarrasRed_cadastroConsumoFatura(rs.getString("CodBarrasRed_cadastroConsumoFatura"));
                
    
                lista.add(testedtoo);}
    }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "falha ao consultar" + ex);
        } finally{
              
}
         return lista;
  }
    }


package DAO;

import DTO.ConsultarConsumoGipDTO;
import DTO.RelatorioGipDTO;
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


public class RelatorioGipDAO { 
    
    Connection conn; //atribui valor de conn
    PreparedStatement pstm;//atribui valor de pstm
    ResultSet rs;//atribui valor de rs
    
    List<RelatorioGipDTO> lista = new ArrayList<>(); //declara uma nova Lista, ou um tipo de lista 
    
    public List<RelatorioGipDTO> RelatorioPesq (String Tipo, String MesRef, String Ano, String Auditoria) {
        
        conn = new ConexaoGipDAO().conectaBD();//puxa a conexão da classe de conexão 
        
        try{
            //função de busca por instalação
            String sql = "SELECT * FROM cadastroConsumoFatura " +
                         "INNER JOIN faturanova ON cadastroConsumoFatura.CodBarrasRed_cadastroConsumoFatura = faturanova.CodBarrasRed_faturanova " +
                         "WHERE faturanova.Tipos_faturanova = ?" +
                         "AND cadastroConsumoFatura.MesReferente_cadastroConsumoFatura = ?" + 
                         "AND cadastroConsumoFatura.Ano_cadastroConsumoFatura = ?" + 
                         "AND cadastroConsumoFatura.Auditoria_cadastroConsumoFatura = ?" ; 
                         //"AND cadastroConsumoFatura.Auditoria_cadastroConsumoFatura = Sim"
            //inicia a construção da consulta do SQL
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, Tipo);//parametro de pesquisa 
            
            pstm.setString(2, MesRef);//parametro de pesquisa
            
            pstm.setString(3, Ano);//parametro de pesquisa
            
            pstm.setString(4, Auditoria);//parametro de pesquisa
            
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                RelatorioGipDTO objrelatoriogipdto = new RelatorioGipDTO();
                
                objrelatoriogipdto.setInstalacao_faturanova(rs.getString("Instalacao_faturanova"));
                
                objrelatoriogipdto.setMesReferente_cadastroConsumoFatura(rs.getString("MesReferente_cadastroConsumoFatura"));
                objrelatoriogipdto.setValor_cadastroConsumoFatura(rs.getString("Valor_cadastroConsumoFatura"));
                objrelatoriogipdto.setKw_cadastroConsumoFatura(rs.getString("Kw_cadastroConsumoFatura"));
                objrelatoriogipdto.setAno_cadastroConsumoFatura(rs.getString("Ano_cadastroConsumoFatura"));
                
                objrelatoriogipdto.setAuditoria_cadastroConsumoFatura(rs.getString("Auditoria_cadastroConsumoFatura"));
                //objrelatoriogipdto.setCodBarrasRed_cadastroConsumoFatura(rs.getString("CodBarrasRed_cadastroConsumoFatura"));
                
                lista.add(objrelatoriogipdto);
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "falha ao consultar" + ex);
        }finally{
            
        }
        
        return lista;
       
    }
    
    public void chamarProcedure() throws SQLException {
        Connection conn = null;
        CallableStatement callableStatement = null;

        try {
            conn = new ConexaoGipDAO().conectaBD();
            // Assume que você tem uma classe de conexão separada
            
            // Chama a procedure usando CallableStatement
            String sqlProcedure = "{CALL MediaeAuditoria}";
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
    
   public void exportarParaPlanilha(List<RelatorioGipDTO> listar, String filePath) {
    
        try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
                   headerRow.createCell(0).setCellValue("instalacao");

            headerRow.createCell(1).setCellValue("Mes Referente");
            headerRow.createCell(2).setCellValue("Valor");
            headerRow.createCell(3).setCellValue("Kw");
            headerRow.createCell(4).setCellValue("Ano");

            headerRow.createCell(5).setCellValue("Auditoria");

            // Preenche os dados na planilha a partir da lista de DTOs
            for (RelatorioGipDTO dto : listar) {
                Row dataRow = sheet.createRow(rowIndex++);
                dataRow.createCell(0).setCellValue(dto.getInstalacao_faturanova());

                dataRow.createCell(1).setCellValue(dto.getMesReferente_cadastroConsumoFatura());
                dataRow.createCell(2).setCellValue(dto.getValor_cadastroConsumoFatura());
                dataRow.createCell(3).setCellValue(dto.getKw_cadastroConsumoFatura());
                dataRow.createCell(4).setCellValue(dto.getAno_cadastroConsumoFatura());

                dataRow.createCell(5).setCellValue(dto.getAuditoria_cadastroConsumoFatura());
            }

        // mensagem que avisa oonde a planilha está/ Salva a mesma
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
            
            System.out.println("Planilha exportada com sucesso para: " + filePath);
        }
        
         
    } catch (Exception e) {
        e.printStackTrace();
    }
}  
}

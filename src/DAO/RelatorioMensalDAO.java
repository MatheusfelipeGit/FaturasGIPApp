
package DAO;

import DTO.RelatorioMensalDTO;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.io.FileOutputStream;
import java.sql.CallableStatement;

public class RelatorioMensalDAO {
   Connection conn; //declara Connection como Conn para a conexão
   PreparedStatement pstm; //declara prepared como pstm para a lógica de get e set 
   ResultSet rs; //declara ResultSet como rs para resultar dados

List<RelatorioMensalDTO> lista = new ArrayList<>(); //declara uma nova Lista, ou um tipo de lista 
    
    public List<RelatorioMensalDTO> RelatorioMensal ( ) {
        
        conn = new ConexaoGipDAO().conectaBD();//puxa a conexão da classe de conexão 
        
        try{
            //função de busca por instalação
            String sql = "SELECT * FROM TotalDeFaturas " ; 
                         //"AND cadastroConsumoFatura.Auditoria_cadastroConsumoFatura = Sim"
            //inicia a construção da consulta do SQL
            
            pstm = conn.prepareStatement(sql);
            
          
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                RelatorioMensalDTO objrelatoriomensaldto = new RelatorioMensalDTO();
                
                objrelatoriomensaldto.setQuantidadeTotal_TotalDeFaturas(rs.getString("QuantidadeTotal_TotalDeFaturas"));
                objrelatoriomensaldto.setQuantidadeMensal_TotalDeFaturas(rs.getString("QuantidadeMensal_TotalDeFaturas"));
                objrelatoriomensaldto.setFaltantes_TotalDeFaturas(rs.getString("Faltantes_TotalDeFaturas"));
               
                lista.add(objrelatoriomensaldto);      
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "falha ao consultar" + ex);
        }finally{
            
        }
        
        return lista;
       
    }
    
    public void chamarProcedure(String mesReferente1, String Ano) throws SQLException {
        java.sql.Connection conn = null;
        CallableStatement callableStatement = null ;

        try { 
            conn = new ConexaoGipDAO().conectaBD();
            // Assume que você tem uma classe de conexão separada
            
            // Chama a procedure usando CallableStatement
            String sqlProcedure = "{call RelatorioMensalQuantidade(?, ?)}";
            
            callableStatement = (CallableStatement) conn.prepareCall(sqlProcedure);
            callableStatement.setString(1, mesReferente1);
            callableStatement.setString(2, Ano);
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
    
   public void exportarParaPlanilha(List<RelatorioMensalDTO> listar, String filePath) {
    
        try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
            headerRow.createCell(0).setCellValue("Total faturas");
            headerRow.createCell(1).setCellValue("total mes ");
            headerRow.createCell(2).setCellValue("faltantes");

            // Preenche os dados na planilha a partir da lista de DTOs
            for (RelatorioMensalDTO dto : listar) {
                Row dataRow = sheet.createRow(rowIndex++);
                dataRow.createCell(0).setCellValue(dto.getQuantidadeTotal_TotalDeFaturas());

                dataRow.createCell(1).setCellValue(dto.getQuantidadeMensal_TotalDeFaturas());
                dataRow.createCell(2).setCellValue(dto.getFaltantes_TotalDeFaturas());
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
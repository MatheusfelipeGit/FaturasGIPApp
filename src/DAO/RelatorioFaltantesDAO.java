package DAO;

import DTO.RelatorioFaltantesDTO;
import java.sql.CallableStatement;

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

public class RelatorioFaltantesDAO {
   Connection conn; //declara Connection como Conn para a conexão
   PreparedStatement pstm; //declara prepared como pstm para a lógica de get e set 
   ResultSet rs; //declara ResultSet como rs para resultar dados

List<RelatorioFaltantesDTO> lista = new ArrayList<>(); //declara uma nova Lista, ou um tipo de lista 
    
    public List<RelatorioFaltantesDTO> RelatorioFaltantes( ) {
        
        conn = new ConexaoGipDAO().conectaBD();//puxa a conexão da classe de conexão 
        
        try{
            //função de busca por instalação
            String sql = "SELECT * FROM testeFaltas " ; 
                         //"AND cadastroConsumoFatura.Auditoria_cadastroConsumoFatura = Sim"
            //inicia a construção da consulta do SQL
            
            pstm = conn.prepareStatement(sql);
            
          
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                RelatorioFaltantesDTO objrelatoriofaltantesdto = new RelatorioFaltantesDTO();
                
                objrelatoriofaltantesdto.setID(rs.getString("ID"));
                objrelatoriofaltantesdto.setReduzido(rs.getString("Reduzido"));
                objrelatoriofaltantesdto.setStatusMensal(rs.getString("StatusMensal"));
                objrelatoriofaltantesdto.setInstalacao(rs.getString("Instalacao"));
                
               
                lista.add(objrelatoriofaltantesdto);      
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "falha ao consultar" + ex);
        }finally{
            
        }
        
        return lista;
       
    }
    
    public void chamarProcedure(String MesRef, String Anoref) throws SQLException {
        java.sql.Connection conn = null;
        CallableStatement callableStatement = null ;

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
public void exportarParaPlanilha(List<RelatorioFaltantesDTO> listar, String filePath) {
    
        try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Reduzido");
            headerRow.createCell(2).setCellValue("Faltantes");
            headerRow.createCell(3).setCellValue("Instalacao");

            // Preenche os dados na planilha a partir da lista de DTOs
            for (RelatorioFaltantesDTO dto : listar) {
                Row dataRow = sheet.createRow(rowIndex++);
                dataRow.createCell(0).setCellValue(dto.getID());

                dataRow.createCell(1).setCellValue(dto.getReduzido());
                dataRow.createCell(2).setCellValue(dto.getStatusMensal());
                dataRow.createCell(3).setCellValue(dto.getInstalacao());
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
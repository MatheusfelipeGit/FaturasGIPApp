package DAO;

import DTO.ConsultarConsumoGipDTO;
import DTO.RelatorioInformativoDTO;
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

public class RelatorioInformativoDAO {
    Connection conn; //define Connection como 'conn'
    PreparedStatement pstm; //define prepared como 'pstm'
    ResultSet rs; //define ResultSet como 'rs' 
    
    List<RelatorioInformativoDTO> lista = new ArrayList<>();
   
    public List<RelatorioInformativoDTO> RelatorioInfo (String Ano_cadastroConsumoFatura) {
        
        conn = new ConexaoGipDAO().conectaBD(); //chama a conexão com a String conn para conecta bd
        
        try{
            String sql = "SELECT * FROM consumo_auditoria" ;
            
            pstm = conn.prepareStatement(sql);
            
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                
                RelatorioInformativoDTO objrelatoriogipdto = new RelatorioInformativoDTO();
                
               // objrelatoriogipdto.setCodigoBarrasCon_cadastroConsumoFatura(rs.getString("CodigoBarrasCon_cadastroConsumoFatura")); 
                objrelatoriogipdto.setCodigo_barras_reduzido(rs.getString("codigo_barras_reduzido")); 
                objrelatoriogipdto.setJaneiro(rs.getString("Janeiro")); 
                objrelatoriogipdto.setFevereiro(rs.getString("Fevereiro")); 
                objrelatoriogipdto.setMarco(rs.getString("Marco")); 
                objrelatoriogipdto.setAbril(rs.getString("Abril")); 
                objrelatoriogipdto.setMaio(rs.getString("Maio")); 
                objrelatoriogipdto.setJunho(rs.getString("Junho")); 
                objrelatoriogipdto.setJulho(rs.getString("Julho")); 
                objrelatoriogipdto.setAgosto(rs.getString("Agosto")); 
                objrelatoriogipdto.setSetembro(rs.getString("Setembro")); 
                objrelatoriogipdto.setOutubro(rs.getString("Outubro")); 
                objrelatoriogipdto.setNovembro(rs.getString("Novembro")); 
                objrelatoriogipdto.setDezembro(rs.getString("Dezembro")); 
                objrelatoriogipdto.setMedia(rs.getString("Media")); 
                objrelatoriogipdto.setAuditoria(rs.getString("Auditoria")); 

                
                
                
                lista.add(objrelatoriogipdto);
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "falha ao consultar" + ex);
        }finally{
            
        }
        
        return lista;
    }
    public void chamarProcedure(String Ano_cadastroConsumoFatura) throws SQLException {
    Connection conn = null;
    CallableStatement callableStatement = null;

    try { 
        conn = new ConexaoGipDAO().conectaBD();
        
        // Chama a procedure
        String sqlProcedure = "{call faturasgip.InserirConsumoAuditoria()}";
        
        callableStatement = (CallableStatement) conn.prepareCall(sqlProcedure);
        
        // Se a procedure **não retorna** dados, use executeUpdate()
        callableStatement.executeUpdate();  

    } finally {
        if (callableStatement != null) {
            callableStatement.close();
        }
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
        
    }public void exportarParaPlanilha1(List<RelatorioInformativoDTO> listar, String filePath) {
    
        try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
            headerRow.createCell(0).setCellValue("Red");
            headerRow.createCell(1).setCellValue("Jan");
            headerRow.createCell(2).setCellValue("Fev");
            headerRow.createCell(3).setCellValue("Mar");
            headerRow.createCell(4).setCellValue("Abr");
            headerRow.createCell(5).setCellValue("Maio");
            headerRow.createCell(6).setCellValue("Jun");
            headerRow.createCell(7).setCellValue("Jul");
            headerRow.createCell(8).setCellValue("Ago");
            headerRow.createCell(9).setCellValue("Set");
            headerRow.createCell(10).setCellValue("Out");
            headerRow.createCell(11).setCellValue("Nov");
            headerRow.createCell(12).setCellValue("Dez");
            headerRow.createCell(13).setCellValue("divatrasadas");
            headerRow.createCell(14).setCellValue("mediaFinal");
            headerRow.createCell(15).setCellValue("Auditoria");

            // Preenche os dados na planilha a partir da lista de DTOs
            for (RelatorioInformativoDTO dto : listar) {
                Row dataRow = sheet.createRow(rowIndex++);
                dataRow.createCell(0).setCellValue(dto.getCodigo_barras_reduzido());
                dataRow.createCell(1).setCellValue(dto.getJaneiro());
                dataRow.createCell(2).setCellValue(dto.getFevereiro());
                dataRow.createCell(3).setCellValue(dto.getMarco());
                dataRow.createCell(4).setCellValue(dto.getAbril());
                dataRow.createCell(5).setCellValue(dto.getMaio());
                dataRow.createCell(6).setCellValue(dto.getJunho());
                dataRow.createCell(7).setCellValue(dto.getJulho());
                dataRow.createCell(8).setCellValue(dto.getAgosto());
                dataRow.createCell(9).setCellValue(dto.getSetembro());
                dataRow.createCell(10).setCellValue(dto.getOutubro());
                dataRow.createCell(11).setCellValue(dto.getNovembro());
                dataRow.createCell(12).setCellValue(dto.getDezembro());
                dataRow.createCell(13).setCellValue(dto.getDivatrasadas());
                dataRow.createCell(14).setCellValue(dto.getMedia());
                dataRow.createCell(15).setCellValue(dto.getAuditoria());
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
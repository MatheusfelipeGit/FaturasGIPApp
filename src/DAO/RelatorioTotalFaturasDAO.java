
package DAO;

import DTO.RelatorioTotalFaturasDTO;
import java.sql.CallableStatement;
import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class RelatorioTotalFaturasDAO {

Connection conn; //declara connection como conn
PreparedStatement pstm; // declara Prepared como pstm
ResultSet rs; // declara ResultSet como rs

List<RelatorioTotalFaturasDTO> lista = new ArrayList<>();//declara uma nova Lista chamando DTO, ou um tipo de lista



public List<RelatorioTotalFaturasDTO> RelatorioQuantidade() {
    
    conn = (Connection) new ConexaoGipDAO().conectaBD(); //puxa a conexão da classe de conexão
    
    try{
        //função de buscar
        String sql = "SELECT * FROM Armaz";
    
        
        pstm = conn.prepareStatement(sql);

        rs = pstm.executeQuery();
        
        while(rs.next()) {
            RelatorioTotalFaturasDTO objrelatorioquantidadedto = new RelatorioTotalFaturasDTO();
            
            objrelatorioquantidadedto.setQuantidadeTotal_Armaz(rs.getString("QuantidadeTotal_Armaz"));
            objrelatorioquantidadedto.setTipo_Armaz(rs.getString("Tipo_Armaz"));
            
            
            lista.add(objrelatorioquantidadedto);
     
    
    }
        
    } catch (SQLException Erro) {
        JOptionPane.showMessageDialog(null,"falha ao consultar" + Erro);
    }finally{
        
    }
    return lista;
}
    public void chamarProcedure1() throws SQLException { // esse throws é quando não se trata no próprio método
            Connection conn = null;
            CallableStatement callableStatement = null;

            try {
                conn = new ConexaoGipDAO().conectaBD();
                // Assume que você tem uma classe de conexão separada

                // Chama a procedure usando CallableStatement
                String sqlProcedure = "{CALL AttArmaz}";
                callableStatement = (CallableStatement) conn.prepareCall(sqlProcedure);
                callableStatement.execute();

            }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar a procedure: " + e.getMessage());
        } 
            finally {
                // Fecha o CallableStatement e a conexão
                if (callableStatement != null) {
                    callableStatement.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
             
                }
            }
        }
    
       public void exportarParaPlanilha(List<RelatorioTotalFaturasDTO> listar, String filePath) {
    
        try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
            headerRow.createCell(0).setCellValue("QuantidadeTotal_Armaz");
            headerRow.createCell(1).setCellValue("Tipo_Armaz");
          

            // Preenche os dados na planilha a partir da lista de DTOs
            for (RelatorioTotalFaturasDTO dto : listar) {
                Row dataRow = sheet.createRow(rowIndex++);
                dataRow.createCell(0).setCellValue(dto.getQuantidadeTotal_Armaz());
                dataRow.createCell(1).setCellValue(dto.getTipo_Armaz());

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

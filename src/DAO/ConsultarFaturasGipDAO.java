
package DAO;


import DTO.ConsultarFaturasGipDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row;


import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import necessario para a realização de uma função/retorno especifico 

public class ConsultarFaturasGipDAO {
     
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<ConsultarFaturasGipDTO> lista = new ArrayList<>();
    
        public List<ConsultarFaturasGipDTO> consultarFatura(String inst, String Tipos, String rua, String CargaLev, String Medidor, String Numero, String Bairro, String PesqGeral){
       
            conn = new ConexaoGipDAO().conectaBD();
            
            try {
        String sql = "SELECT * FROM faturanova WHERE 1=1"; // Inicia a construção da consulta do SQL

        
        if (!inst.isEmpty()) {
            sql += " AND Instalacao_faturanova LIKE ?"; // Adiciona a condição para o mês de referência
        }
        
        if (!Tipos.isEmpty()) {
            sql += " AND Tipos_faturanova LIKE ?"; // Adiciona a condição para o ano de referência
        }
        
        if (!rua.isEmpty()) {
            sql += " AND Rua_faturanova LIKE ?"; // Adiciona a condição para o ano de referência
        }
        
        if (!CargaLev.isEmpty()) {
            sql += " AND CargaLevantada_faturanova LIKE ?"; // Adiciona a condição para o ano de referência
        }
        
        if (!Medidor.isEmpty()) {
            sql += " AND MedidorInstalacao_faturanova LIKE ?"; // Adiciona a condição para o ano de referência
        }
        
        if (!Numero.isEmpty()) {
            sql += " AND Numero_faturanova LIKE ?"; // Adiciona a condição para o ano de referência
        }
        
        if (!Bairro.isEmpty()) {
            sql += " AND Bairro_faturanova LIKE ?"; // Adiciona a condição para o ano de referência
        }
        
        if (!PesqGeral.isEmpty()) {
            sql += " AND (CodigoBarras_faturanova LIKE ? OR " +
                    "Instalacao_faturanova LIKE ? OR " +
                    "Rua_faturanova LIKE ? OR " +
                    "Numero_faturanova LIKE ? OR " +
                    "Tipos_faturanova LIKE ? OR " +
                    "CargaLevantada_faturanova LIKE ? OR " +
                    "MedidorInstalacao_faturanova LIKE ? OR " +
                    "Bairro_faturanova LIKE ? )"; // Adiciona a condição para a pesquisa geral em várias colunas
                   
        } 
            
        pstm = conn.prepareStatement(sql); // Prepara a declaração SQL com as condições adicionadas 
        int index = 1; // Índice dos placeholders
        /*Um placeholder é um marcador ou espaço reservado em uma consulta SQL que é usado
        para representar um valor que será fornecido posteriormente. 
        Esses marcadores são substituídos pelos valores reais quando 
        a consulta é executada, o que permite a criação de consultas dinâmicas e parametrizadas.*/
        //ou seja, ele pega o valor do placeholder, amarzana em uma variavel, e depois me retorna o valor pesquisado dentro dessa viaravel
        
        
        if (!inst.isEmpty()) {
            pstm.setString(index++,"%"+ inst +"%"); // Adiciona o valor do mês ao placeholder
        }
        
        if (!Tipos.isEmpty()) {
            pstm.setString(index++, "%"+ Tipos + "%"); // Adiciona o valor do ano ao placeholder
        }
        
        if (!rua.isEmpty()) {
            pstm.setString(index++, "%"+ rua + "%"); // Adiciona o valor do ano ao placeholder
        }
        
        if (!CargaLev.isEmpty()) {
            pstm.setString(index++, "%"+ CargaLev + "%"); // Adiciona o valor do ano ao placeholder
        }
        if (!Medidor.isEmpty()) {
            pstm.setString(index++, "%"+ Medidor + "%"); // Adiciona o valor do ano ao placeholder
        }
        if (!Numero.isEmpty()) {
            pstm.setString(index++, "%"+ Numero + "%"); // Adiciona o valor do ano ao placeholder
        }
        if (!Bairro.isEmpty()) {
            pstm.setString(index++, "%"+ Bairro + "%"); // Adiciona o valor do ano ao placeholder
        }
        
        if (!PesqGeral.isEmpty()) {
            for (int i = 1; i <= 8; i++) {
                pstm.setString(index++, "%" + PesqGeral + "%"); // Adiciona o valor de pesquisa geral aos placeholders
            }
        }
              
                
                rs = pstm.executeQuery();
                
                while(rs.next()){
                    ConsultarFaturasGipDTO objconsultarfaturasgipdto = new ConsultarFaturasGipDTO();
                    
                    objconsultarfaturasgipdto.setCodigoBarras_faturanova(rs.getString("CodigoBarras_faturanova"));
                    objconsultarfaturasgipdto.setInstalacao_faturanova(rs.getString("Instalacao_faturanova"));
                    objconsultarfaturasgipdto.setCargaLevantada_faturanova(rs.getString("CargaLevantada_faturanova"));
                    objconsultarfaturasgipdto.setMedidorInstalacao_faturanova(rs.getString("MedidorInstalacao_faturanova"));
                    objconsultarfaturasgipdto.setRua_faturanova(rs.getString("Rua_faturanova"));
                    objconsultarfaturasgipdto.setNumero_faturanova(rs.getString("Numero_faturanova"));
                    objconsultarfaturasgipdto.setBairro_faturanova(rs.getString("Bairro_faturanova"));
                    objconsultarfaturasgipdto.setTipos_faturanova(rs.getString("Tipos_faturanova"));
                    
                    
                    lista.add(objconsultarfaturasgipdto);
                }
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Falha ao consultar" + erro);
            } finally{
                //esse finally serve para finalizar a pesquisa total 
            }
        return lista;
    }
      public void exportarParaPlanilha(List<ConsultarFaturasGipDTO> listar, String filePath) {
    
        try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
        headerRow.createCell(0).setCellValue("Cod. Barras");
        headerRow.createCell(1).setCellValue("Instalação");
        headerRow.createCell(2).setCellValue("Carga Levantada");
        headerRow.createCell(3).setCellValue("Medidor Inst.");
        headerRow.createCell(4).setCellValue("Rua");
        headerRow.createCell(5).setCellValue("Número");
        headerRow.createCell(6).setCellValue("Bairro");
        headerRow.createCell(7).setCellValue("Tipos");

        // Preenche os dados na planilha a partir da lista de DTOs
        for (ConsultarFaturasGipDTO dto : listar) {
            Row dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(dto.getCodigoBarras_faturanova());
            dataRow.createCell(1).setCellValue(dto.getInstalacao_faturanova());
            dataRow.createCell(2).setCellValue(dto.getCargaLevantada_faturanova());
            dataRow.createCell(3).setCellValue(dto.getMedidorInstalacao_faturanova());
            dataRow.createCell(4).setCellValue(dto.getRua_faturanova());
            dataRow.createCell(5).setCellValue(dto.getNumero_faturanova());
            dataRow.createCell(6).setCellValue(dto.getBairro_faturanova());
            dataRow.createCell(7).setCellValue(dto.getTipos_faturanova());
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
/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE lEITE JANUÁRIO
*/ 

package DAO;

import DTO.ConsultarConsumoGipDTO;
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
//import necessario para a realização de uma função/retorno especifico 

public class ConsultarConsumoGipDAO {
    
    Connection conn; //define conn Connection
    PreparedStatement pstm; //define pstm como preparedstatement
    ResultSet rs; //define rs como ResultSet
    
    List<ConsultarConsumoGipDTO> lista = new ArrayList<>();
    
    public List<ConsultarConsumoGipDTO> consultarConsumo(String instalacao, String Mesref, String MesVenc, String AnoRef, String Valor, String Data, String Kw, String Tipos,String Atrasadas, String PesqGeral, String Filtroinstalacao, String FiltroMesRef, String FiltroMesVenc, String FiltroAnoRef, String FiltroValor, String FiltroData, String FiltroKw, String FiltroTipos, String FiltroAtrasadas) {
        //declaração de Strings de pesquisa
        conn = new ConexaoGipDAO().conectaBD();//realiza conexao
        
        try {
            String sql = " SELECT * FROM cadastroConsumoFatura " +
                    " INNER JOIN faturanova on CodBarrasRed_cadastroConsumoFatura = CodBarrasRed_faturanova AND Tipos_faturanova = Tipos_faturanova";
              //codigo de conversação com o banco de dados na linguagem do banco de dados       
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
            
        if (!instalacao.isEmpty()) {
            sql += " AND Instalacao_faturanova LIKE ? "; // Adicione a condição para a instalação
        }
        
        if (!Mesref.isEmpty()) {
            sql += " AND MesReferente_cadastroConsumoFatura LIKE ? ";
        }
        
        if (!MesVenc.isEmpty()) {
            sql += " AND MesVencimento_cadastroConsumoFatura LIKE ? ";
        }
            
        if (!AnoRef.isEmpty()) {
            sql += " AND Ano_cadastroConsumoFatura LIKE ? ";
        }
          
        if (!Valor.isEmpty()) {
            sql += " AND Valor_cadastroConsumoFatura LIKE ? "; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!Data.isEmpty()) {
            sql += " AND DataCadastro_cadastroConsumoFatura LIKE ? "; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!Kw.isEmpty()) {
            sql += " AND Kw_cadastroConsumoFatura LIKE ? "; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!Tipos.isEmpty()) {
            sql += " AND Tipos_faturanova LIKE ? "; // Adiciona a condição para o CodBarrasRed de referência
        }
        if (!Atrasadas.isEmpty()) {
            sql += " AND Atrasadas_cadastroConsumoFatura LIKE ? "; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        if (!Filtroinstalacao.isEmpty()) {
                sql += " AND Instalacao_faturanova LIKE ? "; // Adicione a condição de referência
            }
        
        if (!FiltroMesRef.isEmpty()) {
            sql += " AND MesReferente_cadastroConsumoFatura LIKE ? "; // Adiciona a condição de referência
        }
        
        if (!FiltroMesVenc.isEmpty()) {
            sql += " AND MesVencimento_cadastroConsumoFatura LIKE ? "; // Adiciona a condição de referência
        }
        
        if (!FiltroAnoRef.isEmpty()) {
            sql += " AND Ano_cadastroConsumoFatura LIKE ? "; // Adiciona a condição de referência
        }
        
        if (!FiltroValor.isEmpty()) {
            sql += " AND Valor_cadastroConsumoFatura LIKE ? "; // Adiciona a condição de referência
        }
        
        if (!FiltroData.isEmpty()) {
            sql += " AND DataCadastro_cadastroConsumoFatura LIKE ? "; // Adiciona a condição de referência
        }
        
        if (!FiltroKw.isEmpty()) {
            sql += " AND Kw_cadastroConsumoFatura LIKE ? "; // Adiciona a condição de referência
        }
        
        if (!FiltroTipos.isEmpty()) {
            sql += " AND Tipos_faturanova LIKE ? "; // Adiciona a condição de referência
        }
        if (!FiltroAtrasadas.isEmpty()) {
            sql += " AND Atrasadas_cadastroConsumoFatura LIKE ? "; // Adiciona a condição de referência
        }
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        if (!PesqGeral.isEmpty()) {
            sql +=  " AND (Instalacao_faturanova LIKE ? OR " +
                    " Tipos_faturanova LIKE ? OR " +
                    " CodigoBarrasCon_cadastroConsumoFatura LIKE ? OR " +
                    " Valor_cadastroConsumoFatura LIKE ? OR " +
                    " Kw_cadastroConsumoFatura LIKE ? OR " +
                    " MesReferente_cadastroConsumoFatura LIKE ? OR " +
                    " MesVencimento_cadastroConsumoFatura LIKE ? OR " +
                    " Ano_cadastroConsumoFatura LIKE ? OR " +
                    " CodBarrasRed_cadastroConsumoFatura LIKE ? OR " + 
                    " Atrasadas_cadastroConsumoFatura LIKE ? OR " +
                    " DataCadastro_cadastroConsumoFatura LIKE ? ) " ;  // Adiciona a condição para a pesquisa geral em várias colunas
                   
        } 
                   pstm = conn.prepareStatement(sql); // Prepara a declaração SQL com as condições adicionadas 
                   
                    int index = 1; // Índice dos placeholders
                    
        /*Um placeholder é um marcador ou espaço reservado em uma consulta SQL que é usado
        para representar um valor que será fornecido posteriormente. 
        Esses marcadores são substituídos pelos valores reais quando 
        a consulta é executada, o que permite a criação de consultas dinâmicas e parametrizadas.*/
        
        //ou seja, ele pega o valor do placeholder, amarzana em uma variavel, e depois me retorna o valor pesquisado dentro dessa viaravel
        
         ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        if (!instalacao.isEmpty()) {
        pstm.setString(index++, "%" + instalacao + "%");
        }
        
        if (!Mesref.isEmpty()) {
            pstm.setString(index++, "%" + Mesref + "%"); // Adiciona o valor 
        }
        
        if (!MesVenc.isEmpty()) {
            pstm.setString(index++, "%" + MesVenc + "%"); // Adiciona o valor 
        }
        
        if (!AnoRef.isEmpty()) {
            pstm.setString(index++, "%" + AnoRef + "%"); // Adiciona o valor 
        }
        
        
        if (!Valor.isEmpty()) {
            pstm.setString(index++, "%" + Valor + "%" ); // Adiciona o valor
        }
        
        if (!Data.isEmpty()) {
            pstm.setString(index++, "%" + Data +"%"); // Adiciona o valor 
        }
        
        if (!Kw.isEmpty()) {
            pstm.setString(index++, "%" + Kw +"%"); // Adiciona o valor
        }
        
        if (!Tipos.isEmpty()) {
            pstm.setString(index++, "%" + Tipos +"%"); // Adiciona o valor 
        }
        if (!Atrasadas.isEmpty()) {
            pstm.setString(index++, "%" + Atrasadas +"%"); // Adiciona o valor 
        }
        
        if (!PesqGeral.isEmpty()) {
            for (int i = 1; i <= 11; i++) {
                pstm.setString(index++,"%"+ PesqGeral +"%"); // Adiciona o valor 
            }
        }
        
         ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        if (!Filtroinstalacao.isEmpty()) {
        sql += " AND Instalacao_faturanova = ? ";
        pstm.setString(index++, instalacao); 
        }
        
        if (!FiltroMesRef.isEmpty()) {
        sql += " AND MesReferente_cadastroConsumoFatura = ? ";
        pstm.setString(index++, FiltroMesRef); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        if (!FiltroMesVenc.isEmpty()) {
        sql += " AND MesVencimento_cadastroConsumoFatura = ? ";
        pstm.setString(index++, FiltroMesVenc); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
         
        if (!FiltroAnoRef.isEmpty()) {
        sql += " AND Ano_cadastroConsumoFatura = ? ";
        pstm.setString(index++, FiltroAnoRef); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        if (!FiltroValor.isEmpty()) {
        sql += " AND Valor_cadastroConsumoFatura = ? ";
        pstm.setString(index++, FiltroValor); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        if (!FiltroData.isEmpty()) {
        sql += " AND DataCadastro_cadastroConsumoFatura = ? ";
        pstm.setString(index++, FiltroData); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        if (!FiltroKw.isEmpty()) {
        sql += " AND Kw_cadastroConsumoFatura = ? ";
        pstm.setString(index++, FiltroKw); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        if (!FiltroTipos.isEmpty()) {
        sql += " AND Tipos_faturanova = ? ";
        pstm.setString(index++, FiltroTipos); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        if (!FiltroAtrasadas.isEmpty()) {
        sql += " AND Atrasadas_cadastroConsumoFatura = ? ";
        pstm.setString(index++, FiltroAtrasadas); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        
        
      
                    rs = pstm.executeQuery();
        
                
         ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
            
         while(rs.next()){
             
             ConsultarConsumoGipDTO objconsultarConsumoGipDTO = new ConsultarConsumoGipDTO();
             
             objconsultarConsumoGipDTO.setInstalacao_faturanova(rs.getString("Instalacao_faturanova"));
             objconsultarConsumoGipDTO.setCodigoBarrasCon_cadastroConsumoFatura(rs.getString("CodigoBarrasCon_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setValor_cadastroConsumoFatura(rs.getString("Valor_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setKw_cadastroConsumoFatura(rs.getString("Kw_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setMesVencimento_cadastroConsumoFatura(rs.getString("MesVencimento_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setMesReferente_cadastroConsumoFatura(rs.getString("MesReferente_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setDataCadastro_cadastroConsumoFatura(rs.getString("DataCadastro_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setAno_cadastroConsumoFatura(rs.getString("Ano_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setCodBarrasRed_cadastroConsumoFatura(rs.getString("CodBarrasRed_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setTipos_faturanova(rs.getString("Tipos_faturanova"));
             objconsultarConsumoGipDTO.setAtrasadas_cadastroConsumoFatura(rs.getString("Atrasadas_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setObservacao(rs.getString("Observacao"));
             
             
             lista.add(objconsultarConsumoGipDTO);
             
         }           
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Falha ao consultar" + erro);
        
        } finally{
            //serve para não dar erro na pesquisa.
        }
        return lista;
    }
    
    public void exportarParaPlanilha(List<ConsultarConsumoGipDTO> listar, String filePath) {
    
        try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
        
        headerRow.createCell(0).setCellValue("instalacao");
        headerRow.createCell(1).setCellValue("Cod. Barras");
        headerRow.createCell(2).setCellValue("Valor");
        headerRow.createCell(3).setCellValue("KW");
        headerRow.createCell(4).setCellValue("Mês Venc.");
        headerRow.createCell(5).setCellValue("Mês Ref.");
        headerRow.createCell(6).setCellValue("Data Cadastro");
        headerRow.createCell(7).setCellValue("Ano");
        headerRow.createCell(8).setCellValue("Cod.Barras Reduzido");
        headerRow.createCell(9).setCellValue("Tipos");
        headerRow.createCell(10).setCellValue("Atrasadas");
        headerRow.createCell(11).setCellValue("Observacao");

        // Preenche os dados na planilha a partir da lista de DTOs
        for (ConsultarConsumoGipDTO dto : listar) {
            Row dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(dto.getInstalacao_faturanova());
            dataRow.createCell(1).setCellValue(dto.getCodigoBarrasCon_cadastroConsumoFatura());
            dataRow.createCell(2).setCellValue(dto.getValor_cadastroConsumoFatura());
            dataRow.createCell(3).setCellValue(dto.getKw_cadastroConsumoFatura());
            dataRow.createCell(4).setCellValue(dto.getMesVencimento_cadastroConsumoFatura());
            dataRow.createCell(5).setCellValue(dto.getMesReferente_cadastroConsumoFatura());
            dataRow.createCell(6).setCellValue(dto.getDataCadastro_cadastroConsumoFatura());
            dataRow.createCell(7).setCellValue(dto.getAno_cadastroConsumoFatura());
            dataRow.createCell(8).setCellValue(dto.getCodBarrasRed_cadastroConsumoFatura());
            dataRow.createCell(9).setCellValue(dto.getTipos_faturanova());
            dataRow.createCell(10).setCellValue(dto.getAtrasadas_cadastroConsumoFatura());
            dataRow.createCell(11).setCellValue(dto.getObservacao());
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





/*package DAO;

import DTO.ConsultarConsumoGipDTO;
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

public class ConsultarConsumoGipDAO {
    
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    List<ConsultarConsumoGipDTO> lista = new ArrayList<>();
    
    public List<ConsultarConsumoGipDTO> consultarConsumo(String Mesref, String AnoRef, String BarrasRed, String Valor, String Data, String CodBarras, String Kw, String PesqGeral, String FiltroMesRef, String FiltroAnoRef, String FiltroValor, String FiltroData, String FiltroKw) {
        
        conn = new ConexaoGipDAO().conectaBD();
        
        try {
        String sql = "SELECT * FROM cadastroConsumoFatura WHERE 1=1"; // Inicia a construção da consulta do SQL
        
        
        if (!Mesref.isEmpty()) {
            sql += " AND MesReferente_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o mês de referência
        }
        
        if (!AnoRef.isEmpty()) {
            sql += " AND Ano_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o ano de referência
        }
        
        if (!BarrasRed.isEmpty()) {
            sql += " AND CodBarrasRed_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!Valor.isEmpty()) {
            sql += " AND Valor_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!Data.isEmpty()) {
            sql += " AND DataCadastro_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!CodBarras.isEmpty()) {
            sql += " AND CodigoBarrasCon_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!Kw.isEmpty()) {
            sql += " AND Kw_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!FiltroMesRef.isEmpty()) {
            sql += " AND MesReferente_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!FiltroAnoRef.isEmpty()) {
            sql += " AND Ano_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!FiltroValor.isEmpty()) {
            sql += " AND Valor_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!FiltroData.isEmpty()) {
            sql += " AND DataCadastro_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!FiltroKw.isEmpty()) {
            sql += " AND Kw_cadastroConsumoFatura LIKE ?"; // Adiciona a condição para o CodBarrasRed de referência
        }
        
        if (!PesqGeral.isEmpty()) {
            sql += " AND (CodigoBarrasCon_cadastroConsumoFatura LIKE ? OR " +
                    " Valor_cadastroConsumoFatura LIKE ? OR " +
                    " Kw_cadastroConsumoFatura LIKE ? OR " +
                    " MesReferente_cadastroConsumoFatura LIKE ? OR " +
                    " Ano_cadastroConsumoFatura LIKE ? OR " +
                    " CodBarrasRed_cadastroConsumoFatura LIKE ? OR " +
                    " MesVencimento_cadastroConsumoFatura LIKE ? OR " +
                    " DataCadastro_cadastroConsumoFatura LIKE ? )";  // Adiciona a condição para a pesquisa geral em várias colunas
                   
        } 
                   pstm = conn.prepareStatement(sql); // Prepara a declaração SQL com as condições adicionadas 
                   
                    int index = 1; // Índice dos placeholders
        /*Um placeholder é um marcador ou espaço reservado em uma consulta SQL que é usado
        para representar um valor que será fornecido posteriormente. 
        Esses marcadores são substituídos pelos valores reais quando 
        a consulta é executada, o que permite a criação de consultas dinâmicas e parametrizadas.*/
        //ou seja, ele pega o valor do placeholder, amarzana em uma variavel, e depois me retorna o valor pesquisado dentro dessa viaravel
        
        
        /*if (!Mesref.isEmpty()) {
            pstm.setString(index++,"%"+ Mesref +"%"); // Adiciona o valor do mês ao placeholder
        }
        if (!AnoRef.isEmpty()) {
            pstm.setString(index++,"%"+AnoRef+"%"); // Adiciona o valor do mês ao placeholder
        }
        
        if (!BarrasRed.isEmpty()) {
            pstm.setString(index++,"%"+ BarrasRed +"%"); // Adiciona o valor do ano ao placeholder
        }
        
        if (!Valor.isEmpty()) {
            pstm.setString(index++,"%"+ Valor +"%"); // Adiciona o valor do ano ao placeholder
        }
        
        if (!Data.isEmpty()) {
            pstm.setString(index++,"%"+ Data +"%"); // Adiciona o valor do ano ao placeholder
        }
        
        if (!CodBarras.isEmpty()) {
            pstm.setString(index++,"%"+ CodBarras +"%"); // Adiciona o valor do ano ao placeholder
        }
        
        if (!Kw.isEmpty()) {
            pstm.setString(index++,"%"+ Kw +"%"); // Adiciona o valor do ano ao placeholder
        }
        
        if (!PesqGeral.isEmpty()) {
            for (int i = 1; i <= 8; i++) {
                pstm.setString(index++,"%"+ PesqGeral +"%"); // Adiciona o valor de pesquisa geral aos placeholders
            }
        }
         
        if (!FiltroMesRef.isEmpty()) {
        sql += " AND MesReferente_cadastroConsumoFatura = ?";
        pstm.setString(index++, FiltroMesRef); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
         
        if (!FiltroAnoRef.isEmpty()) {
        sql += " AND Ano_cadastroConsumoFatura = ?";
        pstm.setString(index++, FiltroAnoRef); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        if (!FiltroValor.isEmpty()) {
        sql += " AND Valor_cadastroConsumoFatura = ?";
        pstm.setString(index++, FiltroValor); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        if (!FiltroData.isEmpty()) {
        sql += " AND DataCadastro_cadastroConsumoFatura = ?";
        pstm.setString(index++, FiltroData); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        if (!FiltroKw.isEmpty()) {
        sql += " AND Kw_cadastroConsumoFatura = ?";
        pstm.setString(index++, FiltroKw); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        
        
      
                    rs = pstm.executeQuery();
            
         while(rs.next()){
             
             ConsultarConsumoGipDTO objconsultarConsumoGipDTO = new ConsultarConsumoGipDTO();
             
             objconsultarConsumoGipDTO.setCodigoBarrasCon_cadastroConsumoFatura(rs.getString("CodigoBarrasCon_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setValor_cadastroConsumoFatura(rs.getString("Valor_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setKw_cadastroConsumoFatura(rs.getString("Kw_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setMesVencimento_cadastroConsumoFatura(rs.getString("MesVencimento_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setMesReferente_cadastroConsumoFatura(rs.getString("MesReferente_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setDataCadastro_cadastroConsumoFatura(rs.getString("DataCadastro_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setAno_cadastroConsumoFatura(rs.getString("Ano_cadastroConsumoFatura"));
             objconsultarConsumoGipDTO.setCodBarrasRed_cadastroConsumoFatura(rs.getString("CodBarrasRed_cadastroConsumoFatura"));
             
             
             lista.add(objconsultarConsumoGipDTO);
             
         }           
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Falha ao consultar" + erro);
        } finally{
            //serve para não dar erro na pesquisa.
        }
        return lista;
    }
    public void exportarParaPlanilha(List<ConsultarConsumoGipDTO> listar, String filePath) {
    
        try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
        headerRow.createCell(0).setCellValue("Cod. Barras");
        headerRow.createCell(1).setCellValue("Valor");
        headerRow.createCell(2).setCellValue("KW");
        headerRow.createCell(3).setCellValue("Mês Venc.");
        headerRow.createCell(4).setCellValue("Mês Ref.");
        headerRow.createCell(5).setCellValue("Data Cadastro");
        headerRow.createCell(6).setCellValue("Ano");
        headerRow.createCell(7).setCellValue("Cod.Barras Reduzido");

        // Preenche os dados na planilha a partir da lista de DTOs
        for (ConsultarConsumoGipDTO dto : listar) {
            Row dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(dto.getCodigoBarrasCon_cadastroConsumoFatura());
            dataRow.createCell(1).setCellValue(dto.getValor_cadastroConsumoFatura());
            dataRow.createCell(2).setCellValue(dto.getKw_cadastroConsumoFatura());
            dataRow.createCell(3).setCellValue(dto.getMesVencimento_cadastroConsumoFatura());
            dataRow.createCell(4).setCellValue(dto.getMesReferente_cadastroConsumoFatura());
            dataRow.createCell(5).setCellValue(dto.getDataCadastro_cadastroConsumoFatura());
            dataRow.createCell(6).setCellValue(dto.getAno_cadastroConsumoFatura());
            dataRow.createCell(7).setCellValue(dto.getCodBarrasRed_cadastroConsumoFatura());
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
}*/
/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE lEITE JANUÁRIO
*/ 
package DAO;

import DTO.ConsultarBandeirasGipDTO;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import necessario para a realização de uma função/retorno especifico 

public class ConsultarBandeirasGipDAO {
     
    
    Connection conn;  //define conn Connection
    PreparedStatement pstm;   //define pstm como preparedstatement
    ResultSet rs; //define rs como ResultSet
    
    List<ConsultarBandeirasGipDTO> lista = new ArrayList<>();
    
    
        public List<ConsultarBandeirasGipDTO> consultarBandeiras(String MesRef, String AnoRef, String Valor, String Cor, String PesqGeral, String FiltroAno, String FiltroCor){ // Cria uma lista para armazenar os resultados
       
            
            conn = new ConexaoGipDAO().conectaBD(); //puxa a conexão com o Banco
            
            try {
        String sql = "SELECT * FROM bandeiras WHERE 1=1"; // Inicia a construção da consulta do SQL

        
        if (!MesRef.isEmpty()) {
            sql += " AND MesReferente_bandeiras LIKE ?"; // Adiciona a condição para o mês de referência
        }
        
        if (!AnoRef.isEmpty()) {
            sql += " AND Ano_bandeiras LIKE ?"; // Adiciona a condição para o ano de referência
        }
        
        if (!Valor.isEmpty()) {
            sql += " AND Valor_bandeiras LIKE ?"; // Adiciona a condição para o ano de referência
        }
        
        if (!Cor.isEmpty()) {
            sql += " AND CorBandeiras_bandeiras LIKE ?"; // Adiciona a condição para o ano de referência
        }
        
        if (!FiltroAno.isEmpty()) {
        sql += " AND Ano_bandeiras = ?";  // adiociona a condição para pesquisa com filtro 
        }
        
        if (!FiltroCor.isEmpty()) {
        sql += " AND CorBandeiras_bandeiras = ?";  // adiociona a condição para pesquisa com filtro 
        }
       
        if (!PesqGeral.isEmpty()) {
            sql += " AND (CorBandeiras_bandeiras LIKE ? OR " +
                    " Valor_bandeiras LIKE ? OR " +
                    " MesReferente_bandeiras LIKE ? OR " +
                   " Ano_bandeiras LIKE ? ) "; // Adiciona a condição para a pesquisa geral em várias colunas
                   
        } 
            
        pstm = conn.prepareStatement(sql); // Prepara a declaração SQL com as condições adicionadas 
        int index = 1; // Índice dos placeholders
        /*Um placeholder é um marcador ou espaço reservado em uma consulta SQL que é usado
        para representar um valor que será fornecido posteriormente. 
        Esses marcadores são substituídos pelos valores reais quando 
        a consulta é executada, o que permite a criação de consultas dinâmicas e parametrizadas.*/
        //ou seja, ele pega o valor do placeholder, amarzana em uma variavel, e depois me retorna o valor pesquisado dentro dessa viaravel
        
        
        if (!MesRef.isEmpty()) {
            pstm.setString(index++,"%"+ MesRef +"%"); // Adiciona o valor do mês ao placeholder
        }
        
        if (!AnoRef.isEmpty()) {
            pstm.setString(index++, "%"+ AnoRef + "%"); // Adiciona o valor do ano ao placeholder
        }
        
        if (!Valor.isEmpty()) {
            pstm.setString(index++, "%"+ Valor + "%"); // Adiciona o valor do ano ao placeholder
        }
        
        if (!Cor.isEmpty()) {
            pstm.setString(index++, "%"+ Cor + "%"); // Adiciona o valor do ano ao placeholder
        }
       
        if (!PesqGeral.isEmpty()) {
            for (int i = 1; i <= 4; i++) {
                pstm.setString(index++, "%" + PesqGeral + "%"); // Adiciona o valor de pesquisa geral aos placeholders
            }
        }
        
        if (!FiltroAno.isEmpty()) {
        sql += " AND Ano_bandeiras = ?";
        pstm.setString(index++, FiltroAno); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        
        if (!FiltroCor.isEmpty()) {
        sql += " AND CorBandeiras_bandeiras = ?";
        pstm.setString(index++, FiltroCor); //não tem a %, por isso ele é preciso na hora do filtro em relação a exportação 
        }
        
      
                rs = pstm.executeQuery();
                
                
                while(rs.next()){
                    ConsultarBandeirasGipDTO objconsultarbandeirasgipdto = new ConsultarBandeirasGipDTO(); //faz um novo objeto DTO  p armazenar os resultados 
                    
                    objconsultarbandeirasgipdto.setCorBandeiras_bandeiras(rs.getString("CorBandeiras_bandeiras")); // Define o valor da coluna no DTO
                    
                    objconsultarbandeirasgipdto.setValor1_bandeiras(rs.getString("Valor1_bandeiras"));
                    
                    objconsultarbandeirasgipdto.setMesReferente_bandeiras(rs.getString("MesReferente_bandeiras"));
                    
                    objconsultarbandeirasgipdto.setAno_bandeiras(rs.getString("Ano_bandeiras"));
                    
                    
                    
                    lista.add(objconsultarbandeirasgipdto); //adiciona o DTO na lista 
                }
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Falha ao consultar" + erro);
            } finally{
                //serve p finalizar a conexão( com os statements e results sets)
            }
        return lista; //retorna a lista 
        }
        
    public void exportarParaPlanilha(List<ConsultarBandeirasGipDTO> listar, String filePath) {
    
        try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
        headerRow.createCell(0).setCellValue("Cor");
        headerRow.createCell(1).setCellValue("Valor");
        headerRow.createCell(2).setCellValue("Mês Referente");
        headerRow.createCell(3).setCellValue("Ano");

        // Preenche os dados na planilha a partir da lista de DTOs
        for (ConsultarBandeirasGipDTO dto : listar) {
            Row dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(dto.getCorBandeiras_bandeiras());
            dataRow.createCell(1).setCellValue(dto.getValor1_bandeiras());
            dataRow.createCell(2).setCellValue(dto.getMesReferente_bandeiras());
            dataRow.createCell(3).setCellValue(dto.getAno_bandeiras());
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
/*try{
               
                String sql = "SELECT * FROM bandeiras WHERE " +  //aqui ele fala pra pegar da tabela( nome da tabela). Onde(where)...
                        "CorBandeiras_bandeiras LIKE ? OR " + // onde tiver um campo com esse nome da tabela, ou(or)..
                        "Valor_bandeiras LIKE ? OR " + // onde tiver um campo com esse nome da tabela, ou(or)..
                         // onde tiver um campo com esse nome da tabela, ou(or)..
                        "MesReferente_bandeiras LIKE ? OR " + // onde tiver um campo com esse nome da tabela, ou(or).. 
                        "Ano_bandeiras LIKE ? "; //like serve para pesquisar tudo que tem no campo da tabela que eu digitei
                        
                 
                pstm = conn.prepareStatement(sql);
                
                 for (int i = 1; i <= 3; i++) {
        pstm.setString(i, "%" +filtro01+ "%" );
    }
                 
                 for (int i = 4; i <= 4 ; i++) {
        pstm.setString(i, "%" +AnoRef+ "%" );
    }*/
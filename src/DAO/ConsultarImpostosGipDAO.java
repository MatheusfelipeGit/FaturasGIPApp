package DAO;

import DTO.ConsultarImpostosGipDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import necessario para a realização de uma função/retorno especifico 

public class ConsultarImpostosGipDAO {

    Connection conn;  //define conn Connection
    PreparedStatement pstm;   //define pstm como preparedstatement
    ResultSet rs; //define rs como ResultSet
    
    List<ConsultarImpostosGipDTO> lista = new ArrayList<>();

    public List<ConsultarImpostosGipDTO> consultarImpostos(String filtrarmes, String filtrarAno, String PesGeral) {
        //declaração de Strings de pesquisa
        conn = new ConexaoGipDAO().conectaBD();//realiza a conexao

        try {
            String sql = "SELECT * FROM impostos WHERE 1=1"; // Inicia a construção da consulta do SQL

            if (!filtrarmes.isEmpty()) {
                sql += " AND MesReferente_impostos LIKE ?"; // Adiciona a condição para o mês de referência
            }

            if (!filtrarAno.isEmpty()) {
                sql += " AND Ano_impostos LIKE ?"; // Adiciona a condição para o ano de referência
            }

            if (!PesGeral.isEmpty()) {
                sql += " AND (Im_TUSD_impostos_IP LIKE ? OR "
                        + "Im_TE_impostos_IP LIKE ? OR "
                        + "Resultado_impostos_Ip LIKE ? OR "
                        + "Im_TUSD_impostos_PP LIKE ? OR " 
                        + "Im_TE_impostos_PP LIKE ? OR "
                        + "Resultado_impostos_PP LIKE ? OR "
                        + "Pis_impostos LIKE ? OR "
                        + "Cofins_impostos LIKE ? OR "
                        + "Ajuste_impostos LIKE ? )"; // Adiciona a condição para a pesquisa geral em várias colunas

            }

            pstm = conn.prepareStatement(sql); // Prepara a declaração SQL com as condições adicionadas 
        int index = 1; // Índice dos placeholders
        /*Um placeholder é um marcador ou espaço reservado em uma consulta SQL que é usado
        para representar um valor que será fornecido posteriormente. 
        Esses marcadores são substituídos pelos valores reais quando 
        a consulta é executada, o que permite a criação de consultas dinâmicas e parametrizadas.*/
        //ou seja, ele pega o valor do placeholder, amarzana em uma variavel, e depois me retorna o valor pesquisado dentro dessa viaravel
        
        
        if (!filtrarmes.isEmpty()) {
            pstm.setString(index++,"%"+ filtrarmes +"%"); // Adiciona o valor do mês ao placeholder
        }
        
        if (!filtrarAno.isEmpty()) {
            pstm.setString(index++, filtrarAno); // Adiciona o valor do ano ao placeholder
        }
        
        if (!PesGeral.isEmpty()) {
            for (int i = 1; i <= 6; i++) {
                pstm.setString(index++, "%" + PesGeral + "%"); // Adiciona o valor de pesquisa geral aos placeholders
            }
        }

            rs = pstm.executeQuery();

            while (rs.next()) {
                ConsultarImpostosGipDTO objconsultarimpostosgipdto = new ConsultarImpostosGipDTO();

                objconsultarimpostosgipdto.setIm_TUSD_impostos_IP(rs.getString("Im_TUSD_impostos_IP"));
                objconsultarimpostosgipdto.setIm_TE_impostos_IP(rs.getString("Im_TE_impostos_IP"));
                objconsultarimpostosgipdto.setResultado_impostos_Ip(rs.getString("Resultado_impostos_Ip"));
                objconsultarimpostosgipdto.setIm_TUSD_impostos_PP(rs.getString("Im_TUSD_impostos_PP"));
                objconsultarimpostosgipdto.setIm_TE_impostos_PP(rs.getString("Im_TE_impostos_PP"));
                objconsultarimpostosgipdto.setResultado_impostos_PP(rs.getString("Resultado_impostos_PP"));
                objconsultarimpostosgipdto.setPis_impostos(rs.getString("Pis_impostos"));
                objconsultarimpostosgipdto.setCofins_impostos(rs.getString("Cofins_impostos"));
                objconsultarimpostosgipdto.setAjuste_impostos(rs.getString("Ajuste_impostos"));
                objconsultarimpostosgipdto.setMesReferente_impostos(rs.getString("MesReferente_impostos"));
                objconsultarimpostosgipdto.setAno_impostos(rs.getString("Ano_impostos"));

                lista.add(objconsultarimpostosgipdto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar" + erro);
        }
        return lista;
    }
}
/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE lEITE JANUÁRIO
 */

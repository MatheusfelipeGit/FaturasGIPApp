
    
package DAO;

import DTO.EdicaoConsumoGipDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
//import necessario para a realização de uma função/retorno especifico

public class EdicaoConsumoGipDAO {

    Connection conn; //define conn Connection
    PreparedStatement pstm; //define pstm como preparedstatement
    ResultSet rs; //define rs como ResultSet
    
    List<EdicaoConsumoGipDTO> lista = new ArrayList<>();

    public List<EdicaoConsumoGipDTO> EdicaoFatura(String inst,String MesRef,String Ano) {
        //declaração de Strings de pesquisa
        conn = new ConexaoGipDAO().conectaBD();

        try {
            //função de busca por instalacao
            String sql = "SELECT * FROM cadastroConsumoFatura " +
             "INNER JOIN faturanova ON cadastroConsumoFatura.CodBarrasRed_cadastroConsumoFatura = faturanova.CodBarrasRed_faturanova " +
             "WHERE faturanova.Instalacao_faturanova = ? " +
             "AND cadastroConsumoFatura.MesReferente_cadastroConsumoFatura = ? " +
             "AND cadastroConsumoFatura.Ano_cadastroConsumoFatura = ?";
             // Inicia a construção da consulta do SQL
             
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, inst);
            pstm.setString(2, MesRef);
            pstm.setString(3, Ano);

            /*Um placeholder é um marcador ou espaço reservado em uma consulta SQL que é usado
        para representar um valor que será fornecido posteriormente. 
        Esses marcadores são substituídos pelos valores reais quando 
        a consulta é executada, o que permite a criação de consultas dinâmicas e parametrizadas.*/
            //ou seja, ele pega o valor do placeholder, amarzana em uma variavel, e depois me retorna o valor pesquisado dentro dessa viaravel
            rs = pstm.executeQuery();

            while (rs.next()) {

                EdicaoConsumoGipDTO objedicaogipdto = new EdicaoConsumoGipDTO();

                objedicaogipdto.setInstalacao_faturanova(rs.getString("Instalacao_faturanova"));
                objedicaogipdto.setCodigoBarrasCon_cadastroConsumoFatura(rs.getString("CodigoBarrasCon_cadastroConsumoFatura"));//
                objedicaogipdto.setValor_cadastroConsumoFatura(rs.getString("Valor_cadastroConsumoFatura"));
                objedicaogipdto.setKw_cadastroConsumoFatura(rs.getString("Kw_cadastroConsumoFatura"));
                objedicaogipdto.setMesVencimento_cadastroConsumoFatura(rs.getString("MesVencimento_cadastroConsumoFatura"));
                objedicaogipdto.setMesReferente_cadastroConsumoFatura(rs.getString("MesReferente_cadastroConsumoFatura"));
                objedicaogipdto.setDataCadastro_cadastroConsumoFatura(rs.getString("DataCadastro_cadastroConsumoFatura"));
                objedicaogipdto.setAno_cadastroConsumoFatura(rs.getString("Ano_cadastroConsumoFatura"));
                objedicaogipdto.setCodBarrasRed_cadastroConsumoFatura(rs.getString("CodBarrasRed_cadastroConsumoFatura"));

                lista.add(objedicaogipdto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar" + erro);
        } finally {
            //esse finally serve para finalizar a pesquisa total 
        }
        return lista;
    }

    public void atualizarCampos(EdicaoConsumoGipDTO edicaoGipDTO) throws SQLException {
        
        conn = new ConexaoGipDAO().conectaBD();

        try {
            String sql = "UPDATE `faturasgip`.`cadastroConsumoFatura` "
                    + "INNER JOIN faturanova ON CodBarrasRed_faturanova = CodBarrasRed_cadastroConsumoFatura "
                    + "SET "
                    + "Instalacao_faturanova = ?, "
                    + "CodigoBarrasCon_cadastroConsumoFatura = ?, "
                    + "Valor_cadastroConsumoFatura = ?, "
                    + "Kw_cadastroConsumoFatura = ?, "
                    + "MesVencimento_cadastroConsumoFatura = ?, "
                    + "MesReferente_cadastroConsumoFatura = ?, "
                    + "DataCadastro_cadastroConsumoFatura = ?, "
                    + "Ano_cadastroConsumoFatura = ?, "
                    + "CodBarrasRed_cadastroConsumoFatura = ? "
                    + "WHERE `Instalacao_faturanova` = ? "
                    + "AND `MesReferente_cadastroConsumoFatura` = ? "
                    + "AND `Ano_cadastroConsumoFatura` = ? ";
              


            pstm = conn.prepareStatement(sql);

            pstm.setString(1, edicaoGipDTO.getInstalacao_faturanova());
            pstm.setString(2, edicaoGipDTO.getCodigoBarrasCon_cadastroConsumoFatura());
            pstm.setString(3, edicaoGipDTO.getValor_cadastroConsumoFatura());
            pstm.setString(4, edicaoGipDTO.getKw_cadastroConsumoFatura());
            pstm.setString(5, edicaoGipDTO.getMesVencimento_cadastroConsumoFatura());
            pstm.setString(6, edicaoGipDTO.getMesReferente_cadastroConsumoFatura());
            pstm.setString(7, edicaoGipDTO.getDataCadastro_cadastroConsumoFatura());
            pstm.setString(8, edicaoGipDTO.getAno_cadastroConsumoFatura());
            pstm.setString(9, edicaoGipDTO.getCodBarrasRed_cadastroConsumoFatura());
            pstm.setString(10,edicaoGipDTO.getInstalacao_faturanova()); // Correção para usar o campo Instalacao_faturanova
            pstm.setString(11,edicaoGipDTO.getMesReferente_cadastroConsumoFatura()); // Correção para usar o campo Instalacao_faturanova
            pstm.setString(12,edicaoGipDTO.getAno_cadastroConsumoFatura()); // Correção para usar o campo Instalacao_faturanova

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Campos atualizados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para a instalação fornecida.");
            }

        } finally {
            // Certifique-se de fechar a conexão e o PreparedStatement no bloco finally
        }
    }
}



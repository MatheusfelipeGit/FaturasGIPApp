
    
package DAO;

import DTO.EdicaoFaturaGipDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class EdicaoFaturaGipDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<EdicaoFaturaGipDTO> lista = new ArrayList<>();

    public List<EdicaoFaturaGipDTO> EdicaoFatura(String inst) {

        conn = new ConexaoGipDAO().conectaBD();

        try {
            //função de busca por instalacao
            String sql = "SELECT * FROM faturanova WHERE Instalacao_faturanova = ?"; // Inicia a construção da consulta do SQL
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, inst);

            /*Um placeholder é um marcador ou espaço reservado em uma consulta SQL que é usado
        para representar um valor que será fornecido posteriormente. 
        Esses marcadores são substituídos pelos valores reais quando 
        a consulta é executada, o que permite a criação de consultas dinâmicas e parametrizadas.*/
            //ou seja, ele pega o valor do placeholder, amarzana em uma variavel, e depois me retorna o valor pesquisado dentro dessa viaravel
            rs = pstm.executeQuery();

            while (rs.next()) {

                EdicaoFaturaGipDTO objedicaogipdto = new EdicaoFaturaGipDTO();

                objedicaogipdto.setCodigoBarras_faturanova(rs.getString("CodigoBarras_faturanova"));
                objedicaogipdto.setInstalacao_faturanova(rs.getString("Instalacao_faturanova"));
                objedicaogipdto.setCargaLevantada_faturanova(rs.getString("CargaLevantada_faturanova"));
                objedicaogipdto.setMedidorInstalacao_faturanova(rs.getString("MedidorInstalacao_faturanova"));
                objedicaogipdto.setRua_faturanova(rs.getString("Rua_faturanova"));
                objedicaogipdto.setNumero_faturanova(rs.getString("Numero_faturanova"));
                objedicaogipdto.setBairro_faturanova(rs.getString("Bairro_faturanova"));
                objedicaogipdto.setTipos_faturanova(rs.getString("Tipos_faturanova"));
                objedicaogipdto.setCodBarrasRed_faturanova(rs.getString("CodBarrasRed_faturanova"));
                objedicaogipdto.setUnidade_faturanova(rs.getString("Unidade_faturanova"));
               /* objedicaogipdto.setCodigoBarrasCon_cadastroConsumoFatura(rs.getString("CodigoBarrasCon_cadastroConsumoFatura"));//
                objedicaogipdto.setValor_cadastroConsumoFatura(rs.getString("Valor_cadastroConsumoFatura"));
                objedicaogipdto.setKw_cadastroConsumoFatura(rs.getString("Kw_cadastroConsumoFatura"));
                objedicaogipdto.setMesVencimento_cadastroConsumoFatura(rs.getString("MesVencimento_cadastroConsumoFatura"));
                objedicaogipdto.setMesReferente_cadastroConsumoFatura(rs.getString("MesReferente_cadastroConsumoFatura"));
                objedicaogipdto.setDataCadastro_cadastroConsumoFatura(rs.getString("DataCadastro_cadastroConsumoFatura"));
                objedicaogipdto.setAno_cadastroConsumoFatura(rs.getString("Ano_cadastroConsumoFatura"));
                objedicaogipdto.setCodBarrasRed_cadastroConsumoFatura(rs.getString("CodBarrasRed_cadastroConsumoFatura"));*/

                lista.add(objedicaogipdto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar" + erro);
        } finally {
            //esse finally serve para finalizar a pesquisa total 
        }
        return lista;
    }

    public void atualizarCampos(EdicaoFaturaGipDTO edicaoGipDTO) throws SQLException {
        
        conn = new ConexaoGipDAO().conectaBD();

        try {
            String sql = "UPDATE `faturasgip`.`faturanova` SET "
                    + "CodigoBarras_faturanova = ?, "
                    + "Instalacao_faturanova = ?, "
                    + "CargaLevantada_faturanova = ?, "
                    + "MedidorInstalacao_faturanova = ?, "
                    + "Rua_faturanova = ?, "
                    + "Numero_faturanova = ?, "
                    + "Bairro_faturanova = ?, "
                    + "Tipos_faturanova = ?, "
                    + "CodBarrasRed_faturanova = ?, "
                    + "Unidade_faturanova = ? "
                   /* + "CodigoBarrasCon_cadastroConsumoFatura = ?, "
                    + "Valor_cadastroConsumoFatura = ?, "
                    + "Kw_cadastroConsumoFatura = ?, "
                    + "MesVencimento_cadastroConsumoFatura = ?, "
                    + "MesReferente_cadastroConsumoFatura = ?, "
                    + "DataCadastro_cadastroConsumoFatura = ?, "
                    + "Ano_cadastroConsumoFatura = ?, "
                    + "CodBarrasRed_cadastroConsumoFatura = ? "*/
                    + "WHERE `Instalacao_faturanova` = ?";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, edicaoGipDTO.getCodigoBarras_faturanova());
            pstm.setString(2, edicaoGipDTO.getInstalacao_faturanova());
            pstm.setString(3, edicaoGipDTO.getCargaLevantada_faturanova());
            pstm.setString(4, edicaoGipDTO.getMedidorInstalacao_faturanova());
            pstm.setString(5, edicaoGipDTO.getRua_faturanova());
            pstm.setString(6, edicaoGipDTO.getNumero_faturanova());
            pstm.setString(7, edicaoGipDTO.getBairro_faturanova());
            pstm.setString(8, edicaoGipDTO.getTipos_faturanova());
            pstm.setString(9, edicaoGipDTO.getCodBarrasRed_faturanova());
            pstm.setString(10, edicaoGipDTO.getUnidade_faturanova());
           /* pstm.setString(11, edicaoGipDTO.getCodigoBarrasCon_cadastroConsumoFatura());
            pstm.setString(12, edicaoGipDTO.getValor_cadastroConsumoFatura());
            pstm.setString(13, edicaoGipDTO.getKw_cadastroConsumoFatura());
            pstm.setString(14, edicaoGipDTO.getMesVencimento_cadastroConsumoFatura());
            pstm.setString(15, edicaoGipDTO.getMesReferente_cadastroConsumoFatura());
            pstm.setString(16, edicaoGipDTO.getDataCadastro_cadastroConsumoFatura());
            pstm.setString(17, edicaoGipDTO.getAno_cadastroConsumoFatura());
            pstm.setString(18, edicaoGipDTO.getCodBarrasRed_cadastroConsumoFatura());*/
            pstm.setString(11, edicaoGipDTO.getInstalacao_faturanova()); // Correção para usar o campo Instalacao_faturanova

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

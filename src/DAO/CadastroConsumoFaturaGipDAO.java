
package DAO;

import DTO.CadastroConsumoFaturaGipDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
//import necessario para a realização de uma função/retorno especifico 

public class CadastroConsumoFaturaGipDAO {
    
    Connection conn;  //define conn Connection
    PreparedStatement pstm;   //define pstm como preparedstatement
    ResultSet rs; //define rs como ResultSet
  
    public void cadastrarConFatura(CadastroConsumoFaturaGipDTO dto) {

    String sqlRepetida = """
    SELECT fn.Tipos_faturanova
    FROM cadastroConsumoFatura cf
    INNER JOIN faturanova fn
        ON fn.CodBarrasRed_faturanova =
           cf.CodBarrasRed_cadastroConsumoFatura
    WHERE cf.CodigoBarrasCon_cadastroConsumoFatura = ?
      AND cf.MesReferente_cadastroConsumoFatura = ?
      AND cf.Ano_cadastroConsumoFatura = ?
    LIMIT 1
""";

    String sqlVerificarCodigo = """
        SELECT Tipos_faturanova
        FROM faturanova
        WHERE CodBarrasRed_faturanova = ?
        LIMIT 1
    """;

    String sqlInsert = """
        INSERT INTO cadastroConsumoFatura (
            CodigoBarrasCon_cadastroConsumoFatura,
            Valor_cadastroConsumoFatura,
            Kw_cadastroConsumoFatura,
            MesVencimento_cadastroConsumoFatura,
            MesReferente_cadastroConsumoFatura,
            Ano_cadastroConsumoFatura,
            DataCadastro_cadastroConsumoFatura,
            CodBarrasRed_cadastroConsumoFatura,
            Atrasadas_cadastroConsumoFatura,
            Atrasadas_Acordo
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;

    try (
        
        Connection conn = new ConexaoGipDAO().conectaBD();

        PreparedStatement pstRepetida = conn.prepareStatement(sqlRepetida);
        PreparedStatement pstVerifica = conn.prepareStatement(sqlVerificarCodigo);
        PreparedStatement pstInsert = conn.prepareStatement(sqlInsert);
    ) {

        // =========================
        // VERIFICA FATURA REPETIDA
        // =========================
        pstRepetida.setString(1, dto.getCodigoBarrasCon_cadastroConsumoFatura());
        pstRepetida.setString(2, dto.getMesReferente_cadastroConsumoFatura());
        pstRepetida.setString(3, dto.getAno_cadastroConsumoFatura());

        try (ResultSet rsRepetida = pstRepetida.executeQuery()) {
            
           if (rsRepetida.next()) {

    String tipoRepetida =
        rsRepetida.getString("Tipos_faturanova");

    JOptionPane.showMessageDialog(
        null,
        "FATURA REPETIDA!\nTipo: " + tipoRepetida
    );

    return;
}
        }

        // =========================
        // VERIFICA SE EXISTE NA FATURANOVA
        // =========================
        pstVerifica.setString(1, dto.getCodBarrasRed_cadastroConsumoFatura());

        String tipoFatura;

        try (ResultSet rsTipo = pstVerifica.executeQuery()) {

            if (!rsTipo.next()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Código reduzido não encontrado na tabela faturanova."
                );
                return;
            }

            tipoFatura = rsTipo.getString("Tipos_faturanova");
        }

        // =========================
        // INSERT
        // =========================
        pstInsert.setString(1, dto.getCodigoBarrasCon_cadastroConsumoFatura());
        pstInsert.setString(2, dto.getValor_cadastroConsumoFatura());
        pstInsert.setString(3, dto.getKw_cadastroConsumoFatura());
        pstInsert.setString(4, dto.getMesVencimento_cadastroConsumoFatura());
        pstInsert.setString(5, dto.getMesReferente_cadastroConsumoFatura());
        pstInsert.setString(6, dto.getAno_cadastroConsumoFatura());
        pstInsert.setString(7, dto.getDataCadastro_cadastroConsumoFatura());
        pstInsert.setString(8, dto.getCodBarrasRed_cadastroConsumoFatura());
        pstInsert.setString(9, dto.getAtrasadas_cadastroConsumoFatura());
        pstInsert.setString(10, dto.getAtrasadas_acordo());

        int linhasAfetadas = pstInsert.executeUpdate();

        if (linhasAfetadas > 0) {
            JOptionPane.showMessageDialog(
                null,
                "Cadastro efetuado! Tipo: " + tipoFatura
            );
        }

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(
            null,
            "Erro ao cadastrar fatura:\n" + erro.getMessage()
        );
    }}
}

    // Restante do seu código...
//faz no meu código. Eu quero que ele verifique se tem repetida antes de verificar se existe uma fatura nova. Vou te mandar o codigo

        
        /*  
    String sqlInserirDados = "INSERT INTO cadastroConsumoFatura (CodigoBarrasCon_cadastroConsumoFatura, Valor_cadastroConsumoFatura, Kw_cadastroConsumoFatura, MesVencimento_cadastroConsumoFatura, MesReferente_cadastroConsumoFatura, Ano_cadastroConsumoFatura, DataCadastro_cadastroConsumoFatura, CodBarrasRed_cadastroConsumoFatura) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    try {
        conn = new ConexaoGipDAO().conectaBD();
        
        
        pstm = conn.prepareStatement(sqlInserirDados);
        pstm.setString(1, objcadastroconsumofaturagipdto.getCodigoBarrasCon_cadastroConsumoFatura());
        pstm.setString(2, objcadastroconsumofaturagipdto.getValor_cadastroConsumoFatura()); 
        pstm.setString(3, objcadastroconsumofaturagipdto.getKw_cadastroConsumoFatura());
        pstm.setString(4, objcadastroconsumofaturagipdto.getMesVencimento_cadastroConsumoFatura());
        pstm.setString(5, objcadastroconsumofaturagipdto.getMesReferente_cadastroConsumoFatura());
        pstm.setString(6, objcadastroconsumofaturagipdto.getAno_cadastroConsumoFatura());
        pstm.setString(7, objcadastroconsumofaturagipdto.getDataCadastro_cadastroConsumoFatura());
        pstm.setString(8, objcadastroconsumofaturagipdto.getCodBarrasRed_cadastroConsumoFatura());
        
        pstm.execute();
        pstm.close();
        
        // Verificar se o código reduzido do novo consumo está presente na outra tabela
            String sqlVerificarCodigo = "SELECT Tipos_faturanova FROM faturanova WHERE CodBarrasRed_faturanova = ?";
            pstm = conn.prepareStatement(sqlVerificarCodigo);
            pstm.setString(1, objcadastroconsumofaturagipdto.getCodBarrasRed_cadastroConsumoFatura());
            rs = pstm.executeQuery();
            
            
            if (!rs.next()) {
                throw new SQLException("Código reduzido não encontrado na outra tabela. Cadastro não permitido.");
            }
            // Se o código reduzido do novo consumo foi encontrado, exibir o tipo em um JOptionPane
            if (rs.next()) {
                String tipo = rs.getString("Tipos_faturanova");
                JOptionPane.showMessageDialog(null, "Tipo:  " + tipo);
            }
    } catch (SQLException erro){
        JOptionPane.showMessageDialog(null, "CONFIRA SE TODOS OS CAMPOS ESTÃO CORRETAMENTE PREENCHIDOS!");
        JOptionPane.showMessageDialog(null, "FaturasGipDAO" + erro);
    }

}*/
/*public void cadastrarConFatura(CadastroConsumoFaturaGipDTO objcadastroconsumofaturagipdto) {
        String sqlAtualizarConsumo = "insert into cadastroConsumoFatura (CodigoBarrasCon_cadastroConsumoFatura,Valor_cadastroConsumoFatura,Kw_cadastroConsumoFatura,MesVencimento_cadastroConsumoFatura, MesReferente_cadastroConsumoFatura, "
                + "Ano_cadastroConsumoFatura, DataCadastro_cadastroConsumoFatura, CodBarrasRed_cadastroConsumoFatura) values (?,?,?,?,?,?,?,?)"
                + "SELECT AtualizarConsumoFatura() AS Resultado";
                
            conn = new ConexaoGipDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sqlAtualizarConsumo);
    
            pstm.setString(1, objcadastroconsumofaturagipdto.getCodigoBarrasCon_cadastroConsumoFatura());          
            pstm.setString(2, objcadastroconsumofaturagipdto.getValor_cadastroConsumoFatura()); 
            pstm.setString(3, objcadastroconsumofaturagipdto.getKw_cadastroConsumoFatura()); 
            pstm.setString(4, objcadastroconsumofaturagipdto.getMesVencimento_cadastroConsumoFatura());  
            pstm.setString(5, objcadastroconsumofaturagipdto.getMesReferente_cadastroConsumoFatura());  
            pstm.setString(6, objcadastroconsumofaturagipdto.getAno_cadastroConsumoFatura()); 
            pstm.setString(7, objcadastroconsumofaturagipdto.getDataCadastro_cadastroConsumoFatura());     
            pstm.setString(8, objcadastroconsumofaturagipdto.getCodBarrasRed_cadastroConsumoFatura());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "CADASTRO DE CONSUMO REALIZADO COM SUCESSO!!" );
            
        } 
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "CONFIRA SE TODOS OS CAMPOS ESTÃO CORRETAMENTE PREENCHIDOS!");
            JOptionPane.showMessageDialog(null, "FaturasGipDAO" + erro);
            
        }
    }*/
/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE lEITE JANUÁRIO
*/ 
package DAO;

import DAO.ConexaoGipDAO;
import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.*;

public class DashDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    // Método que retorna um dataset com soma por tipo
    public DefaultCategoryDataset getConsumoPorMesAno(String mes, String ano) {
        conn = new ConexaoGipDAO().conectaBD();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // SQL corrigido: soma por tipo e agrupa
        String sql = "SELECT Tipos_faturanova, SUM(Valor_cadastroConsumoFatura) AS total " +
                     "FROM cadastroConsumoFatura " +
                     "INNER JOIN faturanova ON CodBarrasRed_faturanova = CodBarrasRed_cadastroConsumoFatura " +
                     "WHERE MesReferente_cadastroConsumoFatura = ? " +
                     "AND Ano_cadastroConsumoFatura = ? " +
                     "GROUP BY Tipos_faturanova";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, mes);
            pstm.setString(2, ano);
            rs = pstm.executeQuery();

            while (rs.next()) {
                double valor = rs.getDouble("total"); // pega o alias 'total'
                String tipo = rs.getString("Tipos_faturanova");

                dataset.addValue(valor, "Consumo", tipo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return dataset;
    }
}

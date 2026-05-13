import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.sql.*;

public class ServidorCSV {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/exportar-csv", new ExportHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("Servidor rodando em http://localhost:8080/exportar-csv");
    }

    static class ExportHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = gerarCSV();

            exchange.getResponseHeaders().add("Content-Type", "text/csv");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    public static String gerarCSV() {
        StringBuilder csv = new StringBuilder();

        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/faturasgip",
                "root",
                "1234"
            );

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
    "SELECT \n" +
"    c.*,\n" +
"    f.Instalacao_faturanova AS Instalacao,\n" +
"    f.Tipos_faturanova AS Tipo\n" +
"FROM cadastroConsumoFatura c\n" +
"LEFT JOIN faturanova f \n" +
"    ON TRIM(c.CodBarrasRed_cadastroConsumoFatura) \n" +
"     = TRIM(f.CodBarrasRed_faturanova)\n" +
"WHERE c.Ano_cadastroConsumoFatura = 2026\n" +
"ORDER BY c.id DESC;"
);

            // Cabeçalho
            csv.append("Id,Instalacao,Valor,KW,MesRef,MesVenc,Ano,DataCadastro, Tipo, Atrasadas\n");

while (rs.next()) {
    csv.append(rs.getString("id")).append(",");
    csv.append(rs.getString("Instalacao")).append(",");
    csv.append(rs.getDouble("Valor_cadastroConsumoFatura")).append(",");
    csv.append(rs.getDouble("Kw_cadastroConsumoFatura")).append(",");
    csv.append(rs.getString("MesReferente_cadastroConsumoFatura")).append(",");
    csv.append(rs.getString("MesVencimento_cadastroConsumoFatura")).append(",");
    csv.append(rs.getInt("Ano_cadastroConsumoFatura")).append(",");
    csv.append(rs.getString("DataCadastro_cadastroConsumoFatura")).append(",");
    csv.append(rs.getString("Tipo")).append(",");
    csv.append(rs.getString("Atrasadas_cadastroConsumoFatura")).append("\n");
}

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return csv.toString();
    }
}
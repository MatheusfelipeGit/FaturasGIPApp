
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import necessario para a realização de uma função/retorno especifico 


public class ConexaoGipDAO {
    //realiza a função 
    public Connection conectaBD() {
        
        Connection conn = null; 
        
        //o erro está no "null", pq não pode retornar vazio.
        /*
            O try aqui, ta tipo testando a conexao com o banco de dados (que eu ainda não criei), mas 
        o caminho já está feito.
            Em 'Libraries' está a aplicação Java que realizou/vai relizar a conexão com o banco.
        
        */
        
        try {
           String url = "jdbc:mysql://localhost:3306/faturasgip?user=root&password=1234";
           
           conn = DriverManager.getConnection(url);

          
        }
        /* esse catch, vai ajudar a identificar caso tenha algum erro na hora de rodar o programa, por isso
        usei o erro.getMessage; Ele vai servir justamente para exibir a mensagem escrita, caso o erro seja 
        na classe ConexaoDAO
        */
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"ConexaoGipDAO"+ erro.getMessage());
        }
        // como não pode ficar sem retornar nada, fui orientado a returnar "conn"
        return conn;
        }
    
    
    
}

/*
CÓDIGO PENSADO POR: JEFF 
E DESENVOLVIDO POR: MATHEUS FELIPE lEITE JANUÁRIO
*/ 
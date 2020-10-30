
package controls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Classe responsavel por abrir a conexão com a base de dados do sistema
 * @author Tiago Teixeira
 */
    

public class ConexaoDAO {

    private static String status = "Não conectou...";

    //Método Construtor da Classe//
    public ConexaoDAO() {

    }

    //Método de Conexão//
    public static java.sql.Connection getConexaoDAO() {

        Connection connection = null;  
        
        try {
    // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão //
            String serverName = "localhost";    
            String mydatabase = "locadora";      
            String url = "jdbc:mysql://" + serverName + ":3306/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";     
            String password = "root";     

            connection = DriverManager.getConnection(url, username, password);
            
            //Testa sua conexão//

            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (ClassNotFoundException e) {
            
            System.out.println("O driver expecificado nao foi encontrado." + e);
            
            return null;
            
        } catch (SQLException e) {
            
            System.out.println("Nao foi possivel conectar ao Banco de Dados." + e);
            
            return null;

        }

    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {

        return status;

    }

    //Método que fecha sua conexão//
    public static boolean FecharConexao() {

        try {

            ConexaoDAO.getConexaoDAO().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();

        return ConexaoDAO.getConexaoDAO();

    }

}
    


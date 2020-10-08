
package DAO;

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

        Connection connection = null;          //atributo do tipo Connection
        
        try {
    // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase = "locadora";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + ":3306/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";        //nome de um usuário de seu BD
            String password = "root";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);
            
            //Testa sua conexão//

            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (ClassNotFoundException e ) {  //Driver não encontrado

            System.out.println("O driver expecificado nao foi encontrado." + e);

            return null;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco
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


   //Método que reinicia sua conexão//

    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();

        return ConexaoDAO.getConexaoDAO();

    }

}
    



package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @ Responsavel por fazer a leitura e preenchimento do combobox da tela de login
 * @author Tiago Teixeira
 */
public class LoginDAO {
    
    private String retorno;
    private boolean sucesso;

    public String getRetorno() {
        return retorno;
    }

    public boolean isSucesso() {
        return sucesso;
    }
    
     public List<models.ClsLogin> select(String nomeLogin) {

        String sql = "select id, Cpf, nomeLogin, senha from colaboradores where nomeLogin = ? ";
        List<models.ClsLogin> login = new ArrayList<models.ClsLogin>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nomeLogin);
            rset = ps.executeQuery();

         
                while (rset.next()) {
                    models.ClsLogin clsLogin = new models.ClsLogin();
                    clsLogin.setId(rset.getInt("id"));
                    clsLogin.setCpfUserLoged(rset.getString("Cpf"));
                    clsLogin.setUsuarioDAO(rset.getString("nomeLogin"));
                    clsLogin.setSenhaDAO(rset.getString("senha"));
                    login.add(clsLogin);
                }
                retorno = "Login Encontrado!";
                sucesso = true;

        } catch (SQLException e) {
            retorno = "Erro: " + e;
            sucesso = false;
        } finally {

            try {

                if (rset != null) {
                    rset.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                    ConexaoDAO.FecharConexao();
                }

            } catch (SQLException e) {
                retorno = "Erro: " + e;
            }
        }

        return login;
    }
     public List<models.ClsLogin> selectFull() {

        String sql = "select id, nomeLogin, senha from colaboradores";
        List<models.ClsLogin> login = new ArrayList<models.ClsLogin>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            rset = ps.executeQuery();

         
                while (rset.next()) {
                    models.ClsLogin clsLogin = new models.ClsLogin();
                    clsLogin.setId(rset.getInt("id"));
                    clsLogin.setUsuarioDAO(rset.getString("nomeLogin"));
                    clsLogin.setSenhaDAO(rset.getString("senha"));
                    login.add(clsLogin);
                }
                retorno = "Login Encontrado!";
                sucesso = true;

        } catch (SQLException e) {
            retorno = "Erro: " + e;
            sucesso = false;
        } finally {

            try {

                if (rset != null) {
                    rset.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                    ConexaoDAO.FecharConexao();
                }

            } catch (SQLException e) {
                retorno = "Erro: " + e;
            }
        }

        return login;
    }
    
}

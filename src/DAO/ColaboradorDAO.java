package DAO;

/**
 * Classe responsavel pelo CRUD tela de colaborador
 *
 * @author Tiago Teixeira
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {

    private String retorno;

    public String getRetorno() {
        return retorno;
    }

    public void save(models.ClsColaborador clscolaborador) {
        // variavel com a string do comando SQL para inserção de dados na enticade Colaborador
        String sql = "insert into colaboradores (nome, cpf, nomeLogin, senha, telefone) values (?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps.setString(1, clscolaborador.getNome());
            ps.setString(2, clscolaborador.getCpf());
            ps.setString(3, clscolaborador.getNomeLogin());
            ps.setString(4, clscolaborador.getSenha());
            ps.setString(5, clscolaborador.getTelefone());

            //executando a instrução com os parametro setados da classe colaborador
            ps.execute();
            retorno = "Gravado com sucesso!";
        } catch (SQLException e) {
            retorno = "Erro ao gravar: " + e;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                    ConexaoDAO.FecharConexao();
                }
            } catch (SQLException e) {
                retorno = "Erro ao Deletar: " + e;
            }
        }
    }

    public void update(models.ClsColaborador clscolaborador) {

        // variavel com a string do comando SQL para atualização dos dados na enticade Colaborador
        String sql = "update colaboradores set nome = ?, cpf = ?, nomeLogin = ?, senha = ?, telefone = ? where id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps.setString(1, clscolaborador.getNome());
            ps.setString(2, clscolaborador.getCpf());
            ps.setString(3, clscolaborador.getNomeLogin());
            ps.setString(4, clscolaborador.getSenha());
            ps.setString(5, clscolaborador.getTelefone());
            ps.setInt(6, clscolaborador.getId());

            //executando a instrução com os parametro setados da classe colaborador
            ps.execute();
            retorno = "Atualizado com sucesso!";
        } catch (SQLException e) {
            retorno = "Erro ao atualizar: " + e;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                    ConexaoDAO.FecharConexao();
                }
            } catch (SQLException e) {
                retorno = "Erro ao Deletar: " + e;
            }
        }
    }

    public void delete(int id_colaborador) {
        // variavel com a string do comando SQL para atualização dos dados na enticade Colaborador
        String sql = "delete from colaboradores where id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps.setInt(1, id_colaborador);

            //executando a instrução com os parametro setados da classe colaborador
            ps.execute();
            retorno = "Deletado com sucesso!";
        } catch (SQLException e) {
            retorno = "Erro ao Deletar: " + e;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                    ConexaoDAO.FecharConexao();
                }
            } catch (SQLException e) {
                retorno = "Erro : " + e;
            }
        }
    }

    public List<models.ClsColaborador> select(String cpf) {

        String sql = "select id, nome, cpf, nomeLogin, senha, telefone from colaboradores where cpf = ?";
        List<models.ClsColaborador> colaboradores = new ArrayList<models.ClsColaborador>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            rset = ps.executeQuery();
            
            while (rset.next()) {
                models.ClsColaborador colaborador = new models.ClsColaborador();
                colaborador.setId(rset.getInt("id"));
                colaborador.setNome(rset.getString("nome"));
                colaborador.setCpf(rset.getString("cpf"));
                colaborador.setNomeLogin(rset.getString("nomeLogin"));
                colaborador.setSenha(rset.getString("senha"));
                colaborador.setTelefone(rset.getString("telefone"));
                colaboradores.add(colaborador);
            }
            retorno = "Colaborador Encontrado!";
        } catch (SQLException e) {
            retorno = "Erro: " + e;
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

        return colaboradores;
    }
    


}

package controls;

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
    private boolean sucesso;

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getRetorno() {
        return retorno;
    }

    public void save(models.ClsColaborador clscolaborador) {
        // variavel com a string do comando SQL para inserção de dados na enticade Colaborador
        String sql = "insert into colaboradores (nome, cpf, nomeLogin, Cpf_funCadastro, senha, telefone, nivel) values (?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps.setString(1, clscolaborador.getNome());
            ps.setString(2, clscolaborador.getCpf());
            ps.setString(3, clscolaborador.getNomeLogin());
            ps.setString(4, clscolaborador.getCpf_funCadastro());
            ps.setString(5, clscolaborador.getSenha());
            ps.setString(6, clscolaborador.getTelefone());
            ps.setString(7, clscolaborador.getNivel());
            //executando a instrução com os parametro setados da classe colaborador
            ps.execute();
            retorno = "Gravado com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            System.out.println(e);
            if (e.getErrorCode() == 1062) {
                retorno = "O CPF já está cadastrado!";
                sucesso = false;
            }
            if (e.getErrorCode() == 1048) {
                retorno = "Verifique todos os campos se estão preenchidos!";
                sucesso = false;
            }

            System.out.println("" + e.getErrorCode() + "" + e);

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
        String sql = "update colaboradores set nome = ?, cpf = ?, nomeLogin = ?, Cpf_funCadastro = ? , senha = ?, telefone = ?, nivel = ? where id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps.setString(1, clscolaborador.getNome());
            ps.setString(2, clscolaborador.getCpf());
            ps.setString(3, clscolaborador.getNomeLogin());
            ps.setString(4, clscolaborador.getCpf_funCadastro());
            ps.setString(5, clscolaborador.getSenha());
            ps.setString(6, clscolaborador.getTelefone());
            ps.setString(7, clscolaborador.getNivel());
            ps.setInt(8, clscolaborador.getId());

            //executando a instrução com os parametro setados da classe colaborador
            ps.execute();
            retorno = "Atualizado com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1048) {
                retorno = "Verifique todos os campos se estão preenchidos!";
                sucesso = false;
            } else {
                retorno = "Erro ao atualizar: " + e;
                sucesso = false;
            }
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
            sucesso = true;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                retorno = "Erro ao Deletar: ";
                sucesso = false;
            }
           
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

        String sql = "select id, nome, cpf, nomeLogin, Cpf_funCadastro, senha, telefone, nivel from colaboradores where cpf = ?";
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
                colaborador.setCpf_funCadastro(rset.getString("Cpf_funCadastro"));
                colaborador.setSenha(rset.getString("senha"));
                colaborador.setTelefone(rset.getString("telefone"));
                colaborador.setNivel(rset.getString("nivel"));
                colaboradores.add(colaborador);
            }
            retorno = "Colaborador Encontrado!";
            sucesso = true;

        } catch (SQLException e) {
            retorno = "Erro: " + e;
            System.out.println(e);
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

        return colaboradores;
    }
    
    public List<models.ClsColaborador> selectAll() {

        String sql = "select id, nome, cpf, nomeLogin, Cpf_funCadastro, senha, telefone, nivel from colaboradores";
        List<models.ClsColaborador> colaboradores = new ArrayList<models.ClsColaborador>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            rset = ps.executeQuery();

            while (rset.next()) {
                models.ClsColaborador colaborador = new models.ClsColaborador();
                colaborador.setId(rset.getInt("id"));
                colaborador.setNome(rset.getString("nome"));
                colaborador.setCpf(rset.getString("cpf"));
                colaborador.setNomeLogin(rset.getString("nomeLogin"));
                colaborador.setCpf_funCadastro(rset.getString("Cpf_funCadastro"));
                colaborador.setSenha(rset.getString("senha"));
                colaborador.setTelefone(rset.getString("telefone"));
                colaborador.setNivel(rset.getString("nivel"));
                colaboradores.add(colaborador);
            }
            retorno = "Colaborador Encontrado!";
            sucesso = true;

        } catch (SQLException e) {
            retorno = "Erro: " + e;
            System.out.println(e);
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

        return colaboradores;
    }

}

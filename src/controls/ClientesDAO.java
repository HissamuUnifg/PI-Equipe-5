
package controls;

/**
 * Resposnsavel por fazer o CRUD do bloco de dados gerais do Cliente na Jframe.JfrmClientes
 * @author Tiago Teixeira
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ClientesDAO {
    SimpleDateFormat formatoUS = new SimpleDateFormat("yyyy-MM-dd");
    private String retorno;
    private boolean sucesso;
    private int idRetornado;

    public int getIdRetornado() {
        return idRetornado;
    }

 
    public String getRetorno() {
        return retorno;
    }

    public boolean isSucesso() {
        return sucesso;
    }
    
    public ClientesDAO() {
    }

    public void save(models.ClsClientes clsClientes){
        String sql = "insert into Clientes (nome, cpf, razaosocial, cnpj, ie, rg, datanascimento, "
                  + " telefone, celular, email, observacoes, cnh, id_colaborador, inativo ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sqlId = "select max(id) as Id from Clientes";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, clsClientes.getNome());
            ps.setString(2, clsClientes.getCpf());
            ps.setString(3, clsClientes.getRazaoSocial());
            ps.setString(4, clsClientes.getCnpj());
            ps.setString(5, clsClientes.getIe());
            ps.setString(6, clsClientes.getRg());
            ps.setString(7, clsClientes.getDataNascimento());
            ps.setString(8, clsClientes.getTelefone());
            ps.setString(9, clsClientes.getCelular());
            ps.setString(10, clsClientes.getEmail());
            ps.setString(11, clsClientes.getObservacoes());
            ps.setString(12, clsClientes.getCnh());            
            ps.setInt(13, clsClientes.getIdColaborador());
            ps.setInt(14, clsClientes.getInativo());            
            
            ps.execute();
            //buscando o id que gerou no banco
            ps = conn.prepareStatement(sqlId);
            rs = ps.executeQuery();
            
            while (rs.next()){
                idRetornado = rs.getInt("id");
            }
            
            retorno = "Cliente gravado com sucerro!";
            sucesso = true;
        } catch (SQLException e) {
            retorno = "Erro ao salvar Cliente!" +e;
            sucesso = false;
        }
        finally
        {
            ConexaoDAO.FecharConexao();
        }
    
    }
    
    public void update(models.ClsClientes clsClientes){
        String sql = " update Clientes set nome = ?, cpf = ?, razaosocial = ?, cnpj = ?, ie = ?, rg = ?, datanascimento = ?, "
                   + " telefone = ?, celular = ?, email = ?, observacoes = ?, cnh = ?,id_colaborador = ?, inativo = ? where id = ? ";
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, clsClientes.getNome());
            ps.setString(2, clsClientes.getCpf());
            ps.setString(3, clsClientes.getRazaoSocial());
            ps.setString(4, clsClientes.getCnpj());
            ps.setString(5, clsClientes.getIe());
            ps.setString(6, clsClientes.getRg());
            ps.setString(7, clsClientes.getDataNascimento());
            ps.setString(8, clsClientes.getTelefone());
            ps.setString(9, clsClientes.getCelular());
            ps.setString(10, clsClientes.getEmail());
            ps.setString(11, clsClientes.getObservacoes());
            ps.setString(12, clsClientes.getCnh());
            ps.setInt(13, clsClientes.getIdColaborador());
            ps.setInt(14, clsClientes.getInativo());
            ps.setInt(15, clsClientes.getId());
            
            ps.execute();
            
            retorno = "Cliente atualizado com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            retorno = "Erro ao atualizar cliente" + e;
            sucesso = false;
        }
        finally
        {
            ConexaoDAO.FecharConexao();
        }
    }
    
    public void delete(int idCliente){
        String sql = "delete from Clientes where id = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);            
            ps.execute();
            EnderecosDAO endDAO = new EnderecosDAO();
            //ao deletar o cliente os endereços também serão deletados
            endDAO.deleteTodos(idCliente);
            
            retorno = "Cliente Deletado com sucesso! "+endDAO.getRetorno();
            sucesso = true;
           
        } catch (SQLException e) {
            retorno = "Erro ao deletar cliente!" + e;
            sucesso = false;
        }
        finally
        {
            ConexaoDAO.FecharConexao();
        }
    }
    
    public List<models.ClsClientes> selectAll() {
       
        List<models.ClsClientes> rClsClientes = new ArrayList<models.ClsClientes>();
        
        String sql = "Select id, nome, cpf, razaosocial, cnpj, ie, rg, datanascimento, telefone, celular, email, observacoes, cnh,  id_colaborador, inativo  from locadora.Clientes";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                models.ClsClientes clsClientes = new models.ClsClientes();
                
                clsClientes.setId(rs.getInt("id"));
                clsClientes.setNome(rs.getString("nome"));
                clsClientes.setCpf(rs.getString("cpf"));
                clsClientes.setRazaoSocial(rs.getString("razaosocial"));
                clsClientes.setCnpj(rs.getString("cnpj"));
                clsClientes.setIe(rs.getString("ie"));
                clsClientes.setRg(rs.getString("rg"));
                clsClientes.setDataNascimento(formatoUS.format(rs.getDate("datanascimento")));
                clsClientes.setTelefone(rs.getString("telefone"));
                clsClientes.setCelular(rs.getString("celular"));
                clsClientes.setEmail(rs.getString("Email"));
                clsClientes.setObservacoes(rs.getString("observacoes"));
                clsClientes.setCnh(rs.getString("cnh"));
                clsClientes.setIdColaborador(rs.getInt("id_colaborador"));
                clsClientes.setInativo(rs.getInt("inativo"));
                rClsClientes.add(clsClientes);

            }
            retorno = "Lista carregada com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            retorno = "Erro ao carregar a lista: " + e;
            sucesso = false;
            System.out.println(e);
        }catch (Exception ex){
            System.out.println(ex);
        
        } finally {
            ConexaoDAO.FecharConexao();
        }

        return rClsClientes;

    }
    
}

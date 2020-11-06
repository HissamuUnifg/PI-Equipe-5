
package controls;

/**
 * Responsavel pelo CRUD do endereço do cliente.
 * @author Tiago Teixeira
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ClsEnderecos;


public class EnderecosDAO {
   
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
    
    
    public EnderecosDAO(){
    
    }
    
    public void save(ClsEnderecos clsEnderecos){
    
    String sql = "insert into Enderecos (Rua, Numero, Bairro, TipoEndereco, Referencia, Cep, Id_cidade, id_cliente) values (?,?,?,?,?,?,?,?)";
    String sqlId = "select MAX(id) as Id from Enderecos";
   
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, clsEnderecos.getRua());
            ps.setString(2, clsEnderecos.getNumero());
            ps.setString(3, clsEnderecos.getBairro());
            ps.setString(4, clsEnderecos.getTipoEndereco());
            ps.setString(5, clsEnderecos.getReferencia());
            ps.setString(6, clsEnderecos.getCep());
            ps.setInt(7, clsEnderecos.getIdCidade());
            ps.setInt(8, clsEnderecos.getIdCliente());
            
            ps.execute();
            ps = conn.prepareStatement(sqlId);
            rs = ps.executeQuery();
            //passando o ultimo ID criado no endereço para Adicionar o cliente.
            while(rs.next()){
            idRetornado = rs.getInt("Id");
            }
            
            sucesso = true;
            retorno = "Inserido com sucesso";
            
        } catch (SQLException e) {
            sucesso = false;
            retorno = "Erro ao inserir o endereço!";
        } finally {
            ConexaoDAO.FecharConexao();
        }

    }
    
    public void update(ClsEnderecos clsEnderecos){
    
    String sql = "update Enderecos set Rua = ? , Numero = ?, Bairro = ?, TipoEndereco = ? , Cep = ?, Id_cidade = ?, referencia = ?, id_cliente = ? where id = ?";
   
   
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, clsEnderecos.getRua());
            ps.setString(2, clsEnderecos.getNumero());
            ps.setString(3, clsEnderecos.getBairro());
            ps.setString(4, clsEnderecos.getTipoEndereco());
            ps.setString(5, clsEnderecos.getCep());
            ps.setInt(6, clsEnderecos.getIdCidade());
            ps.setString(7, clsEnderecos.getReferencia());
            ps.setInt(8, clsEnderecos.getIdCliente());
            ps.setInt(9, clsEnderecos.getId());
            
            
            ps.execute();
                        
            sucesso = true;
            retorno = "Atualizado com sucesso";
            
        } catch (SQLException e) {
            sucesso = false;
            retorno = "Erro ao inserir o endereço!";
        } finally {
            ConexaoDAO.FecharConexao();
        }

    }
    
    public List<ClsEnderecos> selectALL(int idCliente) {
        List<ClsEnderecos> clsEndereco = new ArrayList<ClsEnderecos>();
        
        String sql = "select end.id as id, end.rua as rua,end.numero as numero,end.bairro as bairro, end.referencia as referencia, "
                   + " cde.nomecidade as nomecidade,cde.estado as estado,end.cep as cep, end.tipoendereco as tipoendereco, cl.id as idcliente, "
                   + " cde.id as id_cidade from enderecos end inner join cidades cde on cde.id = end.id_cidade "
                   + " inner join Clientes cl on cl.id = end.id_cliente where cl.id = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {

            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            while (rs.next()) {
                ClsEnderecos clsend = new ClsEnderecos();
                clsend.setId(rs.getInt("id"));
                clsend.setRua(rs.getString("rua"));
                clsend.setNumero(rs.getString("Numero"));
                clsend.setBairro(rs.getString("Bairro"));
                clsend.setTipoEndereco(rs.getString("Referencia"));
                clsend.setNomeCidade(rs.getString("NomeCidade"));
                clsend.setEstado(rs.getString("Estado"));
                clsend.setCep(rs.getString("Cep"));
                clsend.setTipoEndereco(rs.getString("TipoEndereco"));                
                clsend.setId_cidade(rs.getInt("Id_cidade"));
                clsend.setIdCliente(rs.getInt("idcliente"));
                clsEndereco.add(clsend);
            }
            retorno = "Carregado lista com sucesso";
            sucesso = true;
        } catch (SQLException e) {
            retorno = "Erro ao obter os dados!" + e;
            sucesso = false;
        } 
        finally 
        {
            ConexaoDAO.FecharConexao();
        }

        return clsEndereco;
    }
    
    public void delete(int IdEndereco){
    String sql = "delete from Enderecos where id = ?";
    
    Connection conn = null;
    PreparedStatement ps = null;
    
        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, IdEndereco);
            ps.execute();
            
            retorno = "deletado com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            retorno = "Erro ao deletar!"+ e;
            sucesso = false;
        } 
        finally 
        {
            ConexaoDAO.FecharConexao();
        }
        
    }
    
    public void deleteTodos(int idCliente){
    String sql = "delete from Enderecos where id_cliente = ?";
    
    Connection conn = null;
    PreparedStatement ps = null;
    
        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.execute();
            
            retorno = "Endereços deletados com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            retorno = "Erro ao deletar!"+ e;
            sucesso = false;
        } 
        finally 
        {
            ConexaoDAO.FecharConexao();
        }
        
    }
}

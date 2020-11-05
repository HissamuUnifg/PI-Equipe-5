
package controls;

/**
 * responsavel por retornar uma lista das cidades cadastradas no banco de dados
 * @author Tiago Teixeira
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ClsCidades;



public class CidadesDAO {
    
    public CidadesDAO(){
    }
    
    private String retorno;
    private boolean sucesso;

    public String getRetorno() {
        return retorno;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    /**
     * Traz uma lista com todos os dados de cidades cadastradas no BD
     * @return Retorna Uma lista contendo todo o conteudo do banco da Tabela Cidades
     */
    public List<ClsCidades> selectALL() {
    
        String sql = "select Id, NomeCidade, SiglaEstado, Estado, Pais from locadora.cidades order by NomeCidade";
        
        List<ClsCidades> listClsCidades = new ArrayList<ClsCidades>();
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(rs.getFetchSize());
            
            while (rs.next()) {
                ClsCidades clsCidades = new ClsCidades();
                clsCidades.setIdCidade(rs.getInt("Id"));
                clsCidades.setNomeCidade(rs.getString("NomeCidade"));
                clsCidades.setSiglaEstado(rs.getString("SiglaEstado"));
                clsCidades.setEstado(rs.getString("Estado"));
                clsCidades.setPais(rs.getString("Pais"));
                listClsCidades.add(clsCidades);
            }
            
            retorno = "Listado com Sucesso!";
            sucesso = true;            
        } catch (SQLException e) {
            retorno = "Erro aqui:" +e;
            sucesso = false;
        } finally {
            ConexaoDAO.FecharConexao();           
        }
       
        return listClsCidades;      
    }
     
    
    
}

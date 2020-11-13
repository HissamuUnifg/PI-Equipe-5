
package controls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import models.ClsContratos;
import models.ClsValidacoes;

/**
 * RESPONSAVEL PELO CRUD DOS CONTRATOS INSERIDOS NO BANCO DE DADOS
 * @author Tiago Teixeira
 */
public class ContratosDAO {
    private String retorno;
    private boolean sucesso;
    ClsValidacoes clsval = new ClsValidacoes();
    SimpleDateFormat formatoUS = new SimpleDateFormat("yyyy-MM-dd");
    
    
 public void save(ClsContratos clsContratos){
    String sql = "INSERT INTO contratos (id_cliente,id_carro,id_colaborador, Observacoes,QuantidadeDiarias,"
            + " QuantidadeKmRet,ValorExtra,ValorTotal,TipoLocacao,DataSaida,DataChegada,DataContrato,Status) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    Connection conn = null;
    PreparedStatement ps = null;
    
     try {
         
         conn = ConexaoDAO.getConexaoDAO();
         ps = conn.prepareStatement(sql);
         
         ps.setInt(1, clsContratos.getIdCliente());
         ps.setInt(2, clsContratos.getIdCarro());
         ps.setInt(3, clsContratos.getIdColaborador());
         ps.setString(4, clsContratos.getObservacoes());
         ps.setInt(5, clsContratos.getQuantidadeDiarias());
         ps.setInt(6, clsContratos.getQuantidadeKmRet());
         ps.setFloat(7, clsContratos.getValorExtra());
         ps.setFloat(8, clsContratos.getValorTotal());
         ps.setString(9, clsContratos.getTipoLocacao());
         ps.setString(10, clsContratos.getDataSaida());
         ps.setString(11, clsContratos.getDataChegada());
         ps.setString(12, clsContratos.getDataContrato());
         ps.setString(13, clsContratos.getStatus());
         
         
         retorno = "Contrato Gravado com Sucesso!";
         sucesso = true;
         
     } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1048:
                    retorno = "Verifique todos os campos se estão preenchidos!";
                    sucesso = false;
                    break;
                case 1062:
                    retorno = "Contrato ja cadastrado!";
                    sucesso = false;
                    break;
                default:
                    retorno = "Erro ao gravar: " + e;
                    sucesso = false;
                    break;
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
                retorno = "Erro ao fechar conexões: " + e;
            }
        }
    
 }
 
 public void update(ClsContratos clsContratos){
    String sql = "update contratos set id_cliente = ?,id_carro = ?,id_colaborador = ?, Observacoes = ?,QuantidadeDiarias = ?,"
            + " QuantidadeKmRet = ?,ValorExtra = ?,ValorTotal = ?,TipoLocacao = ?,DataSaida = ?,DataChegada = ?,DataContrato = ?,Status = ? where id = ?";
    
    Connection conn = null;
    PreparedStatement ps = null;
    
     try {
         
         conn = ConexaoDAO.getConexaoDAO();
         ps = conn.prepareStatement(sql);
         
         ps.setInt(1, clsContratos.getIdCliente());
         ps.setInt(2, clsContratos.getIdCarro());
         ps.setInt(3, clsContratos.getIdColaborador());
         ps.setString(4, clsContratos.getObservacoes());
         ps.setInt(5, clsContratos.getQuantidadeDiarias());
         ps.setInt(6, clsContratos.getQuantidadeKmRet());
         ps.setFloat(7, clsContratos.getValorExtra());
         ps.setFloat(8, clsContratos.getValorTotal());
         ps.setString(9, clsContratos.getTipoLocacao());
         ps.setString(10, clsContratos.getDataSaida());
         ps.setString(11, clsContratos.getDataChegada());
         ps.setString(12, clsContratos.getDataContrato());
         ps.setString(13, clsContratos.getStatus());
         ps.setInt(14, clsContratos.getId());
         
         retorno = "Contrato Gravado com Sucesso!";
         sucesso = true;
         
     } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1048:
                    retorno = "Verifique todos os campos se estão preenchidos!";
                    sucesso = false;
                    break;
                case 1062:
                    retorno = "Contrato ja cadastrado!";
                    sucesso = false;
                    break;
                default:
                    retorno = "Erro ao atualizar: " + e;
                    sucesso = false;
                    break;
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
                retorno = "Erro ao fechar conexões: " + e;
            }
        }
    
 }
 
 public void delete(int idContrato) {
        String sql = "delete from contratos where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idContrato);

            ps.execute();
            retorno = "Excluido com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            sucesso = false;
            retorno = "Erro ao excluir:" + e;
        } finally {
            ConexaoDAO.FecharConexao();
        }
    }
    
 public ClsContratos select(int idContrato) {
        ClsContratos clsCont = new ClsContratos();
        String sql = "select id, id_cliente, id_carro, id_colaborador, Observacoes, QuantidadeDiarias, "
                + " QuantidadeKmRet,ValorExtra,ValorTotal,TipoLocacao,DataSaida,DataChegada, "
                + " DataContrato,Status from contratos where = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idContrato);
            rs = ps.executeQuery();
            
            while (rs.next()){
            ClsContratos clsContratos = new ClsContratos();
            clsContratos.setId(rs.getInt("id"));
            clsContratos.setIdCliente(rs.getInt("id_cliente"));
            clsContratos.setIdCarro(rs.getInt("id_carro"));
            clsContratos.setIdColaborador(rs.getInt("id_colaborador"));
            clsContratos.setObservacoes(rs.getString("Observacoes"));
            clsContratos.setQuantidadeDiarias(rs.getInt("quantidadediarias"));
            clsContratos.setQuantidadeKmRet(rs.getInt("quantidadekmret"));
            clsContratos.setValorExtra(rs.getFloat("valorextra"));
            clsContratos.setValorTotal(rs.getFloat("valortotal"));
            clsContratos.setTipoLocacao(rs.getString("tipolocacao"));
            clsContratos.setDataSaida(formatoUS.format(rs.getDate("datasaida")));
            clsContratos.setDataChegada(formatoUS.format(rs.getDate("datachegada")));
            clsContratos.setDataContrato(formatoUS.format(rs.getDate("datacontrato")));
            clsContratos.setStatus(rs.getString("status"));
            clsCont = clsContratos;
            }
            
            retorno = "Contrato encontrado!";
            sucesso = true;
            
        } catch (SQLException e) {
            sucesso = false;
            retorno = "Erro ao buscar contrato: "+e;
        }finally {
            ConexaoDAO.FecharConexao();
        }
        return clsCont;
    }
    
}

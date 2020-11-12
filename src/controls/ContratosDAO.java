
package controls;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    
    
    
}

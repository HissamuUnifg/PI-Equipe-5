
package DAO;

/**
 * Responsavel pelo CRUD tela de Cadastro e Movimentação de Veiculos
 * @author Tiago Teixeira
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ClsCarros;


public class CarrosDAO {
    
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

    public void save(ClsCarros clscarros) {
        // variavel com a string do comando SQL para inserção de dados na enticade Colaborador
        String sql = "INSERT INTO carros (Nome,Marca,Modelo,Classe,TipoVeiculo,Cor,Placa,Renavam,ObsEstado,DataCompra,AnoModelo,AnoFabricacao,"
                                       + "Chassi,KmRodados,ValorMercado,ValorSeguro,ValorKmRd,ValorDiariaLoc,Status,Inativo,id_colaborador) "
                                        + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps.setString(1, clscarros.getNome());
            ps.setString(2, clscarros.getMarca());
            ps.setString(3, clscarros.getModelo());
            ps.setString(4, clscarros.getClasse());
            ps.setString(5, clscarros.getTipoVeiculo());
            ps.setString(6, clscarros.getCor());
            ps.setString(7, clscarros.getPlaca());
            ps.setInt(8, clscarros.getRenavam());
            ps.setString(9, clscarros.getObsEstado());
            ps.setDate(10, clscarros.getDataCompra());
            ps.setInt(11, clscarros.getAnoModelo());
            ps.setInt(12, clscarros.getAnoFabricacao());
            ps.setString(13, clscarros.getChassi());
            ps.setInt(14, clscarros.getKmRodados());
            ps.setFloat(15, clscarros.getValorMercado());
            ps.setFloat(16, clscarros.getValorSeguro());
            ps.setFloat(17, clscarros.getValorKmRd());
            ps.setFloat(18, clscarros.getValorDiariaLoc());
            ps.setInt(19, clscarros.getStatus());
            ps.setInt(20, clscarros.getInativo());
            ps.setInt(21, clscarros.getId_colaborador());
            //executando a instrução com os parametro setados da classe colaborador
            ps.execute();
            retorno = "Gravado com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                retorno = "O Carro já está cadastrado!";
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
                retorno = "Erro ao fechar conexões: " + e;
            }
        }
    }

    public void update(ClsCarros clscarros) {

        // variavel com a string do comando SQL para atualização dos dados na enticade Colaborador
        String sql = "update colaboradores set Nome =?, Marca = ?, Modelo = ?, Classe = ?, TipoVeiculo = ?, Cor = ?, Placa = ?, Renavam = ?, ObsEstado = ?,"
                + "  DataCompra = ?, AnoModelo = ?, AnoFabricacao = ?, Chassi = ?, KmRodados = ?, ValorMercado = ?,ValorSeguro  = ?"
                + "  , ValorKmRd = ?, ValorDiariaLoc = ?, Status = ?, Inativo = ?, id_colaborador = ? where id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps.setString(1, clscarros.getNome());
            ps.setString(2, clscarros.getMarca());
            ps.setString(3, clscarros.getModelo());
            ps.setString(4, clscarros.getClasse());
            ps.setString(5, clscarros.getTipoVeiculo());
            ps.setString(6, clscarros.getCor());
            ps.setString(7, clscarros.getPlaca());
            ps.setInt(8, clscarros.getRenavam());
            ps.setString(9, clscarros.getObsEstado());
            ps.setDate(10, clscarros.getDataCompra());
            ps.setInt(11, clscarros.getAnoModelo());
            ps.setInt(12, clscarros.getAnoFabricacao());
            ps.setString(13, clscarros.getChassi());
            ps.setInt(14, clscarros.getKmRodados());
            ps.setFloat(15, clscarros.getValorMercado());
            ps.setFloat(16, clscarros.getValorSeguro());
            ps.setFloat(17, clscarros.getValorKmRd());
            ps.setFloat(18, clscarros.getValorDiariaLoc());
            ps.setInt(19, clscarros.getStatus());
            ps.setInt(20, clscarros.getInativo());
            ps.setInt(21, clscarros.getId_colaborador());

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
                retorno = "Erro fechar conexão: " + e;
            }
        }
    }

    public void delete(int id_carro) {
        // variavel com a string do comando SQL para atualização dos dados na enticade Colaborador
        String sql = "delete from carros where id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps.setInt(1, id_carro);

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

    /**
     * Author: Tiago Teixeira
     * @param placa
     * @return objeto com os dados da classe ClsCarro
     */
    public ClsCarros select(String placa) {

        String sql = "SELECT id, Nome, Marca, Modelo, Classe, TipoVeiculo, Cor, "
                + "Placa, Renavam, ObsEstado,DataCompra,AnoModelo,AnoFabricacao, "
                + "Chassi, KmRodados, ValorMercado, ValorSeguro, ValorKmRd,"
                + "ValorDiariaLoc, Status, Inativo, id_colaborador 	"
                + "FROM carros where Placa = ?";
        ClsCarros carroEcontrado = null;    
        
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, placa);
            rset = ps.executeQuery();

            carroEcontrado.setId(rset.getInt("Id"));
            carroEcontrado.setNome(rset.getString("Nome"));
            carroEcontrado.setMarca(rset.getString("Marca"));
            carroEcontrado.setModelo(rset.getString("Modelo"));
            carroEcontrado.setClasse(rset.getString("Classe"));
            carroEcontrado.setTipoVeiculo(rset.getString("TipoVeiculo"));
            carroEcontrado.setCor(rset.getString("Cor"));
            carroEcontrado.setPlaca(rset.getString("Placa"));
            carroEcontrado.setRenavam(rset.getInt("Renavam"));
            carroEcontrado.setObsEstado(rset.getString("ObsEstado"));
            carroEcontrado.setDataCompra(rset.getDate("DataCompra"));
            carroEcontrado.setAnoModelo(rset.getInt("AnoModelo"));
            carroEcontrado.setAnoFabricacao(rset.getInt("AnoFabricacao"));
            carroEcontrado.setChassi(rset.getString("Chassi"));
            carroEcontrado.setKmRodados(rset.getInt("KmRodados"));
            carroEcontrado.setValorMercado(rset.getFloat("ValorMercado"));
            carroEcontrado.setValorSeguro(rset.getFloat("ValorSeguro"));
            carroEcontrado.setValorKmRd(rset.getFloat("ValorKmRd"));
            carroEcontrado.setValorDiariaLoc(rset.getFloat("ValorDiariaLoc"));
            carroEcontrado.setStatus(rset.getInt("Status"));
            carroEcontrado.setInativo(rset.getInt("Inativo"));
            carroEcontrado.setId_colaborador(rset.getInt("Id_colaborador"));
            

     
            
            //ClsCarros incremento = new ClsCarros(carroEcontrado);
            retorno = "Carro Encontrado!";
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
        
        return carroEcontrado;
    }
    public List<ClsCarros> select() {
        
        List<ClsCarros> carros = new ArrayList<ClsCarros>();
        
        String sql = "SELECT id, Nome, Marca, Modelo, Classe, TipoVeiculo, Cor, "
                + "Placa, Renavam, ObsEstado,DataCompra,AnoModelo,AnoFabricacao, "
                + "Chassi, KmRodados, ValorMercado, ValorSeguro, ValorKmRd,"
                + "ValorDiariaLoc, Status, Inativo, id_colaborador 	"
                + "FROM carros";
       
        ClsCarros carroEcontrado = null;    
        
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            conn = ConexaoDAO.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            rset = ps.executeQuery();
            while(rset.next()){
            carroEcontrado.setId(rset.getInt("Id"));
            carroEcontrado.setNome(rset.getString("Nome"));
            carroEcontrado.setMarca(rset.getString("Marca"));
            carroEcontrado.setModelo(rset.getString("Modelo"));
            carroEcontrado.setClasse(rset.getString("Classe"));
            carroEcontrado.setTipoVeiculo(rset.getString("TipoVeiculo"));
            carroEcontrado.setCor(rset.getString("Cor"));
            carroEcontrado.setPlaca(rset.getString("Placa"));
            carroEcontrado.setRenavam(rset.getInt("Renavam"));
            carroEcontrado.setObsEstado(rset.getString("ObsEstado"));
            carroEcontrado.setDataCompra(rset.getDate("DataCompra"));
            carroEcontrado.setAnoModelo(rset.getInt("AnoModelo"));
            carroEcontrado.setAnoFabricacao(rset.getInt("AnoFabricacao"));
            carroEcontrado.setChassi(rset.getString("Chassi"));
            carroEcontrado.setKmRodados(rset.getInt("KmRodados"));
            carroEcontrado.setValorMercado(rset.getFloat("ValorMercado"));
            carroEcontrado.setValorSeguro(rset.getFloat("ValorSeguro"));
            carroEcontrado.setValorKmRd(rset.getFloat("ValorKmRd"));
            carroEcontrado.setValorDiariaLoc(rset.getFloat("ValorDiariaLoc"));
            carroEcontrado.setStatus(rset.getInt("Status"));
            carroEcontrado.setInativo(rset.getInt("Inativo"));
            carroEcontrado.setId_colaborador(rset.getInt("Id_colaborador"));
            carros.add(carroEcontrado);
            }
            retorno = "Carro Encontrado!";
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
        
        return carros;
    }

    
    
}

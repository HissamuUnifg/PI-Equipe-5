
package models;

/**
 *
 * @author Tiago Teixeira
 */
public class ClsCidades {
    protected int IdCidade;
    protected String NomeCidade;
    protected String SiglaEstado;
    protected String Estado;
    protected String Pais;

    
    public ClsCidades() {
    
    }
    
    public ClsCidades(int id, String NomeCidade, String SiglaEstado, String Estado, String Pais) {
        this.IdCidade = id;
        this.NomeCidade = NomeCidade;
        this.SiglaEstado = SiglaEstado;
        this.Estado = Estado;
        this.Pais = Pais;
    }
    
    public int getIdCidade() {
        return IdCidade;
    }

    public void setIdCidade(int id_end) {
        this.IdCidade = id_end;
    }

    
        

    public String getNomeCidade() {
        return NomeCidade;
    }

    public void setNomeCidade(String NomeCidade) {
        this.NomeCidade = NomeCidade;
    }

    public String getSiglaEstado() {
        return SiglaEstado;
    }

    public void setSiglaEstado(String SiglaEstado) {
        this.SiglaEstado = SiglaEstado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }
}

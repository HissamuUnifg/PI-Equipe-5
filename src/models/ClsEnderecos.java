
package models;

/**
 *
 * @author Tiago Teixeira
 */
public class ClsEnderecos extends ClsCidades {
    protected int Id;
    protected String Rua;
    protected String Numero;
    protected String Bairro;
    protected String TipoEndereco;
    protected String Referencia;
    protected String Cep;
    protected  int Id_cidade;
    protected  int idCliente;
                 
    
    public ClsEnderecos() {
    }


    
    public ClsEnderecos(int Id, String Rua, String Numero, String Bairro, int Id_cidade) {
        this.Id = Id;
        this.Rua = Rua;
        this.Numero = Numero;
        this.Bairro = Bairro;
        this.Id_cidade = Id_cidade;
                 
    }
      
       

    public int getId() {
        return Id;
    }


    public void setId(int Id) {
        this.Id = Id;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }
    
    public String getTipoEndereco() {
        return TipoEndereco;
    }

    public void setTipoEndereco(String TipoEndereco) {
        this.TipoEndereco = TipoEndereco;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }
    
    
    
    public int getId_cidade() {
        return Id_cidade;
    }

    public void setId_cidade(int Id_cidade) {
        this.Id_cidade = Id_cidade;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
}

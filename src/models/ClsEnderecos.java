
package models;

/**
 *
 * @author Tiago Teixeira
 */
public class ClsEnderecos   {
    private int Id;
    private String Rua;
    private String Numero;
    private String Bairro;
    private  int Id_cidade;
                    
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

    public int getId_cidade() {
        return Id_cidade;
    }

    public void setId_cidade(int Id_cidade) {
        this.Id_cidade = Id_cidade;
    }
}

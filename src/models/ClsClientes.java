
package models;

/**
 *
 * @author Tiago Teixeira
 */
public class ClsClientes extends ClsUsuarios{
   
    protected String cnpj;
    protected String rg;
    protected String ie;
    protected String cnh;
    protected String celular;
    protected String Email;
    protected String Observacoes;

    @Override   
    public boolean isValido() {
        return valido;
    }
    
    public void cleanClientes() {
        this.id = 0;
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.cnpj = "";
        this.rg = "";
        this.ie = "";
        this.cnh = "";
        this.celular = "";
        this.Email = "";
        this.Observacoes = "";
    
    }

    public ClsClientes( int id, String nome, String nomeLogin, String cpf, String telefone,
                        String cnpj, String rg, String ie, String cnh, String celular,
                        String Email, String Observacoes) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.rg = rg;
        this.ie = ie;
        this.cnh = cnh;
        this.celular = celular;
        this.Email = Email;
        this.Observacoes = Observacoes;
    }

    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        models.ClsValidacoes clsvalidacoes = new models.ClsValidacoes();
        String cnpj_reformatado = clsvalidacoes.replaceDado(cnpj);
        this.valido = clsvalidacoes.isValid(cnpj_reformatado);
        if (valido == true) {
            this.cnpj = cnpj_reformatado;
        }else{
            this.valido = false;
        }

    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }
    
}

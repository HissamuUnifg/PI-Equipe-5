
package models;



/**
 *
 * @author Tiago Teixeira
 */
public class ClsClientes extends ClsUsuarios{
   
    private String cnpj;
    private String RazaoSocial;
    private String rg;
    private String ie;
    private String cnh;
    private String celular;
    private String Email; 
    private String Observacoes; 
    private String DataNascimento;
    private int idColaborador;
    private int Inativo;

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
           ClsValidacoes clsval = new ClsValidacoes(); 
           this.DataNascimento = clsval.dataFormatoBR(DataNascimento);
    }


    
    public  void cleanClientes(ClsClientes clsCli, ClsEnderecos clsEnd) {
        clsCli.id = 0;
        clsCli.nome = "";
        clsCli.cpf = "";
        clsCli.telefone = "";
        clsCli.cnpj = "";
        clsCli.rg = "";
        clsCli.ie = "";
        clsCli.cnh = "";
        clsCli.celular = "";
        clsCli.Email = "";
        clsCli.Observacoes = "";
        clsCli.RazaoSocial = "";
        clsCli.DataNascimento = "";
        clsEnd.cleanEnd(clsEnd);
    }

    public ClsClientes( int id, String nome, String nomeLogin, String cpf, String telefone,
                        String cnpj, int rg, String ie, String cnh, String celular,
                        String Email, String Observacoes, String RazaoSocial, String DataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.rg = "";
        this.ie = "";
        this.cnh = cnh;
        this.celular = celular;
        this.Email = Email;
        this.Observacoes = Observacoes;
        this.RazaoSocial = RazaoSocial;
        this.DataNascimento = DataNascimento;
    }
    
    public ClsClientes() {
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    
    public int getInativo() {
        return Inativo;
    }

    public void setInativo(int Inativo) {
        this.Inativo = Inativo;
    }
    
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;       
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


package models;



/**
 *
 * @author Tiago Teixeira
 */
public class ClsClientes extends ClsUsuarios{
   
    private String cnpj;
    private String RazaoSocial;
    private int rg;
    private int ie;
    private int cnh;
    private String celular;
    private String Email; //null
    private String Observacoes; //null
    private String DataNascimento;
    private int idEndereco;
    private int idColaborador;
    private int Inativo;

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public String getDataNascimento() {
        ClsValidacoes clsval = new ClsValidacoes();
        return clsval.dataFormatoBR(DataNascimento);
    }

    public void setDataNascimento(String DataNascimento) {
//        ClsValidacoes clsval = new ClsValidacoes();
//        this.DataNascimento = clsval.dataFormatoUS(DataNascimento);   
           this.DataNascimento = DataNascimento;
    }

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
        this.rg = 0;
        this.ie = 0;
        this.cnh = 0;
        this.celular = "";
        this.Email = "";
        this.Observacoes = "";
        this.RazaoSocial = "";
        this.DataNascimento = "";
    
    }

    public ClsClientes( int id, String nome, String nomeLogin, String cpf, String telefone,
                        String cnpj, int rg, int ie, int cnh, String celular,
                        String Email, String Observacoes, String RazaoSocial, String DataNascimento) {
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
        ClsValidacoes clsvalidacoes = new ClsValidacoes();
        String cnpj_reformatado = clsvalidacoes.replaceDado(cnpj);
        this.valido = clsvalidacoes.isValid(cnpj_reformatado);
        if (valido == true) {
            this.cnpj = cnpj_reformatado;
        }else{
            this.valido = false;
        }

    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    
    
    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getIe() {
        return ie;
    }

    public void setIe(int ie) {
        this.ie = ie;
    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
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

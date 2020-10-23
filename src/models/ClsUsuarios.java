
package models;

/**
 *  
 * @author Tiago Teixeira
 */
public class ClsUsuarios {
    protected int id;
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected boolean valido;
    protected String Cpf_funCadastro;

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getCpf_funCadastro() {
        return Cpf_funCadastro;
    }

    public void setCpf_funCadastro(String Cpf_funCadastro) {
        this.Cpf_funCadastro = Cpf_funCadastro;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
     models.ClsValidacoes clsvalidacoes = new models.ClsValidacoes();
        String cpf_reformatado = clsvalidacoes.replaceDado(cpf);
        valido = clsvalidacoes.isValid(cpf_reformatado);
        if (valido == true) {
            this.cpf = cpf_reformatado;
        }else{
            valido = false;
        }

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}

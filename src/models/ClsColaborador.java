
package models;

/**
 *
 * @author Tiago Teixeira
 */
    public class ClsColaborador extends ClsUsuarios{

        
    private String nomeLogin;
    private String senha;
    private String Cpf_funCadastro;
    
    public String getCpf_funCadastro() {
        return Cpf_funCadastro;
    }

    public void setCpf_funCadastro(String Cpf_funCadastro) {
        this.Cpf_funCadastro = Cpf_funCadastro;
    }
    
    public void setNomeLogin(String nomeLogin_){
        this.nomeLogin = nomeLogin_;
    }
    public void setSenha(String senha_){
        this.senha = senha_;
    }
    
    public String getNomeLogin(){
        return nomeLogin;
    }
    public String getSenha(){
        return senha;
    }
       
    
}

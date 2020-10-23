
package models;

/**
 *
 * @author Tiago Teixeira
 */
    public class ClsColaborador extends ClsUsuarios{

        
    private String nomeLogin;
    private String senha;
    

    public boolean isValido() {
        return valido;
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

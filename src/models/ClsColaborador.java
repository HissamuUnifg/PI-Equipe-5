
package models;

/**
 *
 * @author Tiago Teixeira
 */
    public class ClsColaborador extends ClsUsuarios{

        
    private String nomeLogin;
    private String senha;
   
 
    @Override
    public void setId(int Id){
        this.id = Id;
    }
    @Override
    public void setNome(String nome_){
        this.nome = nome_;
    }
    public void setNomeLogin(String nomeLogin_){
        this.nomeLogin = nomeLogin_;
    }
    public void setSenha(String senha_){
        this.senha = senha_;
    }
    @Override
    public void setTelefone(String fone_){
        this.telefone = fone_;
    }
    @Override
    public void setCpf(String cpf_){
        this.cpf = cpf_;
    }
    
    @Override
    public int getId(){
        return id;
    }
    @Override
    public String getNome(){
        return nome;
    }
    public String getNomeLogin(){
        return nomeLogin;
    }
    public String getSenha(){
        return senha;
    }
    @Override
    public String getTelefone(){
        return telefone;
    }
    @Override
    public String getCpf(){
        return cpf;
    }
    
    
}

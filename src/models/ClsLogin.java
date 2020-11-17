
package models;

/**
 * Class Responsavel pela funcionalidade de login
 * @author Tiago Teixeira
 */
    public class ClsLogin extends ClsColaborador{
    private String usuarioDAO = "Admin";
    private String senhaDAO = "123456";
    private String userLoged;   // responsavel por levar para todo o sistema a informação do usuario logado.
    private String cpfUserLoged; 

    public void ClsLogin(int id, String usuarioDAO, String senhaDAO, String cpfUserLoged, String nivel){
        this.id = id;
        this.usuarioDAO = usuarioDAO;
        this.senhaDAO = senhaDAO;
        this.cpfUserLoged = cpfUserLoged;
        this.nivel = nivel;
    }

    public String getCpfUserLoged() {
        return cpfUserLoged;
    }

    public void setCpfUserLoged(String cpfUserLoged) {
        this.cpfUserLoged = cpfUserLoged;
    }
    
    public String getUsuarioDAO() {
        return usuarioDAO;
    }
    
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setUsuarioDAO(String usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public String getSenhaDAO() {
        return senhaDAO;
    }

    public void setSenhaDAO(String senhaDAO) {
        this.senhaDAO = senhaDAO;
    }
    
    public boolean validarlogin(String usuario, String senha){
        if(usuario.equals(usuarioDAO) && senha.equals(senhaDAO)){
            return true;
        }else{
            return false;
        }
    }
    
    public String getUserLoged(){
        return userLoged;
    }
    public void setUserLoged(String usuario){
        userLoged = usuario;
    }
}

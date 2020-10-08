
package models;

/**
 * Class Responsavel pela funcionalidade de login
 * @author Tiago Teixeira
 */
public class ClsLogin {
    private String usuarioDAO = "Admin";
    private String senhaDAO = "123456";
    private String userLoged;   // responsavel por levar para todo o sistema a informação do usuario logado.
    
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

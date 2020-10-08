/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Tiago Teixeira
 */
    public class ClsColaborador {
    private int id;
    private String nome;
    private String nomeLogin;
    private String senha;
    private String telefone;
    private String cpf;
    
    
    public void setId(int Id){
        id = Id;
    }
    public void setNome(String nome_){
        nome = nome_;
    }
    public void setNomeLogin(String nomeLogin_){
        nomeLogin = nomeLogin_;
    }
    public void setSenha(String senha_){
        senha = senha_;
    }
    public void setTelefone(String fone_){
        telefone = fone_;
    }
    public void setCpf(String cpf_){
        cpf = cpf_;
    }
    
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getNomeLogin(){
        return nomeLogin;
    }
    public String getSenha(){
        return senha;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getCpf(){
        return cpf;
    }
    
    
}

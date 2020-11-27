
package views;

import controls.ConexaoDAO;
import controls.LoginDAO;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import models.ClsLogin;





public class JfrmLogin extends javax.swing.JFrame {
    
    boolean FnLiberaAcesso;
    private boolean loginsucess;
    private boolean usarOffline;
    private String senhaDigitada;
    JfrmContratos cont;
    
    
    ConexaoDAO conn;
    ClsLogin clslogin;
    LoginDAO loginDAO;
    
    public JfrmLogin() {
        FnLiberaAcesso = false;
        initComponents();
        setIcon();
        conn = new ConexaoDAO();
        clslogin = new ClsLogin();
        loginDAO = new LoginDAO();
       
        //loadUser();
        loadUserDB();
        jPassSenha.setEnabled(false);
        jBtnLogin.setEnabled(false);
    }
    /**
     * Caso entre no jFrmLogin como FnLibera acesso True o Sistema troca a função de login 
     * @param FnLiberaAcesso 
     * @param cont 
     */
    public JfrmLogin(boolean FnLiberaAcesso, JfrmContratos cont) {
        this.cont = cont;
        this.FnLiberaAcesso = FnLiberaAcesso;
        conn = new ConexaoDAO();
        clslogin = new ClsLogin();
        loginDAO = new LoginDAO();
        initComponents();
        setIcon();
        //loadUser();
        loadUserDB();
        jPassSenha.setEnabled(false);
        jBtnLogin.setEnabled(false);
    }
    
    private void FnLiberaAcessoFalse() {
        if (jCboUsuario.getSelectedIndex() > 0) {
            senhaDigitada =  new String(jPassSenha.getPassword());
            loginsucess = clslogin.validarlogin(jCboUsuario.getSelectedItem().toString(), senhaDigitada);
            if (loginsucess == true) {
                clslogin.setUserLoged(jCboUsuario.getSelectedItem().toString());
                this.setVisible(false);
                //criando o objeto da tela principal
                views.JfrmPrincipal telaprincipal = new views.JfrmPrincipal(clslogin);
                telaprincipal.show();
            } else {
                JOptionPane.showMessageDialog(this, "Senha ou Usuario Incorretos", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario não selecionado, por favor selecione!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void FnLiberaAcessoTrue() {
        if (jCboUsuario.getSelectedIndex() > 0) {
            senhaDigitada =  new String(jPassSenha.getPassword());
            loginsucess = clslogin.validarlogin(jCboUsuario.getSelectedItem().toString(), senhaDigitada);
            if (loginsucess == true) {
                clslogin.setUserLoged(jCboUsuario.getSelectedItem().toString());
                //passando a informação do usuario gerente para o operador
                cont.JfrmContratosLiberacao(clslogin.getNivel());
                this.setVisible(false);
                
                
            } else {
                JOptionPane.showMessageDialog(this, "Senha ou Usuario Incorretos", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario não selecionado, por favor selecione!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCboUsuario = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jBtnLogin = new javax.swing.JButton();
        jBtnFechar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPassSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login Sistema");
        setName("Login Sistema"); // NOI18N
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/identificador.png"))); // NOI18N
        jLabel1.setText("Usuário");

        jCboUsuario.setMaximumRowCount(20);
        jCboUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jCboUsuario.setToolTipText("Selecione o Usuário");
        jCboUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCboUsuarioKeyPressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/senha.png"))); // NOI18N
        jLabel2.setText("Senha");

        jBtnLogin.setText("Login");
        jBtnLogin.setToolTipText("Clique aqui para fazer o login");
        jBtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLoginActionPerformed(evt);
            }
        });

        jBtnFechar.setText("Fehar");
        jBtnFechar.setToolTipText("Clique aqui para fechar o sistema");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/employee_icon-icons.com_66882.png"))); // NOI18N

        jPassSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPassSenha.setToolTipText("Digite a sua senha!");
        jPassSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPassSenhaFocusLost(evt);
            }
        });
        jPassSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassSenhaActionPerformed(evt);
            }
        });
        jPassSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPassSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jCboUsuario, javax.swing.GroupLayout.Alignment.LEADING, 0, 160, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnLogin)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnFechar))
                            .addComponent(jPassSenha, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPassSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnLogin)
                    .addComponent(jBtnFechar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
       this.setVisible(false);
       System.exit(0);
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jBtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLoginActionPerformed
        if(FnLiberaAcesso){
            FnLiberaAcessoTrue();
        }else{
            FnLiberaAcessoFalse();
        }
    }//GEN-LAST:event_jBtnLoginActionPerformed

    private void jPassSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassSenhaActionPerformed
        jBtnLogin.setEnabled(true);       
    }//GEN-LAST:event_jPassSenhaActionPerformed

    private void jPassSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPassSenhaKeyPressed
        jBtnLogin.setEnabled(true);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (FnLiberaAcesso) {
                FnLiberaAcessoTrue();
            } else {
                FnLiberaAcessoFalse();
            }
        }
    }//GEN-LAST:event_jPassSenhaKeyPressed

    private void jPassSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPassSenhaFocusLost
        senhaDigitada = new String(jPassSenha.getPassword());
        jBtnLogin.setEnabled(true);
        jBtnLogin.requestFocus();
       
    }//GEN-LAST:event_jPassSenhaFocusLost

    private void jCboUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCboUsuarioKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (jCboUsuario.getSelectedIndex() > -1) {
                jPassSenha.setEnabled(true);
                jPassSenha.requestFocus();
                if (usarOffline == true) {
                    loadUser();
                } else {
                    List<ClsLogin> ResultSet = loginDAO.select(jCboUsuario.getSelectedItem().toString());

                    clslogin.ClsLogin(ResultSet.get(0).getId(), jCboUsuario.getSelectedItem().toString(),
                            ResultSet.get(0).getSenhaDAO(), ResultSet.get(0).getCpfUserLoged(), ResultSet.get(0).getNivel());
                }
            }
        }
    }//GEN-LAST:event_jCboUsuarioKeyPressed

  
               

 
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnLogin;
    private javax.swing.JComboBox<String> jCboUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPassSenha;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/business_man.png")));
    }

    private void loadUser() {
        jCboUsuario.addItem("Admin");
        clslogin.setNivel("GERENTE");
        
    }

    private void loadUserDB() {
        try {
            List<models.ClsLogin> ResultSet = loginDAO.selectFull();
            if (ResultSet.size() < 1) {
                loadUser();
                JOptionPane.showMessageDialog(this, "Banco de Dados não configurado, passando usuario mestre para login!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                for (models.ClsLogin cls : loginDAO.selectFull()) {
                    jCboUsuario.addItem(cls.getUsuarioDAO());
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Banco de Dados não configurado, passando usuario mestre para login!", "ERRO", JOptionPane.ERROR_MESSAGE);
            loadUser();
            usarOffline = true;
        }

    }
}

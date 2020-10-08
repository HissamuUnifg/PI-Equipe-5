
package telas;

import java.awt.Toolkit;
import javax.swing.JOptionPane;



public class JfrmLogin extends javax.swing.JFrame {

    private boolean loginsucess;
    public JfrmLogin() {
        initComponents();
        setIcon();
        loadUser();
        jPassSenha.enable(false);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Sistema");
        setName("Login Sistema"); // NOI18N
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/identificador.png"))); // NOI18N
        jLabel1.setText("Usuário");

        jCboUsuario.setMaximumRowCount(20);
        jCboUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jCboUsuario.setToolTipText("Selecione o Usuário");
        jCboUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCboUsuarioItemStateChanged(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/senha.png"))); // NOI18N
        jLabel2.setText("Senha");

        jBtnLogin.setText("Login");
        jBtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLoginActionPerformed(evt);
            }
        });

        jBtnFechar.setText("Fehar");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/employee_icon-icons.com_66882.png"))); // NOI18N

        jPassSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPassSenha.setToolTipText("Digite a sua senha!");

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
     
       if(jCboUsuario.getSelectedIndex() > 0){
           models.ClsLogin clslogin = new models.ClsLogin();
       loginsucess = clslogin.validarlogin(jCboUsuario.getSelectedItem().toString(), new String(jPassSenha.getPassword()));
       if(loginsucess == true){
           clslogin.setUserLoged(jCboUsuario.getSelectedItem().toString());
           this.setVisible(false);
           //criando o objeto da tela principal
           telas.JfrmPrincipal telaprincipal = new telas.JfrmPrincipal(clslogin);
           telaprincipal.show();
       }else{
           JOptionPane.showMessageDialog(this, "Senha ou Usuario Incorretos", "ERRO", JOptionPane.ERROR_MESSAGE);
       }
       }else{
           JOptionPane.showMessageDialog(this, "Usuario não selecionado, por favor selecione!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
       }
       
       
       
    }//GEN-LAST:event_jBtnLoginActionPerformed

    private void jCboUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCboUsuarioItemStateChanged
      jPassSenha.enable(true);
    }//GEN-LAST:event_jCboUsuarioItemStateChanged

  
               

 
 

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
    }
}

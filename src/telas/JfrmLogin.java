
package telas;



public class JfrmLogin extends javax.swing.JFrame {

    
    public JfrmLogin() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCboUsuario = new javax.swing.JComboBox<>();
        jTxtSenha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBtnLogin = new javax.swing.JButton();
        jBtnFechar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Sistema");
        setName("Login Sistema"); // NOI18N
        setResizable(false);

        jLabel1.setText("Usuário");

        jCboUsuario.setMaximumRowCount(20);
        jCboUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jCboUsuario.setToolTipText("Selecione o Usuário");

        jTxtSenha.setText("Inserir Senha");
        jTxtSenha.setAutoscrolls(false);
        jTxtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtSenhaActionPerformed(evt);
            }
        });

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
                            .addComponent(jCboUsuario, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnLogin)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnFechar))
                            .addComponent(jTxtSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnLogin)
                    .addComponent(jBtnFechar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtSenhaActionPerformed
        // TODO add your handling code here:
        jTxtSenha.setEditable(false);
    }//GEN-LAST:event_jTxtSenhaActionPerformed

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
       this.setVisible(false);
       System.exit(0);
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jBtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLoginActionPerformed
       this.setVisible(false);
       
       //criando o objeto da tela principal
       telas.JfrmPrincipal telaprincipal = new telas.JfrmPrincipal();
       telaprincipal.show();
    }//GEN-LAST:event_jBtnLoginActionPerformed

 
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnLogin;
    private javax.swing.JComboBox<String> jCboUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTxtSenha;
    // End of variables declaration//GEN-END:variables
}

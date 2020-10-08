
package telas;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago Teixeira
 */
public class JfrmColaborador extends javax.swing.JFrame {

    models.ClsColaborador clscolaborador = new models.ClsColaborador();
    DAO.ColaboradorDAO colaboradorDAO = new DAO.ColaboradorDAO();

    public JfrmColaborador() {
        initComponents();
        getIcon();
        disableControls();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbtnExcluir = new javax.swing.JButton();
        JbtnBuscar = new javax.swing.JButton();
        JbtnSalvar = new javax.swing.JButton();
        JbtnEditar = new javax.swing.JButton();
        JbtnNovo = new javax.swing.JButton();
        JpanDadosGerais = new javax.swing.JPanel();
        jTxtNome = new javax.swing.JTextField();
        jTxtCpf = new javax.swing.JTextField();
        jTxtNmlogin = new javax.swing.JTextField();
        jTxtFone = new javax.swing.JTextField();
        jTxtSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Colaboraores");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_121907.png"))); // NOI18N
        JbtnExcluir.setToolTipText("Clique aqui para excluir Colaborador");
        JbtnExcluir.setBorder(null);
        JbtnExcluir.setFocusPainted(false);

        JbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search_121759.png"))); // NOI18N
        JbtnBuscar.setToolTipText("Clique aqui para buscar Colaborador usando o seu CPF");
        JbtnBuscar.setBorder(null);
        JbtnBuscar.setFocusPainted(false);

        JbtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_121760.png"))); // NOI18N
        JbtnSalvar.setToolTipText("Clique aqui para salvar Colaborador");
        JbtnSalvar.setBorder(null);
        JbtnSalvar.setFocusPainted(false);
        JbtnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnSalvarMouseClicked(evt);
            }
        });

        JbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new_121792.png"))); // NOI18N
        JbtnEditar.setToolTipText("Clique aqui para editar Colaborador");
        JbtnEditar.setBorder(null);
        JbtnEditar.setFocusPainted(false);

        JbtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); // NOI18N
        JbtnNovo.setToolTipText("Clique aqui para novo Colaborador");
        JbtnNovo.setBorder(null);
        JbtnNovo.setFocusPainted(false);
        JbtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnNovoActionPerformed(evt);
            }
        });

        JpanDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        jTxtNome.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNome.setToolTipText("Digite o nome completo do colaborador");
        jTxtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));
        jTxtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtNomeFocusLost(evt);
            }
        });
        jTxtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtNomeKeyPressed(evt);
            }
        });

        jTxtCpf.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCpf.setToolTipText("Digite o CPF do colaborador");
        jTxtCpf.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF"));
        jTxtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtCpfFocusLost(evt);
            }
        });

        jTxtNmlogin.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNmlogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNmlogin.setToolTipText("Digite o nomedo login do colaborador");
        jTxtNmlogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome Login"));
        jTxtNmlogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtNmloginFocusLost(evt);
            }
        });

        jTxtFone.setBackground(new java.awt.Color(240, 240, 240));
        jTxtFone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtFone.setToolTipText("Digite o Telefone do colaborador");
        jTxtFone.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone"));
        jTxtFone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtFoneFocusLost(evt);
            }
        });

        jTxtSenha.setBackground(new java.awt.Color(240, 240, 240));
        jTxtSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtSenha.setToolTipText("Digite a senha do colaborador");
        jTxtSenha.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha"));
        jTxtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtSenhaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout JpanDadosGeraisLayout = new javax.swing.GroupLayout(JpanDadosGerais);
        JpanDadosGerais.setLayout(JpanDadosGeraisLayout);
        JpanDadosGeraisLayout.setHorizontalGroup(
            JpanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JpanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jTxtNmlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jTxtFone))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpanDadosGeraisLayout.setVerticalGroup(
            JpanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNmlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/3592854-add-user-business-man-employee-general-human-member-office_107767.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JpanDadosGerais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(JbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JpanDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       telas.JfrmPrincipal telaprincipal = new telas.JfrmPrincipal();
       telaprincipal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void JbtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnNovoActionPerformed
       enableControls();
    }//GEN-LAST:event_JbtnNovoActionPerformed

    private void jTxtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (jTxtNome.getText().length() < 10) {
                JOptionPane.showMessageDialog(this, "O nome está muito pequeno", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            } else {
                clscolaborador.setNome(jTxtNome.getText());
            }
        }
    }//GEN-LAST:event_jTxtNomeKeyPressed

    private void jTxtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtNomeFocusLost
       if (jTxtNome.getText().length() < 10) {
                JOptionPane.showMessageDialog(this, "O nome está muito pequeno", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            } else {
                clscolaborador.setNome(jTxtNome.getText());
            }
    }//GEN-LAST:event_jTxtNomeFocusLost

    private void jTxtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCpfFocusLost
        models.ClsValidacoes clsvalidacoes = new models.ClsValidacoes();
        boolean validado;
        if (jTxtCpf.getText().length() < 11) {
            JOptionPane.showMessageDialog(this, "CPF digitado invalido! Tamanho menor que 11 digitos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            validado = clsvalidacoes.isValid(jTxtCpf.getText());
            if (validado == true) {
                clscolaborador.setCpf(jTxtCpf.getText());
            } else {
                JOptionPane.showMessageDialog(this, "CPF digitado invalido!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTxtCpfFocusLost

    private void jTxtNmloginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtNmloginFocusLost
       if(jTxtNmlogin.getText().length() > 15){
           JOptionPane.showMessageDialog(this, "Apelido maior que o permitido!", "ERRO", JOptionPane.ERROR_MESSAGE);
       }else{
           clscolaborador.setNomeLogin(jTxtNmlogin.getText());
       }
    }//GEN-LAST:event_jTxtNmloginFocusLost

    private void jTxtSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtSenhaFocusLost
        if(jTxtSenha.getText().length() > 15){
            JOptionPane.showMessageDialog(this, "Senha muito extensa!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            clscolaborador.setSenha(jTxtSenha.getText());
        }
    }//GEN-LAST:event_jTxtSenhaFocusLost

    private void jTxtFoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFoneFocusLost
        if(jTxtFone.getText().length() < 11){
            JOptionPane.showMessageDialog(this, "Telefone invalido, tamanho inferior ao padrão!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            clscolaborador.setTelefone(jTxtFone.getText());
        }
        
    }//GEN-LAST:event_jTxtFoneFocusLost

    private void JbtnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbtnSalvarMouseClicked
        colaboradorDAO.save(clscolaborador);
        JOptionPane.showMessageDialog(this, colaboradorDAO.getRetorno(), "Informação", JOptionPane.INFORMATION_MESSAGE);
        disableControls();
        JbtnNovo.setEnabled(true);
        JbtnExcluir.setEnabled(true);
        JbtnEditar.setEnabled(true);
        JbtnBuscar.setEnabled(true);
    }//GEN-LAST:event_JbtnSalvarMouseClicked

    /**
     * @param args the command line arguments
     */
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnBuscar;
    private javax.swing.JButton JbtnEditar;
    private javax.swing.JButton JbtnExcluir;
    private javax.swing.JButton JbtnNovo;
    private javax.swing.JButton JbtnSalvar;
    private javax.swing.JPanel JpanDadosGerais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTxtCpf;
    private javax.swing.JTextField jTxtFone;
    private javax.swing.JTextField jTxtNmlogin;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtSenha;
    // End of variables declaration//GEN-END:variables

    private void getIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone_colaborador.png")));
    }

    private void disableControls() {
        //desabilitando os controles jTextBox
        jTxtCpf.setEnabled(false);
        jTxtFone.setEnabled(false);
        jTxtNmlogin.setEnabled(false);
        jTxtNome.setEnabled(false);
        jTxtSenha.setEnabled(false);
        //desabilitando os controles Jbutton
        JbtnSalvar.setEnabled(false);
    }

    private void enableControls() {
        //habilitando os controles apos o clieque no botão novo e editar
        jTxtCpf.setEnabled(true);
        jTxtFone.setEnabled(true);
        jTxtNmlogin.setEnabled(true);
        jTxtNome.setEnabled(true);
        jTxtSenha.setEnabled(true);
        //desabilitando os botes e habilitando apenas o Jbutton salvar
        JbtnNovo.setEnabled(false);
        JbtnExcluir.setEnabled(false);
        JbtnEditar.setEnabled(false);
        JbtnBuscar.setEnabled(false);
        JbtnSalvar.setEnabled(true);
    }
}

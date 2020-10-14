
package telas;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;



/**
 *
 * @author Tiago Teixeira
 */
public class JfrmColaborador extends javax.swing.JFrame {
   
    models.ClsColaborador clscolaborador = new models.ClsColaborador();
    DAO.ColaboradorDAO colaboradorDAO = new DAO.ColaboradorDAO();
    models.ClsMascaraCampos clsMascaraCampos = new models.ClsMascaraCampos();
    models.ClsValidacoes clsValidacoes = new models.ClsValidacoes();
    
    private boolean editando = false;
    
    public JfrmColaborador() throws ParseException {
        initComponents();
        getIcon();
        disableControls(); 
        initMascaraCpfTelefone();
    }
    
    
    private void initMascaraCpfTelefone() throws ParseException {
       // iniciando a mascara com os formatos contidos na classe MascaraCampos//
        try {
           jTxtFone.setFormatterFactory(new DefaultFormatterFactory(clsMascaraCampos.mascaraCelular(jTxtFone))); 
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Possivel caracter que não seja numero inserido" + e+"", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
           jTxtCpf.setFormatterFactory(new DefaultFormatterFactory(clsMascaraCampos.mascaraCpf(jTxtCpf))); 
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Possivel caracter que não seja numero inserido" + e+"", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
       
    }
    private void getIcon() {
        // setando o icone principal do Jframe //
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

    private void clearTextBox() {
        //limpando os TxtBox
        jTxtCpf.setText("");
        jTxtFone.setText("");
        jTxtNmlogin.setText("");
        jTxtNome.setText("");
        jTxtSenha.setText("");
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
        jTxtNmlogin = new javax.swing.JTextField();
        jTxtSenha = new javax.swing.JTextField();
        jTxtCpf = new javax.swing.JFormattedTextField();
        jTxtFone = new javax.swing.JFormattedTextField();
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
        JbtnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnExcluirMouseClicked(evt);
            }
        });

        JbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search_121759.png"))); // NOI18N
        JbtnBuscar.setToolTipText("Clique aqui para buscar Colaborador usando o seu CPF");
        JbtnBuscar.setBorder(null);
        JbtnBuscar.setFocusPainted(false);
        JbtnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnBuscarMouseClicked(evt);
            }
        });

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
        JbtnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnEditarMouseClicked(evt);
            }
        });

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

        jTxtNmlogin.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNmlogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNmlogin.setToolTipText("Digite o nomedo login do colaborador");
        jTxtNmlogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome Login"));
        jTxtNmlogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtNmloginFocusLost(evt);
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

        jTxtCpf.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCpf.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF"));
        jTxtCpf.setToolTipText("Digite o CPF do colaborador");
        jTxtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtCpfFocusLost(evt);
            }
        });
        jTxtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtCpfKeyPressed(evt);
            }
        });

        jTxtFone.setBackground(new java.awt.Color(240, 240, 240));
        jTxtFone.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone"));
        jTxtFone.setToolTipText("Digite o Telefone do colaborador");
        jTxtFone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtFoneFocusLost(evt);
            }
        });
        jTxtFone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtFoneKeyPressed(evt);
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
                    .addComponent(jTxtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jTxtFone))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpanDadosGeraisLayout.setVerticalGroup(
            JpanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtNome)
                    .addComponent(jTxtCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNmlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFone, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
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
                .addContainerGap())
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
       editando = false;
       clearTextBox();
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

    private void JbtnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbtnSalvarMouseClicked
        if (editando == false) {
            colaboradorDAO.save(clscolaborador);
            JOptionPane.showMessageDialog(this, colaboradorDAO.getRetorno(), "Informação", JOptionPane.INFORMATION_MESSAGE);
            disableControls();
            JbtnNovo.setEnabled(true);
            JbtnExcluir.setEnabled(true);
            JbtnEditar.setEnabled(true);
            JbtnBuscar.setEnabled(true);
        }else{
            colaboradorDAO.update(clscolaborador);
            JOptionPane.showMessageDialog(this, colaboradorDAO.getRetorno(), "Informação", JOptionPane.INFORMATION_MESSAGE);
            disableControls();
            JbtnNovo.setEnabled(true);
            JbtnExcluir.setEnabled(true);
            JbtnEditar.setEnabled(true);
            JbtnBuscar.setEnabled(true);
        }
        
        
        
    }//GEN-LAST:event_JbtnSalvarMouseClicked

    private void JbtnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbtnBuscarMouseClicked
        String cpf = JOptionPane.showInputDialog("Digite o CPF para procurar");
                
        for(models.ClsColaborador clb: colaboradorDAO.select(cpf)){
            jTxtNome.setText(clb.getNome());
            clscolaborador.setNome(clb.getNome());
            jTxtCpf.setText(clb.getCpf());
            clscolaborador.setCpf(clb.getCpf());
            jTxtNmlogin.setText(clb.getNomeLogin());
            clscolaborador.setNomeLogin(clb.getNomeLogin());
            jTxtFone.setText(clb.getTelefone());
            clscolaborador.setTelefone(clb.getTelefone());
            jTxtSenha.setText(clb.getSenha());
            clscolaborador.setSenha(clb.getSenha());
            clscolaborador.setId(clb.getId());
            System.out.println(clb.getId());
        }
    }//GEN-LAST:event_JbtnBuscarMouseClicked

    private void JbtnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbtnEditarMouseClicked
       enableControls();
       editando = true;
    }//GEN-LAST:event_JbtnEditarMouseClicked

    private void JbtnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbtnExcluirMouseClicked
        int deletar = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if(deletar == 0){
            colaboradorDAO.delete(clscolaborador.getId());
            clearTextBox();                     
        }
        
    }//GEN-LAST:event_JbtnExcluirMouseClicked

    private void jTxtCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCpfKeyPressed
        boolean validado = clsValidacoes.isValid(clsValidacoes.replaceDado(jTxtCpf.getText()));
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (jTxtCpf.getText().length() < 11) {
                JOptionPane.showMessageDialog(this, "O numero do CPF é invalido, tamanho menor que 11 digitos!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            }
            if (validado == false) {
                JOptionPane.showMessageDialog(this, "O numero do CPF é invalido!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                clscolaborador.setCpf(clsValidacoes.replaceDado(jTxtCpf.getText()));
            }
        }
    }//GEN-LAST:event_jTxtCpfKeyPressed

    private void jTxtFoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFoneKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (jTxtFone.getText().length() < 11) {
                JOptionPane.showMessageDialog(this, "O numero do Celular é invalido, tamanho menor que 11 digitos!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            } else {
                clscolaborador.setTelefone(jTxtFone.getText());
            }
        }
    }//GEN-LAST:event_jTxtFoneKeyPressed

    private void jTxtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCpfFocusLost
        boolean validado = clsValidacoes.isValid(clsValidacoes.replaceDado(jTxtCpf.getText()));
        if (jTxtCpf.getText().length() < 11) {
            JOptionPane.showMessageDialog(this, "O numero do CPF é invalido, tamanho menor que 11 digitos!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
        if (validado == false) {
            JOptionPane.showMessageDialog(this, "O numero do CPF é invalido!", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            clscolaborador.setCpf(clsValidacoes.replaceDado(jTxtCpf.getText()));
        }
    }//GEN-LAST:event_jTxtCpfFocusLost

    private void jTxtFoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFoneFocusLost
        if (jTxtFone.getText().length() < 11) {
            JOptionPane.showMessageDialog(this, "O numero do Celular é invalido, tamanho menor que 11 digitos!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        } else {
            clscolaborador.setTelefone(jTxtFone.getText());
        }
    }//GEN-LAST:event_jTxtFoneFocusLost

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
    private javax.swing.JFormattedTextField jTxtCpf;
    private javax.swing.JFormattedTextField jTxtFone;
    private javax.swing.JTextField jTxtNmlogin;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtSenha;
    // End of variables declaration//GEN-END:variables

 


   
}

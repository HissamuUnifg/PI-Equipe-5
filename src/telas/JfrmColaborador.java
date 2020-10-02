
package telas;

import java.awt.Toolkit;

/**
 *
 * @author Tiago Teixeira
 */
public class JfrmColaborador extends javax.swing.JFrame {


    public JfrmColaborador() {
        initComponents();
       getIcon();
       
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

        JbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new_121792.png"))); // NOI18N
        JbtnEditar.setToolTipText("Clique aqui para editar Colaborador");
        JbtnEditar.setBorder(null);
        JbtnEditar.setFocusPainted(false);

        JbtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); // NOI18N
        JbtnNovo.setToolTipText("Clique aqui para novo Colaborador");
        JbtnNovo.setBorder(null);
        JbtnNovo.setFocusPainted(false);

        JpanDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        jTxtNome.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNome.setToolTipText("Digite o nome completo do colaborador");
        jTxtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        jTxtCpf.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCpf.setToolTipText("Digite o CPF do colaborador");
        jTxtCpf.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF"));

        jTxtNmlogin.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNmlogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNmlogin.setToolTipText("Digite o nomedo login do colaborador");
        jTxtNmlogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome Login"));

        jTxtFone.setBackground(new java.awt.Color(240, 240, 240));
        jTxtFone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtFone.setToolTipText("Digite o Telefone do colaborador");
        jTxtFone.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone"));

        jTxtSenha.setBackground(new java.awt.Color(240, 240, 240));
        jTxtSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtSenha.setToolTipText("Digite a senha do colaborador");
        jTxtSenha.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha"));

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
}


package telas;

import java.awt.Toolkit;
import java.text.ParseException;
import models.ClsLogin;

/**
 *
 * @author Tiago Teixeira
 */
public class JfrmPrincipal extends javax.swing.JFrame {
    private String userLoged = "";
    public JfrmPrincipal() {
        initComponents();
        setIcon();
        setUserLoged();
    }
    public JfrmPrincipal(ClsLogin clslogin) {
       userLoged = clslogin.getUserLoged();
       initComponents();
       setIcon();
       setUserLoged();
    }
   
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JlbUserLoged = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenuClientes = new javax.swing.JMenu();
        jMenuCadastroCli = new javax.swing.JMenuItem();
        jMenuPatriVeicu = new javax.swing.JMenu();
        jMenuCadMovVeic = new javax.swing.JMenuItem();
        jMenuContratLoc = new javax.swing.JMenu();
        jMenuCadMovCont = new javax.swing.JMenuItem();
        jMenuColaboradores = new javax.swing.JMenu();
        jMenuCadColab = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal - Locadora App");
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(1170, 850));
        setSize(new java.awt.Dimension(1170, 850));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Frota3.jpg"))); // NOI18N
        jLabel1.setText("Locadora App Release 1.0");
        jLabel1.setToolTipText("");
        jLabel1.setFocusable(false);

        JlbUserLoged.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(JlbUserLoged, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(JlbUserLoged)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1171, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("jLabel2");

        jMenuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_menu_clientes.png"))); // NOI18N
        jMenuClientes.setText("Clientes");

        jMenuCadastroCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_menu_clientes.png"))); // NOI18N
        jMenuCadastroCli.setText("Cadastro");
        jMenuCadastroCli.setToolTipText("");
        jMenuCadastroCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroCliActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuCadastroCli);

        jMenuBar2.add(jMenuClientes);

        jMenuPatriVeicu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_menu_carro.png"))); // NOI18N
        jMenuPatriVeicu.setText("Patrimônios Veiculos");
        jMenuPatriVeicu.setToolTipText("");

        jMenuCadMovVeic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_veiculo.png"))); // NOI18N
        jMenuCadMovVeic.setText("Cadastro/Movimentação");
        jMenuCadMovVeic.setToolTipText("");
        jMenuCadMovVeic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadMovVeicActionPerformed(evt);
            }
        });
        jMenuPatriVeicu.add(jMenuCadMovVeic);

        jMenuBar2.add(jMenuPatriVeicu);

        jMenuContratLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_menu_contrato.png"))); // NOI18N
        jMenuContratLoc.setText("Contrato Locação");

        jMenuCadMovCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_contrato2.png"))); // NOI18N
        jMenuCadMovCont.setText("Cadastro/Movimentação");
        jMenuCadMovCont.setToolTipText("");
        jMenuCadMovCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadMovContActionPerformed(evt);
            }
        });
        jMenuContratLoc.add(jMenuCadMovCont);

        jMenuBar2.add(jMenuContratLoc);

        jMenuColaboradores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_menu_colaborador.png"))); // NOI18N
        jMenuColaboradores.setText("Colaboradores");

        jMenuCadColab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Icone_colaborador.png"))); // NOI18N
        jMenuCadColab.setText("Cadastro");
        jMenuCadColab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadColabActionPerformed(evt);
            }
        });
        jMenuColaboradores.add(jMenuCadColab);

        jMenuBar2.add(jMenuColaboradores);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadastroCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroCliActionPerformed
        telas.JfrmClientes telaclientes = new telas.JfrmClientes();
        this.setVisible(false);
        telaclientes.show();
    }//GEN-LAST:event_jMenuCadastroCliActionPerformed

    private void jMenuCadColabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadColabActionPerformed
        telas.JfrmColaborador telacolaborador = new telas.JfrmColaborador();
        this.setVisible(false);
        telacolaborador.show();
    }//GEN-LAST:event_jMenuCadColabActionPerformed

    private void jMenuCadMovVeicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadMovVeicActionPerformed
       telas.JfrmVeiculos telaveiculos = new telas.JfrmVeiculos();
       this.setVisible(false);
       telaveiculos.show();
    }//GEN-LAST:event_jMenuCadMovVeicActionPerformed

    private void jMenuCadMovContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadMovContActionPerformed
        telas.JfrmContratos telacontrato = new telas.JfrmContratos();
        this.setVisible(false);
        telacontrato.show();
    }//GEN-LAST:event_jMenuCadMovContActionPerformed


    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlbUserLoged;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuCadColab;
    private javax.swing.JMenuItem jMenuCadMovCont;
    private javax.swing.JMenuItem jMenuCadMovVeic;
    private javax.swing.JMenuItem jMenuCadastroCli;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenu jMenuColaboradores;
    private javax.swing.JMenu jMenuContratLoc;
    private javax.swing.JMenu jMenuPatriVeicu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone_menu_carro.png")));
    }

    private void setUserLoged() {
        JlbUserLoged.setText("Seja bem vindo " + userLoged); 
    }
   
}

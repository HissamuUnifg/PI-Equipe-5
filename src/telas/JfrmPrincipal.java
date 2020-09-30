
package telas;
/**
 *
 * @author Tiago Teixeira
 */
public class JfrmPrincipal extends javax.swing.JFrame {

public boolean ativo = true;
    public JfrmPrincipal() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        setPreferredSize(new java.awt.Dimension(848, 490));
        setResizable(false);
        setSize(new java.awt.Dimension(848, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Frota2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jMenuClientes.setText("Clientes");

        jMenuCadastroCli.setText("Cadastro");
        jMenuCadastroCli.setToolTipText("");
        jMenuCadastroCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroCliActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuCadastroCli);

        jMenuBar2.add(jMenuClientes);

        jMenuPatriVeicu.setText("Patrimonios Veiculos");
        jMenuPatriVeicu.setToolTipText("");

        jMenuCadMovVeic.setText("Cadastro/Movimentação");
        jMenuCadMovVeic.setToolTipText("");
        jMenuCadMovVeic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadMovVeicActionPerformed(evt);
            }
        });
        jMenuPatriVeicu.add(jMenuCadMovVeic);

        jMenuBar2.add(jMenuPatriVeicu);

        jMenuContratLoc.setText("Contrato Locação");

        jMenuCadMovCont.setText("Cadastro/Movimentação");
        jMenuCadMovCont.setToolTipText("");
        jMenuCadMovCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadMovContActionPerformed(evt);
            }
        });
        jMenuContratLoc.add(jMenuCadMovCont);

        jMenuBar2.add(jMenuContratLoc);

        jMenuColaboradores.setText("Colaboradores");

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
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadastroCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroCliActionPerformed
        telas.JfrmClientes telaclientes = new telas.JfrmClientes();
        this.setVisible(false);
        ativo = false;
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
    private javax.swing.JLabel jLabel1;
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
    // End of variables declaration//GEN-END:variables
   
}

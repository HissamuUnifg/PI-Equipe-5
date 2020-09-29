
package telas;

/**
 *
 * @author Tiago Teixeira
 */
public class JfrmPrincipal extends javax.swing.JFrame {


    public JfrmPrincipal() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        jMenuClientes.setText("Clientes");

        jMenuCadastroCli.setText("Cadastro");
        jMenuCadastroCli.setToolTipText("");
        jMenuClientes.add(jMenuCadastroCli);

        jMenuBar2.add(jMenuClientes);

        jMenuPatriVeicu.setText("Patrimonios Veiculos");
        jMenuPatriVeicu.setToolTipText("");

        jMenuCadMovVeic.setText("Cadastro/Movimentação");
        jMenuCadMovVeic.setToolTipText("");
        jMenuPatriVeicu.add(jMenuCadMovVeic);

        jMenuBar2.add(jMenuPatriVeicu);

        jMenuContratLoc.setText("Contrato Locação");

        jMenuCadMovCont.setText("Cadastro/Movimentação");
        jMenuCadMovCont.setToolTipText("");
        jMenuContratLoc.add(jMenuCadMovCont);

        jMenuBar2.add(jMenuContratLoc);

        jMenuColaboradores.setText("Colaboradores");

        jMenuCadColab.setText("Cadastro");
        jMenuColaboradores.add(jMenuCadColab);

        jMenuBar2.add(jMenuColaboradores);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1023, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuCadColab;
    private javax.swing.JMenuItem jMenuCadMovCont;
    private javax.swing.JMenuItem jMenuCadMovVeic;
    private javax.swing.JMenuItem jMenuCadastroCli;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenu jMenuColaboradores;
    private javax.swing.JMenu jMenuContratLoc;
    private javax.swing.JMenu jMenuPatriVeicu;
    // End of variables declaration//GEN-END:variables
   
}

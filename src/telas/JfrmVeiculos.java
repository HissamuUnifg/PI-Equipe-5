
package telas;

/**
 *
 * @author Tiago Teixeira
 */
public class JfrmVeiculos extends javax.swing.JFrame {


    public JfrmVeiculos() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbtnNovo = new javax.swing.JButton();
        JbtnEditar = new javax.swing.JButton();
        JbtnSalvar = new javax.swing.JButton();
        JbtnExcluir = new javax.swing.JButton();
        jPaneDadosGerais = new javax.swing.JPanel();
        jTxtNome = new javax.swing.JTextField();
        jTxtVeiculo = new javax.swing.JTextField();
        jTxtMarca = new javax.swing.JTextField();
        jTxtCor = new javax.swing.JTextField();
        jTxtPlaca = new javax.swing.JTextField();
        jTxtChassi = new javax.swing.JTextField();
        jTxtKm = new javax.swing.JTextField();
        jTxtAnoModelo = new javax.swing.JTextField();
        jTxtAnoFabricacao = new javax.swing.JTextField();
        jCboClasse = new javax.swing.JComboBox<>();
        jCboTipo = new javax.swing.JComboBox<>();
        jDateCompra = new com.toedter.calendar.JDateChooser();
        jTxtNumeroRenavan = new javax.swing.JTextField();
        jTxtObservacoes = new javax.swing.JTextField();
        jLabelCodigo = new javax.swing.JLabel();
        jCkbInativar = new javax.swing.JCheckBox();
        jPanelDadosValores = new javax.swing.JPanel();
        jTxtValorMercado = new javax.swing.JTextField();
        jTxtValorSeguro = new javax.swing.JTextField();
        jTxtValorKmRodado = new javax.swing.JTextField();
        jTxtValorDiaria = new javax.swing.JTextField();
        jPanelBusca = new javax.swing.JPanel();
        jTxtPlacaBusca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro e Movimentação de Veiculos/Patrimonios");
        setPreferredSize(new java.awt.Dimension(1055, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1055, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); // NOI18N
        JbtnNovo.setToolTipText("Clique aqui para novo veiculo");
        JbtnNovo.setBorder(null);
        JbtnNovo.setFocusPainted(false);

        JbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new_121792.png"))); // NOI18N
        JbtnEditar.setToolTipText("Clique aqui para editar veiculo");
        JbtnEditar.setBorder(null);
        JbtnEditar.setFocusPainted(false);

        JbtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_121760.png"))); // NOI18N
        JbtnSalvar.setToolTipText("Clique aqui para salvar veiculo");
        JbtnSalvar.setBorder(null);
        JbtnSalvar.setFocusPainted(false);

        JbtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_121907.png"))); // NOI18N
        JbtnExcluir.setToolTipText("Clique aqui para excluir veiculo");
        JbtnExcluir.setBorder(null);
        JbtnExcluir.setFocusPainted(false);

        jPaneDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"));

        jTxtNome.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNome.setToolTipText("Digite o nome do veiculo");
        jTxtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        jTxtVeiculo.setBackground(new java.awt.Color(240, 240, 240));
        jTxtVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtVeiculo.setToolTipText("Digite o modelo do veiculo");
        jTxtVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Modelo"));

        jTxtMarca.setBackground(new java.awt.Color(240, 240, 240));
        jTxtMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtMarca.setToolTipText("Digite a marca do veiculo");
        jTxtMarca.setBorder(javax.swing.BorderFactory.createTitledBorder("Marca"));

        jTxtCor.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCor.setToolTipText("Digite a cor do veiculo");
        jTxtCor.setBorder(javax.swing.BorderFactory.createTitledBorder("Cor"));

        jTxtPlaca.setBackground(new java.awt.Color(240, 240, 240));
        jTxtPlaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtPlaca.setToolTipText("Digite a placa do veiculo");
        jTxtPlaca.setBorder(javax.swing.BorderFactory.createTitledBorder("Placa"));

        jTxtChassi.setBackground(new java.awt.Color(240, 240, 240));
        jTxtChassi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtChassi.setToolTipText("Digite o numero do chassi do veiculo");
        jTxtChassi.setBorder(javax.swing.BorderFactory.createTitledBorder("Chassi"));

        jTxtKm.setBackground(new java.awt.Color(240, 240, 240));
        jTxtKm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtKm.setToolTipText("Digite a KM rodada do veiculo");
        jTxtKm.setBorder(javax.swing.BorderFactory.createTitledBorder("Km Rodado"));

        jTxtAnoModelo.setBackground(new java.awt.Color(240, 240, 240));
        jTxtAnoModelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtAnoModelo.setToolTipText("Digite ano modelo do veiculo");
        jTxtAnoModelo.setBorder(javax.swing.BorderFactory.createTitledBorder("Ano Modelo"));

        jTxtAnoFabricacao.setBackground(new java.awt.Color(240, 240, 240));
        jTxtAnoFabricacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtAnoFabricacao.setToolTipText("Digite ano fabricação do veiculo");
        jTxtAnoFabricacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Ano Fabricacao"));

        jCboClasse.setBackground(new java.awt.Color(240, 240, 240));
        jCboClasse.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboClasse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCboClasse.setToolTipText("Selecione a classe do veiculo");
        jCboClasse.setBorder(javax.swing.BorderFactory.createTitledBorder("Classe"));

        jCboTipo.setBackground(new java.awt.Color(240, 240, 240));
        jCboTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCboTipo.setToolTipText("Selecione o Tipo de veiculo");
        jCboTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));

        jDateCompra.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Compra"));
        jDateCompra.setToolTipText("Selecione a data da compra do veiculo");

        jTxtNumeroRenavan.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNumeroRenavan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNumeroRenavan.setToolTipText("Digite o numero RENAVAN do veiculo");
        jTxtNumeroRenavan.setBorder(javax.swing.BorderFactory.createTitledBorder("RENAVAN"));

        jTxtObservacoes.setBackground(new java.awt.Color(240, 240, 240));
        jTxtObservacoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtObservacoes.setToolTipText("Digite breve observação sobre o veiculo");
        jTxtObservacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações/Estado"));

        javax.swing.GroupLayout jPaneDadosGeraisLayout = new javax.swing.GroupLayout(jPaneDadosGerais);
        jPaneDadosGerais.setLayout(jPaneDadosGeraisLayout);
        jPaneDadosGeraisLayout.setHorizontalGroup(
            jPaneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jCboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCboClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPaneDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jTxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtKm, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPaneDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jTxtNumeroRenavan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtObservacoes)))
                .addContainerGap())
        );
        jPaneDadosGeraisLayout.setVerticalGroup(
            jPaneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneDadosGeraisLayout.createSequentialGroup()
                .addGroup(jPaneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPaneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPaneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNumeroRenavan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabelCodigo.setText("Codigo:");
        jLabelCodigo.setToolTipText("");

        jCkbInativar.setText("Inativar");
        jCkbInativar.setToolTipText("Clique aqui para inativar o veiculo");

        jPanelDadosValores.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Valores"));

        jTxtValorMercado.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorMercado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorMercado.setToolTipText("Digite valor de mercado do veiculo");
        jTxtValorMercado.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Mercado/Bem"));

        jTxtValorSeguro.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorSeguro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorSeguro.setToolTipText("Digite o valor do seguro anual do veiculo");
        jTxtValorSeguro.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Seguro"));

        jTxtValorKmRodado.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorKmRodado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorKmRodado.setToolTipText("Digite o valor de cada KM rodado do veiculo");
        jTxtValorKmRodado.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Km Rodado"));

        jTxtValorDiaria.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorDiaria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorDiaria.setToolTipText("Digite o valor da diária do veiculo");
        jTxtValorDiaria.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Diaria"));

        jPanelBusca.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Placa"));

        jTxtPlacaBusca.setBackground(new java.awt.Color(240, 240, 240));
        jTxtPlacaBusca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtPlacaBusca.setToolTipText("Digite a placa para realizar a busca");
        jTxtPlacaBusca.setBorder(javax.swing.BorderFactory.createTitledBorder("Placa "));

        jButton1.setText("Localizar");

        javax.swing.GroupLayout jPanelBuscaLayout = new javax.swing.GroupLayout(jPanelBusca);
        jPanelBusca.setLayout(jPanelBuscaLayout);
        jPanelBuscaLayout.setHorizontalGroup(
            jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTxtPlacaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanelBuscaLayout.setVerticalGroup(
            jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscaLayout.createSequentialGroup()
                .addGroup(jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtPlacaBusca, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Modelo", "Placa", "Marca", "Cor", "Tipo", "Classe", "Ano Modelo", "Ano Fabricacao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setToolTipText("Selecione e use as feramentas da parte superior da tela");
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Patrimonios/Veiculos Cadastrados");

        javax.swing.GroupLayout jPanelDadosValoresLayout = new javax.swing.GroupLayout(jPanelDadosValores);
        jPanelDadosValores.setLayout(jPanelDadosValoresLayout);
        jPanelDadosValoresLayout.setHorizontalGroup(
            jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                        .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtValorMercado)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jTxtValorSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtValorKmRodado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDadosValoresLayout.setVerticalGroup(
            jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                        .addComponent(jPanelBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtValorMercado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtValorSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtValorKmRodado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCkbInativar))
                    .addComponent(jPanelDadosValores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(JbtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(JbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCodigo)
                        .addGap(40, 40, 40))
                    .addComponent(jPaneDadosGerais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jCkbInativar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPaneDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanelDadosValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       telas.JfrmPrincipal telaprincipal = new telas.JfrmPrincipal();
       telaprincipal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnEditar;
    private javax.swing.JButton JbtnExcluir;
    private javax.swing.JButton JbtnNovo;
    private javax.swing.JButton JbtnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCboClasse;
    private javax.swing.JComboBox<String> jCboTipo;
    private javax.swing.JCheckBox jCkbInativar;
    private com.toedter.calendar.JDateChooser jDateCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JPanel jPaneDadosGerais;
    private javax.swing.JPanel jPanelBusca;
    private javax.swing.JPanel jPanelDadosValores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtAnoFabricacao;
    private javax.swing.JTextField jTxtAnoModelo;
    private javax.swing.JTextField jTxtChassi;
    private javax.swing.JTextField jTxtCor;
    private javax.swing.JTextField jTxtKm;
    private javax.swing.JTextField jTxtMarca;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtNumeroRenavan;
    private javax.swing.JTextField jTxtObservacoes;
    private javax.swing.JTextField jTxtPlaca;
    private javax.swing.JTextField jTxtPlacaBusca;
    private javax.swing.JTextField jTxtValorDiaria;
    private javax.swing.JTextField jTxtValorKmRodado;
    private javax.swing.JTextField jTxtValorMercado;
    private javax.swing.JTextField jTxtValorSeguro;
    private javax.swing.JTextField jTxtVeiculo;
    // End of variables declaration//GEN-END:variables
}

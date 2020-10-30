
package views;

import java.awt.Toolkit;
import models.ClsLogin;

/**
 *  
 * @author Tiago Teixeira
 */
public class JfrmContratos extends javax.swing.JFrame {

    private String userLoged;
    private int userIdLoged;
    private String CpfUserLoged;
    
    public JfrmContratos() {
        initComponents();
        setIcon();
    }
    public JfrmContratos(ClsLogin clslogin) {
        userLoged = clslogin.getUserLoged();
        userIdLoged = clslogin.getId();
        CpfUserLoged = clslogin.getCpfUserLoged();
        initComponents();
        setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbtnNovo = new javax.swing.JButton();
        JbtnEditar = new javax.swing.JButton();
        JbtnSalvar = new javax.swing.JButton();
        JbtnImprimir = new javax.swing.JButton();
        JbtnBuscar = new javax.swing.JButton();
        JbtnExcluir = new javax.swing.JButton();
        JbtnRecalcular = new javax.swing.JButton();
        jPanDadosGerais = new javax.swing.JPanel();
        jTxt_rg_ie = new javax.swing.JTextField();
        jTxtCPF_CNPJ = new javax.swing.JTextField();
        jTxtCNH = new javax.swing.JTextField();
        jFtxtFone = new javax.swing.JFormattedTextField();
        jFtxtCelular = new javax.swing.JFormattedTextField();
        jTxtEmail = new javax.swing.JTextField();
        jCboNome = new javax.swing.JComboBox<>();
        jPanelDadosEnderecos = new javax.swing.JPanel();
        jTxtRua = new javax.swing.JTextField();
        jTxtNumero = new javax.swing.JTextField();
        jTxtCEP = new javax.swing.JTextField();
        jTxtBairro = new javax.swing.JTextField();
        jTxtEstado = new javax.swing.JTextField();
        jTxtReferencia = new javax.swing.JTextField();
        jTxtCidade = new javax.swing.JTextField();
        jTxtTipoEnd = new javax.swing.JTextField();
        jPaneDadosVeiculos = new javax.swing.JPanel();
        jTxtNome = new javax.swing.JTextField();
        jTxtMarca = new javax.swing.JTextField();
        jTxtCor = new javax.swing.JTextField();
        jTxtChassi = new javax.swing.JTextField();
        jTxtKm = new javax.swing.JTextField();
        jTxtAnoModelo = new javax.swing.JTextField();
        jTxtAnoFabricacao = new javax.swing.JTextField();
        jTxtNumeroRenavan = new javax.swing.JTextField();
        jTxtVeiculo = new javax.swing.JTextField();
        jCboPlaca = new javax.swing.JComboBox<>();
        jTxtTipo = new javax.swing.JTextField();
        jTxtClasse = new javax.swing.JTextField();
        jPanelDadosValores = new javax.swing.JPanel();
        jTxtValorKmRodado = new javax.swing.JTextField();
        jTxtValorTotal = new javax.swing.JTextField();
        jCboTipoContrato = new javax.swing.JComboBox<>();
        jCboStatusContrato = new javax.swing.JComboBox<>();
        jTxtValorKmFinal = new javax.swing.JTextField();
        jTxtQtdDias = new javax.swing.JTextField();
        jDateSaidaContrato = new com.toedter.calendar.JDateChooser();
        jDateChegada = new com.toedter.calendar.JDateChooser();
        jTextObservacoes = new javax.swing.JTextField();
        jTxtValorDiaria1 = new javax.swing.JTextField();
        jTxtValorExtra = new javax.swing.JTextField();
        jLabelCodigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1055, 640));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); // NOI18N
        JbtnNovo.setToolTipText("Clique aqui para novo Contrato");
        JbtnNovo.setBorder(null);
        JbtnNovo.setFocusPainted(false);

        JbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new_121792.png"))); // NOI18N
        JbtnEditar.setToolTipText("Clique aqui para editar Contrato");
        JbtnEditar.setBorder(null);
        JbtnEditar.setFocusPainted(false);

        JbtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_121760.png"))); // NOI18N
        JbtnSalvar.setToolTipText("Clique aqui para salvar Contrato");
        JbtnSalvar.setBorder(null);
        JbtnSalvar.setFocusPainted(false);

        JbtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print_121773.png"))); // NOI18N
        JbtnImprimir.setToolTipText("Clique aqui para imprimir Contrato");
        JbtnImprimir.setBorder(null);
        JbtnImprimir.setFocusPainted(false);

        JbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search_121759.png"))); // NOI18N
        JbtnBuscar.setToolTipText("Clique aqui para buscar Contrato");
        JbtnBuscar.setBorder(null);
        JbtnBuscar.setFocusPainted(false);

        JbtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_121907.png"))); // NOI18N
        JbtnExcluir.setToolTipText("Clique aqui para excluir Contrato");
        JbtnExcluir.setBorder(null);
        JbtnExcluir.setFocusPainted(false);

        JbtnRecalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rotate_121763.png"))); // NOI18N
        JbtnRecalcular.setToolTipText("Clique aqui para recalcular Contrato");
        JbtnRecalcular.setBorder(null);
        JbtnRecalcular.setFocusPainted(false);

        jPanDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"), "Dados Gerais"));

        jTxt_rg_ie.setBackground(new java.awt.Color(240, 240, 240));
        jTxt_rg_ie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxt_rg_ie.setToolTipText("Exibição do RG ou IE do cliente");
        jTxt_rg_ie.setBorder(javax.swing.BorderFactory.createTitledBorder("RG/IE"));

        jTxtCPF_CNPJ.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCPF_CNPJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCPF_CNPJ.setToolTipText("Exibição do CPF ou CNPJ do cliente");
        jTxtCPF_CNPJ.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF/CNPJ"));

        jTxtCNH.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCNH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCNH.setToolTipText("Exibição do Numero do CNH do cliente");
        jTxtCNH.setBorder(javax.swing.BorderFactory.createTitledBorder("CNH"));

        jFtxtFone.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtFone.setBorder(javax.swing.BorderFactory.createTitledBorder("Fone"));
        jFtxtFone.setToolTipText("Exibição do numero de telefone fixo do cliente");
        jFtxtFone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jFtxtCelular.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtCelular.setBorder(javax.swing.BorderFactory.createTitledBorder("Celular"));
        jFtxtCelular.setToolTipText("Exibição do numero de telefone celular do cliente");
        jFtxtCelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTxtEmail.setBackground(new java.awt.Color(240, 240, 240));
        jTxtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtEmail.setToolTipText("Exibição do Email do Cliente do Cliente");
        jTxtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("E-mail"));

        jCboNome.setBackground(new java.awt.Color(240, 240, 240));
        jCboNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCboNome.setToolTipText("Selecione o cliente para iniciar o contrato");
        jCboNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        javax.swing.GroupLayout jPanDadosGeraisLayout = new javax.swing.GroupLayout(jPanDadosGerais);
        jPanDadosGerais.setLayout(jPanDadosGeraisLayout);
        jPanDadosGeraisLayout.setHorizontalGroup(
            jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jCboNome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jFtxtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jTxtCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jTxt_rg_ie, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jTxtCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTxtEmail))
                .addContainerGap())
        );
        jPanDadosGeraisLayout.setVerticalGroup(
            jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxt_rg_ie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboNome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFtxtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanelDadosEnderecos.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Endereços"));

        jTxtRua.setBackground(new java.awt.Color(240, 240, 240));
        jTxtRua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtRua.setToolTipText("Exibição do nome da rua");
        jTxtRua.setBorder(javax.swing.BorderFactory.createTitledBorder("Rua"));

        jTxtNumero.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNumero.setToolTipText("Exibição do Numero");
        jTxtNumero.setBorder(javax.swing.BorderFactory.createTitledBorder("Numero"));

        jTxtCEP.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCEP.setToolTipText("Exibição do CEP");
        jTxtCEP.setBorder(javax.swing.BorderFactory.createTitledBorder("CEP"));

        jTxtBairro.setBackground(new java.awt.Color(240, 240, 240));
        jTxtBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtBairro.setToolTipText("Exibição do nome do bairro");
        jTxtBairro.setBorder(javax.swing.BorderFactory.createTitledBorder("Bairro"));

        jTxtEstado.setBackground(new java.awt.Color(240, 240, 240));
        jTxtEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtEstado.setToolTipText("Exibição do Estado");
        jTxtEstado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        jTxtReferencia.setBackground(new java.awt.Color(240, 240, 240));
        jTxtReferencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtReferencia.setToolTipText("Exibição da referencia");
        jTxtReferencia.setBorder(javax.swing.BorderFactory.createTitledBorder("Referencia"));

        jTxtCidade.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCidade.setToolTipText("Exibição da cidade ");
        jTxtCidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Cidade"));

        jTxtTipoEnd.setBackground(new java.awt.Color(240, 240, 240));
        jTxtTipoEnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtTipoEnd.setToolTipText("Exibição do tipo de endereço");
        jTxtTipoEnd.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Endereço"));

        javax.swing.GroupLayout jPanelDadosEnderecosLayout = new javax.swing.GroupLayout(jPanelDadosEnderecos);
        jPanelDadosEnderecos.setLayout(jPanelDadosEnderecosLayout);
        jPanelDadosEnderecosLayout.setHorizontalGroup(
            jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosEnderecosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosEnderecosLayout.createSequentialGroup()
                        .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jTxtTipoEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtReferencia))
                    .addGroup(jPanelDadosEnderecosLayout.createSequentialGroup()
                        .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDadosEnderecosLayout.setVerticalGroup(
            jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosEnderecosLayout.createSequentialGroup()
                .addGroup(jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTipoEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPaneDadosVeiculos.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Veiculos"));
        jPaneDadosVeiculos.setFocusable(false);

        jTxtNome.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNome.setToolTipText("Exibição do nome do veiculo");
        jTxtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        jTxtMarca.setBackground(new java.awt.Color(240, 240, 240));
        jTxtMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtMarca.setToolTipText("Exibição da marca do veiculo");
        jTxtMarca.setBorder(javax.swing.BorderFactory.createTitledBorder("Marca"));

        jTxtCor.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCor.setToolTipText("Exibição da cor do veiculo");
        jTxtCor.setBorder(javax.swing.BorderFactory.createTitledBorder("Cor"));

        jTxtChassi.setBackground(new java.awt.Color(240, 240, 240));
        jTxtChassi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtChassi.setToolTipText("Exibição do numero do chassi do veiculo");
        jTxtChassi.setBorder(javax.swing.BorderFactory.createTitledBorder("Chassi"));

        jTxtKm.setBackground(new java.awt.Color(240, 240, 240));
        jTxtKm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtKm.setToolTipText("Exibição do KM rodada do veiculo");
        jTxtKm.setBorder(javax.swing.BorderFactory.createTitledBorder("Km Rodado Atual"));

        jTxtAnoModelo.setBackground(new java.awt.Color(240, 240, 240));
        jTxtAnoModelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtAnoModelo.setToolTipText("Exibição do ano modelo do veiculo");
        jTxtAnoModelo.setBorder(javax.swing.BorderFactory.createTitledBorder("Ano Modelo"));

        jTxtAnoFabricacao.setBackground(new java.awt.Color(240, 240, 240));
        jTxtAnoFabricacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtAnoFabricacao.setToolTipText("Exibição do ano fabricação do veiculo");
        jTxtAnoFabricacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Ano Fabricacao"));

        jTxtNumeroRenavan.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNumeroRenavan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNumeroRenavan.setToolTipText("Exibição do numero RENAVAN do veiculo");
        jTxtNumeroRenavan.setBorder(javax.swing.BorderFactory.createTitledBorder("RENAVAN"));

        jTxtVeiculo.setBackground(new java.awt.Color(240, 240, 240));
        jTxtVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtVeiculo.setToolTipText("Exibição do modelo do veiculo");
        jTxtVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Modelo"));

        jCboPlaca.setBackground(new java.awt.Color(240, 240, 240));
        jCboPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboPlaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCboPlaca.setToolTipText("Selecione a placa do veiculo a ser alugado");
        jCboPlaca.setBorder(javax.swing.BorderFactory.createTitledBorder("Placa"));

        jTxtTipo.setBackground(new java.awt.Color(240, 240, 240));
        jTxtTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtTipo.setToolTipText("Exibição do tipo do veiculo");
        jTxtTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));

        jTxtClasse.setBackground(new java.awt.Color(240, 240, 240));
        jTxtClasse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtClasse.setToolTipText("Exibição da classe do veiculo");
        jTxtClasse.setBorder(javax.swing.BorderFactory.createTitledBorder("Classe"));

        javax.swing.GroupLayout jPaneDadosVeiculosLayout = new javax.swing.GroupLayout(jPaneDadosVeiculos);
        jPaneDadosVeiculos.setLayout(jPaneDadosVeiculosLayout);
        jPaneDadosVeiculosLayout.setHorizontalGroup(
            jPaneDadosVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneDadosVeiculosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPaneDadosVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneDadosVeiculosLayout.createSequentialGroup()
                        .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtKm, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTxtNumeroRenavan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPaneDadosVeiculosLayout.createSequentialGroup()
                        .addComponent(jCboPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPaneDadosVeiculosLayout.setVerticalGroup(
            jPaneDadosVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneDadosVeiculosLayout.createSequentialGroup()
                .addGroup(jPaneDadosVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPaneDadosVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNumeroRenavan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelDadosValores.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Vaores"));

        jTxtValorKmRodado.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorKmRodado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorKmRodado.setToolTipText("Exibição do valor de cada KM rodado desse veiculo");
        jTxtValorKmRodado.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Km Rodado"));

        jTxtValorTotal.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorTotal.setToolTipText("Exibição do valor total calculado para esse contrato");
        jTxtValorTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Total"));

        jCboTipoContrato.setBackground(new java.awt.Color(240, 240, 240));
        jCboTipoContrato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboTipoContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCboTipoContrato.setToolTipText("Selecione o tipo de contrato, escolha entre diaria ou km rodado");
        jCboTipoContrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Contrato"));

        jCboStatusContrato.setBackground(new java.awt.Color(240, 240, 240));
        jCboStatusContrato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboStatusContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCboStatusContrato.setToolTipText("Selecione o status do contrato do cliente");
        jCboStatusContrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Status Contrato"));

        jTxtValorKmFinal.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorKmFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorKmFinal.setToolTipText("Digite o KM rodado no ato da entrega do veiculo");
        jTxtValorKmFinal.setBorder(javax.swing.BorderFactory.createTitledBorder("KM Rodado Final"));

        jTxtQtdDias.setBackground(new java.awt.Color(240, 240, 240));
        jTxtQtdDias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtQtdDias.setToolTipText("Digite a quantidade de dias que será alugado o veiculo");
        jTxtQtdDias.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias Alugados"));

        jDateSaidaContrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Saida/Contrato"));
        jDateSaidaContrato.setToolTipText("Selecione a data de contrato/saida do veiculo");

        jDateChegada.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Chegada"));
        jDateChegada.setToolTipText("Selecione a data de chegada do veiculo");

        jTextObservacoes.setToolTipText("Breve observação caso houver sobre o veiculo");
        jTextObservacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        jTxtValorDiaria1.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorDiaria1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorDiaria1.setToolTipText("Exibição do valor da diária desse veiculo");
        jTxtValorDiaria1.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Diaria"));

        jTxtValorExtra.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorExtra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorExtra.setToolTipText("Campo para digitação de despesas extras, como multas, avarias e etc.");
        jTxtValorExtra.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores Extras"));

        javax.swing.GroupLayout jPanelDadosValoresLayout = new javax.swing.GroupLayout(jPanelDadosValores);
        jPanelDadosValores.setLayout(jPanelDadosValoresLayout);
        jPanelDadosValoresLayout.setHorizontalGroup(
            jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCboTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboStatusContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                        .addComponent(jTxtValorKmRodado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtValorDiaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtValorKmFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateSaidaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                        .addComponent(jTextObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtValorExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChegada, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanelDadosValoresLayout.setVerticalGroup(
            jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtValorKmRodado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCboTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtValorKmFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtValorDiaria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jDateChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateSaidaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCboStatusContrato)
                    .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtValorExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jLabelCodigo.setText("Codigo:");
        jLabelCodigo.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JbtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(JbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JbtnRecalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JbtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCodigo)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanDadosGerais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDadosEnderecos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPaneDadosVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDadosValores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnRecalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCodigo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDadosEnderecos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPaneDadosVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDadosValores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        models.ClsLogin clslogin = new ClsLogin();
        clslogin.setUserLoged(userLoged);
        clslogin.setId(userIdLoged);
        clslogin.setCpfUserLoged(CpfUserLoged);
        views.JfrmPrincipal telaprincipal = new views.JfrmPrincipal(clslogin);
        telaprincipal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnBuscar;
    private javax.swing.JButton JbtnEditar;
    private javax.swing.JButton JbtnExcluir;
    private javax.swing.JButton JbtnImprimir;
    private javax.swing.JButton JbtnNovo;
    private javax.swing.JButton JbtnRecalcular;
    private javax.swing.JButton JbtnSalvar;
    private javax.swing.JComboBox<String> jCboNome;
    private javax.swing.JComboBox<String> jCboPlaca;
    private javax.swing.JComboBox<String> jCboStatusContrato;
    private javax.swing.JComboBox<String> jCboTipoContrato;
    private com.toedter.calendar.JDateChooser jDateChegada;
    private com.toedter.calendar.JDateChooser jDateSaidaContrato;
    private javax.swing.JFormattedTextField jFtxtCelular;
    private javax.swing.JFormattedTextField jFtxtFone;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JPanel jPanDadosGerais;
    private javax.swing.JPanel jPaneDadosVeiculos;
    private javax.swing.JPanel jPanelDadosEnderecos;
    private javax.swing.JPanel jPanelDadosValores;
    private javax.swing.JTextField jTextObservacoes;
    private javax.swing.JTextField jTxtAnoFabricacao;
    private javax.swing.JTextField jTxtAnoModelo;
    private javax.swing.JTextField jTxtBairro;
    private javax.swing.JTextField jTxtCEP;
    private javax.swing.JTextField jTxtCNH;
    private javax.swing.JTextField jTxtCPF_CNPJ;
    private javax.swing.JTextField jTxtChassi;
    private javax.swing.JTextField jTxtCidade;
    private javax.swing.JTextField jTxtClasse;
    private javax.swing.JTextField jTxtCor;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEstado;
    private javax.swing.JTextField jTxtKm;
    private javax.swing.JTextField jTxtMarca;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtNumero;
    private javax.swing.JTextField jTxtNumeroRenavan;
    private javax.swing.JTextField jTxtQtdDias;
    private javax.swing.JTextField jTxtReferencia;
    private javax.swing.JTextField jTxtRua;
    private javax.swing.JTextField jTxtTipo;
    private javax.swing.JTextField jTxtTipoEnd;
    private javax.swing.JTextField jTxtValorDiaria1;
    private javax.swing.JTextField jTxtValorExtra;
    private javax.swing.JTextField jTxtValorKmFinal;
    private javax.swing.JTextField jTxtValorKmRodado;
    private javax.swing.JTextField jTxtValorTotal;
    private javax.swing.JTextField jTxtVeiculo;
    private javax.swing.JTextField jTxt_rg_ie;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone_contrato2.png")));
    }
}

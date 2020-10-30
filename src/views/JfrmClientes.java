
package views;

import java.awt.Toolkit;
import models.ClsLogin;




/**
 *
 * @author Tiago Teixeira
 */
public class JfrmClientes extends javax.swing.JFrame {
   private String userLoged;
   private int userIdLoged;
   private String CpfUserLoged;
    public JfrmClientes() {
        initComponents();
        setIcon();
    }
    public JfrmClientes(ClsLogin clslogin) {
        userLoged = clslogin.getUserLoged();
        userIdLoged = clslogin.getId();
        CpfUserLoged = clslogin.getCpfUserLoged();
        initComponents();
        setIcon();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbtnSalvar = new javax.swing.JButton();
        JbtnNovo = new javax.swing.JButton();
        JbtnExcluir = new javax.swing.JButton();
        JbtnImprimir = new javax.swing.JButton();
        JbtnEditar = new javax.swing.JButton();
        JbtnBuscar = new javax.swing.JButton();
        jPanDadosGerais = new javax.swing.JPanel();
        jTxt_rg_ie = new javax.swing.JTextField();
        jTxtCPF_CNPJ = new javax.swing.JTextField();
        jTxtCNH = new javax.swing.JTextField();
        jCkb_inativar = new javax.swing.JCheckBox();
        jFtxtFone = new javax.swing.JFormattedTextField();
        jFtxtCelular = new javax.swing.JFormattedTextField();
        jTxtEmail = new javax.swing.JTextField();
        jTxtNome = new javax.swing.JTextField();
        jPanelObservacoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextObservacoes = new javax.swing.JTextArea();
        jPanelDadosEnderecos = new javax.swing.JPanel();
        jTxtRua = new javax.swing.JTextField();
        jTxtNumero = new javax.swing.JTextField();
        jCboCidade = new javax.swing.JComboBox<>();
        jTxtCEP = new javax.swing.JTextField();
        jTxtBairro = new javax.swing.JTextField();
        jTxtEstado1 = new javax.swing.JTextField();
        jCboTipoEnd = new javax.swing.JComboBox<>();
        jTxtReferencia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblEnderecos = new javax.swing.JTable();
        jBtn_Adcionar_end = new javax.swing.JButton();
        jBtn_Salvar_End = new javax.swing.JButton();
        jBtn_excluir_end = new javax.swing.JButton();
        jBtn_Editar_End = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setResizable(false);
        setSize(new java.awt.Dimension(1055, 630));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JbtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_121760.png"))); // NOI18N
        JbtnSalvar.setToolTipText("Clique aqui para salvar Cliente");
        JbtnSalvar.setBorder(null);
        JbtnSalvar.setFocusPainted(false);

        JbtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); // NOI18N
        JbtnNovo.setToolTipText("Clique aqui para novo Cliente");
        JbtnNovo.setBorder(null);
        JbtnNovo.setFocusPainted(false);

        JbtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_121907.png"))); // NOI18N
        JbtnExcluir.setToolTipText("Clique aqui para excluir Cliente");
        JbtnExcluir.setBorder(null);
        JbtnExcluir.setFocusPainted(false);

        JbtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print_121773.png"))); // NOI18N
        JbtnImprimir.setToolTipText("Clique aqui para imprimir Cliente");
        JbtnImprimir.setBorder(null);
        JbtnImprimir.setFocusPainted(false);

        JbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new_121792.png"))); // NOI18N
        JbtnEditar.setToolTipText("Clique aqui para editar Cliente");
        JbtnEditar.setBorder(null);
        JbtnEditar.setFocusPainted(false);

        JbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search_121759.png"))); // NOI18N
        JbtnBuscar.setToolTipText("Clique aqui para buscar Cliente");
        JbtnBuscar.setBorder(null);
        JbtnBuscar.setFocusPainted(false);

        jPanDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"), "Dados Gerais"));

        jTxt_rg_ie.setBackground(new java.awt.Color(240, 240, 240));
        jTxt_rg_ie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxt_rg_ie.setToolTipText("Numero do RG ou IE do cliente");
        jTxt_rg_ie.setBorder(javax.swing.BorderFactory.createTitledBorder("RG/IE"));

        jTxtCPF_CNPJ.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCPF_CNPJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCPF_CNPJ.setToolTipText("Numero do CPF ou CNPJ do cliente");
        jTxtCPF_CNPJ.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF/CNPJ"));

        jTxtCNH.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCNH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCNH.setToolTipText("Numero do CNH do cliente");
        jTxtCNH.setBorder(javax.swing.BorderFactory.createTitledBorder("CNH"));

        jCkb_inativar.setText("Inativar");
        jCkb_inativar.setToolTipText("Marque aqui caso deseje Inativar o cliente");

        jFtxtFone.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtFone.setBorder(javax.swing.BorderFactory.createTitledBorder("Fone"));
        jFtxtFone.setToolTipText("Adicione aqui o numero de telefone fixo do cliente");
        jFtxtFone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jFtxtCelular.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtCelular.setBorder(javax.swing.BorderFactory.createTitledBorder("Celular"));
        jFtxtCelular.setToolTipText("Adicione aqui o numero de telefone celular do cliente");
        jFtxtCelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTxtEmail.setBackground(new java.awt.Color(240, 240, 240));
        jTxtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtEmail.setToolTipText("Adicione o Email do Cliente do Cliente");
        jTxtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("E-mail"));

        jTxtNome.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNome.setToolTipText("Nome completo do Cliente");
        jTxtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        javax.swing.GroupLayout jPanDadosGeraisLayout = new javax.swing.GroupLayout(jPanDadosGerais);
        jPanDadosGerais.setLayout(jPanDadosGeraisLayout);
        jPanDadosGeraisLayout.setHorizontalGroup(
            jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jTxtNome)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxt_rg_ie, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jFtxtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtEmail)))
                .addGap(18, 18, 18)
                .addComponent(jCkb_inativar)
                .addContainerGap())
        );
        jPanDadosGeraisLayout.setVerticalGroup(
            jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxt_rg_ie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFtxtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCkb_inativar))
        );

        jPanelObservacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        jTextObservacoes.setColumns(20);
        jTextObservacoes.setRows(5);
        jScrollPane1.setViewportView(jTextObservacoes);

        javax.swing.GroupLayout jPanelObservacoesLayout = new javax.swing.GroupLayout(jPanelObservacoes);
        jPanelObservacoes.setLayout(jPanelObservacoesLayout);
        jPanelObservacoesLayout.setHorizontalGroup(
            jPanelObservacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelObservacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelObservacoesLayout.setVerticalGroup(
            jPanelObservacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelObservacoesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDadosEnderecos.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Endereços"));

        jTxtRua.setBackground(new java.awt.Color(240, 240, 240));
        jTxtRua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtRua.setToolTipText("Nome da rua do cliente");
        jTxtRua.setBorder(javax.swing.BorderFactory.createTitledBorder("Rua"));

        jTxtNumero.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNumero.setToolTipText("Numero da Residencia");
        jTxtNumero.setBorder(javax.swing.BorderFactory.createTitledBorder("Numero"));

        jCboCidade.setBackground(new java.awt.Color(240, 240, 240));
        jCboCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCboCidade.setToolTipText("Selecione a cidade do cliente");
        jCboCidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Cidade"));

        jTxtCEP.setBackground(new java.awt.Color(240, 240, 240));
        jTxtCEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtCEP.setToolTipText("CEP da Residencia");
        jTxtCEP.setBorder(javax.swing.BorderFactory.createTitledBorder("CEP"));

        jTxtBairro.setBackground(new java.awt.Color(240, 240, 240));
        jTxtBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtBairro.setToolTipText("Bairro da Residencia");
        jTxtBairro.setBorder(javax.swing.BorderFactory.createTitledBorder("Bairro"));

        jTxtEstado1.setBackground(new java.awt.Color(240, 240, 240));
        jTxtEstado1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtEstado1.setToolTipText("Estado da Residencia");
        jTxtEstado1.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        jCboTipoEnd.setBackground(new java.awt.Color(240, 240, 240));
        jCboTipoEnd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboTipoEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCboTipoEnd.setToolTipText("Selecione o tipo de endereço do cliente");
        jCboTipoEnd.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Endereço"));

        jTxtReferencia.setBackground(new java.awt.Color(240, 240, 240));
        jTxtReferencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtReferencia.setToolTipText("Breve ponto de referencia");
        jTxtReferencia.setBorder(javax.swing.BorderFactory.createTitledBorder("Referencia"));

        jTblEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Rua", "Numero", "Cidade", "Estado", "Bairro", "CEP", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblEnderecos.setToolTipText("Selecione o endereço para usar as opções");
        jTblEnderecos.setCellSelectionEnabled(true);
        jTblEnderecos.setName(""); // NOI18N
        jScrollPane2.setViewportView(jTblEnderecos);

        jBtn_Adcionar_end.setText("Adicionar");
        jBtn_Adcionar_end.setToolTipText("Clique para adicionar um endereço");

        jBtn_Salvar_End.setText("Salvar");
        jBtn_Salvar_End.setToolTipText("Clique para salvar o endereço");

        jBtn_excluir_end.setText("Excluir");
        jBtn_excluir_end.setToolTipText("Clique para excluir o endereço selecionado");

        jBtn_Editar_End.setText("Editar");
        jBtn_Editar_End.setToolTipText("Clique para editar o endereço selecionado");

        javax.swing.GroupLayout jPanelDadosEnderecosLayout = new javax.swing.GroupLayout(jPanelDadosEnderecos);
        jPanelDadosEnderecos.setLayout(jPanelDadosEnderecosLayout);
        jPanelDadosEnderecosLayout.setHorizontalGroup(
            jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosEnderecosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelDadosEnderecosLayout.createSequentialGroup()
                        .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCboTipoEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtReferencia))
                    .addGroup(jPanelDadosEnderecosLayout.createSequentialGroup()
                        .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosEnderecosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtn_Adcionar_end)
                        .addGap(18, 18, 18)
                        .addComponent(jBtn_Editar_End)
                        .addGap(18, 18, 18)
                        .addComponent(jBtn_Salvar_End)
                        .addGap(18, 18, 18)
                        .addComponent(jBtn_excluir_end)))
                .addContainerGap())
        );
        jPanelDadosEnderecosLayout.setVerticalGroup(
            jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosEnderecosLayout.createSequentialGroup()
                .addGroup(jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboTipoEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_Adcionar_end)
                    .addComponent(jBtn_Salvar_End)
                    .addComponent(jBtn_excluir_end)
                    .addComponent(jBtn_Editar_End)))
        );

        jLabelCodigo.setText("Codigo:");

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
                .addComponent(JbtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCodigo)
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelDadosEnderecos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanDadosGerais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelObservacoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCodigo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDadosEnderecos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JButton JbtnSalvar;
    private javax.swing.JButton jBtn_Adcionar_end;
    private javax.swing.JButton jBtn_Editar_End;
    private javax.swing.JButton jBtn_Salvar_End;
    private javax.swing.JButton jBtn_excluir_end;
    private javax.swing.JComboBox<String> jCboCidade;
    private javax.swing.JComboBox<String> jCboTipoEnd;
    private javax.swing.JCheckBox jCkb_inativar;
    private javax.swing.JFormattedTextField jFtxtCelular;
    private javax.swing.JFormattedTextField jFtxtFone;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JPanel jPanDadosGerais;
    private javax.swing.JPanel jPanelDadosEnderecos;
    private javax.swing.JPanel jPanelObservacoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblEnderecos;
    private javax.swing.JTextArea jTextObservacoes;
    private javax.swing.JTextField jTxtBairro;
    private javax.swing.JTextField jTxtCEP;
    private javax.swing.JTextField jTxtCNH;
    private javax.swing.JTextField jTxtCPF_CNPJ;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEstado1;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtNumero;
    private javax.swing.JTextField jTxtReferencia;
    private javax.swing.JTextField jTxtRua;
    private javax.swing.JTextField jTxt_rg_ie;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone_menu_clientes.png")));
    }
}

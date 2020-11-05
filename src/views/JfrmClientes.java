
package views;


import models.ClsCidades;
import models.ClsEnderecos;
import models.ClsLogin;
import controls.CidadesDAO;
import java.awt.Toolkit;
import java.util.List;



/**
 * 
 * @author Tiago Teixeira
 */
public class JfrmClientes extends javax.swing.JFrame {
   
   private String userLoged;
   private int userIdLoged;
   private String CpfUserLoged;
   
   ClsEnderecos clsEnderecos;
   ClsCidades clsCidades;
   CidadesDAO cidadesDAO;
   
   public JfrmClientes() {
        initComponents();
        setIcon();
   }
    
    public JfrmClientes(ClsLogin clslogin) {
        
        userLoged = clslogin.getUserLoged();
        userIdLoged = clslogin.getId();
        CpfUserLoged = clslogin.getCpfUserLoged();
        clsEnderecos = new ClsEnderecos();
        clsCidades = new ClsCidades();
        cidadesDAO = new CidadesDAO();
        loadCidades();
        initComponents();
        setIcon();
    }
    
    private void loadCidades(){
        List<ClsCidades> listCidades = cidadesDAO.selectALL();

        if (listCidades.size() < 1) {
            System.out.println("Não conseguiu carregar a lista do DB");
        } else {
            for (ClsCidades clsCidade : cidadesDAO.selectALL()) {
                jCboCidade.addItem(clsCidade.getNomeCidade());
            }
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnSalvar = new javax.swing.JButton();
        jBbtnNovo = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnImprimir = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnBuscar = new javax.swing.JButton();
        jPanDadosGerais = new javax.swing.JPanel();
        jFtxtFone = new javax.swing.JFormattedTextField();
        jFtxtCelular = new javax.swing.JFormattedTextField();
        jTxtEmail = new javax.swing.JTextField();
        jTxtNome = new javax.swing.JTextField();
        jRadioBtnCpf = new javax.swing.JRadioButton();
        jRadioBtnCnpj = new javax.swing.JRadioButton();
        jFTxtCpfCnpj = new javax.swing.JFormattedTextField();
        jFtxtRgIe = new javax.swing.JFormattedTextField();
        javax.swing.JFormattedTextField jFtxtCnh = new javax.swing.JFormattedTextField();
        jPanelObservacoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextObservacoes = new javax.swing.JTextArea();
        jPanelDadosEnderecos = new javax.swing.JPanel();
        jTxtRua = new javax.swing.JTextField();
        jTxtNumero = new javax.swing.JTextField();
        jCboCidade = new javax.swing.JComboBox<>();
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
        jFtxtCep = new javax.swing.JFormattedTextField();
        jLabelCodigo = new javax.swing.JLabel();
        jCkb_inativar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setResizable(false);
        setSize(new java.awt.Dimension(1055, 630));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_121760.png"))); // NOI18N
        jBtnSalvar.setToolTipText("Clique aqui para salvar Cliente");
        jBtnSalvar.setBorder(null);
        jBtnSalvar.setFocusPainted(false);

        jBbtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); // NOI18N
        jBbtnNovo.setToolTipText("Clique aqui para novo Cliente");
        jBbtnNovo.setBorder(null);
        jBbtnNovo.setFocusPainted(false);

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_121907.png"))); // NOI18N
        jBtnExcluir.setToolTipText("Clique aqui para excluir Cliente");
        jBtnExcluir.setBorder(null);
        jBtnExcluir.setFocusPainted(false);

        jBtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print_121773.png"))); // NOI18N
        jBtnImprimir.setToolTipText("Clique aqui para imprimir Cliente");
        jBtnImprimir.setBorder(null);
        jBtnImprimir.setFocusPainted(false);

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new_121792.png"))); // NOI18N
        jBtnEditar.setToolTipText("Clique aqui para editar Cliente");
        jBtnEditar.setBorder(null);
        jBtnEditar.setFocusPainted(false);

        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search_121759.png"))); // NOI18N
        jBtnBuscar.setToolTipText("Clique aqui para buscar Cliente");
        jBtnBuscar.setBorder(null);
        jBtnBuscar.setFocusPainted(false);
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jPanDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"), "Dados Gerais"));

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

        jRadioBtnCpf.setText("CPF");
        jRadioBtnCpf.setToolTipText("Marque para pessoa fisica!");

        jRadioBtnCnpj.setText("CNPJ");
        jRadioBtnCnpj.setToolTipText("Marque para pessoa Juridica!");

        jFTxtCpfCnpj.setBackground(new java.awt.Color(240, 240, 240));
        jFTxtCpfCnpj.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF/CNPJ"));
        jFTxtCpfCnpj.setToolTipText("Escolha entre CPF ou CNPJ e insira o dado!");
        jFTxtCpfCnpj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jFtxtRgIe.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtRgIe.setBorder(javax.swing.BorderFactory.createTitledBorder("RG/IE"));
        jFtxtRgIe.setToolTipText("Insira o RG caso seja pessoa fisica ou IE caso seja pessoa juridica");
        jFtxtRgIe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jFtxtCnh.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtCnh.setBorder(javax.swing.BorderFactory.createTitledBorder("CNH"));
        jFtxtCnh.setToolTipText("Numero da CNH do cliente");
        jFtxtCnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanDadosGeraisLayout = new javax.swing.GroupLayout(jPanDadosGerais);
        jPanDadosGerais.setLayout(jPanDadosGeraisLayout);
        jPanDadosGeraisLayout.setHorizontalGroup(
            jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jFtxtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtEmail))
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioBtnCnpj)
                            .addComponent(jRadioBtnCpf))
                        .addGap(18, 18, 18)
                        .addComponent(jFTxtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFtxtRgIe, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFtxtCnh)))
                .addContainerGap())
        );
        jPanDadosGeraisLayout.setVerticalGroup(
            jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanDadosGeraisLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jRadioBtnCpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioBtnCnpj))
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTxtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFtxtRgIe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFtxtCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFtxtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        jCboCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jCboCidade.setToolTipText("Selecione a cidade do cliente");
        jCboCidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Cidade"));

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

        jFtxtCep.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtCep.setBorder(javax.swing.BorderFactory.createTitledBorder("CEP"));
        jFtxtCep.setToolTipText("Nuero do CEP do endereço do cliente");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosEnderecosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosEnderecosLayout.createSequentialGroup()
                                .addComponent(jBtn_Adcionar_end)
                                .addGap(18, 18, 18)
                                .addComponent(jBtn_Editar_End)
                                .addGap(18, 18, 18)
                                .addComponent(jBtn_Salvar_End)
                                .addGap(18, 18, 18)
                                .addComponent(jBtn_excluir_end))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosEnderecosLayout.createSequentialGroup()
                                .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFtxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanelDadosEnderecosLayout.setVerticalGroup(
            jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosEnderecosLayout.createSequentialGroup()
                .addGroup(jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFtxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jCkb_inativar.setText("Inativar");
        jCkb_inativar.setToolTipText("Marque aqui caso deseje Inativar o cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBbtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCkb_inativar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelCodigo)
                                .addGap(48, 48, 48))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelDadosEnderecos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanDadosGerais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelObservacoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBbtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jCkb_inativar)))
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

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
 
    }//GEN-LAST:event_jBtnBuscarActionPerformed
    
    /**
     * @param args the command line arguments
     */
  

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbtnNovo;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnImprimir;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JButton jBtn_Adcionar_end;
    private javax.swing.JButton jBtn_Editar_End;
    private javax.swing.JButton jBtn_Salvar_End;
    private javax.swing.JButton jBtn_excluir_end;
    private javax.swing.JComboBox<String> jCboCidade;
    private javax.swing.JComboBox<String> jCboTipoEnd;
    private javax.swing.JCheckBox jCkb_inativar;
    private javax.swing.JFormattedTextField jFTxtCpfCnpj;
    private javax.swing.JFormattedTextField jFtxtCelular;
    private javax.swing.JFormattedTextField jFtxtCep;
    private javax.swing.JFormattedTextField jFtxtFone;
    private javax.swing.JFormattedTextField jFtxtRgIe;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JPanel jPanDadosGerais;
    private javax.swing.JPanel jPanelDadosEnderecos;
    private javax.swing.JPanel jPanelObservacoes;
    private javax.swing.JRadioButton jRadioBtnCnpj;
    private javax.swing.JRadioButton jRadioBtnCpf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblEnderecos;
    private javax.swing.JTextArea jTextObservacoes;
    private javax.swing.JTextField jTxtBairro;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEstado1;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtNumero;
    private javax.swing.JTextField jTxtReferencia;
    private javax.swing.JTextField jTxtRua;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone_menu_clientes.png")));
    }
}


package views;


import models.ClsCidades;
import models.ClsEnderecos;
import models.ClsLogin;
import models.ClsClientes;
import controls.CidadesDAO;
import controls.ClientesDAO;
import controls.EnderecosDAO;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import models.ClsCarregarTableEndereco;
import models.ClsValidacoes;
import models.ClsMascaraCampos;




/**
 * 
 * @author Tiago Teixeira
 */
public class JfrmClientes extends javax.swing.JFrame {
   
   private String userLoged;
   private int userIdLoged;
   private String CpfUserLoged;
   
   EnderecosDAO enderecosDAO;
   ClsEnderecos clsEnderecos;
   ClsCidades clsCidades;
   CidadesDAO cidadesDAO;
   ClientesDAO clientesDAO;
   ClsClientes clsClientes;
   ClsValidacoes clsValidacoes;
   boolean precionado;
   boolean editando;
   ClsCarregarTableEndereco clsCarregarTableEndereco;
   ClsMascaraCampos clsMascaracampos;
   private int tipoCliente; // 0 o programa vai gravar o CNPJ 1 o programa grava CPF
   
   
   List<ClsCidades> listCidadesBD;
   List<ClsEnderecos> listEnderecosBD;
   List<ClsClientes> listClientesBD;
   
   public JfrmClientes() {
        initComponents();
        setIcon();
   }
    
    public JfrmClientes(ClsLogin clslogin) {

        initComponents();
        setIcon();

        userLoged = clslogin.getUserLoged();
        userIdLoged = clslogin.getId();
        CpfUserLoged = clslogin.getCpfUserLoged();

        clsEnderecos = new ClsEnderecos();
        clsCidades = new ClsCidades();
        cidadesDAO = new CidadesDAO();
        clsClientes = new ClsClientes();
        enderecosDAO = new EnderecosDAO();
        clsValidacoes = new ClsValidacoes();
        listCidadesBD = cidadesDAO.selectALL();
        clsMascaracampos = new ClsMascaraCampos();

        try {
            addMascara();
        } catch (ParseException ex) {
            System.out.println("Erro ao aplicar mascaras: " + ex);
        }

        precionado = false;
        editando = false;

        loadCidades();
        loadEnderecoTipo();
        disableControl();

               
    }
    
    private void addMascara() throws ParseException {
        jFtxtDataNascimento.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraData(jFtxtDataNascimento)));
        jFtxtCep.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCep(jFtxtCep)));
        jFtxtFone.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraTelefone(jFtxtFone)));
        jFtxtCelular.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCelular(jFtxtCelular)));
        jFtxtCnh.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCNH(jFtxtCnh)));
    }
    
    /**
     * Passando o valor true ele vai formatar um CPF
     * Passando o valor false ele vai formatar um CNPJ
     * @param tipo
     * @throws ParseException 
     */
    private void addMascaraCpfCnpj(boolean tipo) throws ParseException {
        //se for true aplica a mascara CPF // se for false aplica a mascara cnpj
        if (tipo == true) {
                jFTxtCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCpf(jFTxtCpfCnpj))); 
        } else if (tipo == false) {
                jFTxtCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCnpj(jFTxtCpfCnpj)));
        }
    }
    
    private void loadCidades(){
        
        jCboCidade.setSelectedIndex(0);
        jCboCidade.setSelectedItem("Selecione");
        if (listCidadesBD.size() < 0) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar lista de Cidades, falha no banco de dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            for (ClsCidades clsCidade : listCidadesBD) {
                jCboCidade.addItem(clsCidade.getNomeCidade());
            }
        }

    }
    
    private void loadEnderecoTipo() {
        jCboTipoEnd.addItem("RESIDENCIAL");
        jCboTipoEnd.addItem("TRABALHO");
        jCboTipoEnd.addItem("COBRANCA");        
    }
    
    private void disableControl() {
        //desabilitando os comboBox
        jCboCidade.setEnabled(false);
        jCboTipoEnd.setEnabled(false);
        //desabilitando os botoes
        jBtnEditar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnImprimir.setEnabled(false);
        jBtnSalvar.setEnabled(false);
        jBtnBuscar.setEnabled(true);
        jBtn_Editar_End.setEnabled(false);
        jBtn_excluir_end.setEnabled(false);
        jBtn_Salvar_End.setEnabled(false);
        jBtn_Adcionar_end.setEnabled(false);
        jRadioBtnCpf.setEnabled(false);
        jRadioBtnCnpj.setEnabled(false);
        jCkb_inativar.setEnabled(false);
        //desabilitando campos de texto
        jTextObservacoes.setEnabled(false);
        jTxtBairro.setEnabled(false);
        jTxtEmail.setEnabled(false);
        jTxtEstado.setEnabled(false);
        jTxtNome.setEnabled(false);
        jTxtNumero.setEnabled(false);
        jTxtReferencia.setEnabled(false);
        jTxtRua.setEnabled(false);
        jFTxtCpfCnpj.setEnabled(false);
        jFtxtCelular.setEnabled(false);
        jFtxtCep.setEnabled(false);
        jFtxtDataNascimento.setEnabled(false);
        jFtxtFone.setEnabled(false);
        jFtxtRgIe.setEnabled(false);
        jFtxtCnh.setEnabled(false);

    }
    
    private void enableControl() {
        //habilitando JcomboBox
        jCboCidade.setEnabled(true);
        jCboTipoEnd.setEnabled(true);
        //habilitando os botoes
        jBtnEditar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnImprimir.setEnabled(false);
        jBtnSalvar.setEnabled(true);
        jBtnBuscar.setEnabled(false);
        jBtn_Editar_End.setEnabled(false);
        jBtn_excluir_end.setEnabled(false);
        jBtn_Salvar_End.setEnabled(false);
        jBtn_Adcionar_end.setEnabled(true);
        jRadioBtnCpf.setEnabled(true);
        jRadioBtnCnpj.setEnabled(true);
        jCkb_inativar.setEnabled(true);
        //habilitando campos de texto
        jTextObservacoes.setEnabled(true);
        jTxtBairro.setEnabled(true);
        jTxtEmail.setEnabled(true);
        jTxtEstado.setEnabled(false);
        jTxtNome.setEnabled(true);
        jTxtNumero.setEnabled(true);
        jTxtReferencia.setEnabled(true);
        jTxtRua.setEnabled(true);
        jFTxtCpfCnpj.setEnabled(true);
        jFtxtCelular.setEnabled(true);
        jFtxtCep.setEnabled(true);
        jFtxtDataNascimento.setEnabled(true);
        jFtxtFone.setEnabled(true);
        jFtxtRgIe.setEnabled(true);
        jFtxtCnh.setEnabled(true);
    }
    
    private void setIconBtnNv(boolean funcao) {
        if (funcao == true) {
            jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_cancelar.png"))); 
            jBtnNovo.setToolTipText("Clique aqui para cancelar a operacao");
        } else {
            jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); 
            jBtnNovo.setToolTipText("Clique aqui para novo Veiculo");
        }
    }
    /**
     * usado no evento do botao "Buscar", valida o cpf/cnpj inserido e se for valido executa a busca 
     * na lista pre carregada com os dados do BD
     */
    private void buscaCliente(){
        String cpf = JOptionPane.showInputDialog("Digite o CPF/CNPJ para procurar");
        boolean valido = clsValidacoes.isValid(cpf);
        boolean tipo = clsValidacoes.isTipoCpfCnpj(); //tipo true é CPF tipo false é CNPJ
        if (valido == true && tipo == true) {
            if (listClientesBD.size() < 1) {
                JOptionPane.showMessageDialog(this, "Erro: CPF não Cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
                buscaCliente();
            } else {
                for (int i = 0; i < listClientesBD.size(); i++) {
                    if (listClientesBD.get(i).getCpf().equals(cpf)) {
                        carregarListaEnd(listClientesBD.get(i).getId());
                        carregarJtable();
                        try {
                            addMascaraCpfCnpj(tipo);
                        } catch (ParseException ex) {
                            System.out.println("Erro ao aplicar: "+ex);
                        }
                        loadBlocoCliente(i);
                        loadBlocoEnd(-1);

                    }

                }

                precionado = true;
            }
        } else if (valido == true && tipo == false) {
            if (listClientesBD.size() < 1) {
                JOptionPane.showMessageDialog(this, "Erro: CNPJ não Cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
                buscaCliente();
            } else {
                   for (int i = 0; i < listClientesBD.size(); i++) {
                    if (listClientesBD.get(i).getCnpj().equals(cpf)) {
                        carregarListaEnd(listClientesBD.get(i).getId());
                        carregarJtable();
                        try {
                            addMascaraCpfCnpj(tipo);
                        } catch (ParseException ex) {
                            System.out.println("Erro ao aplicar: "+ex);
                        }
                        loadBlocoCliente(i);
                        loadBlocoEnd(-1);

                    }

                }

                precionado = true;
            }
        } else {
            JOptionPane.showMessageDialog(this, "O CPF/CNPJ digitado é invalido!", "ERRO", JOptionPane.ERROR_MESSAGE);
            buscaCliente();
        }
    }

    private void clearTxt() {
        jTextObservacoes.setText("");
        jTxtBairro.setText("");
        jTxtEmail.setText("");
        jTxtEstado.setText("");
        jTxtNome.setText("");
        jTxtNumero.setText("");
        jTxtReferencia.setText("");
        jTxtRua.setText("");
        jFTxtCpfCnpj.setText("");
        jFtxtCelular.setText("");
        jFtxtCep.setText("");
        jFtxtDataNascimento.setText("");
        jFtxtFone.setText("");
        jFtxtRgIe.setText("");
        jFtxtCnh.setText("");
        jCboCidade.setSelectedItem("Selecione");
        jCboTipoEnd.setSelectedItem("Selecione");
    }
    
    //funções relacionadas a Jtable que exibe os endereços //
    
    
    public void carregarListaEnd(int idCliente){
    listEnderecosBD = enderecosDAO.selectALL(idCliente);
    }
    
    public void carregarJtable() {
     jTblEnderecos.setModel(new ClsCarregarTableEndereco(listEnderecosBD));
    }
    
    public void atualizaListEnd(int Indice){
       listEnderecosBD.set(Indice, clsEnderecos);
       clsCarregarTableEndereco.updatedListRow(Indice, clsEnderecos);
       clsCarregarTableEndereco.updatedRow(Indice, Indice);
       
    }
    
    public void removeRowList(int indice) {
        listEnderecosBD.remove(indice);
        clsCarregarTableEndereco.deleteRow(indice);
    }
    
    public void addRowTable(){
        clsCarregarTableEndereco.addRow(clsEnderecos);
    }
    
    
    
    
    //funções responsaveis por carregar os componentes da tela //
    
    
    
    /**
     * Recebe -1 para primeiro endereço da lista ou a linha selecionada para carregar 
     * o bloco de endereços na Jframe
     * @param indice 
     */
    public void loadBlocoEnd(int indice){
        int indiceB;
        if (indice < 0) {
            indiceB = 0;
        } else {
            indiceB = indice;
        }
        jTxtBairro.setText(listEnderecosBD.get(indiceB).getBairro());
        jTxtEstado.setText(listEnderecosBD.get(indiceB).getEstado());
        jCboCidade.setSelectedItem(listEnderecosBD.get(indiceB).getNomeCidade());
        jTxtRua.setText(listEnderecosBD.get(indiceB).getRua());
        jTxtReferencia.setText(listEnderecosBD.get(indiceB).getReferencia());
        jFtxtCep.setText(listEnderecosBD.get(indiceB).getCep());
        jTxtNumero.setText(listEnderecosBD.get(indiceB).getNumero());
        jCboTipoEnd.setSelectedItem(listEnderecosBD.get(indiceB).getTipoEndereco());
    }
    
    /**
     * Carrega o Bloco do enderço do cliente usando como parametro o indice 
     * que ele se encontra "listClienteBD".
     * Os RadiosButton vao ser ativados e desativados de acordo com o tipo de cadastro.
     * No CheckBox Inativar se no banco estiver 0 estará desmarcado e 1 estará marcado
     * @param indice
     */
    public void loadBlocoCliente(int indice) {
        jLabelCodigo.setText("Codigo: "+listClientesBD.get(indice).getId());
        jTextObservacoes.setText(listClientesBD.get(indice).getObservacoes());
        jTxtEmail.setText(listClientesBD.get(indice).getEmail());
        if(listClientesBD.get(indice).getNome() == null || listClientesBD.get(indice).getNome().equals("")){
            jTxtNome.setText(listClientesBD.get(indice).getRazaoSocial());
            jRadioBtnCpf.setEnabled(false);
            jRadioBtnCnpj.setEnabled(true);
            jRadioBtnCnpj.setSelected(true);
        } else if (listClientesBD.get(indice).getRazaoSocial() == null || listClientesBD.get(indice).getRazaoSocial().equals("")) {
            jTxtNome.setText(listClientesBD.get(indice).getNome());
            jRadioBtnCpf.setEnabled(true);
            jRadioBtnCpf.setSelected(true);
            jRadioBtnCnpj.setEnabled(false);
        }      
        if(listClientesBD.get(indice).getCpf() == null || listClientesBD.get(indice).getCpf().equals("")) {
            jFTxtCpfCnpj.setText(listClientesBD.get(indice).getCnpj());
        } else if (listClientesBD.get(indice).getCnpj() == null || listClientesBD.get(indice).getCnpj().equals("")) {
            jFTxtCpfCnpj.setText(listClientesBD.get(indice).getCpf());
        }
        jFtxtCelular.setText(listClientesBD.get(indice).getCelular());
        jFtxtDataNascimento.setText(listClientesBD.get(indice).getDataNascimento());      
        jFtxtFone.setText(listClientesBD.get(indice).getTelefone());
        if(listClientesBD.get(indice).getRg() == 0){
            jFtxtRgIe.setText(""+listClientesBD.get(indice).getIe());
        } else if(listClientesBD.get(indice).getIe() == 0){
            jFtxtRgIe.setText(""+listClientesBD.get(indice).getRg());
        }        
        jFtxtCnh.setText(""+listClientesBD.get(indice).getCnh());
        if (listClientesBD.get(indice).getInativo() == 0) {
            jCkb_inativar.setSelected(false);
        } else if (listClientesBD.get(indice).getInativo() == 1) {
            jCkb_inativar.setSelected(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnSalvar = new javax.swing.JButton();
        jBtnNovo = new javax.swing.JButton();
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
        jFtxtCnh = new javax.swing.JFormattedTextField();
        jFtxtDataNascimento = new javax.swing.JFormattedTextField();
        jPanelObservacoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextObservacoes = new javax.swing.JTextArea();
        jPanelDadosEnderecos = new javax.swing.JPanel();
        jTxtRua = new javax.swing.JTextField();
        jTxtNumero = new javax.swing.JTextField();
        jCboCidade = new javax.swing.JComboBox<>();
        jTxtBairro = new javax.swing.JTextField();
        jTxtEstado = new javax.swing.JTextField();
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

        jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); // NOI18N
        jBtnNovo.setToolTipText("Clique aqui para novo Cliente");
        jBtnNovo.setBorder(null);
        jBtnNovo.setFocusPainted(false);
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });

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
        jRadioBtnCpf.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioBtnCpfItemStateChanged(evt);
            }
        });

        jRadioBtnCnpj.setText("CNPJ");
        jRadioBtnCnpj.setToolTipText("Marque para pessoa Juridica!");
        jRadioBtnCnpj.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioBtnCnpjItemStateChanged(evt);
            }
        });

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

        jFtxtDataNascimento.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtDataNascimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Nascimento"));
        jFtxtDataNascimento.setToolTipText("Data nascimento do cliente!");
        jFtxtDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanDadosGeraisLayout = new javax.swing.GroupLayout(jPanDadosGerais);
        jPanDadosGerais.setLayout(jPanDadosGeraisLayout);
        jPanDadosGeraisLayout.setHorizontalGroup(
            jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jFtxtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
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
                        .addGap(0, 0, Short.MAX_VALUE)
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
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFtxtFone)
                            .addComponent(jFtxtDataNascimento)
                            .addComponent(jFtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
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
        jCboCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCboCidadeItemStateChanged(evt);
            }
        });

        jTxtBairro.setBackground(new java.awt.Color(240, 240, 240));
        jTxtBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtBairro.setToolTipText("Bairro da Residencia");
        jTxtBairro.setBorder(javax.swing.BorderFactory.createTitledBorder("Bairro"));

        jTxtEstado.setBackground(new java.awt.Color(240, 240, 240));
        jTxtEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtEstado.setToolTipText("Estado da Residencia");
        jTxtEstado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        jCboTipoEnd.setBackground(new java.awt.Color(240, 240, 240));
        jCboTipoEnd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboTipoEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jCboTipoEnd.setToolTipText("Selecione o tipo de endereço do cliente");
        jCboTipoEnd.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Endereço"));
        jCboTipoEnd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCboTipoEndItemStateChanged(evt);
            }
        });

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
                                .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jBtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jBtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        ClientesDAO cliDBA = new ClientesDAO();                
        listClientesBD =  cliDBA.selectAll();
        buscaCliente();
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jCboTipoEndItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCboTipoEndItemStateChanged
        if(jCboTipoEnd.getSelectedIndex() > -1) {
          clsEnderecos.setTipoEndereco(jCboTipoEnd.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jCboTipoEndItemStateChanged

    private void jCboCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCboCidadeItemStateChanged
        if (jCboCidade.getSelectedIndex() > -1) {
            clsEnderecos.setNomeCidade(jCboCidade.getSelectedItem().toString());
            for (int i = 0; i < listCidadesBD.size(); i++) {
                if (listCidadesBD.get(i).getNomeCidade().equals(jCboCidade.getSelectedItem().toString())) {
                    String sigla = listCidadesBD.get(i).getSiglaEstado();
                    clsEnderecos.setIdCidade(listCidadesBD.get(i).getIdCidade());
                    clsEnderecos.setEstado(listCidadesBD.get(i).getEstado());
                    jTxtEstado.setText("" + sigla + " - " + listCidadesBD.get(i).getEstado());
                }
            }
        }
    }//GEN-LAST:event_jCboCidadeItemStateChanged

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
               if (precionado == false) {
            jTblEnderecos.setEnabled(false);
            setIconBtnNv(true);
            enableControl();
            clearTxt();
            precionado = true;
            editando = false;
            jTxtNome.requestFocus();
            
            
        } else {
            jTblEnderecos.setEnabled(true);
            setIconBtnNv(false);
            disableControl();
            clearTxt();
            precionado = false;
            editando = false;
        }
        
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jRadioBtnCpfItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioBtnCpfItemStateChanged
        if (jRadioBtnCpf.isSelected() == true) {
            jRadioBtnCnpj.setEnabled(false);
            tipoCliente = 1;
            try {
                jFTxtCpfCnpj.setText("");
                addMascaraCpfCnpj(true);
            } catch (ParseException ex) {
                System.out.println("Erro ao aplicar mascara: " + ex);
            }
        } else if (jRadioBtnCpf.isSelected() == false) {
            jRadioBtnCnpj.setEnabled(true);
            try {
                jFTxtCpfCnpj.setText("");
                addMascaraCpfCnpj(true);
            } catch (ParseException ex) {
                System.out.println("Erro ao aplicar mascara: " + ex);
            }
        }
    }//GEN-LAST:event_jRadioBtnCpfItemStateChanged

    private void jRadioBtnCnpjItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioBtnCnpjItemStateChanged
        if (jRadioBtnCnpj.isSelected() == true) {
            jRadioBtnCpf.setEnabled(false);
            tipoCliente = 0;
            try {
                addMascaraCpfCnpj(false);
            } catch (ParseException ex) {
                System.out.println("Erro ao aplicar mascara: " + ex);
            }
        } else if (jRadioBtnCnpj.isSelected() == false) {
            jRadioBtnCpf.setEnabled(true);
            try {
                addMascaraCpfCnpj(true);
            } catch (ParseException ex) {
                System.out.println("Erro ao aplicar mascara: " + ex);
            }
        }
    }//GEN-LAST:event_jRadioBtnCnpjItemStateChanged
    
    /**
     * @param args the command line arguments
     */
  

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnImprimir;
    private javax.swing.JButton jBtnNovo;
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
    private javax.swing.JFormattedTextField jFtxtCnh;
    private javax.swing.JFormattedTextField jFtxtDataNascimento;
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
    private javax.swing.JTextField jTxtEstado;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtNumero;
    private javax.swing.JTextField jTxtReferencia;
    private javax.swing.JTextField jTxtRua;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone_menu_clientes.png")));
    }


}

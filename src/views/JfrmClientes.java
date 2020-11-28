
package views;


import models.ClsCidades;
import models.ClsEnderecos;
import models.ClsLogin;
import models.ClsClientes;
import controls.CidadesDAO;
import controls.ClientesDAO;
import controls.EnderecosDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import models.ClsCarregarTableEndereco;
import models.ClsControlaCpNumericCliente;
import models.ClsImpressao;
import models.ClsValidacoes;
import models.ClsMascaraCampos;
import net.sf.jasperreports.engine.JRException;




/**
 * 
 * @author Tiago Teixeira
 */
public class JfrmClientes extends javax.swing.JFrame {
   
   private String userLoged;
   private int userIdLoged;
   private String CpfUserLoged;
   private String userNivel;
   
 
   EnderecosDAO enderecosDAO;
   ClsEnderecos clsEnderecos;
   ClsCidades clsCidades;
   CidadesDAO cidadesDAO;
   ClientesDAO clientesDAO;
   ClsClientes clsClientes;
   ClsValidacoes clsValidacoes;
   ClsCarregarTableEndereco clsCarregarTableEndereco = null;
   ClsMascaraCampos clsMascaracampos;
   
   //Variáveis que auxiliam nas ações dos botões
   
   boolean precionado;
   boolean editando;
   boolean buscando;
   boolean precionadoEnd;
   boolean editandoEnd;
   boolean buscandoEnd;
   private int linhaIndice;
   
   
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
        userNivel = clslogin.getNivel();

        clientesDAO = new ClientesDAO();
        clsEnderecos = new ClsEnderecos();
        clsCidades = new ClsCidades();
        cidadesDAO = new CidadesDAO();
        clsClientes = new ClsClientes();
        enderecosDAO = new EnderecosDAO();
        clsValidacoes = new ClsValidacoes();
        listCidadesBD = cidadesDAO.selectALL();
        clsMascaracampos = new ClsMascaraCampos();
        listClientesBD = clientesDAO.selectAll();

        try {
            addMascara();
        } catch (ParseException ex) {
            System.out.println("Erro ao aplicar mascaras: " + ex);
        }

        precionado = false;
        editando = false;
        buscando = false;
        
        precionadoEnd = false;
        editandoEnd = false;
        buscandoEnd = false;
        
        loadCidades();
        loadEnderecoTipo();
        disableControl();
        controleDigitacao();

               
    }
    
    private void reloadListClientes(){
        listClientesBD.clear();
        listClientesBD = clientesDAO.selectAll();
    }
    
    /**
     * Pssando as mascaras responsaveis por formatar os dados inseridos
     * @throws ParseException 
     */
    private void addMascara() throws ParseException {
        jFtxtDataNascimento.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraData(jFtxtDataNascimento)));
        jFtxtCep.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCep(jFtxtCep)));
        jFtxtFone.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraTelefone(jFtxtFone)));
        jFtxtCelular.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCelular(jFtxtCelular)));
        jFtxtCnh.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCNH(jFtxtCnh)));
    }
    
    private void removeMascara() throws ParseException {
        jFTxtCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.removeMasc(jFTxtCpfCnpj)));
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
                jFTxtCpfCnpj.setValue(null);
                jFTxtCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCpf(jFTxtCpfCnpj))); 
        } else if (tipo == false) {
                jFTxtCpfCnpj.setValue(null);
                jFTxtCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCnpj(jFTxtCpfCnpj)));
        }
    }
    
    /**
     * Controla a digitação permintindo apenas numeros
     */
    private void controleDigitacao() {
        jFtxtRgIe.setDocument(new ClsControlaCpNumericCliente());
    }
    /**
     * Responsavel por arregar uma lista de cidades obtidas no BD 
     * E em seguida adiciona todos os dados no jCoboBox "JcboCidade"
     */
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
    /**
     * Responsave por carregar o jComboBox "jCboTipo
     * Para uso no cadastro do endereço
     */
    private void loadEnderecoTipo() {
        jCboTipoEnd.addItem("RESIDENCIAL");
        jCboTipoEnd.addItem("TRABALHO");
        jCboTipoEnd.addItem("COBRANCA");        
    }
    /**
     * Responsavel por desabilitar todos os jFormattedTextField e jTextField
     * Desabilita alguns botoes de controle e habiita outros
     */
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
    /**
     * Responsavel por habilitar os controles da tela
     * Caso a busca encontre um registro ele é chamado
     * Usado junto com a função "buscaCliente"
     */
    private void enableControlBusca() {
        jBtnEditar.setEnabled(true);
        jBtnExcluir.setEnabled(true);
        jBtnImprimir.setEnabled(true);
        jBtnSalvar.setEnabled(false);
        jBtnBuscar.setEnabled(true);
        jBtn_Editar_End.setEnabled(false);
        jBtn_excluir_end.setEnabled(false);
        jBtn_Salvar_End.setEnabled(false);
        jBtn_Adcionar_end.setEnabled(true);
        jRadioBtnCpf.setEnabled(false);
        jRadioBtnCnpj.setEnabled(false);
        jCkb_inativar.setEnabled(false);
    }
    /**
     * Responsavel por habilitar toda a tela ao clicar no "jBtnEditar"
     * Libea a ediçao de todos os campos
     */
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
        jBtn_Adcionar_end.setEnabled(false);
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
    /**
     * Ao passar um valor "true" o botão muda o icone para a função de Cancelar
     * Ao passar um valor "false" o botão muda o icone para a função de Novo Registro
     * @param funcao 
     */
    private void setIconBtnNv(boolean funcao) {
        if (funcao == true) {
            jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_cancelar.png"))); 
            jBtnNovo.setToolTipText("Clique aqui para cancelar a operacao");
        } else {
            jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); 
            jBtnNovo.setToolTipText("Clique aqui para novo Cliente");
        }
    }
    /**
     * Usado nos controles do bloco de Endereço
     * Ao passar um valor "true" o botão muda o texto para a função de Cancelar
     * Ao passar um valor "false" o botão muda o texto para a função de Novo Registro
     * @param funcao 
     */
    private void setIconBtnAdd(boolean funcao) {
        if (funcao == true) {
            jBtn_Adcionar_end.setText("Cancelar");
            jBtn_Adcionar_end.setToolTipText("Clique aqui para cancelar a operacao");
        } else {
            jBtn_Adcionar_end.setText("Adicionar");
            jBtn_Adcionar_end.setToolTipText("Clique aqui para novo Endereço");
        }
    }
    /**
     * Mostra um JOptionPane formatado com uma menssagen de Campo Obrigatório
     * Passa uma String com o nome do campo
     * @param dado 
     */
    private void msgObgCampo(String dado) {
        JOptionPane.showMessageDialog(this, "Olá " + userLoged + " esse dado: " + dado + " é obrigatório", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
     /**
     * Mostra um JOptionPane formatado com uma menssagen de Informação de inconsistência no Dado
     * Passa uma String com o nome do campo
     * @param dado 
     */
    private void msgAdvCampo(String dado) {
        JOptionPane.showMessageDialog(this, "Olá " + userLoged + " esse dado: " + dado + " está maior ou menor do que o permitido!", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
     /**
     * Mostra um JOptionPane formatado com uma menssagen de Erro de inconsistência no Dado
     * Passa uma String com o nome do campo
     * @param dado 
     */
    private void msgErrCampo(String dado) {
        JOptionPane.showMessageDialog(this, "Olá " + userLoged + " esse dado: " + dado + " é invalido!", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Usado junco a a funcão de "buscaCliente" para verificar se o CPF é cadastrado
     * @param cpf
     * @return 
     */
    private boolean listBuscaCPF(String cpf){
        boolean encontrado = false;
        for (int i = 0; i < listClientesBD.size(); i++) {
            if (listClientesBD.get(i).getCpf().equals(cpf)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    
    /**
     * Usado junco a a funcão de "buscaCliente" para verificar se o CNPJ é cadastrado
     * @param cpf
     * @return 
     */
     private boolean listBuscaCNPJ(String cpf){
        boolean encontrado = false;
        for (int i = 0; i < listClientesBD.size(); i++) {
            if (listClientesBD.get(i).getCnpj().equals(cpf)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    /**
     * usado no evento do botao "Buscar", valida o cpf/cnpj inserido e se for valido executa a busca 
     * na lista pre carregada com os dados do BD
    */
    private void buscaCliente(){
        String cpf = JOptionPane.showInputDialog("Digite o CPF/CNPJ para procurar");
        if (cpf.equals("")) {
            jBtnBuscar.requestFocus();
        } else {
            clsClientes.cleanClientes(clsClientes,clsEnderecos);
            boolean valido = clsValidacoes.isValid(cpf);
            boolean tipo = clsValidacoes.isTipoCpfCnpj(); //tipo true é CPF tipo false é CNPJ
            if (valido == true && tipo == true) {
                if (listBuscaCPF(cpf) == false) {
                    JOptionPane.showMessageDialog(this, "Erro: CPF não Cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    buscaCliente();
                } else {
                    for (int i = 0; i < listClientesBD.size(); i++) {
                        if (listClientesBD.get(i).getCpf().equals(cpf)) {
                            carregarListaEnd(listClientesBD.get(i).getId());
                            linhaIndice = i;
                            carregarJtable();
                            try {
                                addMascaraCpfCnpj(tipo);
                            } catch (ParseException ex) {
                                System.out.println("Erro ao aplicar: " + ex);
                            }
                            loadBlocoCliente(i);
                            loadBlocoEnd(-1);
                            enableControlBusca();
                            clsClientes = listClientesBD.get(i);

                        }
                    }
                    precionado = false;
                }
            } else if (valido == true && tipo == false) {
                if (listBuscaCNPJ(cpf) == false) {
                    JOptionPane.showMessageDialog(this, "Erro: CNPJ não Cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    buscaCliente();
                } else {
                    for (int i = 0; i < listClientesBD.size(); i++) {
                        if (listClientesBD.get(i).getCnpj().equals(cpf)) {
                            carregarListaEnd(listClientesBD.get(i).getId());
                            linhaIndice = i;
                            carregarJtable();
                            try {
                                addMascaraCpfCnpj(tipo);
                            } catch (ParseException ex) {
                                System.out.println("Erro ao aplicar: " + ex);
                            }
                            loadBlocoCliente(i);
                            loadBlocoEnd(-1);
                            enableControlBusca();

                            clsClientes = listClientesBD.get(i);
                        }
                    }
                    precionado = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "O CPF/CNPJ digitado é invalido!", "ERRO", JOptionPane.ERROR_MESSAGE);
                buscaCliente();
            }
        }
    }
    
    /**
     * Função responsavel por limpar os campos de texto e seleção do sistema
     * Usada quando o botão cancelar é precionado ou ao excluir um cadastro
     */
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
        jRadioBtnCnpj.setSelected(false);
        jRadioBtnCpf.setSelected(false);
        jCkb_inativar.setSelected(false);
    }
    /**
     * Responsavel por lipar os Campos de texto e seleção jComboBox do bloco de endereços
     */
    private void clearTxtEnd() {
        jTxtBairro.setText("");
        jTxtEstado.setText("");
        jTxtNumero.setText("");
        jTxtReferencia.setText("");
        jTxtRua.setText("");
        jFtxtCep.setText("");
        jCboCidade.setSelectedItem("Selecione");
        jCboTipoEnd.setSelectedItem("Selecione");
    }
    
    //funções relacionadas a Jtable que exibe os endereços //
    
    /**
     * Carrega a lista de endereço do cliente encontrado na Busca
     * Passa o idCliente para a busca, com isso traz apenas os endereços
     * do próprio cliente
     * @param idCliente 
     */
    public void carregarListaEnd(int idCliente){
    EnderecosDAO endDAO = new EnderecosDAO();
    listEnderecosBD = endDAO.selectALL(idCliente);
    }
    /**
     * Carrega uma nova jTable com a lista de Endereços carregada 
     * pela a função "carregarListaEnd"
     */
    public void carregarJtable() {
     jTblEnderecos.setModel(new ClsCarregarTableEndereco(listEnderecosBD));
    }
    /**
     * Usado para recriar a jTable, nas atualizações, exclusões e adições
     * Usado junto com os controles do bloco de endereços
     */
    public void reloadTable(){
        listEnderecosBD.clear();
        EnderecosDAO endDAO = new EnderecosDAO();
        listEnderecosBD = endDAO.selectALL(clsClientes.getId());
        jTblEnderecos.setModel(new ClsCarregarTableEndereco(listEnderecosBD)); 
    }
    /**
     * Responsável por imar a lista de endereços e em seguida carrega a jTble com
     * a lista vazia.
     * Usado quando o "jBtnNovo" em modo cancelar é clicado.
     */
    public void removeTable() {
       listEnderecosBD.clear();
       jTblEnderecos.setModel(new ClsCarregarTableEndereco(listEnderecosBD)); 
    }
    
    /**
     * Recebe -1 para primeiro endereço da lista ou a linha selecionada para carregar 
     * o bloco de endereços na Jframe
     * @param indice 
     */
    private void loadBlocoEnd(int indice){
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
     * ativa os campos de texto e jcombobox do bloco de endereço
     * usado no evento de click do Jtable
     */
    private void enableBlocoEnd() {
        jTxtBairro.setEnabled(true);
        jTxtEstado.setEnabled(false);
        jCboCidade.setEnabled(true);
        jTxtRua.setEnabled(true);
        jTxtReferencia.setEnabled(true);
        jFtxtCep.setEnabled(true);
        jTxtNumero.setEnabled(true);
        jCboTipoEnd.setEnabled(true);
        jCboCidade.setEnabled(true);
        jBtn_Editar_End.setEnabled(true);
        jBtn_excluir_end.setEnabled(true);
        jBtn_Salvar_End.setEnabled(true);
        jBtn_Adcionar_end.setEnabled(true);
    }
    
    /**
     * Habilita os botoes apos salvar um endereço adicional em um cliente ja cadastrado
     */
    private void enableBtnBlocoEnd() {
        jBtn_Adcionar_end.setEnabled(true);
        jBtn_Editar_End.setEnabled(true);
        jBtn_excluir_end.setEnabled(true);
        jBtn_Salvar_End.setEnabled(true);
    }
    /**
     * Habilita os botoes apos salvar um cliente novo
     */
    private void enableBtnPrincipal() {
        jBtn_Adcionar_end.setEnabled(true);
        jBtnEditar.setEnabled(true);
        jBtnImprimir.setEnabled(true);
        jBtnExcluir.setEnabled(true);
        jTblEnderecos.setEnabled(true);
    
    }
    
    /**
     * desativa os campos de texto e jcombobox do bloco de endereços
     * usado no evendo do botão cancelar do bloco de endereço
     */
    private void disableBlocoEnd() {
        jTxtBairro.setEnabled(false);
        jTxtEstado.setEnabled(false);
        jCboCidade.setEnabled(false);
        jTxtRua.setEnabled(false);
        jTxtReferencia.setEnabled(false);
        jFtxtCep.setEnabled(false);
        jTxtNumero.setEnabled(false);
        jCboTipoEnd.setEnabled(false);
        jCboCidade.setEnabled(false);
        jBtn_Editar_End.setEnabled(false);
        jBtn_excluir_end.setEnabled(false);
        jBtn_Salvar_End.setEnabled(false);
        jBtn_Adcionar_end.setEnabled(true);
    }
    
    /**
     * Carrega o Bloco do enderço do cliente usando como parametro o indice 
     * que ele se encontra "listClienteBD".
     * Os RadiosButton vao ser ativados e desativados de acordo com o tipo de cadastro.
     * No CheckBox Inativar se no banco estiver 0 estará desmarcado e 1 estará marcado
     * @param indice
     */
    private void loadBlocoCliente(int indice) {
        jLabelCodigo.setText("Codigo: " + listClientesBD.get(indice).getId());
        jTextObservacoes.setText(listClientesBD.get(indice).getObservacoes());
        jTxtEmail.setText(listClientesBD.get(indice).getEmail());
        if (listClientesBD.get(indice).getNome() == null || listClientesBD.get(indice).getNome().equals("")) {
            jTxtNome.setText(listClientesBD.get(indice).getRazaoSocial());
            jRadioBtnCpf.setEnabled(false);
            jRadioBtnCpf.setSelected(false);
            jRadioBtnCnpj.setEnabled(true);
            jRadioBtnCnpj.setSelected(true);
        } else if (listClientesBD.get(indice).getRazaoSocial() == null || listClientesBD.get(indice).getRazaoSocial().equals("")) {
            jTxtNome.setText(listClientesBD.get(indice).getNome());
            jRadioBtnCpf.setEnabled(true);
            jRadioBtnCpf.setSelected(true);
            jRadioBtnCnpj.setEnabled(false);
            jRadioBtnCnpj.setSelected(false);
        }
        if (listClientesBD.get(indice).getCpf() == null || listClientesBD.get(indice).getCpf().equals("")) {
            jFTxtCpfCnpj.setText(listClientesBD.get(indice).getCnpj());
            jRadioBtnCpf.setEnabled(false);
            jRadioBtnCpf.setSelected(false);
            jRadioBtnCnpj.setEnabled(true);
            jRadioBtnCnpj.setSelected(true);
        } else if (listClientesBD.get(indice).getCnpj() == null || listClientesBD.get(indice).getCnpj().equals("")) {
            jFTxtCpfCnpj.setText(listClientesBD.get(indice).getCpf());
            jRadioBtnCpf.setEnabled(true);
            jRadioBtnCpf.setSelected(true);
            jRadioBtnCnpj.setEnabled(false);
            jRadioBtnCnpj.setSelected(false);
        }
        jFtxtCelular.setText(listClientesBD.get(indice).getCelular());
        jFtxtDataNascimento.setText(listClientesBD.get(indice).getDataNascimento());
        jFtxtFone.setText(listClientesBD.get(indice).getTelefone());
        if (listClientesBD.get(indice).getRg().equals("") || listClientesBD.get(indice).getRg() == null) {
            jFtxtRgIe.setText("" + listClientesBD.get(indice).getIe());
        } else if (listClientesBD.get(indice).getIe().equals("") || listClientesBD.get(indice).getIe() == null) {
            jFtxtRgIe.setText("" + listClientesBD.get(indice).getRg());
        }
        jFtxtCnh.setText("" + listClientesBD.get(indice).getCnh());
        if (listClientesBD.get(indice).getInativo() == 0) {
            jCkb_inativar.setSelected(false);
            jLabelStatus.setText("Cliente Liberado");
            jLabelStatus.setForeground(Color.BLUE);
        } else if (listClientesBD.get(indice).getInativo() == 1) {
            jCkb_inativar.setSelected(true);
            jLabelStatus.setText("Cliente Bloqueado");
            jLabelStatus.setForeground(Color.RED);
        }
        
    }
    
    /**
     * Responsavel por validar campo a campo Bloco Cliente, seguindo a regra de negócio
     * levando em considerão o tamamnho e consistência dos dados
     * @return 
     */
    private boolean validaBlocoCliente() {
        //valida campo Nome
        if (jTxtNome.getText().length() < 1) {
            msgObgCampo("Nome");
            jTxtNome.requestFocus();
            return false;
        } else if (jTxtNome.getText().length() > 200) {
            msgAdvCampo("Nome");
            jTxtNome.requestFocus();
            return false;
        } else  if (jFTxtCpfCnpj.getText().length() < 1) {
            msgObgCampo("CpfCnpj");
            jFTxtCpfCnpj.requestFocus();
            return false;
        } else if (jFTxtCpfCnpj.getText().length() > 18) {
            msgAdvCampo("CpfCnpj");
            jFTxtCpfCnpj.requestFocus();
            return false;
        } else    if (jFtxtRgIe.getText().length() < 1) {
            msgObgCampo("Rg/Ie");
            jFtxtRgIe.requestFocus();
            return false;
        } else if (jFtxtRgIe.getText().length() > 20) {
            msgAdvCampo("Rg/Ie");
            jFtxtRgIe.requestFocus();
            return false;
        } else    if (jFtxtCnh.getText().length() < 1) {
            msgObgCampo("CNH");
            jFtxtCnh.requestFocus();
            return false;
        } else if (jFtxtCnh.getText().length() > 20) {
            msgAdvCampo("CNH");
            jFtxtCnh.requestFocus();
            return false;
        } else if (jFtxtDataNascimento.getText().length() < 1) {
            msgObgCampo("Data Nascimento");
            jFtxtDataNascimento.requestFocus();
            return false;
        } else if (jFtxtDataNascimento.getText().length() > 10) {
            msgAdvCampo("Data Nascimento");
            jFtxtDataNascimento.requestFocus();
            return false;
        } else if (jFtxtFone.getText().length() < 1) {
            msgObgCampo("Telefone");
            jFtxtFone.requestFocus();
            return false;
        } else if (jFtxtFone.getText().length() > 13) {
            msgAdvCampo("Telefone");
            jFtxtFone.requestFocus();
            return false;
        } else if (jFtxtCelular.getText().length() < 1) {
            msgObgCampo("Celular");
            jFtxtCelular.requestFocus();
            return false;
        } else if (jFtxtCelular.getText().length() > 14) {
            msgAdvCampo("Celular");
            jFtxtCelular.requestFocus();
            return false;
        } else if (jTxtEmail.getText().length() < 1) {
            msgObgCampo("Email");
            jTxtEmail.requestFocus();
            return false;
        } else if (jTxtEmail.getText().length() > 250) {
            msgAdvCampo("Email");
            jTxtEmail.requestFocus();
            return false;
        } else if (jTextObservacoes.getText().length() > 1000){
             msgAdvCampo("Observacoes");
            jTextObservacoes.requestFocus();
            return false;
        }
        return true;
    }
        /**
     * Responsavel por validar campo a campo Bloco Endereços, seguindo a regra de negócio
     * levando em considerão o tamamnho e consistência dos dados
     * @return 
     */
    private boolean validaBlocoEnd() {
        if (jTxtRua.getText().length() < 1) {
            msgObgCampo("Rua");
            jTxtRua.requestFocus();
            return false;
        } else if (jTxtRua.getText().length() > 200) {
            msgAdvCampo("Rua");
            jTxtRua.requestFocus();
            return false;
        } else if (jTxtNumero.getText().length() < 1) {
            msgObgCampo("Numero");
            jTxtNumero.requestFocus();
            return false;
        } else if (jTxtNumero.getText().length() > 5) {
            msgAdvCampo("Numero");
            jTxtNumero.requestFocus();
            return false;
        } else if (jTxtEstado.getText().length() < 1) {
            msgObgCampo("Cidade/Estado");
            jTxtEstado.requestFocus();
            return false;
        } else if (jTxtEstado.getText().length() > 100) {
            msgAdvCampo("Cidade/Estado");
            jTxtEstado.requestFocus();
            return false;
        } else if (jFtxtCep.getText().length() < 1) {
            msgObgCampo("Cep");
            jFtxtCep.requestFocus();
            return false;
        } else if (jFtxtCep.getText().length() > 10) {
            msgAdvCampo("Cep");
            jFtxtCep.requestFocus();
            return false;
        } else if (jTxtBairro.getText().length() < 1) {
            msgObgCampo("Bairro");
            jTxtBairro.requestFocus();
            return false;
        } else if (jTxtBairro.getText().length() > 100) {
            msgAdvCampo("Bairro");
            jTxtBairro.requestFocus();
            return false;
        } else if (jCboTipoEnd.getSelectedItem() == "Selecione"){
            msgObgCampo("Tipo Endereco");
            jCboTipoEnd.requestFocus();
            return false;
        } 
       
        return true;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        jLabelStatus = new javax.swing.JLabel();

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
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

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
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print_121773.png"))); // NOI18N
        jBtnImprimir.setToolTipText("Clique aqui para imprimir Cliente");
        jBtnImprimir.setBorder(null);
        jBtnImprimir.setFocusPainted(false);
        jBtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnImprimirActionPerformed(evt);
            }
        });

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new_121792.png"))); // NOI18N
        jBtnEditar.setToolTipText("Clique aqui para editar Cliente");
        jBtnEditar.setBorder(null);
        jBtnEditar.setFocusPainted(false);
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

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
        jFtxtFone.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jFtxtFone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFtxtFone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFtxtFoneFocusLost(evt);
            }
        });

        jFtxtCelular.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtCelular.setBorder(javax.swing.BorderFactory.createTitledBorder("Celular"));
        jFtxtCelular.setToolTipText("Adicione aqui o numero de telefone celular do cliente");
        jFtxtCelular.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jFtxtCelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFtxtCelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFtxtCelularFocusLost(evt);
            }
        });

        jTxtEmail.setBackground(new java.awt.Color(240, 240, 240));
        jTxtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtEmail.setToolTipText("Adicione o Email do Cliente do Cliente");
        jTxtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("E-mail"));
        jTxtEmail.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jTxtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtEmailFocusLost(evt);
            }
        });

        jTxtNome.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNome.setToolTipText("Nome completo do Cliente");
        jTxtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));
        jTxtNome.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jTxtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtNomeFocusLost(evt);
            }
        });

        jRadioBtnCpf.setSelected(true);
        jRadioBtnCpf.setText("Fisica");
        jRadioBtnCpf.setToolTipText("Marque para pessoa fisica!");
        jRadioBtnCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioBtnCpfMouseClicked(evt);
            }
        });
        jRadioBtnCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBtnCpfActionPerformed(evt);
            }
        });

        jRadioBtnCnpj.setText("Juridica");
        jRadioBtnCnpj.setToolTipText("Marque para pessoa Juridica!");
        jRadioBtnCnpj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioBtnCnpjMouseClicked(evt);
            }
        });
        jRadioBtnCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBtnCnpjActionPerformed(evt);
            }
        });

        jFTxtCpfCnpj.setBackground(new java.awt.Color(240, 240, 240));
        jFTxtCpfCnpj.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF/CNPJ"));
        jFTxtCpfCnpj.setToolTipText("Escolha entre CPF ou CNPJ e insira o dado!");
        jFTxtCpfCnpj.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jFTxtCpfCnpj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFTxtCpfCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTxtCpfCnpjFocusLost(evt);
            }
        });

        jFtxtRgIe.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtRgIe.setBorder(javax.swing.BorderFactory.createTitledBorder("RG/IE"));
        jFtxtRgIe.setToolTipText("Insira o RG caso seja pessoa fisica ou IE caso seja pessoa juridica");
        jFtxtRgIe.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jFtxtRgIe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFtxtRgIe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFtxtRgIeFocusLost(evt);
            }
        });

        jFtxtCnh.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtCnh.setBorder(javax.swing.BorderFactory.createTitledBorder("CNH"));
        jFtxtCnh.setToolTipText("Numero da CNH do cliente");
        jFtxtCnh.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jFtxtCnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFtxtCnh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFtxtCnhFocusLost(evt);
            }
        });

        jFtxtDataNascimento.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtDataNascimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Nascimento"));
        jFtxtDataNascimento.setToolTipText("Data nascimento do cliente!");
        jFtxtDataNascimento.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jFtxtDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFtxtDataNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFtxtDataNascimentoFocusLost(evt);
            }
        });

        jLabel1.setText("Pessoa");

        jLabel2.setText("Pessoa");

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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioBtnCpf)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioBtnCnpj)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jFTxtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFtxtRgIe, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFtxtCnh)))
                .addContainerGap())
        );
        jPanDadosGeraisLayout.setVerticalGroup(
            jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioBtnCnpj)
                    .addComponent(jRadioBtnCpf)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTxtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFtxtRgIe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFtxtCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
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
        jTextObservacoes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextObservacoesFocusLost(evt);
            }
        });
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
        jTxtRua.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jTxtRua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtRuaFocusLost(evt);
            }
        });

        jTxtNumero.setBackground(new java.awt.Color(240, 240, 240));
        jTxtNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtNumero.setToolTipText("Numero da Residencia");
        jTxtNumero.setBorder(javax.swing.BorderFactory.createTitledBorder("Numero"));
        jTxtNumero.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jTxtNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtNumeroFocusLost(evt);
            }
        });

        jCboCidade.setBackground(new java.awt.Color(240, 240, 240));
        jCboCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jCboCidade.setToolTipText("Selecione a cidade do cliente");
        jCboCidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Cidade"));
        jCboCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCboCidadeFocusLost(evt);
            }
        });

        jTxtBairro.setBackground(new java.awt.Color(240, 240, 240));
        jTxtBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtBairro.setToolTipText("Bairro da Residencia");
        jTxtBairro.setBorder(javax.swing.BorderFactory.createTitledBorder("Bairro"));
        jTxtBairro.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jTxtBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtBairroFocusLost(evt);
            }
        });

        jTxtEstado.setBackground(new java.awt.Color(240, 240, 240));
        jTxtEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtEstado.setToolTipText("Estado da Residencia");
        jTxtEstado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));
        jTxtEstado.setDisabledTextColor(new java.awt.Color(90, 90, 90));

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
        jTxtReferencia.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jTxtReferencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtReferenciaFocusLost(evt);
            }
        });

        jTblEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Rua", "Numero", "Cidade", "Estado", "Bairro", "CEP", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblEnderecos.setToolTipText("Selecione o endereço para usar as opções");
        jTblEnderecos.setName(""); // NOI18N
        jTblEnderecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblEnderecosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTblEnderecos);

        jBtn_Adcionar_end.setText("Adicionar");
        jBtn_Adcionar_end.setToolTipText("Clique para adicionar um endereço");
        jBtn_Adcionar_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Adcionar_endActionPerformed(evt);
            }
        });

        jBtn_Salvar_End.setText("Salvar");
        jBtn_Salvar_End.setToolTipText("Clique para salvar o endereço");
        jBtn_Salvar_End.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Salvar_EndActionPerformed(evt);
            }
        });

        jBtn_excluir_end.setText("Excluir");
        jBtn_excluir_end.setToolTipText("Clique para excluir o endereço selecionado");
        jBtn_excluir_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_excluir_endActionPerformed(evt);
            }
        });

        jBtn_Editar_End.setText("Editar");
        jBtn_Editar_End.setToolTipText("Clique para editar o endereço selecionado");
        jBtn_Editar_End.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Editar_EndActionPerformed(evt);
            }
        });

        jFtxtCep.setBackground(new java.awt.Color(240, 240, 240));
        jFtxtCep.setBorder(javax.swing.BorderFactory.createTitledBorder("CEP"));
        jFtxtCep.setToolTipText("Nuero do CEP do endereço do cliente");
        jFtxtCep.setDisabledTextColor(new java.awt.Color(90, 90, 90));
        jFtxtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFtxtCepFocusLost(evt);
            }
        });

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
        jCkb_inativar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCkb_inativarMouseClicked(evt);
            }
        });

        jLabelStatus.setText("Sataus");
        jLabelStatus.setToolTipText("");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStatus)
                                    .addComponent(jLabelCodigo))
                                .addGap(16, 16, 16))))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCkb_inativar)
                        .addGap(19, 19, 19)))
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
        clslogin.setNivel(userNivel);
        views.JfrmPrincipal telaprincipal = new views.JfrmPrincipal(clslogin);
        telaprincipal.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /*EM SEGUIDA SÃO OS AÇÕES E EVENTOS DOS CONTROLES DA TELA*/
    
    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        buscando = true;
        ClientesDAO cliDBA = new ClientesDAO();                
        listClientesBD =  cliDBA.selectAll();
        buscaCliente();
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jCboTipoEndItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCboTipoEndItemStateChanged
        if(jCboTipoEnd.getSelectedIndex() > -1) {
          clsEnderecos.setTipoEndereco(jCboTipoEnd.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jCboTipoEndItemStateChanged

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        if (precionado == false) {
            jTblEnderecos.setEnabled(false);
            setIconBtnNv(true);
            clsClientes.cleanClientes(clsClientes,clsEnderecos);
            enableControl();
            clearTxt();
            try {
                removeMascara();
            } catch (ParseException ex) {
                System.out.println("Erro: "+ex);
            }
            if (buscando == true || editando == true) {
                removeTable();
            }
            precionado = true;
            editando = false;
            jTxtNome.setEnabled(false);
            jTxtNome.requestFocus();
        } else {
            jTblEnderecos.setEnabled(true);
            setIconBtnNv(false);
            disableControl();
            clearTxt();
            clsClientes.cleanClientes(clsClientes,clsEnderecos);
            if (buscando == true || editando == true) {
                removeTable();
            }
            precionado = false;
            editando = false;
        }
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        precionado = true;
        editando = true;
        clsClientes = listClientesBD.get(linhaIndice);
        clsEnderecos.setIdCliente(clsClientes.getId());
        //jTblEnderecos.setEnabled(false);
        jTxtNome.setEnabled(true);
        setIconBtnNv(true);
        enableControl();
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jTxtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtNomeFocusLost
       if(jTxtNome.getText().length() > 1){
           if(jRadioBtnCpf.isSelected() == true && jRadioBtnCnpj.isSelected() == false){
             clsClientes.setNome(jTxtNome.getText());
             clsClientes.setRazaoSocial("");
           }else if (jRadioBtnCpf.isSelected() == false && jRadioBtnCnpj.isSelected() == true) {
             clsClientes.setNome("");
             clsClientes.setRazaoSocial(jTxtNome.getText());
           }
           
       }
    }//GEN-LAST:event_jTxtNomeFocusLost

    private void jFTxtCpfCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTxtCpfCnpjFocusLost
        if (jFTxtCpfCnpj.getText().length() > 1 && jRadioBtnCnpj.isSelected() == true && jRadioBtnCpf.isSelected() == false) {
            if (clsValidacoes.isValid(clsValidacoes.replaceDado(jFTxtCpfCnpj.getText()))) {
                if (listBuscaCNPJ(clsValidacoes.replaceDado(jFTxtCpfCnpj.getText())) && editando == false) {
                    JOptionPane.showMessageDialog(this, "CNPJ inserido já cadastrado no sistema, use a Busca", "ERRO", JOptionPane.ERROR_MESSAGE);
                    jFTxtCpfCnpj.setText("");
                    jFTxtCpfCnpj.requestFocus();

                } else {
                    clsClientes.setCnpj(clsValidacoes.replaceDado(jFTxtCpfCnpj.getText()));
                    clsClientes.setCpf("");
                }

            } else {
                JOptionPane.showMessageDialog(this, "CNPJ inserido é invalido confira e tente novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                jFTxtCpfCnpj.setText("");
                jFTxtCpfCnpj.requestFocus();

            }

        } else if (jFTxtCpfCnpj.getText().length() > 1 && jRadioBtnCpf.isSelected() == true && jRadioBtnCnpj.isSelected() == false) {

            if (clsValidacoes.isValid(jFTxtCpfCnpj.getText())) {
                if (listBuscaCPF(clsValidacoes.replaceDado(jFTxtCpfCnpj.getText())) && editando == false) {
                    JOptionPane.showMessageDialog(this, "CPF inserido já cadastrado no sistema, use a Busca", "ERRO", JOptionPane.ERROR_MESSAGE);
                    jFTxtCpfCnpj.setText("");
                    jFTxtCpfCnpj.requestFocus();

                } else {
                    clsClientes.setCpf(clsValidacoes.replaceDado(jFTxtCpfCnpj.getText()));
                    clsClientes.setCnpj("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "CPF inserido é invalido confira e tente novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                jFTxtCpfCnpj.setText("");
                jFTxtCpfCnpj.requestFocus();

            }
        }
    }//GEN-LAST:event_jFTxtCpfCnpjFocusLost

    private void jFtxtRgIeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFtxtRgIeFocusLost
        if (jFtxtRgIe.getText().length() > 1 && jRadioBtnCnpj.isSelected() == true && jRadioBtnCpf.isSelected() == false) {
            clsClientes.setIe(jFtxtRgIe.getText());
            clsClientes.setRg("");
        } else if (jFtxtRgIe.getText().length() > 1 && jRadioBtnCpf.isSelected() == true && jRadioBtnCnpj.isSelected() == false) {
            clsClientes.setRg(jFtxtRgIe.getText());
            clsClientes.setIe("");
        }
    }//GEN-LAST:event_jFtxtRgIeFocusLost

    private void jFtxtCnhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFtxtCnhFocusLost
        if(jFtxtCnh.getText().length() > 1){
            clsClientes.setCnh(jFtxtCnh.getText());
        }
    }//GEN-LAST:event_jFtxtCnhFocusLost

    private void jFtxtDataNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFtxtDataNascimentoFocusLost

        if(jFtxtDataNascimento.getText().length() > 1){
            if(clsValidacoes.validaDataFormatoBR(jFtxtDataNascimento.getText()) == false){
                JOptionPane.showMessageDialog(this, "A data: "+jFtxtDataNascimento.getText()+" é invalida, tente novamente!", "Informação", 
                JOptionPane.INFORMATION_MESSAGE);
                jFtxtDataNascimento.requestFocus();
            }else{
                clsClientes.setDataNascimento(clsValidacoes.dataFormatoUS(jFtxtDataNascimento.getText()));
            }
            
        }
    }//GEN-LAST:event_jFtxtDataNascimentoFocusLost

    private void jFtxtFoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFtxtFoneFocusLost
        if(jFtxtFone.getText().length() > 1) {
             clsClientes.setTelefone(jFtxtFone.getText());
        }
    }//GEN-LAST:event_jFtxtFoneFocusLost

    private void jFtxtCelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFtxtCelularFocusLost
        if (jFtxtCelular.getText().length() > 1) {
            clsClientes.setCelular(jFtxtCelular.getText());
        }
    }//GEN-LAST:event_jFtxtCelularFocusLost

    private void jTxtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtEmailFocusLost
        if (jTxtEmail.getText().length() > 1) {
            if (clsValidacoes.isValidEmailAddressRegex(jTxtEmail.getText()) == true) {
                clsClientes.setEmail(jTxtEmail.getText());
            } else {
                msgErrCampo("Email");
            }
        }
    }//GEN-LAST:event_jTxtEmailFocusLost

    private void jTextObservacoesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextObservacoesFocusLost
        if(jTextObservacoes.getText().length() > 1) {
            clsClientes.setObservacoes(jTextObservacoes.getText());
        } else if (jTextObservacoes.getText().length() > 999) {
            msgAdvCampo("Observacoes");
        } else if (jTextObservacoes.getText().equals("")) {
            clsClientes.setObservacoes("");
        }
    }//GEN-LAST:event_jTextObservacoesFocusLost

    private void jTxtRuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtRuaFocusLost
        if (jTxtRua.getText().length() >1) {
            clsEnderecos.setRua(jTxtRua.getText());
        }
    }//GEN-LAST:event_jTxtRuaFocusLost

    private void jTxtNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtNumeroFocusLost
        if (jTxtNumero.getText().length() > 0 ) {
            clsEnderecos.setNumero(jTxtNumero.getText());
        }
    }//GEN-LAST:event_jTxtNumeroFocusLost

    private void jFtxtCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFtxtCepFocusLost
        if (jFtxtCep.getText().length() > 1) {
            clsEnderecos.setCep(jFtxtCep.getText());
        }
    }//GEN-LAST:event_jFtxtCepFocusLost

    private void jTxtBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtBairroFocusLost
        if (jTxtBairro.getText().length() > 1) {
            clsEnderecos.setBairro(jTxtBairro.getText());
        }
    }//GEN-LAST:event_jTxtBairroFocusLost

    private void jTxtReferenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtReferenciaFocusLost
        if (jTxtReferencia.getText().length() > 1) {
            clsEnderecos.setReferencia(jTxtReferencia.getText());
        } else if (jTxtReferencia.getText().length() > 999) {
            msgErrCampo("Referencia");
        } else if (jTxtReferencia.getText().equals("")) {
            clsEnderecos.setReferencia("");
        }
    }//GEN-LAST:event_jTxtReferenciaFocusLost

    private void jTblEnderecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblEnderecosMouseClicked
        clsEnderecos = listEnderecosBD.get(jTblEnderecos.getSelectedRow());
        if (editandoEnd == true || buscando == true) {
            int rowSelected = jTblEnderecos.getSelectedRow();
            loadBlocoEnd(rowSelected);            
            enableBtnBlocoEnd();
            setIconBtnAdd(false);
            precionadoEnd = false;
            editandoEnd = true;            
        }
               
    }//GEN-LAST:event_jTblEnderecosMouseClicked

    private void jBtn_Adcionar_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Adcionar_endActionPerformed
        if (precionadoEnd == false) {
            clsEnderecos.setIdCliente(clsClientes.getId());
            enableBlocoEnd();
            clearTxtEnd();
            setIconBtnAdd(true);
            precionadoEnd = true;
            editandoEnd = false;
            
        } else {
            setIconBtnAdd(false);
            disableBlocoEnd();
            clearTxtEnd();
            precionadoEnd = false;
            editandoEnd = false;
        }
    }//GEN-LAST:event_jBtn_Adcionar_endActionPerformed

    private void jBtn_Salvar_EndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Salvar_EndActionPerformed
        if (editandoEnd == false) {
            if (validaBlocoEnd() == true) {
                EnderecosDAO endDAO = new EnderecosDAO();
                endDAO.save(clsEnderecos);
                if (endDAO.isSucesso() == true) {
                    JOptionPane.showMessageDialog(this, endDAO.getRetorno(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    disableBlocoEnd();
                    reloadTable();
                    jTblEnderecos.setEnabled(true);
                    setIconBtnAdd(false);
                } else {
                    JOptionPane.showMessageDialog(this, endDAO.getRetorno(), "ERRO", JOptionPane.INFORMATION_MESSAGE);
                    disableBlocoEnd();
                    clearTxtEnd();
                    jTblEnderecos.setEnabled(false);
                    setIconBtnAdd(false);
                }
            }
        } else {
            if (validaBlocoEnd() == true) {
                EnderecosDAO endDAO = new EnderecosDAO();
                endDAO.update(clsEnderecos);
                if (endDAO.isSucesso() == true) {
                    JOptionPane.showMessageDialog(this, endDAO.getRetorno(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    disableBlocoEnd();
                    reloadTable();
                    jTblEnderecos.setEnabled(true);
                    setIconBtnAdd(false);
                } else {
                    JOptionPane.showMessageDialog(this, endDAO.getRetorno(), "ERRO", JOptionPane.INFORMATION_MESSAGE);
                    disableBlocoEnd();
                    clearTxtEnd();
                    jTblEnderecos.setEnabled(false);
                    setIconBtnAdd(false);
                }
            }
        }
    }//GEN-LAST:event_jBtn_Salvar_EndActionPerformed

    private void jBtn_excluir_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_excluir_endActionPerformed
        int deletar = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (deletar == 0) {
            EnderecosDAO endDAO = new EnderecosDAO();
            endDAO.delete(clsEnderecos.getId());
            if (endDAO.isSucesso() == true) {
                JOptionPane.showMessageDialog(this, endDAO.getRetorno(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                clearTxtEnd();
                disableBlocoEnd();
                reloadTable();
                setIconBtnAdd(false);
                precionadoEnd = false;
            } else {
                JOptionPane.showMessageDialog(this, endDAO.getRetorno() + "O usuario " + userLoged + ""
                        + " não tem permissao para deletar!", "Erro", JOptionPane.ERROR_MESSAGE);
                setIconBtnAdd(true);
                precionadoEnd = true;
            }

        }
    }//GEN-LAST:event_jBtn_excluir_endActionPerformed

    private void jBtn_Editar_EndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Editar_EndActionPerformed
        clsEnderecos = listEnderecosBD.get(jTblEnderecos.getSelectedRow());
        precionadoEnd = true;
        editandoEnd = true;
        enableBlocoEnd();
        setIconBtnAdd(true);
       
    }//GEN-LAST:event_jBtn_Editar_EndActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        if (editando == false) {
            if (validaBlocoEnd() == true && validaBlocoCliente() == true) {
                clsClientes.setIdColaborador(userIdLoged);
                ClientesDAO cliDAO = new ClientesDAO();
                cliDAO.save(clsClientes);
                clsEnderecos.setIdCliente(cliDAO.getIdRetornado());
                clsClientes.setId(cliDAO.getIdRetornado());
                EnderecosDAO endDAO = new EnderecosDAO();
                endDAO.save(clsEnderecos);
                if (endDAO.isSucesso() == true && cliDAO.isSucesso() == true) {
                    JOptionPane.showMessageDialog(this, "Endereco: " + endDAO.getRetorno() + "Cliente: " + cliDAO.getRetorno(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    disableControl();
                    enableBtnPrincipal();
                    listEnderecosBD = endDAO.selectALL(clsClientes.getId());
                    listClientesBD.add(clsClientes);
                    reloadTable();
                    setIconBtnAdd(false);
                    setIconBtnNv(false);
                    precionado = false;
                    editando = false;
                } else {
                    JOptionPane.showMessageDialog(this, "Endereco: " + endDAO.getRetorno() + "Cliente: " + cliDAO.getRetorno(), "ERRO", JOptionPane.INFORMATION_MESSAGE);
                    disableControl();
                    clearTxt();
                    setIconBtnAdd(false);
                    setIconBtnNv(false);
                    precionado = false;
                    editando = false;
                }
            }
        } else {
            if (validaBlocoEnd() == true && validaBlocoCliente() == true) {
                ClientesDAO cliDAO = new ClientesDAO();
                cliDAO.update(clsClientes);
                EnderecosDAO endDAO = new EnderecosDAO();
                endDAO.update(clsEnderecos);
                if (endDAO.isSucesso() == true && cliDAO.isSucesso() == true) {
                    JOptionPane.showMessageDialog(this, "Endereco: " + endDAO.getRetorno() + "Cliente: " + cliDAO.getRetorno(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    disableControl();
                    enableBtnPrincipal();
                    listEnderecosBD = endDAO.selectALL(clsClientes.getId());
                    listClientesBD.add(clsClientes);
                    reloadTable();
                    setIconBtnAdd(false);
                    setIconBtnNv(false);
                    precionado = false;
                    editando = false;
                } else {
                    JOptionPane.showMessageDialog(this, "Endereco: " + endDAO.getRetorno() + "Cliente: " + cliDAO.getRetorno(), "ERRO", JOptionPane.INFORMATION_MESSAGE);
                    disableControl();
                    clearTxt();
                    setIconBtnAdd(false);
                    setIconBtnNv(false);
                    precionado = false;
                    editando = false;
                }
            }
        }
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
       int deletar = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (deletar == 0) {
            ClientesDAO cliDAO = new ClientesDAO();
            cliDAO.delete(clsClientes.getId());
            if (cliDAO.isSucesso() == true) {
                JOptionPane.showMessageDialog(this,  cliDAO.getRetorno(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                clearTxt();
                disableControl();
                reloadListClientes();
                removeTable();
                setIconBtnNv(false);
                precionado = false;
            } else {
                JOptionPane.showMessageDialog(this, cliDAO.getRetorno() + "O usuario " + userLoged + ""
                        + " não tem permissao para deletar!", "Erro", JOptionPane.ERROR_MESSAGE);
                setIconBtnNv(true);
                precionado = true;
            }

        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jCkb_inativarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCkb_inativarMouseClicked
       if (jCkb_inativar.isSelected() == false) {
            clsClientes.setInativo(0);
            jLabelStatus.setText("Cliente Liberado");
            jLabelStatus.setForeground(Color.BLUE);
        } else if (jCkb_inativar.isSelected() == true) {
            int deletar = JOptionPane.showConfirmDialog(this, "Ao inativar o cliente ele ficará invisível para os demais módulos. \n Deseja inativa o cliente?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (deletar == 0) {
                JOptionPane.showMessageDialog(this, "Cliente Inativado do Sistema", "Antenção", JOptionPane.INFORMATION_MESSAGE);
                clsClientes.setInativo(1);
                jLabelStatus.setText("Cliente Bloqueado");
                jLabelStatus.setForeground(Color.RED);
                jCkb_inativar.setSelected(true);
            }
        }
    }//GEN-LAST:event_jCkb_inativarMouseClicked

    private void jCboCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCboCidadeFocusLost
        if (jCboCidade.getSelectedIndex() != 0) {
            clsEnderecos.setNomeCidade(jCboCidade.getSelectedItem().toString());
            for (int i = 0; i < listCidadesBD.size(); i++) {
                if (listCidadesBD.get(i).getNomeCidade().equals(jCboCidade.getSelectedItem().toString())) {
                    String sigla = listCidadesBD.get(i).getSiglaEstado();
                    clsEnderecos.setId_cidade(listCidadesBD.get(i).getIdCidade());
                    clsEnderecos.setIdCidade(listCidadesBD.get(i).getIdCidade());
                    clsEnderecos.setEstado(listCidadesBD.get(i).getEstado());
                    jTxtEstado.setText("" + sigla + " - " + listCidadesBD.get(i).getEstado());
                }
            }
        }
    }//GEN-LAST:event_jCboCidadeFocusLost

    private void jBtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnImprimirActionPerformed
        File directory = new File("./src/relatorios/relClientes.jrxml");
        // passa o caminho do relatorio e o parametro para carregar o relatorio.
        try {
            ClsImpressao clsimpressao = new ClsImpressao();
            clsimpressao.ClsImpressao(directory.getAbsolutePath(), "idCliente", "" + clsClientes.getId(), "Cadastro do Cliente");
        } catch (ClassNotFoundException | SQLException | JRException e) {
            JOptionPane.showMessageDialog(this, "Erro foi aqui" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnImprimirActionPerformed

    private void jRadioBtnCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioBtnCpfMouseClicked

    }//GEN-LAST:event_jRadioBtnCpfMouseClicked

    private void jRadioBtnCnpjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioBtnCnpjMouseClicked

    }//GEN-LAST:event_jRadioBtnCnpjMouseClicked

    private void jRadioBtnCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBtnCpfActionPerformed
            if (jRadioBtnCpf.isSelected() == true) {
            jRadioBtnCnpj.setEnabled(false);
            try {
                clsClientes.setCpf("");
                clsClientes.setCnpj("");
                jFTxtCpfCnpj.setText("");
                addMascaraCpfCnpj(true);
                jTxtNome.setEnabled(true);
            } catch (ParseException ex) {
                System.out.println("Erro ao aplicar mascara: " + ex);
            }
        } else if (jRadioBtnCpf.isSelected() == false) {
            jRadioBtnCnpj.setEnabled(true);
            jFTxtCpfCnpj.setText("");
        }
    }//GEN-LAST:event_jRadioBtnCpfActionPerformed

    private void jRadioBtnCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBtnCnpjActionPerformed
        if (jRadioBtnCnpj.isSelected() == true) {
            jRadioBtnCpf.setEnabled(false);
            try {
                clsClientes.setCpf("");
                clsClientes.setCnpj("");
                jFTxtCpfCnpj.setText("");
                addMascaraCpfCnpj(false);
                jTxtNome.setEnabled(true);
            } catch (ParseException ex) {
                System.out.println("Erro ao aplicar mascara: " + ex);
            }
        } else if (jRadioBtnCnpj.isSelected() == false) {
            jRadioBtnCpf.setEnabled(true);
            jFTxtCpfCnpj.setText("");
        }
    }//GEN-LAST:event_jRadioBtnCnpjActionPerformed
     
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelStatus;
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

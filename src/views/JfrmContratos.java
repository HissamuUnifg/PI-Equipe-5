
package views;


import controls.CarrosDAO;
import controls.CidadesDAO;
import controls.ClientesDAO;
import controls.ConexaoDAO;
import controls.EnderecosDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultFormatterFactory;
import models.ClsCarros;
import models.ClsCidades;
import models.ClsClientes;
import models.ClsContratos;
import models.ClsControlaCpNumeric;
import models.ClsEnderecos;
import models.ClsImpressao;
import models.ClsLogin;
import models.ClsMascaraCampos;
import models.ClsValidacoes;

/**
 *  
 * @author Tiago Teixeira
 */
public class JfrmContratos extends javax.swing.JFrame {

    private String userLoged;
    private int userIdLoged;
    private String CpfUserLoged;
    
    //INDICADOR DE TIPO DE CONTRATO
    private int tipoContrato; // 0 KM, 1 DIARIA
    //GLOBAIS INDICES DAS LISTAS
    private int indiceCliente;
    private int indiceCarro;
    private boolean precionado;
    private boolean editando;
    SimpleDateFormat formatoBr = new SimpleDateFormat("dd-MM-yyyy");
    Locale locale;
    NumberFormat FormatterMoeda;
    ClsValidacoes clsValidacoes;
    
    //GLOBAIS OBJETOS DE CONEXAO
    ConexaoDAO conexaoDAO;
    CarrosDAO carrosDAO;
    ClientesDAO clientesDAO;
    EnderecosDAO enderecosDAO;
    
    
    //GLOBAIS OBJETOS LISTA 
    List<ClsCarros> listaCarros;
    List<ClsClientes> listaClientes;
    
    //GLOBAIS OBJETOS USO COMUM
    ClsEnderecos clsEnderecos;
    ClsCidades clsCidades;
    ClsContratos clsContratos;
    ClsCarros clsCarros;
    ClsClientes clsClientes;
    ClsMascaraCampos clsMascaracampos;
    
    
  
    
    public JfrmContratos() {
        initComponents();
        setIcon();
    }
    
    public JfrmContratos(ClsLogin clslogin) {
        initComponents();
        setIcon();

        clsEnderecos = new ClsEnderecos();
        clsCidades = new ClsCidades();
        clsContratos = new ClsContratos();
        clsCarros = new ClsCarros();
        clsClientes = new ClsClientes();
        clsMascaracampos = new ClsMascaraCampos();
        locale = new Locale("pt", "BR");
        FormatterMoeda = NumberFormat.getCurrencyInstance(locale);
        clsValidacoes = new ClsValidacoes();

        carrosDAO = new CarrosDAO();
        clientesDAO = new ClientesDAO();
        enderecosDAO = new EnderecosDAO();


        userLoged = clslogin.getUserLoged();
        userIdLoged = clslogin.getId();
        CpfUserLoged = clslogin.getCpfUserLoged();
       
        listaCarros = carrosDAO.selectAll();
        listaClientes = clientesDAO.selectAll();
        
        
        precionado = false;
        editando = false;
        
        controleDigitacao();
        loadCombCarro();
        loadCombTipoStatus();
        loadCombCliente();
        disableControl();
        try {
            addMascara();
        } catch (ParseException ex) {
            System.out.println("Erro aqui: "+ ex);
        }
                
    }
    
    /**
     * Responsavel por trocar a função e icone do botão "jBtnNovo"
     * Passando false o botão assume a posição de novo
     * Passando true o botão assume a posição de cancelar 
     * @param funcao 
     */        
    private void setIconBtnNv(boolean funcao) {
        if (funcao == true) {
            jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_cancelar.png"))); // NOI18N
            jBtnNovo.setToolTipText("Clique aqui para cancelar a operacao");
        } else {
            jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); // NOI18N
            jBtnNovo.setToolTipText("Clique aqui para novo Veiculo");
        }
    }
    
    private void addMascara() throws ParseException {
        JfTxtDataChegada.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraData(JfTxtDataChegada)));
        JfTxtDataSaida.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraData(JfTxtDataSaida)));
        jFtxtCep.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCep(jFtxtCep)));
        jFtxtFone.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraTelefone(jFtxtFone)));
        jFtxtCelular.setFormatterFactory(new DefaultFormatterFactory(clsMascaracampos.mascaraCelular(jFtxtCelular)));
    }
    
    private void controleDigitacao() {
        //todos os Jtext que estiver aqui só vão aceitar numeros e pontos
        jTxtValorDiaria.setDocument(new ClsControlaCpNumeric());
        jTxtValorKmRodado.setDocument(new ClsControlaCpNumeric());
        jTxtQtdDias.setDocument(new ClsControlaCpNumeric());
        jTxtValorKmRodado.setDocument(new ClsControlaCpNumeric());
        jTxtValorExtra.setDocument(new ClsControlaCpNumeric());

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
    
    
    private void disableControl(){
        //desabilitando os comboBox
        jCboNome.setEnabled(false);
        jCboPlaca.setEnabled(false);
        jCboTipoContrato.setEnabled(false);
        jCboStatusContrato.setEnabled(false);
        //desabilitando os botoes
        jBtnRecalcular.setEnabled(false);
        jBtnEditar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnImprimir.setEnabled(false);
        jBtnSalvar.setEnabled(false);
        jBtnBuscar.setEnabled(true);
        //desabilitando campos de texto
        jTxtObservacoes.setEnabled(true);
        jTxtBairro.setEnabled(false);
        jTxtEmail.setEnabled(false);
        jTxtEstado.setEnabled(false);
        jTxtNumero.setEnabled(false);
        jTxtReferencia.setEnabled(false);
        jTxtRua.setEnabled(false);
        jFTxtCpfCnpj.setEnabled(false);
        jFtxtCelular.setEnabled(false);
        jFtxtCep.setEnabled(false);
        JfTxtDataChegada.setEnabled(false);
        JfTxtDataSaida.setEnabled(false);
        jFtxtFone.setEnabled(false);
        jFtxtRgIe.setEnabled(false);
        jFtxtCnh.setEnabled(false);
        jTxtClasse.setEnabled(false);
        jTxtTipo.setEnabled(false);
        jTxtCidade.setEnabled(false);
        jTxtTipoEnd.setEnabled(false);
        jTxtValorDiaria.setEnabled(false);
        jTxtValorExtra.setEnabled(false);
        jTxtValorTotal.setEnabled(false);
        jTxtValorKmFinal.setEnabled(false);
        jTxtQtdDias.setEnabled(false);
        jTxtValorKmRodado.setEnabled(false);
        
        jTxtAnoFabricacao.setEnabled(false);
        jTxtAnoModelo.setEnabled(false);
        jTxtChassi.setEnabled(false);
        jTxtCor.setEnabled(false);
        jTxtKm.setEnabled(false);
        jTxtMarca.setEnabled(false);
        jTxtNome.setEnabled(false);
        jTxtNumeroRenavan.setEnabled(false);
        jTxtVeiculo.setEnabled(false);
    
    }
    
    private void enableControl() {
        jCboNome.setEnabled(true);
        jCboPlaca.setEnabled(true);
        jCboTipoContrato.setEnabled(true);
        jCboStatusContrato.setEnabled(true);
        //desabilitando os botoes
        jBtnRecalcular.setEnabled(true);
        jBtnEditar.setEnabled(false);
        jBtnExcluir.setEnabled(true);
        jBtnImprimir.setEnabled(true);
        jBtnSalvar.setEnabled(true);
        jBtnBuscar.setEnabled(false);
        
        JfTxtDataChegada.setEnabled(true);
        JfTxtDataSaida.setEnabled(true);
        jTxtObservacoes.setEnabled(true);
        
    }
    
    private void clearTxt() {
    
        jTxtObservacoes.setText("");
        jTxtBairro.setText("");
        jTxtEmail.setText("");
        jTxtEstado.setText("");
        jTxtNumero.setText("");
        jTxtReferencia.setText("");
        jTxtRua.setText("");
        jFTxtCpfCnpj.setText("");
        jFtxtCelular.setText("");
        jFtxtCep.setText("");
        JfTxtDataChegada.setText("");
        JfTxtDataSaida.setText("");
        jFtxtFone.setText("");
        jFtxtRgIe.setText("");
        jFtxtCnh.setText("");
        jTxtClasse.setText("");
        jTxtTipo.setText("");
        
        jTxtValorDiaria.setText("");
        jTxtValorExtra.setText("");
        jTxtValorTotal.setText("");
        jTxtValorKmFinal.setText("");
        jTxtQtdDias.setText("");
        jTxtValorKmRodado.setText("");
        
        jTxtAnoFabricacao.setText("");
        jTxtAnoModelo.setText("");
        jTxtChassi.setText("");
        jTxtCor.setText("");
        jTxtKm.setText("");
        jTxtMarca.setText("");
        jTxtNome.setText("");
        jTxtNumeroRenavan.setText("");
        jTxtVeiculo.setText("");
    }
    
    /**
     * Passando true ele habilita os controles Jtext para Tipo de Contrato por KM
     * Passando false ele habilita os controles Jtext para o Tipo de contrato por Dia Locado
     * @param Tipo 
     */
    private void enableTipoKM(boolean tipo) {
        if (tipo) {
            
            jTxtValorExtra.setEnabled(true);
            jTxtValorTotal.setEnabled(false);
            jTxtValorKmFinal.setEnabled(true);
            jTxtValorKmFinal.requestFocus();
            jTxtQtdDias.setEnabled(false);

        } else {

            jTxtValorExtra.setEnabled(true);
            jTxtValorTotal.setEnabled(false);
            jTxtValorKmFinal.setEnabled(false);
            jTxtQtdDias.setEnabled(true);
            jTxtQtdDias.requestFocus();

        }
    }

    private void loadCombCliente() {
        if (listaClientes.size() > 1) {
            for (models.ClsClientes clC : listaClientes) {
                jCboNome.addItem(clC.getNome());
            }
        }
    }
    
    private void loadCombCarro() {
        if (listaCarros.size() > 1) {
        for (models.ClsCarros clCar: listaCarros) {
            jCboPlaca.addItem(clCar.getPlaca());
        }
        }
    }
    
    private void loadCombTipoStatus() {
        jCboTipoContrato.addItem("KM-RODADO");
        jCboTipoContrato.addItem("DIÁRIA");
        
        jCboStatusContrato.addItem("ABERTO");
        jCboStatusContrato.addItem("ANDAMENTO");
        jCboStatusContrato.addItem("FINALIZADO");
        
    }
    
    
    private void buscaIndiceCarros(String placaCarro) {
        for (int i = 0; i < listaCarros.size(); i++) {
            if (listaCarros.get(i).getPlaca().equals(placaCarro)) {
                indiceCarro = i;
                clsCarros = listaCarros.get(indiceCarro);
                clsContratos.setIdCarro(clsCarros.getId());
                loadTxtCarro();
                break;
            }
        }
    }
    private void buscaIndiceCarrosID(int  idCarro) {
        for (int i = 0; i < listaCarros.size(); i++) {
            if (listaCarros.get(i).getId() == idCarro) {
                indiceCarro = i;
                clsCarros = listaCarros.get(indiceCarro);
                clsContratos.setIdCarro(clsCarros.getId());
                loadTxtCarro();
                break;
            }
        }
    }
    
    private void buscaIndiceClientes(String nomeCliente){
        boolean encontrado = false;
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNome().equals(nomeCliente)) {
                indiceCliente = i;
                clsClientes = listaClientes.get(indiceCliente);
                clsContratos.setIdCliente(clsClientes.getId());
                clsContratos.setIdColaborador(userIdLoged);
                loadTxtCliente(i);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            clsEnderecos = enderecosDAO.selectId(clsClientes.getId());
            loadTxtEndCLiente();
        }
    }
    private void buscaIndiceClientesID(int idCliente){
        boolean encontrado = false;
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == idCliente) {
                indiceCliente = i;
                clsClientes = listaClientes.get(indiceCliente);
                clsContratos.setIdCliente(clsClientes.getId());
                clsContratos.setIdColaborador(userIdLoged);
                loadTxtCliente(i);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            clsEnderecos = enderecosDAO.selectId(clsClientes.getId());
            loadTxtEndCLiente();
        }
    }
    
    private void loadTxtCliente(int indice) {
        
        jTxtObservacoes.setText(listaClientes.get(indice).getObservacoes());
        jTxtEmail.setText(listaClientes.get(indice).getEmail());
        if (listaClientes.get(indice).getNome() == null || listaClientes.get(indice).getNome().equals("")) {
            jCboNome.setSelectedItem(listaClientes.get(indice).getRazaoSocial());
            
        } else if (listaClientes.get(indice).getRazaoSocial() == null || listaClientes.get(indice).getRazaoSocial().equals("")) {
            jCboNome.setSelectedItem(listaClientes.get(indice).getNome());

        }
        if (listaClientes.get(indice).getCpf() == null || listaClientes.get(indice).getCpf().equals("")) {
            jFTxtCpfCnpj.setText(listaClientes.get(indice).getCnpj());

        } else if (listaClientes.get(indice).getCnpj() == null || listaClientes.get(indice).getCnpj().equals("")) {
            jFTxtCpfCnpj.setText(listaClientes.get(indice).getCpf());

        }
        jFtxtCelular.setText(listaClientes.get(indice).getCelular());
        jFtxtFone.setText(listaClientes.get(indice).getTelefone());
        if (listaClientes.get(indice).getRg().equals("") || listaClientes.get(indice).getRg() == null) {
            jFtxtRgIe.setText("" + listaClientes.get(indice).getIe());
        } else if (listaClientes.get(indice).getIe().equals("") || listaClientes.get(indice).getIe() == null) {
            jFtxtRgIe.setText("" + listaClientes.get(indice).getRg());
        }
        jFtxtCnh.setText("" + listaClientes.get(indice).getCnh());

    }
    
    private void loadTxtEndCLiente() {
 
        jTxtBairro.setText(clsEnderecos.getBairro());
        jTxtNumero.setText(clsEnderecos.getNumero());
        jTxtReferencia.setText(clsEnderecos.getReferencia());
        jTxtRua.setText(clsEnderecos.getRua());
        jFtxtCep.setText(clsEnderecos.getCep());
        jTxtEstado.setText(clsEnderecos.getEstado());
        jTxtTipoEnd.setText(clsEnderecos.getTipoEndereco());
        jTxtCidade.setText(clsEnderecos.getNomeCidade());
    }
    
    private void loadTxtCarro() {
        jTxtNome.setText(clsCarros.getNome());
        jTxtClasse.setText(clsCarros.getClasse());
        jTxtTipo.setText(clsCarros.getTipoVeiculo());
        jTxtValorKmRodado.setText(FormatterMoeda.format(clsCarros.getValorKmRd()));
        jTxtValorDiaria.setText(FormatterMoeda.format(clsCarros.getValorDiariaLoc()));
        jTxtAnoFabricacao.setText(""+clsCarros.getAnoFabricacao());
        jTxtAnoModelo.setText(""+clsCarros.getAnoModelo());
        jTxtChassi.setText(clsCarros.getChassi());
        jTxtCor.setText(clsCarros.getCor());
        jTxtKm.setText(""+clsCarros.getKmRodados());
        jTxtMarca.setText(clsCarros.getMarca());
        jTxtNumeroRenavan.setText(clsCarros.getRenavam());
        jTxtVeiculo.setText(clsCarros.getNome());
 
    }
    
    private void loadTxtFull(int idCarro, int idCliente) {
        buscaIndiceCarrosID(idCarro);
        buscaIndiceClientesID(idCliente);
        jTxtObservacoes.setText(clsContratos.getObservacoes());
        jTxtValorExtra.setText(FormatterMoeda.format(clsContratos.getValorExtra()));
        jTxtValorTotal.setText(FormatterMoeda.format(clsContratos.getValorTotal()));
        jTxtValorKmFinal.setText(""+clsContratos.getQuantidadeKmRet());
        jTxtQtdDias.setText(""+clsContratos.getQuantidadeDiarias());
    }
    
        /**
     * Usado por lançar um MensageBox de campo obrigatório
     * @param dado 
     */
    private void msgObgCampo(String dado) {
        JOptionPane.showMessageDialog(this, "Olá " + userLoged + " esse dado: " + dado + " "
                + "é obrigatório", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    
     /**
     * Usado por lançar um MensageBox de campo obrigatório Advertencia
     * @param dado 
     */
    private void msgAdvCampo(String dado) {
        JOptionPane.showMessageDialog(this, "Olá " + userLoged + " esse dado: " + dado + " "
                + "está maior ou menor do que o permitido!", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    
     /**
     * Usado por lançar um MensageBox de campo obrigatório Erro
     * @param dado 
     */
    private void msgErrCampo(String dado) {
        JOptionPane.showMessageDialog(this, "Olá " + userLoged + " esse dado: " + dado + ""
                + " é invalido!", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private boolean validaCampos(){
        if (jCboNome.getSelectedIndex() == 0) {
            msgObgCampo("Nome Cliente");
            jCboNome.requestFocus();
            return false;
        } else if (jCboPlaca.getSelectedIndex() == 0) {
            msgAdvCampo("Carro");
            jCboPlaca.requestFocus();
            return false;
        } else  if (jCboTipoContrato.getSelectedIndex() == 0) {
            msgObgCampo("Tipo Contrato");
            jCboTipoContrato.requestFocus();
            return false;
        } else if (jCboStatusContrato.getSelectedIndex() == 0) {
            msgAdvCampo("Status Contrato");
            jCboStatusContrato.requestFocus();
            return false;
        } else if (jTxtValorKmFinal.getText().length() > 5) {
            msgErrCampo("Valor Km Final");
            jTxtValorKmFinal.requestFocus();
            return false;
        } else if (jTxtQtdDias.getText().length() > 3) {
            msgErrCampo("Quantidade de Dias");
            jTxtQtdDias.requestFocus();
            return false;
        } else if (JfTxtDataSaida.getText().length() < 1) {
            msgObgCampo("Data Saida");
            JfTxtDataSaida.requestFocus();
            return false;
        } else if (JfTxtDataChegada.getText().length() < 1) {
            msgErrCampo("Data Chegada");
            JfTxtDataChegada.requestFocus();
            return false;
        } else {
             return true;
        }
           
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnNovo = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jBtnImprimir = new javax.swing.JButton();
        jBtnBuscar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnRecalcular = new javax.swing.JButton();
        jPanDadosGerais = new javax.swing.JPanel();
        jFtxtFone = new javax.swing.JFormattedTextField();
        jFtxtCelular = new javax.swing.JFormattedTextField();
        jTxtEmail = new javax.swing.JTextField();
        jCboNome = new javax.swing.JComboBox<>();
        jFTxtCpfCnpj = new javax.swing.JFormattedTextField();
        jFtxtRgIe = new javax.swing.JFormattedTextField();
        jFtxtCnh = new javax.swing.JFormattedTextField();
        jPanelDadosEnderecos = new javax.swing.JPanel();
        jTxtRua = new javax.swing.JTextField();
        jTxtNumero = new javax.swing.JTextField();
        jTxtBairro = new javax.swing.JTextField();
        jTxtEstado = new javax.swing.JTextField();
        jTxtReferencia = new javax.swing.JTextField();
        jTxtCidade = new javax.swing.JTextField();
        jTxtTipoEnd = new javax.swing.JTextField();
        jFtxtCep = new javax.swing.JFormattedTextField();
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
        jTxtObservacoes = new javax.swing.JTextField();
        jTxtValorDiaria = new javax.swing.JTextField();
        jTxtValorExtra = new javax.swing.JTextField();
        JfTxtDataChegada = new javax.swing.JFormattedTextField();
        JfTxtDataSaida = new javax.swing.JFormattedTextField();
        jLabelCodigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1055, 640));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add_121935.png"))); // NOI18N
        jBtnNovo.setToolTipText("Clique aqui para novo Contrato");
        jBtnNovo.setBorder(null);
        jBtnNovo.setFocusPainted(false);
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new_121792.png"))); // NOI18N
        jBtnEditar.setToolTipText("Clique aqui para editar Contrato");
        jBtnEditar.setBorder(null);
        jBtnEditar.setFocusPainted(false);

        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_121760.png"))); // NOI18N
        jBtnSalvar.setToolTipText("Clique aqui para salvar Contrato");
        jBtnSalvar.setBorder(null);
        jBtnSalvar.setFocusPainted(false);

        jBtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print_121773.png"))); // NOI18N
        jBtnImprimir.setToolTipText("Clique aqui para imprimir Contrato");
        jBtnImprimir.setBorder(null);
        jBtnImprimir.setFocusPainted(false);
        jBtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnImprimirActionPerformed(evt);
            }
        });

        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search_121759.png"))); // NOI18N
        jBtnBuscar.setToolTipText("Clique aqui para buscar Contrato");
        jBtnBuscar.setBorder(null);
        jBtnBuscar.setFocusPainted(false);

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_121907.png"))); // NOI18N
        jBtnExcluir.setToolTipText("Clique aqui para excluir Contrato");
        jBtnExcluir.setBorder(null);
        jBtnExcluir.setFocusPainted(false);

        jBtnRecalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/rotate_121763.png"))); // NOI18N
        jBtnRecalcular.setToolTipText("Clique aqui para recalcular Contrato");
        jBtnRecalcular.setBorder(null);
        jBtnRecalcular.setFocusPainted(false);

        jPanDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais"), "Dados Gerais"));

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
        jCboNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jCboNome.setToolTipText("Selecione o cliente para iniciar o contrato");
        jCboNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));
        jCboNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCboNomeFocusLost(evt);
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

        javax.swing.GroupLayout jPanDadosGeraisLayout = new javax.swing.GroupLayout(jPanDadosGerais);
        jPanDadosGerais.setLayout(jPanDadosGeraisLayout);
        jPanDadosGeraisLayout.setHorizontalGroup(
            jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCboNome, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jFtxtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                        .addComponent(jFTxtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFtxtRgIe, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFtxtCnh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTxtEmail))
                .addContainerGap())
        );
        jPanDadosGeraisLayout.setVerticalGroup(
            jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanDadosGeraisLayout.createSequentialGroup()
                .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jFTxtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFtxtRgIe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFtxtCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCidade)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFtxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDadosEnderecosLayout.setVerticalGroup(
            jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosEnderecosLayout.createSequentialGroup()
                .addGroup(jPanelDadosEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFtxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jCboPlaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jCboPlaca.setToolTipText("Selecione a placa do veiculo a ser alugado");
        jCboPlaca.setBorder(javax.swing.BorderFactory.createTitledBorder("Placa"));
        jCboPlaca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCboPlacaFocusLost(evt);
            }
        });

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
                        .addComponent(jTxtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
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
                        .addGap(14, 14, 14)
                        .addComponent(jTxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtTipo)
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

        jPanelDadosValores.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Valores e Finalização Contrato"));
        jPanelDadosValores.setToolTipText("Selecionar informações do tipo de contrato, valores, diarias, status do contrato!");

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
        jCboTipoContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jCboTipoContrato.setToolTipText("Selecione o tipo de contrato, escolha entre diaria ou km rodado");
        jCboTipoContrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Contrato"));
        jCboTipoContrato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCboTipoContratoFocusLost(evt);
            }
        });

        jCboStatusContrato.setBackground(new java.awt.Color(240, 240, 240));
        jCboStatusContrato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCboStatusContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jCboStatusContrato.setToolTipText("Selecione o status do contrato do cliente");
        jCboStatusContrato.setBorder(javax.swing.BorderFactory.createTitledBorder("Status Contrato"));
        jCboStatusContrato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCboStatusContratoFocusLost(evt);
            }
        });

        jTxtValorKmFinal.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorKmFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorKmFinal.setToolTipText("Digite o KM rodado no ato da entrega do veiculo");
        jTxtValorKmFinal.setBorder(javax.swing.BorderFactory.createTitledBorder("KM Rodado Final"));
        jTxtValorKmFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtValorKmFinalFocusLost(evt);
            }
        });
        jTxtValorKmFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTxtValorKmFinalMouseClicked(evt);
            }
        });

        jTxtQtdDias.setBackground(new java.awt.Color(240, 240, 240));
        jTxtQtdDias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtQtdDias.setToolTipText("Digite a quantidade de dias que será alugado o veiculo");
        jTxtQtdDias.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias Alugados"));
        jTxtQtdDias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtQtdDiasFocusLost(evt);
            }
        });
        jTxtQtdDias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTxtQtdDiasMouseClicked(evt);
            }
        });

        jTxtObservacoes.setBackground(new java.awt.Color(240, 240, 240));
        jTxtObservacoes.setToolTipText("Breve observação caso houver sobre o veiculo");
        jTxtObservacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        jTxtValorDiaria.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorDiaria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorDiaria.setToolTipText("Exibição do valor da diária desse veiculo");
        jTxtValorDiaria.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Diaria"));

        jTxtValorExtra.setBackground(new java.awt.Color(240, 240, 240));
        jTxtValorExtra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtValorExtra.setToolTipText("Campo para digitação de despesas extras, como multas, avarias e etc.");
        jTxtValorExtra.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores Extras"));
        jTxtValorExtra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtValorExtraFocusLost(evt);
            }
        });
        jTxtValorExtra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTxtValorExtraMouseClicked(evt);
            }
        });

        JfTxtDataChegada.setBackground(new java.awt.Color(240, 240, 240));
        JfTxtDataChegada.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Chegada"));
        JfTxtDataChegada.setToolTipText("Inserir data de chegada do Veiculo!");
        JfTxtDataChegada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JfTxtDataChegada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JfTxtDataChegadaFocusLost(evt);
            }
        });

        JfTxtDataSaida.setBackground(new java.awt.Color(240, 240, 240));
        JfTxtDataSaida.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Saida"));
        JfTxtDataSaida.setToolTipText("Inserir data de saida do Veiculo!");
        JfTxtDataSaida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JfTxtDataSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JfTxtDataSaidaFocusLost(evt);
            }
        });

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
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTxtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosValoresLayout.createSequentialGroup()
                        .addComponent(jTxtValorKmRodado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtValorKmFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JfTxtDataSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jTxtValorExtra))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JfTxtDataChegada, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jTxtValorTotal))
                .addGap(15, 15, 15))
        );
        jPanelDadosValoresLayout.setVerticalGroup(
            jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosValoresLayout.createSequentialGroup()
                        .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtValorKmRodado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCboTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtValorKmFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosValoresLayout.createSequentialGroup()
                        .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JfTxtDataChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JfTxtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCboStatusContrato)
                    .addGroup(jPanelDadosValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtValorExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jLabelCodigo.setText("Codigo:");
        jLabelCodigo.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnRecalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnRecalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jBtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnImprimirActionPerformed

          JFileChooser fileChooser = new JFileChooser();
          fileChooser.setDialogTitle("Gravar contrato");
          fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
          FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos Microsoft Word", "DOC", "DOCX");
          fileChooser.setFileFilter(filtro);
          fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
          int retorno = fileChooser.showSaveDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File arquivoSalvo = fileChooser.getSelectedFile();
            String caminhoArquivo = fileChooser.getCurrentDirectory().toString();
            models.ClsImpressao clsImp = new ClsImpressao(clsEnderecos, clsClientes, clsCarros, clsContratos);
            try {
                if (tipoContrato == 0) {
                    clsImp.criarContratoKM(caminhoArquivo + "\\" + arquivoSalvo.getName());
                } else if (tipoContrato == 1) {
                    clsImp.criarContratoDiaria(caminhoArquivo + "\\" + arquivoSalvo.getName());
                }

            } catch (Exception ex) {
                System.out.println("Não gerou o arquivo");
            }
            System.out.println(caminhoArquivo + "\\" + arquivoSalvo.getName());
        } else {
            System.out.println("Canlecou aqui.");
        }
    }//GEN-LAST:event_jBtnImprimirActionPerformed

    private void jCboTipoContratoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCboTipoContratoFocusLost

        if (jCboTipoContrato.getSelectedItem().equals("KM-RODADO")) {
            enableTipoKM(true);
            tipoContrato = 0;
            clsContratos.setTipoLocacao(jCboTipoContrato.getSelectedItem().toString());
        } else if (jCboTipoContrato.getSelectedItem().equals("DIÁRIA")) {
            tipoContrato = 1;
            clsContratos.setTipoLocacao(jCboTipoContrato.getSelectedItem().toString());
            enableTipoKM(false);
        }


    }//GEN-LAST:event_jCboTipoContratoFocusLost

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        if (precionado == false) {
            setIconBtnNv(true);
            enableControl();
            clearTxt();
            precionado = true;
            editando = false;
            jTxtNome.requestFocus();

        } else {
            setIconBtnNv(false);
            disableControl();
            clearTxt();
            precionado = false;
            editando = false;
        }

    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jCboNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCboNomeFocusLost

            buscaIndiceClientes(jCboNome.getSelectedItem().toString());

    }//GEN-LAST:event_jCboNomeFocusLost

    private void jCboPlacaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCboPlacaFocusLost

            buscaIndiceCarros(jCboPlaca.getSelectedItem().toString());
    
    }//GEN-LAST:event_jCboPlacaFocusLost

    private void jCboStatusContratoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCboStatusContratoFocusLost

            clsContratos.setStatus(jCboStatusContrato.getSelectedItem().toString());

    }//GEN-LAST:event_jCboStatusContratoFocusLost

    private void jTxtValorKmFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtValorKmFinalFocusLost
        clsContratos.setValorExtra(0);
        jTxtValorExtra.setText(FormatterMoeda.format(clsContratos.getValorExtra()));
        if(jTxtValorKmFinal.getText().length() < 1){
            JOptionPane.showMessageDialog(this, "O campo deve ser preenchido", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
        }else{
            clsContratos.setQuantidadeKmRet(Integer.parseInt(jTxtValorKmFinal.getText()));
            jTxtValorTotal.setText(FormatterMoeda.format(clsContratos.calcularValorTotalKM(clsCarros.getValorKmRd())));
        }
    }//GEN-LAST:event_jTxtValorKmFinalFocusLost

    private void jTxtValorExtraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtValorExtraFocusLost
        if("".equals(jTxtValorExtra.getText())){
            clsContratos.setValorExtra(0);
        }else if (jTxtValorExtra.getText().length() > 14){
            JOptionPane.showMessageDialog(this, "O valor inserido é maior que o permitido", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                clsContratos.setValorExtra(clsValidacoes.formataMoeda(jTxtValorExtra.getText()));
                jTxtValorTotal.setText(FormatterMoeda.format(clsContratos.calcularValorTotalKM(clsCarros.getValorKmRd())));
                jTxtValorExtra.setText(FormatterMoeda.format(clsContratos.getValorExtra()));
            } catch (ParseException ex) {
                System.out.println(""+ex);
            }
            
        }
        
    }//GEN-LAST:event_jTxtValorExtraFocusLost

    private void jTxtValorExtraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtValorExtraMouseClicked
        jTxtValorExtra.setText("");
    }//GEN-LAST:event_jTxtValorExtraMouseClicked

    private void jTxtQtdDiasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtQtdDiasFocusLost
        clsContratos.setValorExtra(0);
        jTxtValorExtra.setText(FormatterMoeda.format(clsContratos.getValorExtra()));
        clsContratos.setQuantidadeDiarias(Integer.parseInt(jTxtQtdDias.getText()));
        jTxtValorTotal.setText(FormatterMoeda.format(clsContratos.calcularValorTotalDIA(clsCarros.getValorDiariaLoc())));
    }//GEN-LAST:event_jTxtQtdDiasFocusLost

    private void jTxtValorKmFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtValorKmFinalMouseClicked
        jTxtValorKmFinal.setText("");
    }//GEN-LAST:event_jTxtValorKmFinalMouseClicked

    private void jTxtQtdDiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtQtdDiasMouseClicked
        jTxtQtdDias.setText("");
    }//GEN-LAST:event_jTxtQtdDiasMouseClicked

    private void JfTxtDataSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JfTxtDataSaidaFocusLost
        if (clsValidacoes.validaDataFormatoBR(JfTxtDataSaida.getText()) == true) {
            clsContratos.setDataSaida(clsValidacoes.dataFormatoUS(JfTxtDataSaida.getText()));
            clsContratos.setDataContrato(clsValidacoes.dataFormatoUS(JfTxtDataSaida.getText()));
        } else {
            msgErrCampo("Data Saida");
        }
    }//GEN-LAST:event_JfTxtDataSaidaFocusLost

    private void JfTxtDataChegadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JfTxtDataChegadaFocusLost
        if (clsValidacoes.validaDataFormatoBR(JfTxtDataChegada.getText()) == true) {
            clsContratos.setDataChegada(clsValidacoes.dataFormatoUS(JfTxtDataChegada.getText()));
            clsContratos.setDataContrato(clsValidacoes.dataFormatoUS(JfTxtDataSaida.getText()));
        } else {
            msgErrCampo("Data Saida");
        }
    }//GEN-LAST:event_JfTxtDataChegadaFocusLost

    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField JfTxtDataChegada;
    private javax.swing.JFormattedTextField JfTxtDataSaida;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnImprimir;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnRecalcular;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JComboBox<String> jCboNome;
    private javax.swing.JComboBox<String> jCboPlaca;
    private javax.swing.JComboBox<String> jCboStatusContrato;
    private javax.swing.JComboBox<String> jCboTipoContrato;
    private javax.swing.JFormattedTextField jFTxtCpfCnpj;
    private javax.swing.JFormattedTextField jFtxtCelular;
    private javax.swing.JFormattedTextField jFtxtCep;
    private javax.swing.JFormattedTextField jFtxtCnh;
    private javax.swing.JFormattedTextField jFtxtFone;
    private javax.swing.JFormattedTextField jFtxtRgIe;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JPanel jPanDadosGerais;
    private javax.swing.JPanel jPaneDadosVeiculos;
    private javax.swing.JPanel jPanelDadosEnderecos;
    private javax.swing.JPanel jPanelDadosValores;
    private javax.swing.JTextField jTxtAnoFabricacao;
    private javax.swing.JTextField jTxtAnoModelo;
    private javax.swing.JTextField jTxtBairro;
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
    private javax.swing.JTextField jTxtObservacoes;
    private javax.swing.JTextField jTxtQtdDias;
    private javax.swing.JTextField jTxtReferencia;
    private javax.swing.JTextField jTxtRua;
    private javax.swing.JTextField jTxtTipo;
    private javax.swing.JTextField jTxtTipoEnd;
    private javax.swing.JTextField jTxtValorDiaria;
    private javax.swing.JTextField jTxtValorExtra;
    private javax.swing.JTextField jTxtValorKmFinal;
    private javax.swing.JTextField jTxtValorKmRodado;
    private javax.swing.JTextField jTxtValorTotal;
    private javax.swing.JTextField jTxtVeiculo;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone_contrato2.png")));
    }
}

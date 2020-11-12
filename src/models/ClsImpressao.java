/*
 Classe responsavel por retornar para o usuário um relatório com os dados solicitados
 Para o correto funcionamento da classe terá que baixar os plugns do iReport e Jasper Studio
 Tem que importar todas as bibliotecas Jasper para o projeto na maquina que for rodar o programa
 Link do iReport, tem que cadastrar no Site para baixar.
 https://community.jaspersoft.com/project/ireport-designer/releases?release_id=838904&download=https%3A/
 /sourceforge.net/projects/ireport/files/iReport/iReport-5.6.0/iReport-5.6.0-windows-installer.exe/download

 Link do Jasper Studio 
 https://community.jaspersoft.com/project/jaspersoft-studio/releases?release_id=1172456&download=https%3A/
 /sourceforge.net/projects/jasperstudio/files/JaspersoftStudio-6.15.0/TIB_js-studiocomm_6.15.0_windows_x86_64.exe/download

 As bibliotecas .jar ficam na pasta que o Jasper Studio Intala caso pegue o instalaor, caso pegue o Zip vai encontrar as bibliotecas 
 nas seguintes pastas.

\iReport-5.6.0\ireport\libs\xlan.jar
\iReport-5.6.0\ireport\Modules\*.*.jar
\iReport-5.6.0\ireport\Modules\ext*.*.jar

 */
package models;

import controls.ConexaoDAO;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * 
 * @author Tiago Teixeira
 */


/*
        funcão para colcar no metodo de chamada de impressão
        //carrega o diretorio raiz de onde o arquivo jrxml está armazenado. 
       File directory = new File("./src/relatorios/NOME RELATORIO.jrxml");
       // passa o caminho do relatorio e o parametro para carregar o relatorio. 
       try {
            new NOME DA FORM().ClsImpressao(directory.getAbsolutePath(),"PARAMETRO RELATORIO", "VALOR A FILTRAR", "TITULO DA TELA JFRAME");
        } catch (ClassNotFoundException | SQLException | JRException e) {
            System.out.println("Erro foi aqui" + e);
        }
*/

public class ClsImpressao {
    ClsEnderecos clsEnd = new ClsEnderecos();
    ClsClientes clsCli = new ClsClientes();
    ClsCarros clsCar = new ClsCarros();
    ClsContratos clsCont = new ClsContratos();
    
    public void ClsImpressao(String nomeRel, String parametro, String valorParametro, String tituloRelatorio) throws JRException, SQLException, ClassNotFoundException {
        //gerando o jasper design
        JasperDesign desenho = JRXmlLoader.load(nomeRel);

        //compila o relatório
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);
         
        //executa o relatório
        Map parametros = new HashMap();
        parametros.put(parametro, valorParametro);
        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoDAO.getConexaoDAO());
        
        //exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao, true);
        relOpemFrame(tituloRelatorio, impressao);
        
        //fecha conexão com o banco de dados
      
        ConexaoDAO.FecharConexao();
    }
    public void ClsImpressao(String nomeRel, String nomeSubRel, String parametro, String valorParametro, String tituloRelatorio) throws JRException, SQLException, ClassNotFoundException {
        //gerando o jasper design
        JasperDesign desenho = JRXmlLoader.load(nomeRel);
        JasperDesign desenho2 = JRXmlLoader.load(nomeSubRel);

        //compila o relatório
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);
        JasperReport relatorio2 = JasperCompileManager.compileReport(desenho2);

               

        //executa o relatório
        Map parametros = new HashMap();
        parametros.put("SUBREPORT_DIR", desenho2);
        parametros.put(parametro, valorParametro);
        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoDAO.getConexaoDAO());
        
        //exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao, true);
        relOpemFrame(tituloRelatorio, impressao);
        
        //fecha conexão com o banco de dados
      
        ConexaoDAO.FecharConexao();
    }
    private static void relOpemFrame( String titulo, JasperPrint print ) {
         /*
         * Cria um JRViewer para exibir o relatório.
        */
        JRViewer viewer = new JRViewer( print );
 
        // cria o JFrame
        JFrame frameRelatorio = new JFrame( titulo );
 
        // adiciona o JRViewer no JFrame
        frameRelatorio.add( viewer, BorderLayout.CENTER );
 
        // configura o tamanho padrão do JFrame
        frameRelatorio.setSize( 500, 500 );
 
        // maximiza o JFrame para ocupar a tela toda.
        frameRelatorio.setExtendedState( JFrame.MAXIMIZED_BOTH );
 
        // configura a operação padrão quando o JFrame for fechado.
        frameRelatorio.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
 
        // exibe o JFrame
        frameRelatorio.setVisible( true );
 
    }
    
    public ClsImpressao() {
    }
    
    /**
     * Usado Para carregar a classe com os dados necessários para gerar o documento Word com o contrato do cliente.
     * Usado parametros das classes envolvidas na operação
     * @param clsEnd
     * @param clsCli
     * @param clsCar
     * @param clsCont 
     */
    public ClsImpressao(ClsEnderecos clsEnd, ClsClientes clsCli, ClsCarros clsCar, ClsContratos clsCont) {
     this.clsEnd = clsEnd;
     this.clsCli = clsCli;
     this.clsCar = clsCar;
     this.clsCont = clsCont;
    }
    
    public void criarContrato(String caminhoNomeArq) throws Exception {
        // TODO O CODIGO PARA GERAR O ARQUIVO VAI FICAR NESSE METODO, AO CRIAR O OBJETO 
        //ClsImpressão, observar o construtor quem pede os 3 objetos da tela de contratos.
       //criando o Documento em Branco
        XWPFDocument documento = new XWPFDocument();
        FileOutputStream arquivo = new FileOutputStream(new File(caminhoNomeArq+".docx"));
        
        //Titulo do Contrato
        XWPFParagraph titulo = documento.createParagraph();
        titulo.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titulo1 = titulo.createRun();
        titulo1.setFontSize(12);
        titulo1.setFontFamily("Arial");
        titulo1.setText("CONTRATO DE ALUGUEL DE VEICULOS - LOCADORA BOA VIAGEM");
        titulo1.addBreak();
        titulo1.addBreak();
        titulo1.setText("IDENTIFICAÇÃO DAS PARTES CONTRATANTES");
        titulo1.addBreak();
        titulo1.addBreak();
        
        //Registro das Parte Locadora
        XWPFParagraph partes = documento.createParagraph();
        partes.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun partes1 = partes.createRun();
        partes1.setFontSize(12);
        partes1.setFontFamily("Arial");

        partes1.setText("LOCADORA: LOCADORA BOA VIAGEM, com sede em CENTRO UNIVERSITARIO FG UNIFG, na Rua RUA DEMONSTRAÇÃO, nº 001, "
                + "bairro CENTRO, Cep 46430000, no Estado BAHIA, inscrita no CNPJ Nº 00.000.000/0001-00, e "
                + "no Cadastro Estadual sob o nº 123456789, neste ato representada pelo seu diretor TIAGO TEIXEIRA, "
                + "BRASILEIRO, DIVORCIADO, ANALISTA DE SISTEMAS, Carteira de Identidade nº 0000000000 , CPF Nº 000.000.000-00, "
                + "residente e domiciliado na Rua RUA DEMONSTRAÇÃO, nº 001, bairro CENTRO, Cep 46430000, Cidade GUANAMBI, no Estado BAHIA");

        partes1.addBreak();
        
        if(clsCli.getNome().equals("") || clsCli.getNome() == null){
       
            partes1.setText("LOCATÁRIO:  "+clsCli.getRazaoSocial()+", "+clsEnd.getPais()+", SOLTEIRO, EMPREGADO,"
                + " Carteira de Identidade nº "+clsCli.getIe()+", Carteira Nacional de Habilitação nº "+clsCli.getCnh()+""
                + " C.P.F. nº "+clsCli.getCnpj()+", residente e domiciliado na Rua "+clsEnd.getRua()+"),"
                + " nº "+clsEnd.getNumero()+", bairro  "+clsEnd.getBairro()+", Cep "+clsEnd.getCep()+", Cidade "+clsEnd.getNomeCidade()+", no Estado "+clsEnd.getEstado()+".");
        
        }else if (clsCli.getRazaoSocial().equals("") || clsCli.getRazaoSocial() == null) {
        
            partes1.setText("LOCATÁRIO:  "+clsCli.getNome()+", "+clsEnd.getPais()+", SOLTEIRO, EMPREGADO,"
                + " Carteira de Identidade nº "+clsCli.getRg()+", Carteira Nacional de Habilitação nº "+clsCli.getCnh()+""
                + " C.P.F. nº "+clsCli.getCpf()+", residente e domiciliado na Rua "+clsEnd.getRua()+"),"
                + " nº "+clsEnd.getNumero()+", bairro  "+clsEnd.getBairro()+", Cep "+clsEnd.getCep()+", Cidade "+clsEnd.getNomeCidade()+", no Estado "+clsEnd.getEstado()+".");
        }
        
       
        partes1.addBreak();
        partes1.addBreak();
        
        
        //informação do Contrato
        XWPFParagraph informacao = documento.createParagraph();
        informacao.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun informacao1 = informacao.createRun();
        informacao1.setFontSize(12);
        informacao1.setFontFamily("Arial");
        informacao1.setItalic(true);
        informacao1.setText("As partes acima identificadas têm, entre si, justo e acertado o presente Contrato de Locação de Automóvel"
                + " de Prazo Determinado, que se regerá pelas cláusulas seguintes e pelas condições descritas no presente.");
        
        informacao1.addBreak();
        informacao1.addBreak();
        
        //DO OBJETO DO CONTRATO
        XWPFParagraph objeto = documento.createParagraph();
        objeto.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun objeto1 = objeto.createRun();
        objeto1.setFontSize(12);
        objeto1.setFontFamily("Arial");
        
        objeto1.setText("DO OBJETO DO CONTRATO");
        
        objeto1.addBreak();
        
        //OBJETO 1
        
        XWPFParagraph carro = documento.createParagraph();
        carro.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun carro1 = carro.createRun();
        carro1.setFontSize(12);
        carro1.setFontFamily("Arial");
        
        carro1.setText("Cláusula 1ª. O presente contrato tem como OBJETO a locação do automóvel"
                + " Carro "+clsCar.getNome()+","
                + " de Marca "+clsCar.getMarca()+", "
                + " de Modelo "+clsCar.getModelo()+", "
                + " de Ano Modelo "+clsCar.getAnoModelo()+", "
                + " de Ano Fabricação "+clsCar.getAnoFabricacao()+","
                + " de Cor "+clsCar.getCor()+", "
                + " de Placa "+clsCar.getPlaca()+" ,"
                + " de Chassi "+clsCar.getChassi()+","
                + " de Numero Renavan "+clsCar.getRenavam()+","
                + " com KM atual de "+clsCar.getKmRodados()+","
                + " e estado ("+clsCar.getObsEstado()+"), de propriedade da LOCADORA.");
        
        carro1.addBreak();
        carro1.addBreak();
        
        
        //Do uso
        XWPFParagraph douso = documento.createParagraph();
        douso.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun douso1 = douso.createRun();
        douso1.setFontSize(12);
        douso1.setFontFamily("Arial");
        
        douso1.setText("DO USO");
        
        douso1.addBreak();
        
        
        
        //CLASULAS DO CONTRATO
        
        XWPFParagraph clasulas = documento.createParagraph();
        clasulas.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun clasulas0 = clasulas.createRun();
        clasulas0.setFontSize(12);
        clasulas0.setFontFamily("Arial");
        
        clasulas0.setText("Cláusula 2ª. O automóvel, objeto deste contrato, será "
                + " utilizado exclusivamente pelo LOCATÁRIO, não sendo permitido o "
                + " seu uso por terceiros sob pena de rescisão contratual e o pagamento"
                + " da multa prevista na Cláusula 7ª.");
        
        clasulas0.addBreak();
        clasulas0.addBreak();
        
        
        //CLASULA DA DEVOLUÇÃO
        
        XWPFParagraph clasulaDev = documento.createParagraph();
        clasulaDev.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun clasulaDev1 = clasulaDev.createRun();
        clasulaDev1.setFontSize(12);
        clasulaDev1.setFontFamily("Arial");
        
        clasulaDev1.setText("Cláusula 3ª. O LOCATÁRIO deverá devolver o automóvel à "
                + " LOCADORA nas mesmas condições em que estava quando o recebeu, ou "
                + " seja, em perfeitas condições de uso, respondendo pelos danos ou "
                + " prejuízos causados2.");
        
        clasulaDev1.addBreak();
        clasulaDev1.addBreak();
        //Registro da parte Locataria
        
        XWPFParagraph locataria = documento.createParagraph();
        locataria.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun locataria1 = locataria.createRun();
        locataria1.setFontSize(12);
        locataria1.setFontFamily("Arial");
        
        locataria1.setText("");
        
        locataria1.addBreak();
        locataria1.addBreak();
        
        //String cliente = clsCli.getNome();
        documento.write(arquivo);
        arquivo.close();

    }

   
    
}

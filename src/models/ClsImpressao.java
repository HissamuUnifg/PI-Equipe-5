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
        
        //Registro das Partes
        XWPFParagraph partes = documento.createParagraph();
        partes.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun partes1 = partes.createRun();
        partes1.setFontSize(12);
        partes1.setFontFamily("Arial");

        partes1.setText("CREATE TABLE IF NOT EXISTS Contratos (\n"
                + "  id INT NOT NULL AUTO_INCREMENT,\n"
                + "  id_cliente INT NOT NULL,\n"
                + "  id_carro INT NOT NULL,\n"
                + "  id_colaborador INT NOT NULL,\n"
                + "  Observacoes VARCHAR(1000) NULL,\n"
                + "  QuantidadeDiarias INT(3) NULL,\n"
                + "  QuantidadeKmRet INT(9) NULL,\n"
                + "  ValorExtra FLOAT NULL,\n"
                + "  ValorTotal FLOAT NULL,\n"
                + "  TipoLocacao CHAR(1) NOT NULL,\n"
                + "  DataSaida DATE NOT NULL,\n"
                + "  DataChegada DATE NULL,\n"
                + "  DataContrato DATE NOT NULL,\n"
                + "  Status VARCHAR(15) NOT NULL,\n"
                + "  PRIMARY KEY (id),\n"
                + "  CONSTRAINT colaboradores_contratos\n"
                + "    FOREIGN KEY (id_colaborador)\n"
                + "    REFERENCES Colaboradores (id)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT clientes_contratos\n"
                + "    FOREIGN KEY (id_cliente)\n"
                + "    REFERENCES Clientes (id)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT carro_contrato\n"
                + "    FOREIGN KEY (id_carro)\n"
                + "    REFERENCES Carros (id)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION)");

        partes1.addBreak();
        partes1.addBreak();

        //String cliente = clsCli.getNome();
        documento.write(arquivo);
        arquivo.close();

    }

   
    
}

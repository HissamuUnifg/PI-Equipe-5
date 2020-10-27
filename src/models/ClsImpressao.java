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

import DAO.ConexaoDAO;
import java.awt.BorderLayout;
import java.sql.Connection;
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
    
    public void ClsImpressao(String nomeRel, String parametro, String valorParametro, String tituloRelatorio) throws JRException, SQLException, ClassNotFoundException {
        //gerando o jasper design
        JasperDesign desenho = JRXmlLoader.load(nomeRel);

        //compila o relatório
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);

        Connection conn = ConexaoDAO.getConexaoDAO();

        //executa o relatório
        Map parametros = new HashMap();
        parametros.put(parametro, valorParametro);
        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, conn);
        
        //exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao, true);
        relOpemFrame(tituloRelatorio, impressao);
        
        //fecha conexão com o banco de dados
        conn.close();
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
    
}

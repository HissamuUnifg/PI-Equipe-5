
package DAO;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.ClsCarros;

/**
 *
 * @author Tiago Teixeira
 */
public class CarregarTableCarroDAO extends AbstractTableModel {

    private final List<ClsCarros> clscarros;
    private final String[] colunas = {"Nome","Modelo","Placa","Marca","Tipo","Classe","Ano Modelo", "Ano Fabricacao"};    


    public CarregarTableCarroDAO(List<ClsCarros> clscarros) {
        this.clscarros = clscarros; 
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return clscarros.size();
    }
    //{"Nome","Modelo","Placa","Marca","Tipo","Classe","Ano Modelo", "Ano Fabricacao"}; 
    @Override
    public Object getValueAt(int linha, int coluna) {        
        ClsCarros clscarro = clscarros.get(linha);         
        switch (coluna) {
            case 0:
                return clscarro.getNome();
            case 1:
                return clscarro.getModelo();    
            case 2:
                return clscarro.getPlaca();
            case 3:
                return clscarro.getMarca();
            case 4:
                return clscarro.getTipoVeiculo();
            case 5:
                return clscarro.getClasse();
            case 6:
                return clscarro.getAnoModelo();
            case 7:
                return clscarro.getAnoFabricacao();           
        }
        return null;        
    }




}

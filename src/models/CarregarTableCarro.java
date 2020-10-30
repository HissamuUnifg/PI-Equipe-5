
package models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tiago Teixeira
 */
public class CarregarTableCarro extends AbstractTableModel {
    
    private static final long serialVersionUID = 1L;

    private final  List<ClsCarros> clscarros;
    private final  String[] colunas = {"Nome","Modelo","Placa","Marca","Tipo","Classe","Ano Modelo", "Ano Fabricacao"};    

    public CarregarTableCarro(List<ClsCarros> clscarros) {
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
    
  
    public Class getColClass(int coluna){
      switch (coluna) {
            case 0:
                return String.class;
            case 1:
                return String.class;  
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return int.class;
            case 7:
                return int.class;
           default:
                return null;
        }
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
            default:
                return 0;
        }
                
    }
    
    public void addRow(ClsCarros carros){
    this.clscarros.add(carros);
    this.fireTableDataChanged();
    }




}

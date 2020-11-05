
package models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Responsavel por Carregar a Jtable Endereços
 * @author Tiago Teixeira
 */
public class ClsCarregarTableEndereco extends AbstractTableModel{
    
    private final List<ClsEnderecos> clsEnderecos;
    private final String[] colunas = {"Rua","Numero","Cidade","Estado","Bairro","Cep","Tipo"};
    
    public ClsCarregarTableEndereco(List<ClsEnderecos> clsEnderecos) {
        this.clsEnderecos = clsEnderecos;
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
        return clsEnderecos.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ClsEnderecos clsEnd = clsEnderecos.get(linha);
        switch (coluna) {
            case 0:
                return clsEnd.getRua();
            case 1:
                return clsEnd.getNumero();
            case 2:
                return clsEnd.getNomeCidade();
            case 3:
                return clsEnd.getEstado();
            case 4:
                return clsEnd.getBairro();
            case 5:
                return clsEnd.getCep();
            case 6:
                return clsEnd.getTipoEndereco();
            default:
                return null;

        }

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
                return String.class;
            default:
                return null;
        }
    }
    
    public void addRow(ClsEnderecos clsEnderecos) {
        this.clsEnderecos.add(clsEnderecos);
        this.fireTableDataChanged();
    }
    
    public void deleteRow(int indice){
        this.clsEnderecos.remove(indice);
        this.fireTableRowsDeleted(0, getRowCount());
    }
    
    public void updatedRow(int indiceI, int indiceF){
        this.fireTableRowsUpdated(indiceI, indiceF);
    }
    public void updatedListRow(int indiceI, ClsEnderecos clsEnderecos){
        this.clsEnderecos.set(indiceI, clsEnderecos);
    }
    
    public void clearList(){
    this.clsEnderecos.clear();
    }
    
}

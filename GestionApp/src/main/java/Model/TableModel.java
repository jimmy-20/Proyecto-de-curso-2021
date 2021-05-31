/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Pojo.Ventas;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FAMILIASOZAORTIZ
 * @param <T>
 */
public class TableModel<T> extends AbstractTableModel implements PropertyChangeListener{
    private List<T> list;
    private String[] header;

    public TableModel(List<T> list, String[] header) {
        this.list = list;
        this.header = header;
    }

    public TableModel(String[] headerVentas, List<Ventas> listventas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        if (list == null){
            return 0;
        }
        
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return toArray()[i1];
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        
    }
    
    public void add(T t){
        list.add(t);
        fireTableDataChanged();
    }
    
    public Object[] toArray(){
        String nameClass =  list.getClass().getSimpleName();
        Object obj[] = null;
        
        if(nameClass.equalsIgnoreCase("DetalleFactura")){
            
        }
        
        return obj;
    }
    
    
    
}

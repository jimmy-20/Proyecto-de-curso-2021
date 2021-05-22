/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FAMILIASOZAORTIZ
 * @param <T>
 */
public class TableModel<T> extends AbstractTableModel{
    private List<T> list;
    private String[] header;

    public TableModel(List<T> list, String[] header) {
        this.list = list;
        this.header = header;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }
    
    
    
}

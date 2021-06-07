/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Pojo.DetalleCompra;
import Pojo.DetalleCompraFactura;
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
        return toArray(i,i1);
    }
    
   
    
    

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        add((T) pce.getNewValue());
        fireTableDataChanged();

    }
    
    public void add(T t){
        this.list.add(t);
    }
    public Object toArray(int row, int column){
         String nameClass =  list.get(0).getClass().getSimpleName();
        
        Object obj;
        
        if(nameClass.equalsIgnoreCase("DetalleCompra")){
            List<DetalleCompra> factura = (List<DetalleCompra>) list;
            obj = factura.get(row).toArray()[column];
            return obj;
        }else{
            System.out.println("error");
        }
        System.out.println(nameClass);
        
        if(nameClass.equalsIgnoreCase("DetalleCompraFactura")){
            List<DetalleCompraFactura> factura = (List<DetalleCompraFactura>) list;
            obj = factura.get(row).toArray()[column];
            return obj;
        }else{
            System.out.println("error");
        }
        System.out.println(nameClass);
        
        return null;
    }
    

    
    
    
}

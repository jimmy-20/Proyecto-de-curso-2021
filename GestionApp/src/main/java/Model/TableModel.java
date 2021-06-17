/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Pojo.Cliente;
import Pojo.DetalleCompra;
import Pojo.DetalleCompraFactura;
import Pojo.DetalleVenta;
import Pojo.DetalleVentaFactura;
import Pojo.Proveedor;
import Pojo.SistemaVentas;
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
        return toElement(i,i1);
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
    
    /**
    *Añade un elemento a la tabla
    *@param t Objeto que se desea agregar
    **/
    public void add(T t){
        this.list.add(t);
    }
  
     /**
     * Devuelve el objeto con la fila y columna seleccionada
     * @param row fila seleccionada
     * @param column columna seleccionada
     * @return Devuelve objeto 
     **/
    public Object toElement(int row, int column){
         String nameClass =  list.get(0).getClass().getSimpleName();
         Object obj;
        
        if(nameClass.equalsIgnoreCase("DetalleCompra")){
            List<DetalleCompra> factura = (List<DetalleCompra>) list;
            obj = factura.get(row).toArray()[column];
            return obj;
        }else if (nameClass.equalsIgnoreCase("DetalleCompraFactura")){
           List<DetalleCompraFactura> factura = (List<DetalleCompraFactura>) list;
            obj = factura.get(row).toArray()[column];
            return obj;  
        }else if (nameClass.equalsIgnoreCase("Proveedor")) {
            List<Proveedor> factura = (List<Proveedor>) list;
            obj = factura.get(row).toArray()[column];
            return obj;
        } else if (nameClass.equalsIgnoreCase("DetalleVentaFactura")){
           List<DetalleVentaFactura> factura = (List<DetalleVentaFactura>) list;
            obj = factura.get(row).toArray()[column];
            return obj;  
        }else if (nameClass.equalsIgnoreCase("DetalleVenta")){
           List<DetalleVenta> factura = (List<DetalleVenta>) list;
            obj = factura.get(row).toArray()[column];
            return obj;  
        }else if (nameClass.equalsIgnoreCase("Cliente")) {
            List<Cliente> factura = (List<Cliente>) list;
            obj = factura.get(row).toArray()[column];
            return obj;
        }else if (nameClass.equalsIgnoreCase("SistemaVentas"))
        {
           List<SistemaVentas> factura = (List<SistemaVentas>) list;
            obj = factura.get(row).toArray()[column];
            return obj; 
        }else if(nameClass.equalsIgnoreCase("Ventas")){
            List<Ventas> factura = (List<Ventas>) list;
            obj = factura.get(row).toArray()[column];
            return obj;
        }else{
            System.out.println("error");
            System.out.println(nameClass);
        }
        return null;

   }
    
   
    public Object toArray(int row, int column){
        String nameClass =  list.get(0).getClass().getSimpleName();
        Object obj;
        
        if(nameClass.equalsIgnoreCase("DetalleCompra")){
            
            List<DetalleCompra> factura = (List<DetalleCompra>) list;
            obj = factura.get(row).toArray()[column];
            return obj;
        }else if (nameClass.equalsIgnoreCase("DetalleCompraFactura")){
           List<DetalleCompraFactura> factura = (List<DetalleCompraFactura>) list;
            obj = factura.get(row).toArray()[column];
            return obj;  
        }else if(nameClass.equalsIgnoreCase("Ventas")){  
            List<Ventas> factura = (List<Ventas>) list;
            obj = factura.get(row).toArray()[column];
            return obj;
        }else if (nameClass.equalsIgnoreCase("SistemaVentas"))
        {
           List<SistemaVentas> factura = (List<SistemaVentas>) list;
            obj = factura.get(row).toArray()[column];
            return obj; 
        }else if (nameClass.equalsIgnoreCase("DetalleVentaFactura"))
        {
           List<DetalleVentaFactura> factura = (List<DetalleVentaFactura>) list;
            obj = factura.get(row).toArray()[column];
            return obj; 
        }else if (nameClass.equalsIgnoreCase("DetalleVenta")){
           List<DetalleVenta> factura = (List<DetalleVenta>) list;
            obj = factura.get(row).toArray()[column];
            return obj;  }
        else if (nameClass.equalsIgnoreCase("Cliente")) {
            List<Cliente> factura = (List<Cliente>) list;
            obj = factura.get(row).toArray()[column];
            return obj;}
        else {
            System.out.println("error");
            System.out.println(nameClass);
        }
       return null;
    }
   
}

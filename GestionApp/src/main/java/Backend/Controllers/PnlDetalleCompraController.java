/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Backend.FilesCompras;
import Model.TableModel;
import Panels.Compra.PnlDetalleCompra;
import Pojo.DetalleCompra;
import Pojo.Proveedor;
import Views.DialogoActualizar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jeison Suarez
 * 
 */
public class PnlDetalleCompraController {
    private DialogoActualizar dialogActualizar;
    private List <DetalleCompra> listCompras;
    private List <Proveedor> listProveedor;
    private FilesCompras fCompras;
    private TableModel<DetalleCompra> modelDetalle;
    private TableModel<Proveedor> modelProveedor;
    private PnlDetalleCompra pnlDcompra;
    private String[] headerDetalle = {"N° Factura", "Fecha", "Tipo de Compra", "Moneda", "Proveedor", 
        "Descripción", "Cantidad", "Costo Unitario",
        "Sub-Total", "IVA", "Total"
    };
    private String[] headerProveedor = { "Proveedor",
        "Sub-Total", "IVA", "Total"
    };
    
    private PropertyChangeSupport propertyChangeSupport;
    private TableRowSorter<TableModel> tblRowSorter;
    private DetalleCompra compra;
    
   
    

  
    public PnlDetalleCompraController(PnlDetalleCompra pnlDcompra) {
        this.pnlDcompra = pnlDcompra;
        
        fCompras = new FilesCompras();

        listCompras = fCompras.findAllDetalle().stream().collect(Collectors.toList());
        listProveedor= fCompras.findAllCredito().stream().collect(Collectors.toList());
       
        initComponent();
    }

    private void initComponent() {
        loadTable();
        
        pnlDcompra.getTxtFinder().addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    txtFinderKeyTyped(e);
                }

            });
        pnlDcompra.getTblViewDetalleCompra().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount()==1){
                   return;
               }
               if(e.getClickCount()==2){
                   dialogActualizar = new DialogoActualizar(null,true);                   
                   int row = pnlDcompra.getTblViewDetalleCompra().getSelectedRow();
                   
                   String factura = String.valueOf(pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 0));
                   String fecha = (String) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 1);
                   String tipoCompra = (String) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 2);
                   String moneda = (String) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 3);
                   String proveedor = (String) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 4);
                   String descripcion = (String) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 5);
                   String cantidad =  pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 6).toString();
                   String costoUnitario=  pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 7).toString();
                   String subTotal =  pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 7).toString();
                   String iva = pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 8).toString();
                   String total =  pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 9).toString();
                   
                   dialogActualizar.getTxtFecha().setText(fecha);
                   dialogActualizar.getTxtFactura().setText(factura);
                   dialogActualizar.getTxtProveedor().setText(proveedor);
                   dialogActualizar.getTxtDescripcion().setText(descripcion);
                   dialogActualizar.getTxtCostoU().setText(costoUnitario);
                   dialogActualizar.getTxtSubTotal().setText(subTotal);
                   dialogActualizar.getTxtIva().setText(iva);
                   dialogActualizar.getTxtTotal().setText(total);
                   
                   dialogActualizar.setVisible(true);
               }
            }  
        });
        
    }
    private void txtFinderKeyTyped(KeyEvent e) {
        RowFilter<TableModel, Object> rf = null;
        rf = RowFilter.regexFilter(pnlDcompra.getTxtFinder().getText(), 0, 1, 2, 3, 4, 5);
        tblRowSorter.setRowFilter(rf);
    }
    
    private void loadTable (){
        modelDetalle= new TableModel(listCompras, headerDetalle);
        modelProveedor= new TableModel(listProveedor, headerProveedor);
        pnlDcompra.getTblViewDetalleCompra().setModel(modelDetalle);
        pnlDcompra.getTblViewProveedores().setModel(modelProveedor);
        tblRowSorter = new TableRowSorter<>(modelDetalle);
        pnlDcompra.getTblViewDetalleCompra().setRowSorter(tblRowSorter);
       
    }
     
    
    

}

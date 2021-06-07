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
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Javier Ramirez
 */
public class PnlDetalleCompraController {
    
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
    
//    public void addPropertyChangeListener(PropertyChangeListener pcl){
//        propertyChangeSupport.addPropertyChangeListener(pcl);
//    }
  
    public PnlDetalleCompraController(PnlDetalleCompra pnlDcompra) {
        this.pnlDcompra = pnlDcompra;
        
        fCompras = new FilesCompras();
//        propertyChangeSupport = new PropertyChangeSupport(this);
        listCompras = fCompras.findAllDetalle().stream().collect(Collectors.toList());
        
        initComponent();
    }

    private void initComponent() {
        modelDetalle= new TableModel(listCompras, headerDetalle);
        modelProveedor= new TableModel(listProveedor, headerProveedor);
//        addPropertyChangeListener(modelDetalle);
        pnlDcompra.getTblViewDetalleCompra().setModel(modelDetalle);
        pnlDcompra.getTblViewProveedores().setModel(modelProveedor);
    }
     
    
    

}

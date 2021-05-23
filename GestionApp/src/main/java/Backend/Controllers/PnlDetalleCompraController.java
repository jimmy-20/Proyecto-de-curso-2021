/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Model.TableModel;
import Panels.Compra.PnlDetalleCompra;
import Pojo.DetalleCompra;
import Pojo.Proveedor;
import java.util.List;

/**
 *
 * @author Javier Ramirez
 */
public class PnlDetalleCompraController {
    
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
    
    private List <DetalleCompra> listCompras;
     private List <Proveedor> listProveedor;

    public PnlDetalleCompraController(PnlDetalleCompra pnlDcompra) {
        this.pnlDcompra = pnlDcompra;
        initComponent();
    }

    private void initComponent() {
        modelDetalle= new TableModel(listCompras, headerDetalle);
        modelProveedor= new TableModel(listProveedor, headerProveedor);
        
        pnlDcompra.getTblViewDetalleCompra().setModel(modelDetalle);
        pnlDcompra.getTblViewProveedores().setModel(modelProveedor);
    }
     
    
    

}

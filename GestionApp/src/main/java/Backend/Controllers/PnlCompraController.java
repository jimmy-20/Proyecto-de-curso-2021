/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Model.TableModel;
import Panels.Compra.PnlCompra;
import Pojo.SubCompra;
import java.util.List;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class PnlCompraController {
    private PnlCompra pnlCompra;
    private String[] header = {"N°o Factura","Fecha Compra","Tipo de Compra","Moneda","Proveedor","Sub-Total","Iva","Total"};
    private SubCompra subCompra;
    private TableModel<SubCompra> tablemodel;
    private List<SubCompra> list;

    public PnlCompraController(PnlCompra pnlCompra) {
        this.pnlCompra = pnlCompra;
        initComponents();
    }

    private void initComponents() {
        tablemodel = new TableModel<>(list,header);
        pnlCompra.getTblResumenCompras().setModel(tablemodel);
    }
    
    
}

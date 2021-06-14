/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Model.TableModel;
import Panels.Ventas.PnlSistemaVentas;
import Panels.Ventas.PnlVentas;
import Pojo.DetalleVentaFactura;
import Pojo.Ventas;
import java.util.List;

/**
 *
 * @author FAM. FONSECA SANDINO
 */
public class PnlVentasController {
    private PnlVentas pnlVentas;
    private PnlSistemaVentas sistemaVentas;
    private String[] headerVentas = {"N°Factura","Fecha de Venta","Nombre del Cliente","Sub-Total","IVA","Total","Item" };
    private Ventas ventas;
    private TableModel<Ventas> modelventas;
    private List<Ventas> listventas;
    private String[] headerFactura = {"N°Factura","Fecha de Venta","Tipo de venta","Moneda","Cliente","Sub-Total","IVA","Total" };
    private TableModel<DetalleVentaFactura> tableModel;
    private List<DetalleVentaFactura> dvfs;

    public PnlVentasController(PnlVentas pnlVentas) {
        this.pnlVentas = pnlVentas;
        initComponents();
    }
    
    private void initComponents()
    {
        modelventas = new TableModel<>(listventas,headerVentas);
        pnlVentas.getTblViewVentas().setModel(modelventas);
       
        tableModel = new TableModel<>(dvfs,headerFactura);
        pnlVentas.getTblReporteVentas().setModel(tableModel);
    }

}

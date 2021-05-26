/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Model.TableModel;
import Panels.Ventas.PnlVentas;
import Pojo.Ventas;
import java.util.List;

/**
 *
 * @author FAM. FONSECA SANDINO
 */
public class PnlVentasController {
    private PnlVentas pnlVentas;
    private String[] headerVentas = 
    {"N°Factura","Fecha de Venta","Nombre del Cliente","Sub-Total","IVA","Total","Item" };
    private Ventas ventas;
    private TableModel<Ventas> modelventas;
    private List<Ventas> listventas;

    public PnlVentasController(PnlVentas pnlVentas) {
        this.pnlVentas = pnlVentas;
        initComponents();
    }
    
    private void initComponents()
    {
        modelventas = new TableModel<>(listventas,headerVentas);
        pnlVentas.getTblViewVentas().setModel(modelventas);
    }

}

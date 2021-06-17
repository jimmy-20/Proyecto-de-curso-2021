/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Backend.FilesVentas;
import Model.TableModel;
import Panels.Ventas.PnlSistemaVentas;
import Panels.Ventas.PnlVentas;
import Pojo.DetalleVentaFactura;
import Pojo.Ventas;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author FAM. FONSECA SANDINO
 */
public class PnlVentasController {
    private PnlVentas pnlVentas;
    private FilesVentas filesVentas;
    private String[] headerVentas = {"N°Factura","Fecha de Venta","Descripción","Sub-Total","IVA","Total","Item" };
    private Ventas ventas;
    private TableModel<Ventas> modelventas;
    private List<Ventas> listventas;
    private String[] headerFactura = {"N°Factura","Fecha de Venta","Tipo de venta","Moneda","Cliente","Sub-Total","IVA","Total" };
    private TableModel<DetalleVentaFactura> tableModel;
    private List<DetalleVentaFactura> dvfs;
    private PropertyChangeSupport propertyChangeSupport;
    private TableRowSorter<TableModel> rowSorter;

    public PnlVentasController(PnlVentas pnlVentas) {
        this.pnlVentas = pnlVentas;
         filesVentas = new FilesVentas();
        
        listventas = filesVentas.findAllVentas().stream().collect(Collectors.toList()); 
        dvfs = filesVentas.findAllFactura().stream().collect(Collectors.toList());
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

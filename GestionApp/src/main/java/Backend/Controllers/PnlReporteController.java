/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Backend.FilesCompras;
import Backend.FilesVentas;
import Model.PojoDataSource;
import Model.TableModel;
import Panels.Reportes.PnlReporte;
import Pojo.DetalleCompra;
import Pojo.DetalleCompraFactura;
import Pojo.DetalleVenta;
import Pojo.DetalleVentaFactura;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class PnlReporteController {
    private DefaultComboBoxModel comboBoxModel;
    private String[] modelCombo = {"---Selecione---","Detalle de Compra","Detalle de Factura de Compra"
            ,"Detalle de Venta","Detalle de Venta de Factura"};
    
    private final String[] headerCFactura =
    {
        "N°o Factura", "Fecha Compra", "Tipo de Compra", "Moneda", "Proveedor", "Sub-Total", "Iva", "Total"
    };
    private String[] headerCDetalle = {"N° Factura", "Fecha", "Tipo de Compra", "Moneda", "Proveedor", 
        "Descripción", "Cantidad", "Costo Unitario",
        "Sub-Total", "IVA", "Total"
    };
    
    private final String[] headerDVentas={"N° Factura", "Fecha","Tipo de Compra","Moneda", "Cliente",
        "Descripción", "Cantidad", "Precio Unitario",
        "Sub-Total", "IVA", "Total"};
    
    private String[] headerVFactura = {"N°Factura","Fecha de Venta","Tipo de venta","Moneda","Cliente","Sub-Total","IVA","Total" };

    private FilesCompras filesCompras;
    private FilesVentas filesVentas;
    private PnlReporte pnlReporte;
    private String report;
    
    public PnlReporteController(PnlReporte pnlReporte){
        this.pnlReporte = pnlReporte;
        filesCompras = new FilesCompras();
        initComponent();
    }

    private void initComponent() {
        comboBoxModel = new DefaultComboBoxModel(modelCombo);
        pnlReporte.getCmbReport().setModel(comboBoxModel);
        
        pnlReporte.getBtnImprimir().addActionListener(((e) -> {
            btnActionPerformed(e);
        }));
        
        pnlReporte.getCmbReport().addItemListener(((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                
                
                if(e.getItem().toString().equalsIgnoreCase(modelCombo[0])){
                    JOptionPane.showMessageDialog(null, "Opción invalida");
                    pnlReporte.getTblReporte().setModel(new DefaultTableModel(0, 0));
                    return;
                }
                
                if (e.getItem().toString().equalsIgnoreCase(modelCombo[1])){
                    List<DetalleCompra> compras = filesCompras.findAllDetalle().stream().collect(Collectors.toList());
                    TableModel<DetalleCompra> modelCompra = new TableModel<>(compras,headerCDetalle);
                    pnlReporte.getTblReporte().setModel(modelCompra);
                    report = "DCompraReport.jasper";
                }
                
                if (e.getItem().toString().equalsIgnoreCase(modelCombo[2])){
                    List<DetalleCompraFactura> compraFacturas = filesCompras.findAllFactura().stream().collect(Collectors.toList());
                    TableModel<DetalleCompraFactura> modelCFacturas = new TableModel<>(compraFacturas,headerCFactura);
                    pnlReporte.getTblReporte().setModel(modelCFacturas);
                    report = "Compra2Report.jasper";
                }
                
                if (e.getItem().toString().equalsIgnoreCase(modelCombo[3])){
                    List<DetalleVenta> ventaDetalle = filesVentas.findAllDetalle().stream().collect(Collectors.toList());
                    TableModel<DetalleVenta> modelDVentas = new TableModel<>(ventaDetalle,headerDVentas);
                    pnlReporte.getTblReporte().setModel(modelDVentas);
                }
                
                if (e.getItem().toString().equalsIgnoreCase(modelCombo[4])){
                    List<DetalleVentaFactura> ventaFacturas = filesVentas.findAllFactura().stream().collect(Collectors.toList());
                    TableModel<DetalleVentaFactura> modelDFactura = new TableModel<>(ventaFacturas,headerVFactura);
                    pnlReporte.getTblReporte().setModel(modelDFactura);
                }
            }
        }));
    }

    private void btnActionPerformed(ActionEvent e) {  
        String fileName = getClass().getResource("/reports/"+report).getPath();
        System.out.println(fileName);

        if (filesCompras.findAllFactura().stream().collect(Collectors.toList()).isEmpty()){
            JOptionPane.showMessageDialog(null, "No se encuentra ningun registro para imprimir");
            return;
        }

        //Nota: Si manda la Exception "FileNotFoundException" se debe a que el nombre de usuario contiene espacios
        PojoDataSource dataSource = new PojoDataSource(filesCompras.findAllFactura().stream().collect(Collectors.toList()));
        System.out.println(fileName);
        try
        {
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(fileName);
            JasperPrint print = JasperFillManager.fillReport(report, null, dataSource);
            JasperViewer viewer = new JasperViewer(print);
            viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (JRException ex)
        {
            Logger.getLogger(PnlReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

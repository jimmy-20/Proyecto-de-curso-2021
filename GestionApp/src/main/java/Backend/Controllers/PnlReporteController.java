/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Backend.FilesCompras;
import Model.PojoDataSource;
import Panels.Reportes.PnlReporte;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
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
    private FilesCompras filesCompras;
    private PnlReporte pnlReporte;
    
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
                    return;
                }
                
                if (e.getItem().toString().equalsIgnoreCase(modelCombo[1])){
                    
                }
                
                if (e.getItem().toString().equalsIgnoreCase(modelCombo[2])){
                    
                }
                
                if (e.getItem().toString().equalsIgnoreCase(modelCombo[3])){
                    
                }
                
                if (e.getItem().toString().equalsIgnoreCase(modelCombo[4])){
                    
                }
            }
        }));
    }

    private void btnActionPerformed(ActionEvent e) {  
        String fileName = getClass().getResource("/reports/Prueba.jasper").getPath();
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

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
import Pojo.Cliente;
import Pojo.DetalleVenta;
import Pojo.DetalleVentaFactura;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
/**
 *
 * @author FAM. FONSECA SANDINO
 */
public class PnlSistemaVentasController {
    private PnlVentas pnlVentas;
    private PnlSistemaVentas sistemaVentas;
    private DetalleVentaFactura factura;
    private FilesVentas filesVentas;
    private String[] headerFactura = {"N°Factura","Fecha de Venta","Tipo de venta","Moneda","Cliente","Sub-Total","IVA","Total" };
    private TableModel<DetalleVentaFactura> tableModel;
    private List<DetalleVentaFactura> dvfs;
    private PropertyChangeSupport propertyChangeSupport;
    
    
    public PnlSistemaVentasController(PnlSistemaVentas sistemaVentas) {
        this.sistemaVentas = sistemaVentas;
        filesVentas = new FilesVentas();
        propertyChangeSupport = new PropertyChangeSupport(this);
        dvfs = filesVentas.findAllFactura().stream().collect(Collectors.toList());
        
        initcomponent();
    }

    public void addPropertyChangeListener(PropertyChangeListener pc){
        propertyChangeSupport.addPropertyChangeListener(pc);
    }
   
    private void initcomponent() {
        
        tableModel = new TableModel<>(dvfs,headerFactura);
        
        addPropertyChangeListener(tableModel);
        
        sistemaVentas.getBtnGroupTipo().add(sistemaVentas.getRdbContado());
        sistemaVentas.getBtnGroupTipo().add(sistemaVentas.getRbdCredito());

        sistemaVentas.getBtnGroupMoneda().add(sistemaVentas.getRdbCordobas());
        sistemaVentas.getBtnGroupMoneda().add(sistemaVentas.getRdbDolar());
        
           sistemaVentas.getSpnCantidad().addChangeListener((ChangeEvent ce) -> 
        {
            if ((int) sistemaVentas.getSpnCantidad().getValue() < 0)
            {
                sistemaVentas.getTxtSubT().setText("");
                sistemaVentas.getTxtIVA().setText("");
                sistemaVentas.getTxtTotal().setText("");
                return;
            }
            
            if (sistemaVentas.getTxtCostoU().getText().equalsIgnoreCase("")){
                sistemaVentas.getTxtSubT().setText("0");
                sistemaVentas.getTxtIVA().setText("0");
                sistemaVentas.getTxtTotal().setText("0");
            }
            setCosto();
        });

        sistemaVentas.getTxtCostoU().addKeyListener(new KeyAdapter() { 
            @Override
            public void keyReleased(KeyEvent e) {
                if (sistemaVentas.getTxtCostoU().getText().isEmpty())
                {
                    sistemaVentas.getTxtSubT().setText("");
                    sistemaVentas.getTxtIVA().setText("");
                    sistemaVentas.getTxtTotal().setText("");
                    return;
                }

                setCosto();
            }

            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                
                if (!Character.isDigit(c)){
                    ke.consume();
                }
            }
            
        });

        sistemaVentas.getCbExcento().addChangeListener((ChangeEvent ce) ->
        {
            if (!sistemaVentas.getCbExcento().isSelected())
            {
                setCosto();
                return;
            }

            if (sistemaVentas.getTxtIVA().getText().equals(""))
            {
                return;
            }

            float iva = Float.parseFloat(sistemaVentas.getTxtIVA().getText());
            float total = Float.parseFloat(sistemaVentas.getTxtTotal().getText());

            sistemaVentas.getTxtIVA().setText("0");
            sistemaVentas.getTxtTotal().setText(String.valueOf(total - iva));
        });
        
        sistemaVentas.getTxtCostoU().addFocusListener ( new FocusAdapter() { 
            @Override
            public void focusGained(FocusEvent fe) {
                if (!sistemaVentas.getTxtCostoU().getText().equalsIgnoreCase("0")){
                    return;
                }
                sistemaVentas.getTxtCostoU().setText("");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (sistemaVentas.getTxtCostoU().getText().equalsIgnoreCase("") || sistemaVentas.getTxtCostoU().getText().equalsIgnoreCase("0")){
                    sistemaVentas.getTxtCostoU().setText("0");
                }
            }   
        });
        
         sistemaVentas.getBtnVentas().addActionListener(((e) ->
        {
           btnAgregarActionPerformed(e);
        }));

        sistemaVentas.getBtnLimpiar().addActionListener(((e) ->
        {
            btnLimpiarActionPerformed(e);
        }));
        
    }
    
     private void setCosto() throws NumberFormatException {
        if (sistemaVentas.getTxtCostoU().getText().equals("")){
            return;
        }
        
        float costo = Float.parseFloat(sistemaVentas.getTxtCostoU().getText());
        int unidades = (int) sistemaVentas.getSpnCantidad().getValue();

        float subTotal = costo * unidades;
        float iva = 0;

        if (sistemaVentas.getCbExcento().isSelected())
        {
            sistemaVentas.getTxtSubT().setText(String.valueOf(subTotal));
            sistemaVentas.getTxtIVA().setText("0");
            sistemaVentas.getTxtTotal().setText(String.valueOf(subTotal));
            return;
        }
        iva = (float) (0.15 * subTotal);
        float total = subTotal + iva;

        sistemaVentas.getTxtSubT().setText(String.valueOf(subTotal));
        sistemaVentas.getTxtIVA().setText(String.valueOf(iva));
        sistemaVentas.getTxtTotal().setText(String.valueOf(total));
    }
    
     private void btnLimpiarActionPerformed(ActionEvent e) {
        sistemaVentas.getTxtNfactura().setText("");
        sistemaVentas.getTxtFecha().setText("");
        sistemaVentas.getTxtCliente().setText("");
        sistemaVentas.getTxtDescripcion().setText("");
        sistemaVentas.getTxtCostoU().setText("0");
        sistemaVentas.getTxtSubT().setText("");
        sistemaVentas.getTxtIVA().setText("");
       sistemaVentas.getTxtTotal().setText("");
    }
     
     private void btnAgregarActionPerformed(ActionEvent e)
     {
         String factura = sistemaVentas.getTxtNfactura().getText();
        String fecha = sistemaVentas.getTxtFecha().getText();
        String tipoventa = null;
        String moneda = null;
             Enumeration btnGroupTipo = sistemaVentas.getBtnGroupTipo().getElements();
        
        while (btnGroupTipo.hasMoreElements())
        {
            JRadioButton rdb = (JRadioButton) btnGroupTipo.nextElement();
            
            if (rdb.isSelected()){
                tipoventa = rdb.getText();
            }
        }
        
        Enumeration btnGroupMoneda = sistemaVentas.getBtnGroupMoneda().getElements();
        
        while (btnGroupMoneda.hasMoreElements()){
            
            JRadioButton rdb = (JRadioButton) btnGroupMoneda.nextElement();
            
            if (rdb.isSelected()){
                moneda = rdb.getText();
            }
        }
        
         String cliente = sistemaVentas.getTxtCliente().getText();
        String descripcion = sistemaVentas.getTxtDescripcion().getText();
        int cantidad = (int) sistemaVentas.getSpnCantidad().getValue();
        float precioU = Float.parseFloat(sistemaVentas.getTxtCostoU().getText());
        float subTotal = Float.parseFloat(sistemaVentas.getTxtSubT().getText());
        float iva = Float.parseFloat(sistemaVentas.getTxtIVA().getText());
        float total = Float.parseFloat(sistemaVentas.getTxtTotal().getText());
        
        DetalleVenta dv = new DetalleVenta(factura, fecha,tipoventa,moneda, cliente, descripcion, cantidad,precioU, subTotal, iva, total);
        DetalleVentaFactura dvF = new DetalleVentaFactura(factura, fecha, tipoventa, moneda, cliente, subTotal, iva, total);
        
        Cliente c = null;
        if (tipoventa.equalsIgnoreCase("Crédito")){
            c = new Cliente(cliente, subTotal, iva, total);
        }
        
        filesVentas.add(dvF,dv,c); 
        propertyChangeSupport.firePropertyChange("factura", this.factura, dvF); //Se crea un evento de actualizacion
        
        JOptionPane.showMessageDialog(null, "Factura de venta añadida correctamente");
        
     }
}

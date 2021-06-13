/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Backend.FilesCompras;
import Model.TableModel;
import Panels.Compra.PnlCompraDesign;
import Pojo.DetalleCompraFactura;
import Pojo.DetalleCompra;
import Pojo.Proveedor;
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
 * @author FAMILIASOZAORTIZ
 */
public class PnlCompraController {

    private PnlCompraDesign pnlCompra;
    private final String[] header =
    {
        "N°o Factura", "Fecha Compra", "Tipo de Compra", "Moneda", "Proveedor", "Sub-Total", "Iva", "Total"
    };
    private TableModel<DetalleCompraFactura> tablemodel;
    private List<DetalleCompraFactura> list;
    private FilesCompras fCompras;
    private DetalleCompraFactura factura;
    
    private PropertyChangeSupport propertyChangeSupport;

    public PnlCompraController(PnlCompraDesign pnlCompra) {
        this.pnlCompra = pnlCompra;
        fCompras = new FilesCompras();
        propertyChangeSupport = new PropertyChangeSupport(this);
        list = fCompras.findAllFactura().stream().collect(Collectors.toList());
        
        initComponents();
    }
    
    public void addPropertyChangeListener(PropertyChangeListener pcl){
        propertyChangeSupport.addPropertyChangeListener(pcl);
    }

    private void initComponents() {
        tablemodel = new TableModel<>(list, header);
        pnlCompra.getTblResumenCompras().setModel(tablemodel);
        addPropertyChangeListener(tablemodel);

        pnlCompra.getBtnGroupTipoCompra().add(pnlCompra.getRdbContado());
        pnlCompra.getBtnGroupTipoCompra().add(pnlCompra.getRdbCredito());

        pnlCompra.getBtnGroupMoneda().add(pnlCompra.getRdbCordoba());
        pnlCompra.getBtnGroupMoneda().add(pnlCompra.getRdbDolar());

        pnlCompra.getSpnCantidad().addChangeListener((ChangeEvent ce) -> //Si se cambia el valor de cantidad, calcular en tiempo real, sus costos
        {
            if ((int) pnlCompra.getSpnCantidad().getValue() < 0)
            {
                pnlCompra.getTxtSubTotal().setText("");
                pnlCompra.getTxtIva().setText("");
                pnlCompra.getTxtTotal().setText("");
                return;
            }
            
            if (pnlCompra.getTxtCostoU().getText().equalsIgnoreCase("")){
                pnlCompra.getTxtSubTotal().setText("0");
                pnlCompra.getTxtIva().setText("0");
                pnlCompra.getTxtTotal().setText("0");
            }
            setCosto();
        });

        pnlCompra.getTxtCostoU().addKeyListener(new KeyAdapter() { //Si el costo es 0, hacer las demas celdas en 0
            @Override
            public void keyReleased(KeyEvent e) {
                if (pnlCompra.getTxtCostoU().getText().isEmpty())
                {
                    pnlCompra.getTxtSubTotal().setText("");
                    pnlCompra.getTxtIva().setText("");
                    pnlCompra.getTxtTotal().setText("");
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

        pnlCompra.getCkbExcento().addChangeListener((ChangeEvent ce) ->
        {
            if (!pnlCompra.getCkbExcento().isSelected())
            {
                setCosto();
                return;
            }

            if (pnlCompra.getTxtIva().getText().equals(""))
            {
                return;
            }

            float iva = Float.parseFloat(pnlCompra.getTxtIva().getText());
            float total = Float.parseFloat(pnlCompra.getTxtTotal().getText());

            pnlCompra.getTxtIva().setText("0");
            pnlCompra.getTxtTotal().setText(String.valueOf(total - iva));
        });
        
        pnlCompra.getTxtCostoU().addFocusListener ( new FocusAdapter() { //Eventos de Focus en el campo de texto del costo unitario
            @Override
            public void focusGained(FocusEvent fe) {
                if (!pnlCompra.getTxtCostoU().getText().equalsIgnoreCase("0")){
                    return;
                }
                pnlCompra.getTxtCostoU().setText("");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (pnlCompra.getTxtCostoU().getText().equalsIgnoreCase("") || pnlCompra.getTxtCostoU().getText().equalsIgnoreCase("0")){
                    pnlCompra.getTxtCostoU().setText("0");
                }
            } 
        });

        pnlCompra.getBtnAgregar().addActionListener(((e) ->
        {
            btnAgregarActionPerformed(e);
        }));

        pnlCompra.getBtnLimpiar().addActionListener(((e) ->
        {
            btnLimpiarActionPerformed(e);
        }));
    }

    private void setCosto() throws NumberFormatException {
        if (pnlCompra.getTxtCostoU().getText().equals("")){
            return;
        }
        
        float costo = Float.parseFloat(pnlCompra.getTxtCostoU().getText());
        int unidades = (int) pnlCompra.getSpnCantidad().getValue();

        float subTotal = costo * unidades;
        float iva = 0;

        if (pnlCompra.getCkbExcento().isSelected())
        {
            pnlCompra.getTxtSubTotal().setText(String.valueOf(subTotal));
            pnlCompra.getTxtIva().setText("0");
            pnlCompra.getTxtTotal().setText(String.valueOf(subTotal));
            return;
        }
        iva = (float) (0.15 * subTotal);
        float total = subTotal + iva;

        pnlCompra.getTxtSubTotal().setText(String.valueOf(subTotal));
        pnlCompra.getTxtIva().setText(String.valueOf(iva));
        pnlCompra.getTxtTotal().setText(String.valueOf(total));
    }

    private void btnAgregarActionPerformed(ActionEvent e) {
        String factura = pnlCompra.getTxtFactura().getText();
        String fecha = pnlCompra.getTxtFecha().getText();
        String tipoCompra = null;
        String moneda = null;
        
        Enumeration btnGroupTipoCompra = pnlCompra.getBtnGroupTipoCompra().getElements();
        
        while (btnGroupTipoCompra.hasMoreElements())
        {
            JRadioButton rdb = (JRadioButton) btnGroupTipoCompra.nextElement();
            
            if (rdb.isSelected()){
                tipoCompra = rdb.getText();
            }
        }
        
        Enumeration btnGroupMoneda = pnlCompra.getBtnGroupMoneda().getElements();
        
        while (btnGroupMoneda.hasMoreElements()){
            
            JRadioButton rdb = (JRadioButton) btnGroupMoneda.nextElement();
            
            if (rdb.isSelected()){
                moneda = rdb.getText();
            }
        }
        
        String proveedor = pnlCompra.getTxtProveedor().getText();
        String descripcion = pnlCompra.getTxtDescripcion().getText();
        int cantidad = (int) pnlCompra.getSpnCantidad().getValue();
        float costoU = Float.parseFloat(pnlCompra.getTxtCostoU().getText());
        float subTotal = Float.parseFloat(pnlCompra.getTxtSubTotal().getText());
        float iva = Float.parseFloat(pnlCompra.getTxtIva().getText());
        float total = Float.parseFloat(pnlCompra.getTxtTotal().getText());
        
        DetalleCompra detalleCompra = new DetalleCompra(factura, fecha, tipoCompra, moneda, proveedor, descripcion, cantidad, costoU, subTotal, iva, total);
        DetalleCompraFactura detalleFactura = new DetalleCompraFactura(factura, fecha, tipoCompra, moneda, proveedor, subTotal, iva, total);
        Proveedor prov = null;
        
        if (tipoCompra.equalsIgnoreCase("Crédito")){
            prov = new Proveedor(proveedor, subTotal, iva, total);
        }
        
        System.out.println("Objeto creado exitosamente");
        printConsole(detalleCompra); //Con fines de prueba, al finalizar el proyecto lo quitare
        fCompras.add(detalleFactura, detalleCompra,prov); // Se crea los archivos para facturas y detalle de compra
        propertyChangeSupport.firePropertyChange("factura", this.factura, detalleFactura); //Se crea un evento de actualizacion
        
        JOptionPane.showMessageDialog(null, "Factura de compra añadida correctamente");
    }

    private void btnLimpiarActionPerformed(ActionEvent e) {
        pnlCompra.getTxtFactura().setText("");
        pnlCompra.getTxtFecha().setText("");
        pnlCompra.getTxtProveedor().setText("");
        pnlCompra.getTxtDescripcion().setText("");
        pnlCompra.getTxtCostoU().setText("0");
        pnlCompra.getTxtSubTotal().setText("");
        pnlCompra.getTxtIva().setText("");
        pnlCompra.getTxtTotal().setText("");
    }
    
    private void printConsole(DetalleCompra detalle){
        header();
        print(detalle);
    }
    
    public static void header(){
        System.out.format("%5s %10s %15s %15s %20s %20s %4s %15s %7s %7s %7s\n -----------------------------------------------------------------------------------------------------------------------------------------------------\n",
                "Factura","Fecha","Tipo Compra","Tipo Moneda","Proveedor","Descripcion",
                "Cantidad","Costo Unitario","Sub Total","Iva","Total");
    }
    
    public static void print(DetalleCompra dc){
        System.out.format("%7s %10s %15s %15s %20s %20s %8d %15.2f %9.2f %7.2f %7.2f",dc.getfactura(),
                dc.getFecha(),dc.getTipoCompra(),dc.getTipomoneda(),dc.getProveedor(),dc.getDescripcion(),
                dc.getCantidad(),dc.getCosto(),dc.getSubTotal(),dc.getIva(),dc.getTotal());
    }
}

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
import Pojo.DetalleCompraFactura;
import Pojo.Proveedor;
import Views.DialogoActualizar;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeSupport;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.RowFilter;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jeison Suarez
 * 
 */
public class PnlDetalleCompraController {
       private DialogoActualizar dialogActualizar;
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
    private DetalleCompraFactura factura;
    
    private PropertyChangeSupport propertyChangeSupport;
    private TableRowSorter<TableModel> tblRowSorter;
    private DetalleCompra compra;
   
    
   
    

  
    public PnlDetalleCompraController(PnlDetalleCompra pnlDcompra) {
        this.pnlDcompra = pnlDcompra;
        
        fCompras = new FilesCompras();

        listCompras = fCompras.findAllDetalle().stream().collect(Collectors.toList());
        listProveedor= fCompras.findAllCredito().stream().collect(Collectors.toList());
       
        initComponent();
    }

    private void initComponent() {
        loadTable();
         dialogActualizar = new DialogoActualizar(null,true);
        
         dialogActualizar.getBtnGroupTipoCompra().add(dialogActualizar.getRdbContado());
        dialogActualizar.getBtnGroupTipoCompra().add(dialogActualizar.getRdbCredito());
        dialogActualizar.getRdbContado().setSelected(true);

        dialogActualizar.getBtnGroupMoneda().add(dialogActualizar.getRdbCordoba());
        dialogActualizar.getBtnGroupMoneda().add(dialogActualizar.getRdbDolar());
        dialogActualizar.getRdbCordoba().setSelected(true);

        dialogActualizar.getSpnCantidad().addChangeListener((ChangeEvent ce) -> //Si se cambia el valor de cantidad, calcular en tiempo real, sus costos
        {
            if ((int) dialogActualizar.getSpnCantidad().getValue() < 0)
            {
                dialogActualizar.getTxtSubTotal().setText("");
                dialogActualizar.getTxtIva().setText("");
                dialogActualizar.getTxtTotal().setText("");
                return;
            }
            
            if (dialogActualizar.getTxtCostoU().getText().equalsIgnoreCase("")){
                dialogActualizar.getTxtSubTotal().setText("0");
                dialogActualizar.getTxtIva().setText("0");
                dialogActualizar.getTxtTotal().setText("0");
            }
            setCosto();
        });

        dialogActualizar.getTxtCostoU().addKeyListener(new KeyAdapter() { //Si el costo es 0, hacer las demas celdas en 0
            @Override
            public void keyReleased(KeyEvent e) {
                if (dialogActualizar.getTxtCostoU().getText().isEmpty())
                {
                    dialogActualizar.getTxtSubTotal().setText("");
                    dialogActualizar.getTxtIva().setText("");
                    dialogActualizar.getTxtTotal().setText("");
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

        dialogActualizar.getCkbExcento().addChangeListener((ChangeEvent ce) ->
        {
            if (!dialogActualizar.getCkbExcento().isSelected())
            {
                setCosto();
                return;
            }

            if (dialogActualizar.getTxtIva().getText().equals(""))
            {
                return;
            }

            float iva = Float.parseFloat(dialogActualizar.getTxtIva().getText());
            float total = Float.parseFloat(dialogActualizar.getTxtTotal().getText());

            dialogActualizar.getTxtIva().setText("0");
            dialogActualizar.getTxtTotal().setText(String.valueOf(total - iva));
        });
        
        dialogActualizar.getTxtCostoU().addFocusListener ( new FocusAdapter() { //Eventos de Focus en el campo de texto del costo unitario
            @Override
            public void focusGained(FocusEvent fe) {
                if (!dialogActualizar.getTxtCostoU().getText().equalsIgnoreCase("0")){
                    return;
                }
                dialogActualizar.getTxtCostoU().setText("");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (dialogActualizar.getTxtCostoU().getText().equalsIgnoreCase("") || dialogActualizar.getTxtCostoU().getText().equalsIgnoreCase("0")){
                    dialogActualizar.getTxtCostoU().setText("0");
                }
            } 
        });

       

        dialogActualizar.getBtnLimpiar().addActionListener(((e) ->
        {
            btnLimpiarActionPerformed(e);
        }));
        pnlDcompra.getTxtFinder().addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    txtFinderKeyTyped(e);
                }

            });
       
        pnlDcompra.getTblViewDetalleCompra().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount()==1){
                   return;
               }
               if(e.getClickCount()==2){
                   int row = pnlDcompra.getTblViewDetalleCompra().getSelectedRow();
                                   
                   
                   
                   String factura = String.valueOf(pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 0));
                   String fecha = (String) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 1);
                   String tipoCompra = (String) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 2);
                   String  moneda = (String ) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 3);
                   String proveedor = (String) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 4);
                   String descripcion = (String) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 5);
                   int  cantidad = (int ) pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 6);
                   String costoUnitario=  pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 7).toString();
                   String subTotal =  pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 7).toString();
                   String iva = pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 8).toString();
                   String total =  pnlDcompra.getTblViewDetalleCompra().getValueAt(row, 9).toString();
                   
                   dialogActualizar.getTxtFecha().setText(fecha);
                   dialogActualizar.getTxtFactura().setText(factura);
                   dialogActualizar.getTxtProveedor().setText(proveedor);
                   dialogActualizar.getTxtDescripcion().setText(descripcion);
                   dialogActualizar.getTxtCostoU().setText(costoUnitario);
                   dialogActualizar.getTxtSubTotal().setText(subTotal);
                   dialogActualizar.getTxtIva().setText(iva);
                   dialogActualizar.getTxtTotal().setText(total);
                   dialogActualizar.getSpnCantidad().setValue(cantidad);
                   
                   
                  
                   
                   dialogActualizar.setVisible(true);
               }
               
                
            }  
        });
        dialogActualizar.getBtnAgregar().addActionListener((e) -> {
            btnAgregarAction(e);
        });
              

    }
    private void txtFinderKeyTyped(KeyEvent e) {
        RowFilter<TableModel, Object> rf = null;
        rf = RowFilter.regexFilter(pnlDcompra.getTxtFinder().getText(), 0, 1, 2, 3, 4, 5);
        tblRowSorter.setRowFilter(rf);
    }
    
    private void loadTable (){
        modelDetalle= new TableModel(listCompras, headerDetalle);
        modelProveedor= new TableModel(listProveedor, headerProveedor);
        pnlDcompra.getTblViewDetalleCompra().setModel(modelDetalle);
        pnlDcompra.getTblViewProveedores().setModel(modelProveedor);
        tblRowSorter = new TableRowSorter<>(modelDetalle);
        pnlDcompra.getTblViewDetalleCompra().setRowSorter(tblRowSorter);
       
    }
    private void btnLimpiarActionPerformed(ActionEvent e) {
        dialogActualizar.getTxtFactura().setText("");
        dialogActualizar.getTxtFecha().setText("");
        dialogActualizar.getTxtProveedor().setText("");
        dialogActualizar.getTxtDescripcion().setText("");
        dialogActualizar.getTxtCostoU().setText("0");
        dialogActualizar.getTxtSubTotal().setText("");
        dialogActualizar.getTxtIva().setText("");
        dialogActualizar.getTxtTotal().setText("");
    }
    public  void btnAgregarAction (ActionEvent i){
        
       
        
        int row = pnlDcompra.getTblViewDetalleCompra().getSelectedRow();
        String factura = dialogActualizar.getTxtFactura().getText();
        String fecha = dialogActualizar.getTxtFecha().getText();
        String tipoCompra = null;
        String moneda = null;
        
        Enumeration btnGroupTipoCompra = dialogActualizar.getBtnGroupTipoCompra().getElements();
        
        while (btnGroupTipoCompra.hasMoreElements())
        {
            JRadioButton rdb = (JRadioButton) btnGroupTipoCompra.nextElement();
            
            if (rdb.isSelected()){
                tipoCompra = rdb.getText();
            }
        }
        
        Enumeration btnGroupMoneda = dialogActualizar.getBtnGroupMoneda().getElements();
        
        while (btnGroupMoneda.hasMoreElements()){
            
            JRadioButton rdb = (JRadioButton) btnGroupMoneda.nextElement();
            
            if (rdb.isSelected()){
                moneda = rdb.getText();
            }
        }
        
        String proveedor = dialogActualizar.getTxtProveedor().getText();
        String descripcion = dialogActualizar.getTxtDescripcion().getText();
        
        if (factura.isEmpty() || proveedor.isEmpty() || descripcion.isEmpty()){
            JOptionPane.showMessageDialog(null, "Rellene todos los espacios en blanco");
            return;
        }
        
        int cantidad = (int) dialogActualizar.getSpnCantidad().getValue();
        float costoU = Float.parseFloat(dialogActualizar.getTxtCostoU().getText());
        float subTotal = Float.parseFloat(dialogActualizar.getTxtSubTotal().getText());
        float iva = Float.parseFloat(dialogActualizar.getTxtIva().getText());
        float total = Float.parseFloat(dialogActualizar.getTxtTotal().getText());
        
       
        DetalleCompra com= new DetalleCompra(factura, fecha, tipoCompra, moneda, proveedor, descripcion, cantidad, costoU, subTotal, iva, total);
        if (com!=null){
            JOptionPane.showMessageDialog( null, "Actulizado correctamente");
        } else {
            JOptionPane.showMessageDialog( null, "Cagaste");
        }
        
       fCompras.edit(com,row);
        
        
        
    }
    
    private void setCosto() throws NumberFormatException {
        if (dialogActualizar.getTxtCostoU().getText().equals("")){
            return;
        }
        
        float costo = Float.parseFloat(dialogActualizar.getTxtCostoU().getText());
        int unidades = (int) dialogActualizar.getSpnCantidad().getValue();

        float subTotal = costo * unidades;
        float iva = 0;

        if (dialogActualizar.getCkbExcento().isSelected())
        {
            dialogActualizar.getTxtSubTotal().setText(String.valueOf(subTotal));
            dialogActualizar.getTxtIva().setText("0");
            dialogActualizar.getTxtTotal().setText(String.valueOf(subTotal));
            return;
        }
        iva = (float) (0.15 * subTotal);
        float total = subTotal + iva;

        dialogActualizar.getTxtSubTotal().setText(String.valueOf(subTotal));
        dialogActualizar.getTxtIva().setText(String.valueOf(iva));
        dialogActualizar.getTxtTotal().setText(String.valueOf(total));
    }
     
    

}

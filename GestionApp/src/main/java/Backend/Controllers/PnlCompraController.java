/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Model.TableModel;
import Panels.Compra.PnlCompra;
import Pojo.SubCompra;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class PnlCompraController {

    private PnlCompra pnlCompra;
    private String[] header =
    {
        "N°o Factura", "Fecha Compra", "Tipo de Compra", "Moneda", "Proveedor", "Sub-Total", "Iva", "Total"
    };
    private SubCompra subCompra;
    private TableModel<SubCompra> tablemodel;
    private List<SubCompra> list;

    public PnlCompraController(PnlCompra pnlCompra) {
        this.pnlCompra = pnlCompra;
        initComponents();
    }

    private void initComponents() {
        tablemodel = new TableModel<>(list, header);
        pnlCompra.getTblResumenCompras().setModel(tablemodel);

        pnlCompra.getBtnGroupTipoCompra().add(pnlCompra.getRdbContado());
        pnlCompra.getBtnGroupTipoCompra().add(pnlCompra.getRdbCredito());

        pnlCompra.getBtnGroupMoneda().add(pnlCompra.getRdbCordoba());
        pnlCompra.getBtnGroupMoneda().add(pnlCompra.getRdbDolar());

        pnlCompra.getSpnCantidad().addChangeListener((ChangeEvent ce) ->
        {
            if ((int) pnlCompra.getSpnCantidad().getValue() < 0)
            {
                pnlCompra.getTxtSubTotal().setText("");
                pnlCompra.getTxtIva().setText("");
                pnlCompra.getTxtTotal().setText("");
                return;
            }
            setCosto();
        });

        pnlCompra.getTxtCostoU().addKeyListener(new KeyAdapter() {
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

    }

    private void btnLimpiarActionPerformed(ActionEvent e) {
        pnlCompra.getTxtFactura().setText("");
        pnlCompra.getTxtFecha().setText("");
        pnlCompra.getTxtProveedor().setText("");
        pnlCompra.getTxtDescripcion().setText("");
        pnlCompra.getTxtCostoU().setText("");
        pnlCompra.getTxtSubTotal().setText("");
        pnlCompra.getTxtIva().setText("");
        pnlCompra.getTxtTotal().setText("");
    }

}

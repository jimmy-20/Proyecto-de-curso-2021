/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.InternalFrames;

import Backend.Controllers.PnlDetalleVentasController;
import Panels.Ventas.PnlDetalleVentas;
import java.awt.BorderLayout;



/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class JifDetalleVentas extends javax.swing.JInternalFrame {


     private PnlDetalleVentas pnlDetalleVentas;
     private PnlDetalleVentasController detalleVentasController;
    public JifDetalleVentas() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContent = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Detalle de Ventas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ventas.png"))); // NOI18N

        pnlContent.setLayout(new java.awt.BorderLayout());

        pnlDetalleVentas=new PnlDetalleVentas();
        detalleVentasController= new PnlDetalleVentasController(pnlDetalleVentas);
        pnlContent.add(pnlDetalleVentas,BorderLayout.CENTER);

        getContentPane().add(pnlContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables
}

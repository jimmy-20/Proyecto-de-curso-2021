/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.InternalFrames;

import Backend.Controllers.PnlDetalleCompraController;
import Panels.Compra.PnlDetalleCompra;
import java.awt.BorderLayout;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class JifDetalleCompras extends javax.swing.JInternalFrame {

    private PnlDetalleCompra pnlDetalleCompra;
    private PnlDetalleCompraController detalleCompraController;
    
    public JifDetalleCompras() {
        initComponents();
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Proveedores");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Proveedores.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(754, 384));

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlDetalleCompra= new PnlDetalleCompra();
        detalleCompraController= new PnlDetalleCompraController(pnlDetalleCompra
        );
        jPanel1.add(pnlDetalleCompra,BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

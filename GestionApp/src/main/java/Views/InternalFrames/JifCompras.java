/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.InternalFrames;

import Backend.Controllers.PnlCompraController;
import Panels.Compra.PnlCompra;
import Panels.Compra.PnlCompraDesign;
import java.awt.BorderLayout;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class JifCompras extends javax.swing.JInternalFrame {
    private PnlCompra pnlCompra;
    private PnlCompraDesign pnlCompraDesign;
    private PnlCompraController pnlCompraController;
   
    
    public JifCompras() {
        initComponents();
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlContentData = new javax.swing.JPanel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Compras");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Compra.png"))); // NOI18N

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlContentData.setMinimumSize(new java.awt.Dimension(593, 602));
        pnlContentData.setLayout(new java.awt.BorderLayout());

        pnlCompraDesign = new PnlCompraDesign();
        pnlCompraController = new PnlCompraController(pnlCompraDesign);
        pnlContentData.add(pnlCompraDesign,BorderLayout.CENTER);

        jPanel1.add(pnlContentData, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlContentData;
    // End of variables declaration//GEN-END:variables
}

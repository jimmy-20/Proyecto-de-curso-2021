/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.InternalFrames;

import Backend.Controllers.PnlReporteController;
import Panels.Reportes.PnlReporte;
import java.awt.BorderLayout;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class JifReportes extends javax.swing.JInternalFrame {
    private PnlReporte pnlReporte;
    private PnlReporteController pnlReporteController;
    
    public JifReportes() {
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
        setTitle("Generador de Reportes");
        setMinimumSize(new java.awt.Dimension(300, 300));

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlReporte = new PnlReporte();
        pnlReporteController = new PnlReporteController(pnlReporte);
        jPanel1.add(pnlReporte,BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

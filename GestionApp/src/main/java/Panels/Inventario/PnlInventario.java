/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels.Inventario;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Jimmy-Soza
 */
public class PnlInventario extends javax.swing.JPanel {
    
    public PnlInventario() {
        initComponents();
    }

    public JButton getBtnEnviartoVentas() {
        return btnEnviartoVentas;
    }

    public void setBtnEnviartoVentas(JButton btnEnviartoVentas) {
        this.btnEnviartoVentas = btnEnviartoVentas;
    }

    public JTable getTblInventario() {
        return tblInventario;
    }

    public void setTblInventario(JTable tblInventario) {
        this.tblInventario = tblInventario;
    }

    public JTextField getTxtFinder() {
        return txtFinder;
    }

    public void setTxtFinder(JTextField txtFinder) {
        this.txtFinder = txtFinder;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFinder = new javax.swing.JTextField();
        btnEnviartoVentas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Buscar: ");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        jPanel1.add(txtFinder, gridBagConstraints);

        btnEnviartoVentas.setText("Enviar a Ventas");
        jPanel1.add(btnEnviartoVentas, new java.awt.GridBagConstraints());

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblInventario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hola", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jScrollPane1.setViewportView(tblInventario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviartoVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtFinder;
    // End of variables declaration//GEN-END:variables
}

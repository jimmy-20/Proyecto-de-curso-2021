/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels.Ventas;

import Panels.Ventas.*;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PnlDetalleVentas extends javax.swing.JPanel {

    
    public PnlDetalleVentas() {
        initComponents();
    }

    public JTable getTblViewClientes() {
        return tblViewClientes;
    }

    public JTable getTblViewDetalleVentas() {
        return tblViewDetalleVentas;
    }

    public JTextField getTxtFinder() {
        return txtFinder;
    }

    

 

    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFinder = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblViewClientes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewDetalleVentas = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(754, 384));
        setPreferredSize(new java.awt.Dimension(754, 384));
        setLayout(new java.awt.BorderLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(754, 384));
        jPanel3.setPreferredSize(new java.awt.Dimension(754, 384));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Buscar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        jPanel5.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 4);
        jPanel5.add(txtFinder, gridBagConstraints);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Clientes\n"));
        jPanel4.setPreferredSize(new java.awt.Dimension(551, 218));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        tblViewClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblViewClientes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jScrollPane2, gridBagConstraints);

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Ventas\n"));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        tblViewDetalleVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblViewDetalleVentas.setName(""); // NOI18N
        jScrollPane1.setViewportView(tblViewDetalleVentas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jScrollPane1, gridBagConstraints);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblViewClientes;
    private javax.swing.JTable tblViewDetalleVentas;
    private javax.swing.JTextField txtFinder;
    // End of variables declaration//GEN-END:variables
}

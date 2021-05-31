/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels.Compra;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class PnlCompraDesign extends javax.swing.JPanel {


    public PnlCompraDesign() {
        initComponents();
    }

    public JTable getTblResumenCompras() {
        return tblResumenCompras;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JSpinner getSpnCantidad() {
        return spnCantidad;
    }

    public JTextField getTxtCostoU() {
        return txtCostoU;
    }

    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public JTextField getTxtFactura() {
        return txtFactura;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public JTextField getTxtIva() {
        return txtIva;
    }

    public JTextField getTxtProveedor() {
        return txtProveedor;
    }

    public JTextField getTxtSubTotal() {
        return txtSubTotal;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public ButtonGroup getBtnGroupMoneda() {
        return btnGroupMoneda;
    }

    public ButtonGroup getBtnGroupTipoCompra() {
        return btnGroupTipoCompra;
    }

    public JRadioButton getRdbContado() {
        return rdbContado;
    }

    public JRadioButton getRdbCordoba() {
        return rdbCordoba;
    }

    public JRadioButton getRdbCredito() {
        return rdbCredito;
    }

    public JRadioButton getRdbDolar() {
        return rdbDolar;
    }

    public JCheckBox getCkbExcento() {
        return ckbExcento;
    }
    
    
    
    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        btnGroupTipoCompra = new javax.swing.ButtonGroup();
        btnGroupMoneda = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResumenCompras = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rdbContado = new javax.swing.JRadioButton();
        rdbCredito = new javax.swing.JRadioButton();
        rdbDolar = new javax.swing.JRadioButton();
        rdbCordoba = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        txtCostoU = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        ckbExcento = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setMinimumSize(new java.awt.Dimension(552, 550));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(552, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(552, 200));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte de factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N
        jScrollPane2.setViewportView(tblResumenCompras);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        jPanel1.add(jScrollPane2, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(205, 218, 253));
        jPanel6.setPreferredSize(new java.awt.Dimension(250, 350));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("No Image");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(186, 118, 150, 98);
        jPanel6.add(jLabel1, gridBagConstraints);

        jPanel3.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jPanel7.setBackground(new java.awt.Color(234, 228, 233));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Numero de Factura:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 14);
        jPanel7.add(txtFactura, gridBagConstraints);

        jLabel3.setText("Fecha Compra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 14);
        jPanel7.add(txtFecha, gridBagConstraints);

        jLabel4.setText("Tipo de Compra");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel4, gridBagConstraints);

        rdbContado.setText("Contado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.2;
        jPanel7.add(rdbContado, gridBagConstraints);

        rdbCredito.setText("Crédito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.2;
        jPanel7.add(rdbCredito, gridBagConstraints);

        rdbDolar.setText("Dolar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 0.2;
        jPanel7.add(rdbDolar, gridBagConstraints);

        rdbCordoba.setText("Córdobas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 0.2;
        jPanel7.add(rdbCordoba, gridBagConstraints);

        jLabel5.setText("Moneda:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Proveedor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 14);
        jPanel7.add(txtProveedor, gridBagConstraints);

        jLabel10.setText("Descripción: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 14);
        jPanel7.add(txtDescripcion, gridBagConstraints);

        jLabel11.setText("Cantidad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel11, gridBagConstraints);

        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 14);
        jPanel7.add(spnCantidad, gridBagConstraints);

        jLabel12.setText("Costo Unitario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel12, gridBagConstraints);

        txtCostoU.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 14);
        jPanel7.add(txtCostoU, gridBagConstraints);

        jLabel7.setText("Sub-Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel7, gridBagConstraints);

        txtSubTotal.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 14);
        jPanel7.add(txtSubTotal, gridBagConstraints);

        jLabel8.setText("IVA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel8, gridBagConstraints);

        txtIva.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 14);
        jPanel7.add(txtIva, gridBagConstraints);

        ckbExcento.setText("Excento de Iva");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel7.add(ckbExcento, gridBagConstraints);

        jLabel9.setText("Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 6, 15);
        jPanel7.add(jLabel9, gridBagConstraints);

        txtTotal.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 14);
        jPanel7.add(txtTotal, gridBagConstraints);

        btnAgregar.setText("Agregar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        jPanel7.add(btnAgregar, gridBagConstraints);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel7.add(btnLimpiar, gridBagConstraints);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.ButtonGroup btnGroupMoneda;
    private javax.swing.ButtonGroup btnGroupTipoCompra;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox ckbExcento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdbContado;
    private javax.swing.JRadioButton rdbCordoba;
    private javax.swing.JRadioButton rdbCredito;
    private javax.swing.JRadioButton rdbDolar;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblResumenCompras;
    private javax.swing.JTextField txtCostoU;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

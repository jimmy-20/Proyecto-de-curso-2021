
package Panels.Ventas;

import javax.swing.JComboBox;
import javax.swing.JTable;


public class PnlDetalleVentas extends javax.swing.JPanel {

    
    public PnlDetalleVentas() {
        initComponents();
        
    }

    public JComboBox<String> getCmbFiltro() {
        return cmbFiltro;
    }

    public JTable getTblViewClientes() {
        return tblViewClientes;
    }

    public JTable getTblViewDetalleVentas() {
        return tblViewDetalleVentas;
    }

    

    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblViewClientes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewDetalleVentas = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(500, 500));
        setLayout(new java.awt.BorderLayout());

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
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        jPanel4.add(jScrollPane2, gridBagConstraints);

        add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("FIltrar por: ");
        jPanel5.add(jLabel1);

        jPanel5.add(cmbFiltro);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_END);

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
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        jPanel6.add(jScrollPane1, gridBagConstraints);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblViewClientes;
    private javax.swing.JTable tblViewDetalleVentas;
    // End of variables declaration//GEN-END:variables
}

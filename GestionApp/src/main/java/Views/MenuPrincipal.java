/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Views.InternalFrames.JifCompras;
import Views.InternalFrames.JifDetalleCompras;
import Views.InternalFrames.JifDetalleVentas;
import Views.InternalFrames.JifReportes;
import Views.InternalFrames.JifSistemaVentas;
import Views.InternalFrames.JifVentas;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private JifCompras compras;
    private JifDetalleCompras detalleCompras;

    private JifVentas ventas;
    private JifDetalleVentas detalleVentas;
    
    private JifSistemaVentas sistemaVentas;
    
    private JifReportes jifReportes;

    public MenuPrincipal() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnCompras = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnDetalleCompras = new javax.swing.JButton();
        btnSistemaVenta = new javax.swing.JButton();
        btnDetalleVentas = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Wallpaper4.png"));
        Image image = icon.getImage();
        dktContent = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }

        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(771, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnCompras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Compra.png"))); // NOI18N
        btnCompras.setText("Compras");
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(btnCompras, gridBagConstraints);

        btnVentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ventas1.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(btnVentas, gridBagConstraints);

        btnDetalleCompras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDetalleCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Proveedores.png"))); // NOI18N
        btnDetalleCompras.setText("Detalle de Compras");
        btnDetalleCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleComprasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(btnDetalleCompras, gridBagConstraints);

        btnSistemaVenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSistemaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ProgramaVentas.png"))); // NOI18N
        btnSistemaVenta.setText("Sistema de Venta");
        btnSistemaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSistemaVentaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(btnSistemaVenta, gridBagConstraints);

        btnDetalleVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ventas.png"))); // NOI18N
        btnDetalleVentas.setText("Detalle de Ventas");
        btnDetalleVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleVentasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(btnDetalleVentas, gridBagConstraints);

        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        jPanel1.add(btnReporte, gridBagConstraints);

        jPanel2.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout dktContentLayout = new javax.swing.GroupLayout(dktContent);
        dktContent.setLayout(dktContentLayout);
        dktContentLayout.setHorizontalGroup(
            dktContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );
        dktContentLayout.setVerticalGroup(
            dktContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jPanel2.add(dktContent, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
        
        List<JInternalFrame> frames =  Arrays.asList(dktContent.getAllFrames()) ;
        Optional<JInternalFrame> optional = frames.stream().filter(j -> j instanceof JifCompras).findAny();
        if (optional.isPresent())
        {
            return;
        }
        
        compras = new JifCompras();
        dktContent.add(compras);
        compras.setVisible(true);
    }//GEN-LAST:event_btnComprasActionPerformed


    
   
    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        List<JInternalFrame> frames =  Arrays.asList(dktContent.getAllFrames()) ;
        Optional<JInternalFrame> optional = frames.stream().filter(j -> j instanceof JifVentas).findAny();
        if (optional.isPresent())
        {
            return;
        }
        
        ventas = new JifVentas();
        dktContent.add(ventas);

        ventas.setVisible(true);

    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnDetalleComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleComprasActionPerformed

        List<JInternalFrame> frames =  Arrays.asList(dktContent.getAllFrames()) ;
        Optional<JInternalFrame> optional = frames.stream().filter(j -> j instanceof JifDetalleCompras).findAny();
        if (optional.isPresent())
        {
            return;
        }
        
        detalleCompras = new JifDetalleCompras();
        dktContent.add(detalleCompras);

        detalleCompras.setVisible(true);

    }//GEN-LAST:event_btnDetalleComprasActionPerformed

    private void btnSistemaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSistemaVentaActionPerformed

        List<JInternalFrame> frames =  Arrays.asList(dktContent.getAllFrames()) ;
        Optional<JInternalFrame> optional = frames.stream().filter(j -> j instanceof JifSistemaVentas).findAny();
        if (optional.isPresent())
        {
            return;
        }
        
        sistemaVentas = new JifSistemaVentas();
        dktContent.add(sistemaVentas);
        sistemaVentas.setVisible(true);
    }//GEN-LAST:event_btnSistemaVentaActionPerformed

    private void btnDetalleVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleVentasActionPerformed
        List<JInternalFrame> frames =  Arrays.asList(dktContent.getAllFrames()) ;
        Optional<JInternalFrame> optional = frames.stream().filter(j -> j instanceof JifDetalleVentas).findAny();
        if (optional.isPresent())
        {
            return;
        }
        
        detalleVentas = new JifDetalleVentas();
        dktContent.add(detalleVentas);
        detalleVentas.setVisible(true);
    }//GEN-LAST:event_btnDetalleVentasActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        List<JInternalFrame> frames =  Arrays.asList(dktContent.getAllFrames()) ;
        Optional<JInternalFrame> optional = frames.stream().filter(j -> j instanceof JifReportes).findAny();
        if (optional.isPresent())
        {
            return;
        }
        
        jifReportes = new JifReportes();
        dktContent.add(jifReportes);
        jifReportes.setVisible(true);
    }//GEN-LAST:event_btnReporteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnDetalleCompras;
    private javax.swing.JButton btnDetalleVentas;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSistemaVenta;
    private javax.swing.JButton btnVentas;
    private javax.swing.JDesktopPane dktContent;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

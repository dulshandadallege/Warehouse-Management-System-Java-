/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import system.user.Material;
import system.user.Person;
import system.user.Supplier;

/**
 *
 *
 */
public class JfrmViewSupplierMaterial extends javax.swing.JFrame {

    /**
     * Creates new form JfrmViewSupplierMaterial
     */
    
    private Person psn;
    
    public JfrmViewSupplierMaterial(Person psn) throws SQLException, ClassNotFoundException {
        initComponents();
        this.psn=psn;
        
        Supplier.listSuppliers().forEach((s)->{
            cmbSplNo.addItem(s);
        });
        
        Material.listMaterial().forEach((s)->{
            cmbMatNo.addItem(s);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDash = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbSplNo = new javax.swing.JComboBox<>();
        cmbMatNo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMatNo = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSplNo = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supplier Material Details");

        btnDash.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDash.setText("<<Dashboard");
        btnDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Supplier");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Material");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Material");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Supplier");

        cmbSplNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbSplNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSplNoActionPerformed(evt);
            }
        });

        cmbMatNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbMatNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMatNoActionPerformed(evt);
            }
        });

        lstMatNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lstMatNo.setVisibleRowCount(10);
        jScrollPane1.setViewportView(lstMatNo);

        lstSplNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lstSplNo.setVisibleRowCount(10);
        jScrollPane2.setViewportView(lstSplNo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSplNo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                .addComponent(cmbMatNo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnDash)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnDash)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbSplNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbMatNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashActionPerformed

        try{
            char pr=psn.getPrv();

            switch(pr)
            {
                case 'M':
                new JfrmManagerDashboard(psn).setVisible(true);
                dispose();
                break;
                case 'S':
                new JfrmSupervisorDashboard(psn).setVisible(true);
                dispose();
                break;
                default:
                JOptionPane.showMessageDialog(null, "Privilage Issue, Please contact System administrator :", "Privilage Issue", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Oops Something went Wrong :" + ex.getMessage(), "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDashActionPerformed

    private void cmbSplNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSplNoActionPerformed
        String splNo=(String)cmbSplNo.getSelectedItem();
        DefaultListModel lstMat=new DefaultListModel();
        Supplier spl=new Supplier(splNo);
        
        try{
            spl.listMaterials().forEach((s)->{
                lstMat.addElement(s);
            });
            lstMatNo.setModel(lstMat);
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Oops Something went Wrong :" + ex.getMessage(), "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmbSplNoActionPerformed

    private void cmbMatNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMatNoActionPerformed
        String matNo=(String)cmbMatNo.getSelectedItem();
        DefaultListModel lstSpl=new DefaultListModel();
        Material mat=new Material(matNo);
        
        try{
            
            mat.listSuppliers().forEach((s)->{
                lstSpl.addElement(s);
            });
            lstSplNo.setModel(lstSpl);
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Oops Something went Wrong :" + ex.getMessage(), "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmbMatNoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JfrmViewSupplierMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmViewSupplierMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmViewSupplierMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmViewSupplierMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDash;
    private javax.swing.JComboBox<String> cmbMatNo;
    private javax.swing.JComboBox<String> cmbSplNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstMatNo;
    private javax.swing.JList<String> lstSplNo;
    // End of variables declaration//GEN-END:variables
}

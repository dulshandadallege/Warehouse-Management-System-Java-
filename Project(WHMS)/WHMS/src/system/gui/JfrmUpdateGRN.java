/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import system.user.Stock;
import system.user.Supervisor;
import system.user.Supplier;
import system.user.Supply;
import system.user.Warehouse;

/**
 *
 * 
 */
public class JfrmUpdateGRN extends javax.swing.JFrame {

    /**
     * Creates new form JfrmUpdateGRN
     */
    private Supervisor sup;
    private List<String> spl;
    
    public JfrmUpdateGRN(Supervisor sup) throws SQLException, ClassNotFoundException {
        initComponents();
        this.sup=sup;
        txtWhNo.enable(false);
        txtWhNo.setText(sup.getWhNo());
        spl=Supplier.listSuppliers();
        spl.forEach((s) -> {
            cmbSplNo.addItem(s);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDash = new javax.swing.JButton();
        txtWhNo = new javax.swing.JTextField();
        cmbMatNo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUnt = new javax.swing.JTextField();
        cmbSplNo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtGRN = new javax.swing.JTextField();
        txtUntPrc = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update GRN");
        setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Warehouse No");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Material No");

        btnDash.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDash.setText("<<Dashboard");
        btnDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashActionPerformed(evt);
            }
        });

        txtWhNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtWhNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWhNoActionPerformed(evt);
            }
        });

        cmbMatNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("GRN No");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Supplier No");

        txtUnt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cmbSplNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbSplNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSplNoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Unit Price");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Unit");

        txtGRN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtUntPrc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSplNo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(btnUpdate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbMatNo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtUnt, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtUntPrc)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtWhNo)
                                            .addComponent(txtGRN)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDash)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnDash)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtWhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbSplNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMatNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUntPrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashActionPerformed
        try {
            new JfrmSupervisorDashboard(this.sup).setVisible(true);
            dispose();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Oops Something went Wrong :" + ex.getMessage(), "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDashActionPerformed

    private void txtWhNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWhNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWhNoActionPerformed

    private void cmbSplNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSplNoActionPerformed
        Supplier spl=new Supplier((String)cmbSplNo.getSelectedItem());
        List<String> mat=null;
        try {
            mat=spl.listMaterials();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Oops Something went Wrong :" + ex.getMessage(), "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }
        cmbMatNo.removeAllItems();
        for(String s:mat)
        {
            cmbMatNo.addItem(s);
        }
    }//GEN-LAST:event_cmbSplNoActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String grnNo, unt, whNo, matNo, splNo, untPrc;
        double ut=0, utPrc=0, qty=0, maxQty=0, ttlQty=0;
        
        ResultSet rs=null, rsMgr=null, rsSpl=null;
        whNo=sup.getWhNo();
        matNo=(String)cmbMatNo.getSelectedItem();
        splNo=(String)cmbSplNo.getSelectedItem();
        grnNo=txtGRN.getText();
        unt=txtUnt.getText();
        untPrc=txtUntPrc.getText();
        Supply spl=new Supply(grnNo,matNo);
        Stock stk=new Stock(sup.getWhNo(),matNo);
        Warehouse wh=null;
        
        if(grnNo.isEmpty() | unt.isEmpty() | untPrc.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Required Feilds are left Blank" , "Validation Issue", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            try{
                ut=Double.parseDouble(unt);
                utPrc=Double.parseDouble(untPrc);
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Please enter Numeric values for Number of units & Unit price and retry :", "Validation Issue", 
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            
        }
        
        if(ut<=0 | utPrc<=0)
        {
            JOptionPane.showMessageDialog(null, "Number of units & Unit price can't be zero or a negative value" , "Validation Issue", 
                    JOptionPane.WARNING_MESSAGE);
        }
        else if(grnNo.length()!=10)
        {
            JOptionPane.showMessageDialog(null, "The GRN Number must have exactly 10 charactors in it" , "Validation Issue", JOptionPane.WARNING_MESSAGE);   
        }
        else
        {   
            try{
                
                rs=stk.pullStock(whNo, matNo);
                              
                if(rs.next())
                {
                        qty=rs.getDouble(3);
                        maxQty=rs.getDouble(5);
                        ttlQty=ut+qty;
                        rsSpl=spl.pullSupply();
                    
                    
                    if(rsSpl.next())
                    {
                        spl=new Supply(grnNo,splNo, matNo, sup.getWhNo(), ut, utPrc);
                        
                        double units=rsSpl.getDouble(5);
                        int diagRes=JOptionPane.showConfirmDialog (null,"The inputted GRN detail already exists, do you want to override it.",
                                "GRN already exist",JOptionPane.INFORMATION_MESSAGE);
                        
                        if(diagRes==JOptionPane.YES_OPTION)
                        {
                            if((ttlQty-units)>maxQty)
                            {
                                JOptionPane.showMessageDialog(null, "There is not enough storage space to store the inputted units in the selected Warehouse. "
                                + "\nInputted Quantity: " + ut + "\nTotal Quantity after Input: " + (ttlQty-units) + "\nMaximum quantity: " + maxQty, 
                                "Warehouse Storage Issue", JOptionPane.WARNING_MESSAGE);
                                rs.close();
                                rsSpl.close();
                            }
                            else
                            {
                                boolean upSpl=spl.updateSupply();
                                boolean upStk=stk.upateStock(rs.getDouble(3)+(ut-units));
                                rs.close();
                                rsSpl.close();
                                if(upStk==true && upSpl==true)
                                {
                                    JOptionPane.showMessageDialog(null, "GRN detail updated sucessfully" , "Updated Successfully", JOptionPane.INFORMATION_MESSAGE);
                                    txtUnt.setText(null);
                                    txtUntPrc.setText(null);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "GRN detail updated failed!" , "Updated Failed", JOptionPane.WARNING_MESSAGE); 
                                }
                            }
                        }
                        else
                        {
                            rs.close();
                            rsSpl.close();
                        }
                    }
                    
                    else
                    {
                        if(ttlQty>maxQty)
                        {    
                            JOptionPane.showMessageDialog(null, "There is not enough storage space to store the inputted units in the selected Warehouse. "
                                + "\nInputted Quantity: " + ut + "\nTotal Quantity after Input: " + ttlQty + "\nMaximum quantity: " + maxQty, 
                                "Warehouse Storage Issue", JOptionPane.WARNING_MESSAGE);
                        }
                        else
                        {
                            spl=new Supply(grnNo,splNo, matNo, sup.getWhNo(), ut, utPrc);
                            boolean insSup=spl.insertSupply();
                            boolean upStk=stk.upateStock(rs.getDouble(3)+ut);
                        
                            if(insSup==true && upStk==true)
                            {
                                JOptionPane.showMessageDialog(null, "GRN detail submitted  Successfully" , "Updated Successfully", JOptionPane.INFORMATION_MESSAGE);
                                txtUnt.setText(null);
                                txtUntPrc.setText(null);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "GRN detail submission Failed!" , "Updated Failed", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                }
                
                else
                {
                    
                    wh=new Warehouse(this.sup.getWhNo());
                    rsMgr=wh.pullManager();
                    rsMgr.next();
                    JOptionPane.showMessageDialog(null, "The Warehouse doesn't have the material you entered in it's stock inventory."
                            + "\nPlease contact your area manager to add materials to the stock inventory as reqired."
                            + "\n\nManager Name: " + rsMgr.getString(1) + "Manager email: " + rsMgr.getString(2) + "\nManager telephone: " 
                            + rsMgr.getString(3),"Warehouse Inventory Issue", JOptionPane.WARNING_MESSAGE);
                    rsMgr.close();
                }        
            }
            
            catch(SQLException | ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(null, "Oops Something went Wrong 7:" + ex.getMessage(), "Runtime Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(JfrmUpdateGRN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmUpdateGRN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmUpdateGRN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmUpdateGRN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDash;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbMatNo;
    private javax.swing.JComboBox<String> cmbSplNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtGRN;
    private javax.swing.JTextField txtUnt;
    private javax.swing.JTextField txtUntPrc;
    private javax.swing.JTextField txtWhNo;
    // End of variables declaration//GEN-END:variables
}

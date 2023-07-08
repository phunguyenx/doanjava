/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import Controller.TypeRoomControl;
import Model.TypeRoom;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGUYEN PHUC NAM
 */
public final class FormLoaiPhong extends javax.swing.JFrame {
    private final ArrayList<TypeRoom> listTypeRooms;
    DefaultTableModel model;
    /**
     * Creates new form FormLoaiPhong
     */
    public FormLoaiPhong() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        listTypeRooms = TypeRoomControl.getlistTypeRooms();
        model = (DefaultTableModel) jTable1.getModel();
        jtextId.setText(TypeRoomControl.ReturnNextIdTypeRoom());
        jtextId.enable(false);
        showTable();
    }
    public void showTable(){
        for(TypeRoom tr : listTypeRooms){
            model.addRow(new Object[]{
                tr.getId_tRoom(), tr.getName(), tr.getPrice()
            });
        }
    }
    public void showResult(){
        TypeRoom tr = listTypeRooms.get(listTypeRooms.size()-1);
        model.addRow(new Object[]{
                tr.getId_tRoom(), tr.getName(), tr.getPrice()
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtextId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextName = new javax.swing.JTextField();
        jTextPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Quản Lý Loại Phòng");

        jLabel2.setText("Mã Loại Phòng");

        jLabel3.setText("Tên Loại Phòng");

        jLabel5.setText("Giá Theo Ngày");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Loại Phòng", "Tên Loại Phòng", "Giá Theo Ngày"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Làm mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(465, 465, 465)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jtextId, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(118, 118, 118)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(29, 29, 29)
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jtextId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTextName.getText().isEmpty() || jTextName.getText().isEmpty() || jTextPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
        }else {
            try {
                String id = jtextId.getText();
                String name = jTextName.getText();
                int price = Integer.parseInt(jTextPrice.getText());
                int check = TypeRoomControl.check(id, name, price);
                switch (check) {
                    case -1 -> JOptionPane.showMessageDialog(null, "Vui lòng bấm làm mới trước khi thêm");
                    case 1  -> {JOptionPane.showMessageDialog(null, "Thêm thành công");
                    
                    TypeRoom tr = new TypeRoom(id, name, price);
                    listTypeRooms.add(tr);
                    showResult();
                    }
                    case 0 -> JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi vui lòng thử lại");
                    default -> throw new AssertionError();
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Giá không bao gồm các chữ và kí tự ");
            }
            
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        
        if (i == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn loại phòng cần sửa");
        }else{
            int cf = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa không?",
                    "XÁC NHẬN", JOptionPane.YES_NO_OPTION);
            if(cf == 0){
                try {
                    String id = jtextId.getText();
                    String name = jTextName.getText();
                    int price = Integer.parseInt(jTextPrice.getText());
                    int check = TypeRoomControl.edit(id, name, price);
                    switch (check) {
                        case 1  -> {JOptionPane.showMessageDialog(null, "Sửa thành công");
                            jTable1.setValueAt(name, i, 1);
                            jTable1.setValueAt(price, i, 2);
                        }
                        case 0 -> JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi vui lòng thử lại");
                        default -> throw new AssertionError();
                }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Giá không bao gồm chữ và kí tự!");
                }
                 
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        jtextId.setText(jTable1.getValueAt(i, 0).toString());
        jTextName.setText(jTable1.getValueAt(i, 1).toString());
        jTextPrice.setText(jTable1.getValueAt(i, 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jtextId.setText(TypeRoomControl.ReturnNextIdTypeRoom());
        jTextName.setText("");
        jTextPrice.setText("");
        jTable1.clearSelection();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn loại phòng muốn xóa.");
        }
        else{
            int cf = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?",
                    "XÁC NHẬN", JOptionPane.YES_NO_OPTION);
            if (cf == 0){
                String id =(String) jTable1.getValueAt(i,0);
                TypeRoomControl.Remove(id);
                model.removeRow(i);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FormLoaiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLoaiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLoaiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLoaiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLoaiPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextPrice;
    private javax.swing.JTextField jtextId;
    // End of variables declaration//GEN-END:variables
}
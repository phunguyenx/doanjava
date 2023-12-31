/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import Controller.EmployeeControl;
import Model.Employee;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGUYEN PHUC NAM
 */
public final class FormNhanVien extends javax.swing.JFrame {

    private final ArrayList<Employee> listEmployees;
    DefaultTableModel model;

    /**
     * Creates new form FormNhanVien
     */
    public FormNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        listEmployees = EmployeeControl.getlistEmployees();
        model = (DefaultTableModel) jTable1.getModel();
        ButtonGroup group = new ButtonGroup();
        group.add(jNam);
        group.add(jNu);
        showTable();
    }

    public void showTable() {
        for (Employee e : listEmployees) {
            if (e.getGender() == 1) {
                model.addRow(new Object[]{
                    e.getID(), e.getName(), e.getIdCard(), "Nam", e.getBirthDate(), e.getAddress(), e.getPhone(), e.getEmail(), e.getEducationLevel()
                });

            } else {
                model.addRow(new Object[]{
                    e.getID(), e.getName(), e.getIdCard(), "Nữ", e.getBirthDate(), e.getAddress(), e.getPhone(), e.getEmail(), e.getEducationLevel()
                });
            }
        }
    }

    public void showResult() {
        Employee e = listEmployees.get(listEmployees.size() - 1);
        Date date = e.getBirthDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (e.getGender() == 1) {
            model.addRow(new Object[]{
                e.getID(), e.getName(), e.getIdCard(), "Nam", dateFormat.format(e.getBirthDate()), e.getAddress(), e.getPhone(), e.getEmail(), e.getEducationLevel()
            });

        } else {
            model.addRow(new Object[]{
                e.getID(), e.getName(), e.getIdCard(), "Nữ", dateFormat.format(e.getBirthDate()), e.getAddress(), e.getPhone(), e.getEmail(), e.getEducationLevel()
            });
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtIdCard = new javax.swing.JTextField();
        jNam = new javax.swing.JRadioButton();
        jNu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPhone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jEduLevel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jBirthDay = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanel1PropertyChange(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "CMND", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "SDT", "Email", "Bằng Cấp"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("ID Nhân Viên:");

        jLabelID.setText("NV001");

        jLabel3.setText("Họ Và Tên:");

        jLabel4.setText("CMND:");

        jTxtIdCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIdCardActionPerformed(evt);
            }
        });

        jNam.setText("Nam");

        jNu.setText("Nữ");

        jLabel5.setText("Giới Tính:");

        jLabel6.setText("Địa Chỉ:");

        jLabel7.setText("SDT:");

        jLabel8.setText("Email:");

        jLabel9.setText("Bằng cấp:");

        jLabel10.setText("Ngày Sinh:");

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

        jButton4.setText("Làm Mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtIdCard)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jNam)
                                .addGap(38, 38, 38)
                                .addComponent(jNu)
                                .addGap(0, 71, Short.MAX_VALUE))
                            .addComponent(jTxtName)
                            .addComponent(jBirthDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelID)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jEmail)
                            .addComponent(jAddress)
                            .addComponent(jPhone)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jEduLevel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabelID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtIdCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNam)
                            .addComponent(jNu)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBirthDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jEduLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtIdCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIdCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIdCardActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = jLabelID.getText();
        String name = jTxtName.getText();
        String idCard = jTxtIdCard.getText();
        int gender = -1;
        if (jNam.isSelected()) {
            gender = 1;
        } else if (jNu.isSelected()) {
            gender = 0;
        }
        Date Bdate = jBirthDay.getDate();
        String address = jAddress.getText();
        String phone = jPhone.getText();
        String email = jEmail.getText();
        String eduLevel = jEduLevel.getText();
        int check = EmployeeControl.check(id, name, idCard, gender, Bdate, address, phone, email, eduLevel);
        switch (check) {
            case -1 ->
                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
            case -2 ->
                JOptionPane.showMessageDialog(null, "Bấm làm mới trước khi thêm nhân viên mới");
            case -3 ->
                JOptionPane.showMessageDialog(null, "Số chứng minh nhân dân bị trùng lặp");
            case -4 ->
                JOptionPane.showMessageDialog(null, "CMND hoặc số điện thoại không hợp lệ");
            case 1 -> {
                JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
                Employee e = new Employee();
                e.setID(id);
                e.setName(name);
                e.setIdCard(idCard);
                e.setGender(gender);
                e.setBirthDate(Bdate);
                e.setAddress(address);
                e.setPhone(phone);
                e.setEmail(email);
                e.setEducationLevel(eduLevel);
                listEmployees.add(e);
                showResult();
                jLabelID.setText(EmployeeControl.ReturnNextID());
                jTxtName.setText("");
                jTxtIdCard.setText("");
                jNam.setSelected(false);
                jNu.setSelected(false);
                jBirthDay.setDate(null);
                jAddress.setText("");
                jPhone.setText("");
                jEmail.setText("");
                jEduLevel.setText("");
            }
            default ->
                throw new AssertionError();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1PropertyChange

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
        jLabelID.setText(EmployeeControl.ReturnNextID());
    }//GEN-LAST:event_formPropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String id = jLabelID.getText();
        String name = jTxtName.getText();
        String idCard = jTxtIdCard.getText();
        int gender = -1;
        if (jNam.isSelected()) {
            gender = 1;
        } else if (jNu.isSelected()) {
            gender = 0;
        }
        Date Bdate = jBirthDay.getDate();
        String address = jAddress.getText();
        String phone = jPhone.getText();
        String email = jEmail.getText();
        String eduLevel = jEduLevel.getText();
        try {
            long x = Integer.parseInt(idCard.substring(0, 7));
            long z = Integer.parseInt(idCard.substring(7, idCard.length()));
            long y = Integer.parseInt(phone.substring(0, 6));
            long y1 = Integer.parseInt(phone.substring(6, phone.length()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CMND hoặc số điện thoại không hợp lệ");
            return;
        }
        int i = jTable1.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa");
        } else {
            int check = EmployeeControl.edit(id, name, idCard, gender, Bdate, address, phone, email, eduLevel);
            switch (check) {
                case 1 -> {
                    JOptionPane.showMessageDialog(null, "Sửa thông tin thành công");
                    jTable1.setValueAt(name, i, 1);
                    jTable1.setValueAt(idCard, i, 2);
                    if (jNam.isSelected()) {
                        jTable1.setValueAt("Nam", i, 3);
                    } else if (jNu.isSelected()) {
                        jTable1.setValueAt("Nữ", i, 3);
                    }
                    java.sql.Date sqlDate = new java.sql.Date(Bdate.getTime());
                    jTable1.setValueAt(sqlDate, i, 4);
                    jTable1.setValueAt(address, i, 5);
                    jTable1.setValueAt(phone, i, 6);
                    jTable1.setValueAt(email, i, 7);
                    jTable1.setValueAt(eduLevel, i, 8);
                    jTable1.updateUI();
                }
                case 0 ->
                    JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng thử lại");
                default ->
                    throw new AssertionError();
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int vitri = jTable1.getSelectedRow();
        jLabelID.setText(jTable1.getValueAt(vitri, 0).toString());
        jTxtName.setText(jTable1.getValueAt(vitri, 1).toString());
        jTxtIdCard.setText(jTable1.getValueAt(vitri, 2).toString());
        if (jTable1.getValueAt(vitri, 3).equals("Nam")) {
            jNam.setSelected(true);
        } else {
            jNu.setSelected(true);
        }
        try {
            jBirthDay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(jTable1.getValueAt(vitri, 4).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        jAddress.setText(jTable1.getValueAt(vitri, 5).toString());
        jPhone.setText(jTable1.getValueAt(vitri, 6).toString());
        jEmail.setText(jTable1.getValueAt(vitri, 7).toString());
        jEduLevel.setText(jTable1.getValueAt(vitri, 8).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jLabelID.setText(EmployeeControl.ReturnNextID());
        jTxtName.setText("");
        jTxtIdCard.setText("");
        jNam.setSelected(false);
        jNu.setSelected(false);
        jBirthDay.setDate(null);
        jAddress.setText("");
        jPhone.setText("");
        jEmail.setText("");
        jEduLevel.setText("");
        jTable1.clearSelection();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int t = jTable1.getSelectedRow();
        if (t == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần xóa");
        } else {
            int cf = JOptionPane.showConfirmDialog(null,
                    "Bạn có muốn xóa nhân viên này không?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
            if (cf == 0) {
                EmployeeControl.Remove(jTable1.getValueAt(t, 0).toString(),
                        jTable1.getValueAt(t, 2).toString());
                model.removeRow(t);
                jTable1.updateUI();
                jLabelID.setText(EmployeeControl.ReturnNextID());
                jTxtName.setText("");
                jTxtIdCard.setText("");
                jNam.setSelected(false);
                jNu.setSelected(false);
                jBirthDay.setDate(null);
                jAddress.setText("");
                jPhone.setText("");
                jEmail.setText("");
                jEduLevel.setText("");
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
            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAddress;
    private com.toedter.calendar.JDateChooser jBirthDay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JTextField jEduLevel;
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JRadioButton jNam;
    private javax.swing.JRadioButton jNu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPhone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtIdCard;
    private javax.swing.JTextField jTxtName;
    // End of variables declaration//GEN-END:variables
}

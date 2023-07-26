/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import Controller.BookRoomControl;
import Controller.GuestControl;
import Controller.Signup;
import Model.Guest;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author NGUYEN PHUC NAM
 */
public final class FormDatPhong extends javax.swing.JFrame {

    /**
     * Creates new form FormCheckIn
     */
    Date startDate;
    Date endDate;
    boolean checkB = true;

    public FormDatPhong() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ButtonGroup group = new ButtonGroup();
        group.add(jNam);
        group.add(jNu);
    }

    public FormDatPhong(Date start, Date end) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ButtonGroup group = new ButtonGroup();
        group.add(jNam);
        group.add(jNu);
        ActionListener a = (e) -> {
            if (checkB) {
                if (jTextname.getText().isEmpty() || jDateBirth.getDate() == null
                        || jNam.isSelected() == false && jNu.isSelected() == false
                        || jphone.getText().isEmpty() || jID.getText().isEmpty()
                        || jStart.getDate() == null || jEnd.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin");
                } else if (jStart.getDate().before(java.sql.Timestamp.valueOf(LocalDateTime.now().minusDays(1)))) {
                    JOptionPane.showMessageDialog(null, "Ngày bắt đầu không hợp lệ");
                } else if (jStart.getDate().after(jEnd.getDate()) || jStart.getDate().getDate() == jEnd.getDate().getDate()) {
                    JOptionPane.showMessageDialog(null, "Ngày dự kiến trả không hợp lệ");
                } else if (!jStart.getDate().equals(startDate) || !jEnd.getDate().equals(endDate)) {
                    JOptionPane.showMessageDialog(null, "Ngày bắt đầu và ngày kết thúc phải đúng với ngày đã tìm kiếm");
                } else {
                    try {
                        String str = jID.getText();
                        long x = Integer.parseInt(str.substring(0, 7));
                        long z = Integer.parseInt(str.substring(7, str.length()));
                        long y = Integer.parseInt(jphone.getText().substring(0, 7));
                        long y1 = Integer.parseInt(jphone.getText().substring(7, jphone.getText().length()));
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Số điện thoại hoặc CMND không hợp lệ");
                        return;
                    }
                    int check = BookRoomControl.addGuest(jTextname.getText(), jID.getText(), jphone.getText(), jNu.isSelected() ? 0 : 1,
                            jDateBirth.getDate());
                    if (check == 1) {
                        BookRoomControl.addReservation(jNameRoomCheckIn.getText().substring(6),
                                jStart.getDate(), jEnd.getDate(), Signup.getLastIdGuest());
                    } else {
                        JOptionPane.showMessageDialog(null, "Xảy ra lỗi!");
                    }

                }
                checkB = false;
            } else {

            }

        };
        jButton1.addActionListener(a);
        startDate = start;
        jStart.setDate(start);
        endDate = end;
        jEnd.setDate(end);
    }

    public FormDatPhong(Date start, Date end, String id_guest) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ButtonGroup group = new ButtonGroup();
        group.add(jNam);
        group.add(jNu);
        ActionListener a = (e) -> {
            if (checkB) {
                if (jTextname.getText().isEmpty() || jDateBirth.getDate() == null
                        || jNam.isSelected() == false && jNu.isSelected() == false
                        || jphone.getText().isEmpty() || jID.getText().isEmpty()
                        || jStart.getDate() == null || jEnd.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin");
                } else if (jStart.getDate().before(java.sql.Timestamp.valueOf(LocalDateTime.now().minusDays(1)))) {
                    JOptionPane.showMessageDialog(null, "Ngày bắt đầu không hợp lệ");
                } else if (jStart.getDate().after(jEnd.getDate()) || jStart.getDate().getDate() == jEnd.getDate().getDate()) {
                    JOptionPane.showMessageDialog(null, "Ngày dự kiến trả không hợp lệ");
                } else if (!jStart.getDate().equals(startDate) || !jEnd.getDate().equals(endDate)) {
                    JOptionPane.showMessageDialog(null, "Ngày bắt đầu và ngày kết thúc phải đúng với ngày đã tìm kiếm");
                } else {
                    BookRoomControl.addReservation(jNameRoomCheckIn.getText().substring(6),
                            jStart.getDate(), jEnd.getDate(), id_guest);
                }
                checkB = false;
            }

        };
        Guest g = GuestControl.findById(id_guest);
        jTextname.setText(g.getName());
        jDateBirth.setDate(g.getBirthday());
        if (g.getGender() == 0) {
            jNu.setSelected(true);
        } else {
            jNam.setSelected(true);
        }
        jphone.setText(g.getPhone());
        jID.setText(g.getIdCard());
        jButton1.addActionListener(a);
        startDate = start;
        jStart.setDate(start);
        endDate = end;
        jEnd.setDate(end);
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
        jNameRoomCheckIn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextname = new javax.swing.JTextField();
        jNam = new javax.swing.JRadioButton();
        jNu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jphone = new javax.swing.JTextField();
        jID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jStart = new com.toedter.calendar.JDateChooser();
        jEnd = new com.toedter.calendar.JDateChooser();
        jDateBirth = new com.toedter.calendar.JDateChooser();

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

        jNameRoomCheckIn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jNameRoomCheckIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jNameRoomCheckIn.setText("Phòng ");
        jNameRoomCheckIn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jNameRoomCheckInPropertyChange(evt);
            }
        });

        jLabel2.setText("Họ và Tên KH");

        jLabel3.setText("Ngày sinh");

        jLabel4.setText("Giới tính");

        jTextname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextnameActionPerformed(evt);
            }
        });

        jNam.setText("Nam");

        jNu.setText("Nữ");

        jLabel5.setText("Số Điện Thoại");

        jLabel6.setText("CCCD");

        jLabel8.setText("Bắt đầu thuê");

        jLabel9.setText("Dự kiến trả");

        jButton1.setText("Đặt Phòng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jNameRoomCheckIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextname)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jphone)
                    .addComponent(jID)
                    .addComponent(jStart, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNameRoomCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDateBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jNam)
                    .addComponent(jNu))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jNameRoomCheckInPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jNameRoomCheckInPropertyChange

        // TODO add your handling code here

    }//GEN-LAST:event_jNameRoomCheckInPropertyChange

    private void jPanel1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1PropertyChange

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
        jNameRoomCheckIn.setText(this.getName());
    }//GEN-LAST:event_formPropertyChange

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
            java.util.logging.Logger.getLogger(FormDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormDatPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateBirth;
    private com.toedter.calendar.JDateChooser jEnd;
    private javax.swing.JTextField jID;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jNam;
    private javax.swing.JLabel jNameRoomCheckIn;
    private javax.swing.JRadioButton jNu;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jStart;
    private javax.swing.JTextField jTextname;
    private javax.swing.JTextField jphone;
    // End of variables declaration//GEN-END:variables
}

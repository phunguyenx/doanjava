/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import connection.ConnectionProvider;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Signup {
    public static int check(String id,String username, String password, String name, String idCard, String phone, int gender, Date bDate) {
        if (username.equals("") || password.equals("") || name.equals("") || idCard.equals("") || phone.equals("") || gender == -1 || bDate == null) {
            return -1;  // thieu thong tin
        }
        else if (LocalDate.now().getYear() - (bDate.getYear()+1900) < 18) {
            return -2;  // khong du tuoi
        }
        else {
            java.sql.Connection conn = ConnectionProvider.getConnection();
            String checkIdcard = "select * from guest where idcard_guest = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(checkIdcard);
                ps.setString(1, idCard);
                
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return -5;  // idcard ton tai
                }
            } catch (SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String checkUser = "select * from user where username = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(checkUser);
                ps.setString(1, username);
                
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return -4;  // username da ton tai trong he thong
                }
            } catch (SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                int x =Integer.parseInt(idCard);
                int y =Integer.parseInt(phone);
            } catch (Exception e) {
                return -6;
            }
            String insert_user = "INSERT INTO user (username, password, role) VALUES (?, ?, 2);";
            
            try {
                PreparedStatement pst = conn.prepareStatement(insert_user);
                    pst.setString(1, username);
                    pst.setString(2, password);
                    int rst = pst.executeUpdate();
                if (rst != 0) {
                    String insert_guest = "INSERT INTO guest (id_guest, name_guest, "
                    + "gender_guest, idcard_guest, phone_guest, birthDate_guest, username)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = conn.prepareStatement(insert_guest);
                    ps.setString(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, gender);
                    ps.setString(4, idCard);
                    ps.setString(5, phone);
                    java.sql.Date sqlDate = new java.sql.Date(bDate.getTime());
                    ps.setDate(6, sqlDate);
                    ps.setString(7, username);
                    ps.executeUpdate();
                    return 1; // them thanh cong
                }
            } catch (SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return 0;
    }
    public static String ReturnNextIdGuest(){
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT MAX(id_guest) FROM guest";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next() && rs.getString(1) != null){
                String so = rs.getString(1).substring(2);//lấy chuỗi sau KH
                int soKH = Integer.parseInt(so);//chuyển thành số
                soKH++;
                String maKHmoi = "KH" + String.format("%05d", soKH);
                return maKHmoi;
            }else{
                return "KH00001";
            }
        } catch (SQLException ex) {
           Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    public static String getLastIdGuest(){
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT MAX(id_guest) FROM guest";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("MAX(id_guest)");
            }
            
        } catch (SQLException ex) {
           Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import connection.ConnectionProvider;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Login {
    public static int checkLog(String username, String password) {
        if(username.equals("") || password.equals("")){
            return -1;  // role = -1 -> thieu thong tin
        }else if(username.equals("admin") && password.equals("admin")){
            return 0;   // role = 0 -> quan ly
        }else {
            java.sql.Connection conn = ConnectionProvider.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    int role = rs.getInt("role");
                    if (role == 1) {
                        return 1;   // role = 1 -> nhan vien
                    }
                    return 2;   // role = 2 -> khach hang
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 7;   // role = 7 -> sai thong tin
    }
    public static String getIdEmployee(String username){
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from user as u "
                + "join employee as e on e.username = u.username "
                + "where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String id = rs.getString("id_emp");
                ConnectionProvider.closeConnection(conn);
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return "";
    }
    public static String getIdGuest(String username){
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from user as u "
                + "join guest as e on e.username = u.username "
                + "where u.username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String id = rs.getString("id_guest");
                ConnectionProvider.closeConnection(conn);
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return "";
    }
}

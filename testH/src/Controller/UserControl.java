/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import connection.ConnectionProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Norris
 */
public class UserControl {
    public static ArrayList<User> listUserEmps(){
        ArrayList<User> list = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select u.username, u.password from user as u join employee as e on u.username = e.username";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                User u =new User(rs.getString("username"), rs.getString("password"));
                list.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return list;
    }
    
    public static ArrayList<User> listUserGuesst(){
        ArrayList<User> list = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select u.username, u.password from user as u join guest as e on u.username = e.username";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                User u =new User(rs.getString("username"), rs.getString("password"));
                list.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return list;
    }
    
    public static void changePass(String username, String pass, String newPass, String checkPass) {
        if (pass.isEmpty() || newPass.isEmpty() || checkPass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return ;
        } else if (!newPass.equals(checkPass)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới phải giống nhau");
            return ;
        } else if (pass.equals(newPass)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới phải khác mật khẩu hiện tại");
            return ;
        } else {
            java.sql.Connection conn = ConnectionProvider.getConnection();
            String sql = "select * from user where username = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    if (rs.getString("password").equals(pass)) {
                        String sql1 = "update user set password = ? where username = ?";
                        PreparedStatement ps1 = conn.prepareStatement(sql1);
                        ps1.setString(1, newPass);
                        ps1.setString(2, username);
                        int rs1 = ps1.executeUpdate();
                        if (rs1 != 0) {
                            JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
                            ConnectionProvider.closeConnection(conn);
                            return ;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Mật khẩu hiện tại không chính xác");
                        ConnectionProvider.closeConnection(conn);
                        return ;
                    }
                }
                ConnectionProvider.closeConnection(conn);
            } catch (SQLException ex) {
                Logger.getLogger(GuestControl.class.getName()).log(Level.SEVERE, null, ex);
                ConnectionProvider.closeConnection(conn);
            }
        }
        JOptionPane.showMessageDialog(null, "Xảy ra lỗi");
    }
}

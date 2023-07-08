/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.TypeRoom;
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
public class TypeRoomControl {

    public static String ReturnNextIdTypeRoom() {//trả về mã loai phòng tiếp theo
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT MAX(id_tRoom) FROM typeroom";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString(1) != null) {
                String so = rs.getString(1).substring(2);//lấy chuỗi sau TR
                int sotr = Integer.parseInt(so);//chuyển thành số
                sotr++;
                String matrMoi = "TR" + String.format("%03d", sotr);
                return matrMoi;
            } else {
                return "TR001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public static int check(String id, String name, int price) {
        java.sql.Connection conn = ConnectionProvider.getConnection();

        String checkId = "select * from typeroom where id_tRoom = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(checkId);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return -1;  // Xảy ra lỗi, bấm làm mới
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        String insert = "insert typeroom value (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, price);
            int t = ps.executeUpdate();
            if (t != 0) {
                return 1;//thêm thành công
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int edit(String id, String name, int price) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "update typeroom set name_tRoom = ?, price_tRoom = ? where id_tRoom = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setString(3, id);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                return 1; // Thành công r cu
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0; // Lỗi k xác định
    }

    public static void Remove(String id) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "delete from furniture where roomNumber = ?";
        String sql1 = "delete from room_reservation where roomNumber = ?";
        String sql2 = "delete from room where id_tRoom = ?";
        String sql3 = "delete from typeroom where id_tRoom = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for (String roomNumber : RoomControl.getListRoomNumberByIdTRoom(id)) {
                ps.setString(1, roomNumber);
                ps.executeUpdate();
                PreparedStatement ps1 = conn.prepareStatement(sql1);
                ps1.setString(1, roomNumber);
                ps1.executeUpdate();
            }
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, id);
            ps2.executeUpdate();
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setString(1, id);
            int rs = ps3.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
                return;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TypeRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Xóa Thất Bại!");
    }

    public static ArrayList<TypeRoom> getlistTypeRooms() {// tra về danh sách loại phòng trong khách sạn
        ArrayList<TypeRoom> listTypeRooms = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT * FROM typeroom";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TypeRoom tr = new TypeRoom(rs.getString("id_tRoom"),
                        rs.getString("name_tRoom"), rs.getInt("price_tRoom"));

                listTypeRooms.add(tr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listTypeRooms;
    }

    public static ArrayList<String> getListNameTypeRoom() {//trả về 1 dãy tên loại phòng
        ArrayList<String> listNTR = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT name_tRoom FROM typeroom";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String Ntr = rs.getString("name_tRoom");
                listNTR.add(Ntr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNTR;
    }

    public static String getIDtRoomByName(String name) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT id_tRoom FROM typeroom where name_tRoom = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("id_tRoom");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}

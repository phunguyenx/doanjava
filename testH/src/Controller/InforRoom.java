/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import connection.ConnectionProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class InforRoom {
    public static String setTypeRoom(String roomNumber, java.sql.Connection conn) {
        String sql = "select * from room where roomNumber = ?";
        try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, roomNumber);
                
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    String id_tRoom = rs.getString("id_tRoom");
                    if (id_tRoom.equalsIgnoreCase("tr001")) {
                        return "Phòng Đơn";
                    }
                    else if (id_tRoom.equalsIgnoreCase("tr002")) {
                        return "Phòng Đôi";
                    }
                    else if (id_tRoom.equalsIgnoreCase("tr003")) {
                        return "Phòng VIP";
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
    
    public static String setStatusRoom(String roomNumber, java.sql.Connection conn) {
        String sql = "select * from room_reservation where roomNumber = ? and status != 5";
        try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, roomNumber);
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {

                    if ((rs.getDate("startTime").toLocalDate().isBefore(LocalDate.now())
                            || rs.getDate("startTime").toLocalDate().equals(LocalDate.now()))
                            && (rs.getDate("endTime").toLocalDate().isAfter(LocalDate.now())
                            || rs.getDate("endTime").toLocalDate().equals(LocalDate.now()))) {
                        int status = rs.getInt("status");
                        switch (status) {
                            case 2 -> {
                                return "Đang bận";
                            }
                            case 3 -> {
                                                    System.out.println(rs.getDate("startTime").toLocalDate());
                    System.out.println(rs.getDate("endTime").toLocalDate());
                                System.out.println(LocalDate.now());
                                return "Đang dọn dẹp";
                            }
                            case 4 -> {
                                return "Đã đặt trước";
                            }
                            
                            default -> {
                                return "Đang trống";
                            }
                        }
                    }
                }
                return "Đang trống";
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
    public static ArrayList<String> getListRoomNumberInOut(java.sql.Connection conn) {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select * from room_reservation where ( startTime = curdate() and status = ? ) "
                + "or ( endTime = curdate() and status = ? )";
        try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, 4);
                ps.setInt(2, 2);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    list.add(rs.getString("roomNumber"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
}

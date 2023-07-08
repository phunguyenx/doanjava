/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import connection.ConnectionProvider;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Norris
 */
public class RoomControl {
        public static ArrayList<String> getListRoomNumberByType(String name_tRoom){
        ArrayList<String> listRoomNumber =new ArrayList<>();
        Connection conn = ConnectionProvider.getConnection();
        String sql = "select roomNumber from room inner join typeroom "
                + "on room.id_tRoom = typeroom.id_tRoom "
                + "where typeroom.name_tRoom = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name_tRoom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                listRoomNumber.add(rs.getString("roomNumber"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRoomNumber;
    }
    public static ArrayList<String> getListRoomNumberByIdTRoom(String id_tRoom){
        ArrayList<String> listRoomNumber =new ArrayList<>();
        Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from room inner join typeroom "
                + "on room.id_tRoom = typeroom.id_tRoom "
                + "where typeroom.name_tRoom = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_tRoom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                listRoomNumber.add(rs.getString("roomNumber"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRoomNumber;
    }
    public static int getNumberOfRoomByType(String name_tRoom){
        Connection conn = ConnectionProvider.getConnection();
        String sql = "select count(roomNumber) from room inner join typeroom "
                + "on room.id_tRoom = typeroom.id_tRoom "
                + "where typeroom.name_tRoom = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name_tRoom);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("count(roomNumber)");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    //don phong
    public static void setStatusToMaintenance(String roomNumberString){
        Connection conn = ConnectionProvider.getConnection();
        String sql = "insert room_reservation(status, startTime, endTime, roomNumber)"
                + "values(3, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setDate(2, Date.valueOf(LocalDate.now().plusDays(1)));
            ps.setString(3, roomNumberString);
            int rs = ps.executeUpdate();
            if(rs != 0){
                JOptionPane.showMessageDialog(null, "Phòng "+roomNumberString+" Bắt đầu Được Dọn");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Guest;
import Model.InforGuest;
import java.sql.ResultSet;
import connection.ConnectionProvider;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Norris
 */
public class BookRoomControl {

    public static int addGuest(String name, String idCard, String phone, int gender, Date d) {

        java.sql.Connection conn = ConnectionProvider.getConnection();

        String insert_guest = "INSERT INTO guest (id_guest, name_guest, "
                + "gender_guest, idcard_guest, phone_guest, birthDate_guest)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            String id = Signup.ReturnNextIdGuest();
            ps = conn.prepareStatement(insert_guest);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, gender);
            ps.setString(4, idCard);
            ps.setString(5, phone);
            java.sql.Date sqldate = new java.sql.Date(d.getTime());
            ps.setDate(6, sqldate);
            ps.executeUpdate();
            return 1; // them thanh cong

        } catch (SQLException ex) {
            Logger.getLogger(BookRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static void addReservation(String roomNumber, Date timeStart, Date timeEnd, String id_guest) {
        java.sql.Connection conn = ConnectionProvider.getConnection();

        String sql = "insert room_reservation(status, startTime, endTime, roomNumber, id_guest) values(4, ?, ?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            java.sql.Date sqlDate = new java.sql.Date(timeStart.getTime());
            ps.setDate(1, sqlDate);
            sqlDate = new java.sql.Date(timeEnd.getTime());
            ps.setDate(2, sqlDate);
            ps.setString(3, roomNumber);
            ps.setString(4, id_guest);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Đặt phòng thành công");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Xảy ra lỗi");

    }

    public static void setStatusToOccupied(String startTime, String roomNumber) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "update room_reservation set status = ? where startTime = ? and roomNumber = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 2);
            ps.setString(2, startTime);
            ps.setString(3, roomNumber);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //check out thanh cong
    public static void setStatusToMaintenance(String roomNumber) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "update room_reservation set status = ? where endTime >= curdate() and roomNumber = ? and status = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 5);
            ps.setString(2, roomNumber);
            ps.setInt(3, 2);
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<String> getListRoomNumBerUnFit(String startTime, String endTime) {
        ArrayList<String> list = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select roomNumber from room_reservation as rr "
                + "where( (endTime >= ? and startTime <= ? and status != ? and status != ? ) "
                + "or (endTime >= ? and startTime <= ? and status != ? ) "
                + "or (endTime <= ? and startTime >= ? and status != ? ) "
                + "or (endTime > ?  and status = ? ) )"
                + "group by roomNumber";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, startTime);
            ps.setString(2, startTime);
            ps.setInt(3, 3);
            ps.setInt(4, 5);
            ps.setString(5, endTime);
            ps.setString(6, endTime);
            ps.setInt(7, 5);
            ps.setString(8, endTime);
            ps.setString(9, startTime);
            ps.setInt(10, 5);
            ps.setString(11, startTime);
            ps.setInt(12, 3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("roomNumber"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<String> getListNumberRoomFit(String startTime, String endTime, String idtRoom) {
        ArrayList<String> list = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql1 = "select roomNumber from room where id_tRoom = ?";
        try {
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, idtRoom);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                String sql = "select roomNumber from room_reservation as rr "
                        + "where( (endTime >= ? and startTime <= ? and status != ? and status != ?) "
                        + "or (endTime >= ? and startTime <= ? and status != ?) "
                        + "or (endTime <= ? and startTime >= ? and status != ?) "
                        + "or (endTime > ?  and status = ? )) "
                        + "and roomNumber = ? "
                        + "group by roomNumber";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, startTime);
                ps.setString(2, startTime);
                ps.setInt(3, 3);
                ps.setInt(4, 5);
                ps.setString(5, endTime);
                ps.setString(6, endTime);
                ps.setInt(7, 5);
                ps.setString(8, endTime);
                ps.setString(9, startTime);
                ps.setInt(10, 5);
                ps.setString(11, startTime);
                ps.setInt(12, 3);
                ps.setString(13, rs1.getString("roomNumber"));
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    list.add(rs1.getString("roomNumber"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<InforGuest> getListInforGuests(String roomNumber) {
        ArrayList<InforGuest> list = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select g.id_guest, g.name_guest, g.birthDate_guest, g.gender_guest, g.phone_guest, g.idcard_guest, rr.startTime, rr.endTime, rr.status "
                + "from room_reservation as rr "
                + "join guest as g on rr.id_guest = g.id_guest "
                + "where rr.roomNumber = ? and status != ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomNumber);
            ps.setInt(2, 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InforGuest inf = new InforGuest();
                inf.setId_guest(rs.getString(1));
                inf.setName(rs.getString(2));
                inf.setBirthday(rs.getDate(3));
                inf.setGender(rs.getInt(4));
                inf.setPhone(rs.getString(5));
                inf.setId_card(rs.getString(6));
                inf.setStartTime(rs.getDate(7));
                inf.setEndTime(rs.getDate(8));
                list.add(inf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static Guest getGuestReserve(String roomNumber) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from room_reservation where roomNumber = ? and startTime = curdate() and status = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomNumber);
            ps.setInt(2, 4);
            ResultSet rs = ps.executeQuery();
            String sql1 = "select * from guest where id_guest = ?";
            if (rs.next()) {
                PreparedStatement ps1 = conn.prepareStatement(sql1);
                ps1.setString(1, rs.getString("id_guest"));
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    return new Guest(rs1.getString(1), rs1.getString(2),
                            rs1.getString(4), rs1.getString(5),
                            rs1.getDate(6), rs1.getInt(3));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean Checkout(String roomNumber) {
        java.sql.Connection conn = ConnectionProvider.getConnection();

        String sql = "select * from room_reservation where roomNumber = ? and endTime >= curdate() and status = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomNumber);
            ps.setInt(2, 2);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static int CancellBookRoom(String id_guest, String roomNumber, String dateStart ){
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from room_reservation where id_guest = ? and roomNumber = ? and startTime = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_guest);
            ps.setString(2, roomNumber);
            ps.setString(3, dateStart);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt("status") == 2) {
                    return -2;//Đã check in không thể hủy
                } else {
                    String sql1 = "delete from room_reservation where idroom_reservation = ?";
                    PreparedStatement ps1 = conn.prepareStatement(sql1);
                    ps1.setString(1, rs.getString("idroom_reservation"));
                    int rs1 = ps1.executeUpdate();
                    if (rs1 != 0) {
                        return 1;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}

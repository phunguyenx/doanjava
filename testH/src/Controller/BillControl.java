/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bill;
import connection.ConnectionProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Norris
 */
public class BillControl {

    public static String getNextIdBill() {//trả về mã dich vu tiếp theo
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT MAX(id_bill) FROM bill";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString(1) != null) {
                String so = rs.getString(1).substring(1);//lấy chuỗi sau B
                int sotr = Integer.parseInt(so);//chuyển thành số
                sotr++;
                String matrMoi = "B" + String.format("%06d", sotr);
                ConnectionProvider.closeConnection(conn);
                return matrMoi;
            } else {
                ConnectionProvider.closeConnection(conn);
                return "B000001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return "";
    }

    public static boolean Checkin(String datetime, String roomNumber) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from room_reservation where roomNumber = ? and startTime = ? and status = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomNumber);
            ps.setDate(2, java.sql.Date.valueOf(datetime.substring(0, 10)));
            ps.setInt(3, 4);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String sql1 = "insert bill(id_bill, time_checkin, idroom_reservation) "
                        + "values (?, ?, ?)";
                try {
                    PreparedStatement ps1 = conn.prepareStatement(sql1);
                    ps1.setString(1, getNextIdBill());
                    ps1.setString(2, datetime);
                    ps1.setString(3, rs.getString("idroom_reservation"));

                    int rs1 = ps1.executeUpdate();
                    if (rs1 != 0) {
                        JOptionPane.showMessageDialog(null, "Check In thành công");
                        ConnectionProvider.closeConnection(conn);
                        return true;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Khách hàng đã đến check in");
                    ConnectionProvider.closeConnection(conn);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Hiện Tại Phòng Không Có Lịch Check In");
                ConnectionProvider.closeConnection(conn);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Xảy ra lỗi");
        ConnectionProvider.closeConnection(conn);
        return false;
    }

    public static Bill Checkout(String datetime, String roomNumber) {
        java.sql.Connection conn = ConnectionProvider.getConnection();

        String sql = "select * from room_reservation where roomNumber = ? and endTime >= curdate() and status = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomNumber);
            ps.setInt(2, 2);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String sql1 = "update bill set time_checkout = ? where idroom_reservation = ?";
                try {
                    PreparedStatement ps1 = conn.prepareStatement(sql1);
                    ps1.setString(1, datetime);
                    ps1.setString(2, rs.getString("idroom_reservation"));

                    int rs1 = ps1.executeUpdate();
                    if (rs1 != 0) {
                        String sql2 = "select * from bill where idroom_reservation = ?";
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                        ps2.setString(1, rs.getString("idroom_reservation"));
                        ResultSet rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            Bill bill = new Bill(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getInt(5));
                            JOptionPane.showMessageDialog(null, "Check Out thành công");
                            ConnectionProvider.closeConnection(conn);
                            return bill;
                        }

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return null;
    }

    public static Bill Checkout(String datetime, String roomNumber, String id_emp) {
        java.sql.Connection conn = ConnectionProvider.getConnection();

        String sql = "select * from room_reservation where roomNumber = ? and endTime >= curdate() and status = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomNumber);
            ps.setInt(2, 2);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String sql1 = "update bill set time_checkout = ?, id_emp = ?  where idroom_reservation = ?";
                try {
                    PreparedStatement ps1 = conn.prepareStatement(sql1);
                    ps1.setString(1, datetime);
                    ps1.setString(3, rs.getString("idroom_reservation"));
                    ps1.setString(2, id_emp);
                    int rs1 = ps1.executeUpdate();
                    if (rs1 != 0) {
                        String sql2 = "select * from bill where idroom_reservation = ?";
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                        ps2.setString(1, rs.getString("idroom_reservation"));
                        ResultSet rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            Bill bill = new Bill(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getInt(5));
                            JOptionPane.showMessageDialog(null, "Check Out thành công");
                            ConnectionProvider.closeConnection(conn);
                            return bill;
                        }

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return null;
    }

    public static String getNameGuestByBill(String id_bill) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select g.name_guest from bill as b "
                + "join room_reservation rr on b.idroom_reservation = rr.idroom_reservation "
                + "join guest g on rr.id_guest = g.id_guest "
                + "where id_bill = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_bill);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name_guest");
                ConnectionProvider.closeConnection(conn);
                return name;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return "";
    }

    public static int getPriceTRoomByBill(String id_bill) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select tr.price_tRoom from bill as b "
                + "join room_reservation rr on b.idroom_reservation = rr.idroom_reservation "
                + "join room r on rr.roomNumber = r.roomNumber "
                + "join typeroom tr on tr.id_tRoom = r.id_tRoom "
                + "where id_bill = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_bill);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int price = rs.getInt("price_tRoom");
                ConnectionProvider.closeConnection(conn);
                return price;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return 0;
    }

    public static String getIdBill(String roomNumber) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from room_reservation "
                + "where startTime <= curdate() and endTime >= curdate() and roomNumber = ? and status = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomNumber);
            ps.setInt(2, 2);
            ResultSet rs = ps.executeQuery();
            String sql1 = "select * from bill where idroom_reservation = ?";
            if (rs.next()) {
                PreparedStatement ps1 = conn.prepareStatement(sql1);
                ps1.setString(1, rs.getString("idroom_reservation"));
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    String id = rs1.getString("id_bill");
                    ConnectionProvider.closeConnection(conn);
                    return id;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return "";
    }

    public static void addToBill_Service(String id_bill, String id_service, int quantity) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "insert bill_service value(?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_bill);
            ps.setString(2, id_service);
            ps.setInt(3, quantity);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Đặt thành công");
            }
        } catch (SQLException ex) {
            String sqlString = "select * from bill_service where id_bill = ? and id_ser = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sqlString);
                ps.setString(1, id_bill);
                ps.setString(2, id_service);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int newq = rs.getInt("quantity") + quantity;
                    String sqlString1 = "update bill_service set quantity = ? where id_bill = ? and id_ser = ?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlString1);
                    ps1.setInt(1, newq);
                    ps1.setString(2, id_bill);
                    ps1.setString(3, id_service);
                    int rs1 = ps1.executeUpdate();
                    if (rs1 != 0) {
                        JOptionPane.showMessageDialog(null, "Đặt thêm thành công ");
                    }
                }
            } catch (SQLException ex1) {
                Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        ConnectionProvider.closeConnection(conn);
    }

    public static int RoomCharge(String id_bill, int checkinHour, int checkOutHour) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        int sum = 0;
        int price = 0;
        String s = "select tr.price_tRoom,tr.price_tRoom * (rr.endTime - rr.startTime) as sum from bill as b "
                + "join room_reservation rr on b.idroom_reservation = rr.idroom_reservation "
                + "join room r on rr.roomNumber = r.roomNumber "
                + "join typeroom tr on tr.id_tRoom = r.id_tRoom "
                + "where id_bill = ? ";
        try {
            PreparedStatement p = conn.prepareStatement(s);
            p.setString(1, id_bill);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                sum = rs.getInt("sum");
                price = rs.getInt("price_tRoom");
                ConnectionProvider.closeConnection(conn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (checkinHour >= 14 && checkOutHour <= 12) {
            
        } else if ((checkinHour >= 9 && checkinHour < 14) || (checkOutHour > 12 && checkOutHour <= 15)) {
            sum += price*0.3;
        } else if ((checkinHour >= 5 && checkinHour < 9) || (checkOutHour > 15 && checkOutHour <= 18)) {
            sum += price*0.5;
        } else {
            sum+= price;
        }
        return sum;
    }

    public static int ServiceCharge(String id_bill) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select sum(price_ser * quantity) as sum from bill as b "
                + "join bill_service as bs on b.id_bill = bs.id_bill "
                + "join service as s on s.id_ser = bs.id_ser "
                + "where b.id_bill = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_bill);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int sum = rs.getInt("sum");
                ConnectionProvider.closeConnection(conn);
                return sum;
            } else {
                ConnectionProvider.closeConnection(conn);
                return 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return 0;
    }

    public static int DamageCharge(String id_bill) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select sum(price_fur) as sum from bill as b "
                + "join bill_furniture as bf on b.id_bill = bf.id_bill "
                + "join furniture as f on bf.id_fur = f.id_fur "
                + "where b.id_bill = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_bill);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("sum");
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static String getTimeReserve(String id_bill) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from bill as b "
                + "join room_reservation as rr on b.idroom_reservation = rr.idroom_reservation "
                + "where id_bill = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_bill);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("startTime") + " -> " + rs.getString("endTime");
            }

        } catch (SQLException ex) {
            Logger.getLogger(BillControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }
}

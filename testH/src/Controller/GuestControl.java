/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Guest;
import connection.ConnectionProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class GuestControl {

    public static int check(String id, String name, String idCard, int gender, Date Bdate, String phone) {
        if (name.equals("") || idCard.equals("") || gender == -1 || Bdate == null || phone.equals("")) {
            return -1;  // thieu thong tin
        } else if (LocalDate.now().getYear() - (Bdate.getYear() + 1900) < 18) {
            return -5;
        } else {
            java.sql.Connection conn = ConnectionProvider.getConnection();

            String checkId = "select * from guest where id_guest = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(checkId);
                ps.setString(1, id);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return -2;  // Xảy ra lỗi bấm làm mới
                }
            } catch (SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }

            String checkIdCard = "select * from guest where idcard_guest = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(checkIdCard);
                ps.setString(1, idCard);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return -3;  // số cmnd bị trùng
                }
            } catch (SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                long x = Integer.parseInt(idCard.substring(0, 7));
                long z = Integer.parseInt(idCard.substring(7, idCard.length()));
                long y = Integer.parseInt(phone.substring(0, 7));
                long y1 = Integer.parseInt(phone.substring(7, phone.length()));
            } catch (Exception e) {
                return -4;
            }
            String insert = "INSERT INTO guest (id_guest, name_guest, "
                    + "idcard_guest, gender_guest, birthDate_guest, phone_guest)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement ps = conn.prepareStatement(insert);
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, idCard);
                ps.setInt(4, gender);
                java.sql.Date sqlDate = new java.sql.Date(Bdate.getTime());
                ps.setDate(5, sqlDate);
                ps.setString(6, phone);
                int rs = ps.executeUpdate();
                if (rs != 0) {
                    return 1;//thêm thành công
                }

            } catch (SQLException ex) {
                Logger.getLogger(GuestControl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return 0;
    }

    public static String ReturnNextID() {//trả về mã Khacsh hang tiếp theo
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT MAX(id_guest) FROM guest";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString(1) != null) {
                String so = rs.getString(1).substring(2);//lấy chuỗi sau KH
                int soNhanVien = Integer.parseInt(so);//chuyển thành số
                soNhanVien++;
                String maNhanVienMoi = "KH" + String.format("%05d", soNhanVien);
                return maNhanVienMoi;
            } else {
                return "KH00001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public static int edit(String id, String name, String idCard, int gender, Date Bdate, String phone) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        if (LocalDate.now().getYear() - Bdate.getYear() - 1900 < 18) {
            return -1;
        }
        String sql = "update guest set name_guest = ?, idcard_guest = ?, gender_guest = ?, birthDate_guest = ?, "
                + " phone_guest = ? where id_guest = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, idCard);
            ps.setInt(3, gender);
            java.sql.Date sqlDate = new java.sql.Date(Bdate.getTime());
            ps.setDate(4, sqlDate);
            ps.setString(5, phone);
            ps.setString(6, id);
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
        String sqlString = "update room_reservation set id_guest = null where id_guest = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlString);
            ps.setString(1, id);
            ps.executeUpdate();
            String sql = "Delete From guest where id_guest = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ps1.setString(1, id);
            int rs = ps1.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "xóa thất bại!");
    }

    public static ArrayList<Guest> getlistGuests() {// tra về danh sách khach hang
        ArrayList<Guest> listGuests = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT * FROM guest";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Guest e = new Guest();
                e.setId(rs.getString("id_guest"));
                e.setName(rs.getString("name_guest"));
                e.setIdCard(rs.getString("idcard_guest"));
                e.setGender(rs.getInt("gender_guest"));
                e.setPhone(rs.getString("phone_guest"));
                e.setBirthday(rs.getDate("birthDate_guest"));
                listGuests.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listGuests;
    }

    public static ArrayList<Guest> getlistGuestsByIdCard(String id_card) {// tra về danh sách khach hang
        ArrayList<Guest> listGuests = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT * FROM guest where idcard_guest like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + id_card + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Guest e = new Guest();
                e.setId(rs.getString("id_guest"));
                e.setName(rs.getString("name_guest"));
                e.setIdCard(rs.getString("idcard_guest"));
                e.setGender(rs.getInt("gender_guest"));
                e.setPhone(rs.getString("phone_guest"));
                e.setBirthday(rs.getDate("birthDate_guest"));
                listGuests.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listGuests;
    }

    public static String getNameByUsername(String username) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from guest where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("name_guest");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public static Guest findById(String id_guest) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from guest where id_guest = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_guest);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Guest e = new Guest();
                e.setId(rs.getString("id_guest"));
                e.setName(rs.getString("name_guest"));
                e.setIdCard(rs.getString("idcard_guest"));
                e.setGender(rs.getInt("gender_guest"));
                e.setPhone(rs.getString("phone_guest"));
                e.setBirthday(rs.getDate("birthDate_guest"));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static Guest findByUsername(String username) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from guest where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Guest e = new Guest();
                e.setId(rs.getString("id_guest"));
                e.setName(rs.getString("name_guest"));
                e.setIdCard(rs.getString("idcard_guest"));
                e.setGender(rs.getInt("gender_guest"));
                e.setPhone(rs.getString("phone_guest"));
                e.setBirthday(rs.getDate("birthDate_guest"));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void updateInfor(String username, String name, String idcard, Date bDate, int gender, String phone) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "update guest set name_guest = ?, idcard_guest = ?, birthDate_guest = ?, gender_guest = ?, phone_guest = ? "
                + "where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, idcard);
            java.sql.Date sqlDate = new java.sql.Date(bDate.getTime());
            ps.setDate(3, sqlDate);
            ps.setInt(4, gender);
            ps.setString(5, phone);
            ps.setString(6, username);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Xảy ra lỗi");
    }

}

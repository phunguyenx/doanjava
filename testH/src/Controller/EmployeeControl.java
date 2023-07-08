/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Employee;
import connection.ConnectionProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Norris
 */
public class EmployeeControl {

    public static int check(String id, String name, String idCard, int gender, Date Bdate, String address,
            String phone, String email, String eduLevel) {
        if (name.equals("") || idCard.equals("") || gender == -1 || Bdate == null || address.equals("")
                || phone.equals("") || email.equals("") || eduLevel.equals("")) {
            return -1;  // thieu thong tin
        } else {
            java.sql.Connection conn = ConnectionProvider.getConnection();

            String checkId = "select * from employee where id_emp = ?";
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

            String checkIdCard = "select * from employee where idcard_emp = ?";
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
            String insert_user_emp = "insert user(username, password, role) value (?, ?, 1)";
            try {
                PreparedStatement pst = conn.prepareStatement(insert_user_emp);
                pst.setString(1, idCard);
                pst.setString(2, "1");
                int rs = pst.executeUpdate();
                if (rs != 0) {

                    String insert_emp = "INSERT INTO employee (id_emp, name_emp, "
                            + "idcard_emp, gender_emp, birthDate_emp, address_emp,"
                            + " phone_emp, email_emp, eduLevel_emp, username)"
                            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = conn.prepareStatement(insert_emp);
                    ps.setString(1, id);
                    ps.setString(2, name);
                    ps.setString(3, idCard);
                    ps.setInt(4, gender);
                    java.sql.Date sqlDate = new java.sql.Date(Bdate.getTime());
                    ps.setDate(5, sqlDate);
                    ps.setString(6, address);
                    ps.setString(7, phone);
                    ps.setString(8, email);
                    ps.setString(9, eduLevel);
                    ps.setString(10, idCard);
                    ps.executeUpdate();
                    return 1;//thêm thành công
                }
            } catch (SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public static ArrayList<Employee> getlistEmployees() {// tra về danh sách nhân viên trong công ty
        ArrayList<Employee> listEmployees = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT * FROM employee";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setID(rs.getString("id_emp"));
                e.setName(rs.getString("name_emp"));
                e.setIdCard(rs.getString("idcard_emp"));
                e.setGender(rs.getInt("gender_emp"));
                e.setBirthDate(rs.getDate("birthDate_emp"));
                e.setAddress(rs.getString("address_emp"));
                e.setPhone(rs.getString("phone_emp"));
                e.setEmail(rs.getString("email_emp"));
                e.setEducationLevel(rs.getString("eduLevel_emp"));
                listEmployees.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listEmployees;
    }

    public static String ReturnNextID() {//trả về mã nhân viên tiếp theo
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT MAX(id_emp) FROM employee";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString(1) != null) {
                String so = rs.getString(1).substring(2);//lấy chuỗi sau NV
                int soNhanVien = Integer.parseInt(so);//chuyển thành số
                soNhanVien++;
                String maNhanVienMoi = "NV" + String.format("%03d", soNhanVien);
                return maNhanVienMoi;
            } else {
                return "NV001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public static int edit(String id, String name, String idCard, int gender, Date Bdate, String address,
            String phone, String email, String eduLevel) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "update employee set name_emp = ?, idcard_emp = ?, gender_emp = ?, birthDate_emp = ?, "
                + "address_emp = ?, phone_emp = ?, email_emp = ?, eduLevel_emp = ? where id_emp = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, idCard);
            ps.setInt(3, gender);
            java.sql.Date sqlDate = new java.sql.Date(Bdate.getTime());
            ps.setDate(4, sqlDate);
            ps.setString(5, address);
            ps.setString(6, phone);
            ps.setString(7, email);
            ps.setString(8, eduLevel);
            ps.setString(9, id);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                return 1; // Thành công r cu
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0; // Lỗi k xác định
    }

    public static void Remove(String id, String id_card) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String s = "update bill set id_emp = null where id_emp = ?";
        String sql = "Delete From employee where id_emp = ?";
        try {
            PreparedStatement p = conn.prepareStatement(s);
            p.setString(1, id);
            p.executeUpdate();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                String sqlString = "delete from user where username = ?";
                PreparedStatement pst = conn.prepareStatement(sqlString);
                pst.setString(1, id_card);
                int rs1 = pst.executeUpdate();
                if (rs1 != 0) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "xóa thất bại!");
        }
    }

    public static String getNameByUsername(String username) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from employee where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("name_emp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public static String getIdByUsername(String username) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from employee where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("id_emp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public static Employee findByUsername(String username) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from employee where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee e = new Employee();
                e.setID(rs.getString("id_emp"));
                e.setName(rs.getString("name_emp"));
                e.setIdCard(rs.getString("idcard_emp"));
                e.setGender(rs.getInt("gender_emp"));
                e.setPhone(rs.getString("phone_emp"));
                e.setBirthDate(rs.getDate("birthDate_emp"));
                e.setAddress(rs.getString("address_emp"));
                e.setEducationLevel("eduLevel_emp");
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void updateInfor(String username, String name, String idcard, Date bDate, int gender, String phone, String address) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "update employee set name_emp = ?, idcard_emp = ?, birthDate_emp = ?, gender_emp = ?, phone_emp = ?, "
                + "address_emp = ? where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, idcard);
            java.sql.Date sqlDate = new java.sql.Date(bDate.getTime());
            ps.setDate(3, sqlDate);
            ps.setInt(4, gender);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.setString(7, username);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                ConnectionProvider.closeConnection(conn);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        JOptionPane.showMessageDialog(null, "Xảy ra lỗi");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Service;
import Model.TypeRoom;
import Model.TypeService;
import connection.ConnectionProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import connection.ConnectionProvider;

/**
 *
 * @author Norris
 */
public class TypeServiceControl {

    public static String getNextIdTypeService() {//trả về mã dich vu tiếp theo
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT MAX(id_tSer) FROM typeservice";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString(1) != null) {
                String so = rs.getString(1).substring(2);//lấy chuỗi sau SV
                int sotr = Integer.parseInt(so);//chuyển thành số
                sotr++;
                String matrMoi = "TS" + String.format("%03d", sotr);
                return matrMoi;
            } else {
                return "TS001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public static int checkAndAdd(String id, String name) {
        java.sql.Connection conn = ConnectionProvider.getConnection();

        String checkId = "select * from typeservice where id_tSer = ?";
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
        String insert = "insert typeservice value (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, id);
            ps.setString(2, name);
            int t = ps.executeUpdate();
            if (t != 0) {
                return 1;//thêm thành công
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int edit(String id, String name) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "update typeservice set name_tSer = ? where id_tSer = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, id);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                return 1; // Thành công
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0; // Lỗi k xác định
    }

    public static void Remove(String id) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String s = "select * from service where id_tSer = ?";
        String sql = "delete from bill_service where id_ser = ?";
        String sql1 = "Delete From service where id_tSer = ?";
        String sql2 = "Delete From typeservice where id_tSer = ?";
        try {
            PreparedStatement p = conn.prepareStatement(s);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, r.getString("id_ser"));
                ps.executeUpdate();
                PreparedStatement ps1 = conn.prepareStatement(sql1);
                ps1.setString(1, id);
                int rs = ps1.executeUpdate();
                if (rs != 0) {
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setString(1, id);
                    int rs1 = ps2.executeUpdate();
                    if (rs1 != 0) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                        return;
                    }

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceControl.class.getName()).log(Level.SEVERE, null, ex);

        }
        JOptionPane.showMessageDialog(null, "xóa thất bại!");
    }

    public static ArrayList<TypeService> getlistTypeServices() {// tra về danh sách loại dich vu trong khách sạn
        ArrayList<TypeService> listTypeServices = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT * FROM typeservice";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TypeService ts = new TypeService(rs.getString("id_tSer"), rs.getString("name_tSer"));
                listTypeServices.add(ts);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceControl.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listTypeServices;
    }

    public static ArrayList<String> getListNameTypeService() {
        ArrayList<String> list = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select name_tSer from typeservice";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString("name_tSer");
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeServiceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static String getIDService(String name_tSer) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String s = "";
        String sql = "select id_tSer from typeservice where name_tSer = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name_tSer);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = rs.getString("id_tSer");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeServiceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public static String getNameService(String id_tSer) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String s = "";
        String sql = "select name_tSer from typeservice where id_tSer = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_tSer);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = rs.getString("name_tSer");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeServiceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public static ArrayList<Service> getListService() {
        ArrayList<Service> services = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select name_tSer, name_ser, price_ser from service as s join  typeservice t on t.id_tSer = s.id_tSer";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service s = new Service(rs.getString("name_tSer"), rs.getString("name_ser"), rs.getInt("price_ser"));
                services.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeServiceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return services;
    }

    public static ArrayList<Service> getListFoundService(String name_tSer) {
        ArrayList<Service> services = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select name_tSer, name_ser, price_ser from service as s join  typeservice t on t.id_tSer = s.id_tSer where name_tSer = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name_tSer);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service s = new Service(rs.getString("name_tSer"), rs.getString("name_ser"), rs.getInt("price_ser"));
                services.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeServiceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return services;
    }

}

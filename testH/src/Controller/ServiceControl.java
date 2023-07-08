/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Service;
import Model.TypeService;
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
public class ServiceControl {

    public static String getNextIdService() {//trả về mã dich vu tiếp theo
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT MAX(id_ser) FROM service";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString(1) != null) {
                String so = rs.getString(1).substring(2);//lấy chuỗi sau SV
                int sotr = Integer.parseInt(so);//chuyển thành số
                sotr++;
                String matrMoi = "SV" + String.format("%03d", sotr);
                return matrMoi;
            } else {
                return "SV001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public static int checkAndAdd(String id, String id_tSer, String name, int price) {
        java.sql.Connection conn = ConnectionProvider.getConnection();

        String checkId = "select * from service where id_ser = ?";
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
        String insert = "insert service value (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, id);
            ps.setString(2, id_tSer);
            ps.setString(3, name);
            ps.setInt(4, price);
            int t = ps.executeUpdate();
            if (t != 0) {
                return 1;//thêm thành công
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeRoomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int edit(String id, String id_tSer, String name, int price) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "update service set id_tSer = ?, name_ser = ?, price_ser = ? where id_ser = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_tSer);
            ps.setString(2, name);
            ps.setInt(3, price);
            ps.setString(4, id);
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
        String sql ="delete from bill_service where id_ser = ?";
        String sql1 = "Delete From service where id_ser = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, id);
            int rs = ps1.executeUpdate();
            if (rs != 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceControl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        JOptionPane.showMessageDialog(null, "xóa thất bại!");
    }

    public static ArrayList<Service> getlistServices() {// tra về danh sách loại dich vu trong khách sạn
        ArrayList<Service> listServices = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT * FROM service";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service sv = new Service(rs.getString("id_ser"),
                        TypeServiceControl.getNameService(rs.getString("id_tSer")),
                        rs.getString("name_ser"),
                        rs.getInt("price_ser"));
                listServices.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceControl.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listServices;
    }
    public static String[] getListNameService(){
        String[] s = new String[100];
        int i = 0;
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select name_ser from service";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name= rs.getString("name_ser");
                s[i] = name;
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeServiceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public static String getPriceService(String name){
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select price_ser from service where name_ser = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("price_ser");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeServiceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public static String getIdService(String name){
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select id_ser from service where name_ser = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("id_ser");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeServiceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public static ArrayList<Service> getListUsedService(String id_bill){
        java.sql.Connection conn = ConnectionProvider.getConnection();
        ArrayList<Service> list = new  ArrayList<>();
        String sql = "select ts.name_tSer, s.name_ser, bs.quantity, s.price_ser from bill_service as bs "
                + "join service as s on s.id_ser = bs.id_ser "
                + "join typeservice as ts on s.id_tSer = ts.id_tSer "
                + "where id_bill = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_bill);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Service s = new Service();
                s.setName_tSer(rs.getString("name_tSer"));
                s.setName(rs.getString("name_ser"));
                s.setPrice(rs.getInt("price_ser"));
                s.setQuantity(rs.getInt("quantity"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  list;
    }
}

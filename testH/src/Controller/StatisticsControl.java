/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bill;
import Model.Bill_Furniture;
import Model.Bill_Service;
import connection.ConnectionProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StatisticsControl {
    public static ArrayList<Bill> revenueStatistics(int year) {
        ArrayList<Bill> listBill = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String getIdBill = "select * from bill where year(time_checkout) = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(getIdBill);
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getString("id_bill"));
                bill.setStartTime(rs.getDate("time_checkin").toString() + " " + rs.getTime("time_checkin").toString());
                bill.setEndTime(rs.getDate("time_checkout").toString() + " " + rs.getTime("time_checkout").toString());
                
                String getIdFur = "select * from bill_furniture where id_bill = ?";
                PreparedStatement ps1 = conn.prepareStatement(getIdFur);
                ps1.setString(1, bill.getId());
                ResultSet rs1 = ps1.executeQuery();
                ArrayList<Bill_Furniture> listIdFur = new ArrayList<>();
                while (rs1.next()) {
                    listIdFur.add(new Bill_Furniture(bill.getId(), rs1.getString("id_fur")));
                }
                bill.setbFur(listIdFur);
                
                String getIdSer = "select * from bill_service where id_bill = ?";
                PreparedStatement ps2 = conn.prepareStatement(getIdSer);
                ps2.setString(1, bill.getId());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<Bill_Service> listIdSer = new ArrayList<>();
                while (rs2.next()) {
                    listIdSer.add(new Bill_Service(bill.getId(), rs2.getString("id_ser"), rs2.getInt("quantity")));
                }
                bill.setbSer(listIdSer);
                
                listBill.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return listBill;
    }
    
    public static ArrayList<Bill> revenueStatistics(int month, int year) {
        ArrayList<Bill> listBill = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String getIdBill = "select * from bill where year(time_checkout) = ? and month(time_checkout) = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(getIdBill);
            ps.setInt(1, year);
            ps.setInt(2, month);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getString("id_bill"));
                bill.setStartTime(rs.getDate("time_checkin").toString() + " " + rs.getTime("time_checkin").toString());
                bill.setEndTime(rs.getDate("time_checkout").toString() + " " + rs.getTime("time_checkout").toString());
                
                String getIdFur = "select * from bill_furniture where id_bill = ?";
                PreparedStatement ps1 = conn.prepareStatement(getIdFur);
                ps1.setString(1, bill.getId());
                ResultSet rs1 = ps1.executeQuery();
                ArrayList<Bill_Furniture> listIdFur = new ArrayList<>();
                while (rs1.next()) {
                    listIdFur.add(new Bill_Furniture(bill.getId(), rs1.getString("id_fur")));
                }
                bill.setbFur(listIdFur);
                
                String getIdSer = "select * from bill_service where id_bill = ?";
                PreparedStatement ps2 = conn.prepareStatement(getIdSer);
                ps2.setString(1, bill.getId());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<Bill_Service> listIdSer = new ArrayList<>();
                while (rs2.next()) {
                    listIdSer.add(new Bill_Service(bill.getId(), rs2.getString("id_ser"), rs2.getInt("quantity")));
                }
                bill.setbSer(listIdSer);
                
                listBill.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return listBill;
    }
    
    public static ArrayList<Bill> revenueStatistics(int day, int month, int year) {
        ArrayList<Bill> listBill = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String getIdBill = "select * from bill where year(time_checkout) = ? and month(time_checkout) = ? and day(time_checkout) = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(getIdBill);
            ps.setInt(1, year);
            ps.setInt(2, month);
            ps.setInt(3, day);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getString("id_bill"));
                bill.setStartTime(rs.getDate("time_checkin").toString() + " " + rs.getTime("time_checkin").toString());
                bill.setEndTime(rs.getDate("time_checkout").toString() + " " + rs.getTime("time_checkout").toString());
                
                String getIdFur = "select * from bill_furniture where id_bill = ?";
                PreparedStatement ps1 = conn.prepareStatement(getIdFur);
                ps1.setString(1, bill.getId());
                ResultSet rs1 = ps1.executeQuery();
                ArrayList<Bill_Furniture> listIdFur = new ArrayList<>();
                while (rs1.next()) {
                    listIdFur.add(new Bill_Furniture(bill.getId(), rs1.getString("id_fur")));
                }
                bill.setbFur(listIdFur);
                
                String getIdSer = "select * from bill_service where id_bill = ?";
                PreparedStatement ps2 = conn.prepareStatement(getIdSer);
                ps2.setString(1, bill.getId());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<Bill_Service> listIdSer = new ArrayList<>();
                while (rs2.next()) {
                    listIdSer.add(new Bill_Service(bill.getId(), rs2.getString("id_ser"), rs2.getInt("quantity")));
                }
                bill.setbSer(listIdSer);
                
                listBill.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionProvider.closeConnection(conn);
        return listBill;
    }
}

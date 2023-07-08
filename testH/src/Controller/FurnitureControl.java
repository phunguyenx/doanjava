/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Furniture;
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
public class FurnitureControl {

    public static String getNextIdFurniture() {//trả về mã đồ dùng cơ sở vật chất tiếp theo
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT MAX(id_fur) FROM furniture";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getString(1) != null) {
                String so = rs.getString(1).substring(2);//lấy chuỗi sau FU
                int sotr = Integer.parseInt(so);//chuyển thành số
                sotr++;
                String matrMoi = "FU" + String.format("%05d", sotr);
                return matrMoi;
            } else {
                return "FU00001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    //kiểm tra và thêm đồ dùng theo loại phòng
    public static int check(String name, int price, String name_tRoom) {
        int c = 0;
        java.sql.Connection conn = ConnectionProvider.getConnection();
        ArrayList<String> listNumberRoomByType = RoomControl.getListRoomNumberByType(name_tRoom);
        for (String s : listNumberRoomByType) {//lặp thêm nhiều đồ dùng 
            String insert = "insert furniture value (?, ?, ?, 1, ?)";
            try {
                PreparedStatement ps = conn.prepareStatement(insert);
                String id = FurnitureControl.getNextIdFurniture();
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setInt(3, price);
                ps.setString(4, s);
                int t = ps.executeUpdate();
                if (t != 0) {
                    c++;//thêm thành công
                }
            } catch (SQLException ex) {
                Logger.getLogger(TypeRoomControl.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Loại phòng không tồn tại");
            }
        }
        if (c == RoomControl.getNumberOfRoomByType(name_tRoom)) {
            return 1;
        } else {
            return 0;
        }
    }

    // tra về danh sách đồ dùng phòng theo loại phòng vừa thêm
    public static ArrayList<Furniture> getlistAddedFurnitures(String name_tRoom) {
        ArrayList<Furniture> listFurnitureAdds = new ArrayList<>();
        ArrayList<Furniture> list = FurnitureControl.getlistFurnituresByTypeRoom();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT * FROM furniture f "
                + " JOIN room r ON f.roomNumber = r.roomNumber "
                + " JOIN typeroom tr ON r.id_tRoom = tr.id_tRoom "
                + " order by id_fur asc ";
        try {//dùng được absolute
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            int i = list.size() - RoomControl.getNumberOfRoomByType(name_tRoom) + 1;//vị trí đầu sau khi thêm 
            while (rs.absolute(i)) {
                Furniture fur = new Furniture();
                fur.setId(rs.getString("id_fur"));
                fur.setName(rs.getString("name_fur"));
                fur.setPrice(rs.getInt("price_fur"));
                fur.setId_RoomNumber(rs.getString("roomNumber"));
                fur.setName_tRoom(rs.getString("name_tRoom"));
                fur.setStatus(rs.getInt("status_fur"));
                listFurnitureAdds.add(fur);
                i++;
            }//lặp thêm hết đồ dùng vừa thêm vào array 
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listFurnitureAdds;
    }

    //sửa hàng loạt đồ dùng theo loại phòng
    public static int edit(String name, int price, String nameOld, int priceOld, String name_tRoomOld) {
        int c = 0;
        java.sql.Connection conn = ConnectionProvider.getConnection();
        ArrayList<String> listRoomNumer = RoomControl.getListRoomNumberByType(name_tRoomOld);

        for (String s : listRoomNumer) {
            String sql = "UPDATE furniture SET name_fur = ?, price_fur = ? "
                    + " WHERE roomNumber = ? and name_fur = ? and price_fur = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setInt(2, price);
                ps.setString(3, s);
                ps.setString(4, nameOld);
                ps.setInt(5, priceOld);
                int rs = ps.executeUpdate();
                if (rs != 0) {
                    c++; // Thành công r cu
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (c == RoomControl.getNumberOfRoomByType(name_tRoomOld)) {
            return 1;// sửa thành công
        } else {
            return 0;//lỗi không xác định
        }

    }

    //xóa hàng loạt theo danh sách số phòng lấy từ loại phòng 
    public static int Remove(String name, int price, ArrayList<String> roomNbs) {
        int c = 0;
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "Delete From furniture where name_fur = ? and price_fur = ? and roomNumber = ?";
        String sql1 = "select * From furniture where name_fur = ? and price_fur = ? and roomNumber = ?";
        String sql2 = "delete from bill_furniture where id_fur = ?";
        for (String a : roomNbs) {
            try {
                PreparedStatement ps1 = conn.prepareStatement(sql1);
                ps1.setString(1, name);
                ps1.setInt(2, price);
                ps1.setString(3, a);
                ResultSet r = ps1.executeQuery();
                if (r.next()) {
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setString(1, r.getString("id_fur"));
                    ps2.executeUpdate();
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setInt(2, price);
                    ps.setString(3, a);
                    int rs = ps.executeUpdate();
                    if (rs != 0) {
                        c++;
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(EmployeeControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (c == roomNbs.size()) {
            return 1;
        } else {
            return -1;
        }
    }

    public static ArrayList<Furniture> getlistFurnituresByTypeRoom() {// tra về danh sách đồ dùng phòng theo loại phòng 
        ArrayList<Furniture> listFurnitures = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT * FROM furniture f "
                + " JOIN room r ON f.roomNumber = r.roomNumber "
                + " JOIN typeroom tr ON r.id_tRoom = tr.id_tRoom "
                + " order by id_fur asc ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Furniture fur = new Furniture();
                fur.setId(rs.getString("id_fur"));
                fur.setName(rs.getString("name_fur"));
                fur.setPrice(rs.getInt("price_fur"));
                fur.setId_RoomNumber(rs.getString("roomNumber"));
                fur.setName_tRoom(rs.getString("name_tRoom"));
                fur.setStatus(rs.getInt("status_fur"));
                listFurnitures.add(fur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listFurnitures;
    }

    //lấy 1 dãy chỉ số hàng từ danh sách đồ dùng để xóa hàng trên giao diện
    public static ArrayList<Integer> getListIndexRowByType(String nameOldString, int priceOld, String name_tRoomOld) {
        ArrayList<Integer> arr = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT f.id_fur as `id`,f.name_fur as `name`, "
                + "f.price_fur as `price`, max(r.roomnumber) as roomNumber, "
                + " max(name_tRoom) as name_tRoom "
                + " FROM furniture f "
                + " JOIN room r ON f.roomNumber = r.roomNumber "
                + " JOIN typeroom tr ON r.id_tRoom = tr.id_tRoom "
                + " group by `id`,`name`,`price`"
                + " order by `id` asc ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("name").equals(nameOldString)
                        && rs.getInt("price") == priceOld
                        && rs.getString("name_tRoom").equals(name_tRoomOld)) {
                    int a = rs.getRow() - 1;
                    arr.add(a);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);

        }
        return arr;
    }

    public static ArrayList<Furniture> getListFurInRoom(String roomNumber) {
        ArrayList<Furniture> list = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select id_fur, name_fur, price_fur, status_fur from furniture where roomNumber = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, roomNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Furniture f = new Furniture(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FurnitureControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void SetToBroken(String id_fur, String id_bill) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String s = "select * from furniture where id_fur = ?";
        try {
            PreparedStatement p = conn.prepareStatement(s);
            p.setString(1, id_fur);
            ResultSet rs = p.executeQuery();
            if (rs.next() && rs.getInt("status_fur") == 0) {
                JOptionPane.showMessageDialog(null, "Thiết Bị Đã Bị Hỏng Trước Đó");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FurnitureControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "update furniture set status_fur = ? where id_fur = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2, id_fur);
            int rs = ps.executeUpdate();
            String sql1 = "insert bill_furniture values(?, ?)";
            if (rs != 0) {
                PreparedStatement ps1 = conn.prepareStatement(sql1);
                ps1.setString(1, id_bill);
                ps1.setString(2, id_fur);
                if (ps1.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Báo Hỏng Thành Công");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FurnitureControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean MaintenanceOrBreak(String id) {
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String s = "select * from furniture where id_fur = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(s);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String sql = "update furniture set status_fur = ? where id_fur = ?";
                PreparedStatement ps1 = conn.prepareStatement(sql);
                if (rs.getInt("status_fur") == 1) {
                    ps1.setInt(1, 0);
                    ps1.setString(2, id);
                    ps1.executeUpdate();
                    return true;
                } else {
                    ps1.setInt(1, 1);
                    ps1.setString(2, id);
                    ps1.executeUpdate();
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(FurnitureControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ArrayList<Furniture> getListFurnituerBeBrokenInBill(String id_bill) {
        ArrayList<Furniture> list = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "select * from bill_furniture as bf "
                + "join furniture as f on f.id_fur = bf.id_fur "
                + "where id_bill = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id_bill);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Furniture f = new Furniture(rs.getString(2), rs.getString(4), rs.getInt(5), rs.getInt(6));
                list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FurnitureControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static ArrayList<Furniture> findListFurByRoomNumber(String roomNumber) {
        ArrayList<Furniture> listGuests = new ArrayList<>();
        java.sql.Connection conn = ConnectionProvider.getConnection();
        String sql = "SELECT * FROM furniture as f "
                + "join room as r on f.roomNumber = r.roomNumber "
                + "join typeroom as tr on r.id_tRoom = tr.id_tRoom "
                + "where r.roomNumber like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + roomNumber + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Furniture f = new Furniture();
                f.setId(rs.getString("id_fur"));
                f.setName(rs.getString("name_fur"));
                f.setPrice(rs.getInt("price_fur"));
                f.setId_RoomNumber(rs.getString("roomNumber"));
                f.setName_tRoom(rs.getString("name_tRoom"));
                f.setStatus(rs.getInt("status_fur"));
                listGuests.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listGuests;
    }
}

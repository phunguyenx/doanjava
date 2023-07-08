/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author NGUYEN PHUC NAM
 */
public class ConnectionProvider {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/testH";
            String username = "root";
            String password = "20032810";
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) { // TODO: handle exception
            // TODO: handle exception
            System.out.println("cannot connect database " + e);
        }
        return conn;
    }

    public static void closeConnection(java.sql.Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    
    
}

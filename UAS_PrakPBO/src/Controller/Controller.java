/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gibran<>
 */
public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();

    public String checkLogin(String email, String password) {
        conn.connect();
        String query = "SELECT * FROM User WHERE userEmail='" + email + "'&&password='" + password + "'";
        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
            java.sql.PreparedStatement ps = conn.con.prepareStatement(query);
            java.sql.ResultSet resultSet = ps.executeQuery(query);
            String un = "";
            String pw = "";
            while (resultSet.next()) {
                un = resultSet.getString("userEmail");
                pw = resultSet.getString("password");
                System.out.println(un);
                System.out.println(pw);
            }
            if (email.equals(un) && password.equals(pw)) {
                return "ada";
            } else {
                return "gaada";
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return "ada";
        }
    }

    public boolean insertLogin() {
        conn.connect();
        String query = "INSERT INTO User VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            
            
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
}

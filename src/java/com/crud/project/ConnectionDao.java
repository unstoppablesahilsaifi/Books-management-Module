/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.project;
import java.sql.*;
/**
 *
 * @author saifi
 */
public class ConnectionDao {
    private static Connection con;
// We will call this method when we need the connection.
    public static Connection getCon() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_management","root","almamun@123");
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
        return con;
    }
}

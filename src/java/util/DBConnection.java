/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LENOVO
 */
public class DBConnection {
    private Connection c;

    public Connection getConnection() {
          
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3307/giyim?user=root&password=root");
            System.out.println("Bağlantı Başarılı");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return c;
 
    }

    public void setConnection(Connection connection) {
        this.c = connection;
    }
    
}

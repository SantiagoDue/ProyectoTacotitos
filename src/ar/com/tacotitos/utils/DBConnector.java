/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Due
 */
public class DBConnector {
    
    public Connection connect() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/taquitos";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, "root", "");
            return conn;
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos :( " + e);
            return null;
        }
    }
}

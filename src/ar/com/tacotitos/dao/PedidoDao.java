/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dao;

import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.PedidoDTO;
import ar.com.tacotitos.utils.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Due
 */
public class PedidoDao {
    
    DBConnector db = new DBConnector();
    
    public PedidoDTO saveAndGetPedido () {
        try {
            Connection con = db.connect();
            String sql = "insert into pedido(fecha,precio_total) values(now(),0);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int row = ps.executeUpdate();
                if (row == 1) {
                    sql = "SELECT * FROM taquitos.pedido ORDER BY id DESC LIMIT 0, 1;";
                    Statement st = con.createStatement();
                    ResultSet rs =st.executeQuery(sql);
                    while (rs.next()) {
                        return new PedidoDTO(
                            rs.getLong("id"),
                            rs.getDate("fecha"),
                            rs.getLong("precio_total"));
                    }
                }
                return null;
            
        } catch (Exception e) {
            
            System.out.println("Error al recuperar los datos de la base :(");
            e.printStackTrace();
            return null;
        }
    }
    
}

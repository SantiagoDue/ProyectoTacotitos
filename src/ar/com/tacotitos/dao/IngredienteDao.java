/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dao;

import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.utils.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Due
 */
public class IngredienteDao {
     
    DBConnector db = new DBConnector();
    
    public Integer save (IngredienteDTO data){
        try {
            Connection con = db.connect();
            String sql = "INSERT INTO ingrediente(nombre, precio, tipo) VALUES(?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getNombre());
            ps.setInt(2, data.getPrecio());
            ps.setInt(3, Integer.parseInt(data.getTipoIngrediente().toString()));
            int row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            System.out.println("Error al recuperar los datos de la base :(");
            return 0;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dao;

import ar.com.tacotitos.dto.TipoIngredienteDTO;
import ar.com.tacotitos.utils.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Due
 */
public class TipoIngredienteDao {
    
    DBConnector db = new DBConnector();
    
    public List<TipoIngredienteDTO> getAll (){
        List<TipoIngredienteDTO> salida = new ArrayList<TipoIngredienteDTO>();
        try {
        Connection con = db.connect();
        TipoIngredienteDTO ti; 
        String sql = "SELECT id, nombre, cant_max FROM ingrediente_tipo";
        Statement st = con.createStatement();
        ResultSet rs =st.executeQuery(sql);
        while (rs.next()) {
            ti = new TipoIngredienteDTO(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getInt("cant_max"));
            salida.add(ti);
        }
        } catch (SQLException e) {
            System.out.println("Error al recuperar los datos de la base :(");
            return salida;
        }
        return salida;
    }
}

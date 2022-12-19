/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dao;

import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.TipoIngredienteDTO;
import ar.com.tacotitos.utils.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Due
 */
public class IngredienteDao {
     
    DBConnector db = new DBConnector();
    
    public List<IngredienteDTO> getByTipoIngredienteId (Long tipoIngredienteId){
        List<IngredienteDTO> salida = new ArrayList<IngredienteDTO>();
        try {   
            Connection con = db.connect();
        IngredienteDTO ti; 
        String sql = "SELECT id, nombre, id_tipo_ingrediente, precio, baja FROM ingrediente where id_tipo_ingrediente = " + tipoIngredienteId + " and baja = 0";
        Statement st = con.createStatement();
        ResultSet rs =st.executeQuery(sql);
            while (rs.next()) {
                ti = new IngredienteDTO(
                            rs.getLong("id"),
                            rs.getString("nombre"),
                            rs.getLong("id_tipo_ingrediente"),
                            rs.getInt("precio"),
                            rs.getBoolean("baja"));
                salida.add(ti);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar los datos de la base :(");
            return salida;
        }
        return salida;
    }
    
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

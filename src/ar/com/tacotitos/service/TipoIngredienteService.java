/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.service;

import ar.com.tacotitos.dao.TipoIngredienteDao;
import ar.com.tacotitos.dto.TipoIngredienteDTO;
import java.util.List;

/**
 *
 * @author Due
 */
public class TipoIngredienteService {
    
    TipoIngredienteDao dao = new TipoIngredienteDao();
    
    public List<TipoIngredienteDTO> getAll(){
        return dao.getAll();
    };
    
    public Integer altaTipoProducto(String nombreTipoProducto, Integer cantidad){
        return dao.guardarNuevoTipoIngrediente(nombreTipoProducto, cantidad);
    };
}

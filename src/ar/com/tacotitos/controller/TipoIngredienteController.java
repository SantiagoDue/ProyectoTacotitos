/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.controller;

import ar.com.tacotitos.dto.TipoIngredienteDTO;
import ar.com.tacotitos.service.TipoIngredienteService;
import java.util.List;

/**
 *
 * @author Due
 */
public class TipoIngredienteController {
    
    TipoIngredienteService service = new TipoIngredienteService();
    
    public List<TipoIngredienteDTO> getTiposDeIngrediente() {
        
        List<TipoIngredienteDTO> listaTipoIngredientes = service.getAll();
        return listaTipoIngredientes;
    }
    
    public Integer ingresarNuevoTipoIngrediente(String tipoIngrediente, Integer cantidad) {
        
        Integer altaTipoProducto = service.altaTipoProducto(tipoIngrediente, cantidad);
        return altaTipoProducto;
    }
}

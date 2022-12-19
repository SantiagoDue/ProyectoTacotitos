/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.controller;
import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.TipoIngredienteDTO;
import ar.com.tacotitos.service.IngredienteService;
import ar.com.tacotitos.views.NuevoIngredienteView;
import java.util.List;


/**
 *
 * @author Due
 */
public class IngredienteController {
    
    IngredienteService service = new IngredienteService();
    
    public List<IngredienteDTO> getIngredientesPorId(Long id_tipo_ingrediente) {
        
        List<IngredienteDTO> listaIngredientes = service.getByTipoIngredienteId(id_tipo_ingrediente);
        return listaIngredientes;
    }
    
    public Integer nuevoIngrediente(String nombre, String precio, String tipoIngrediente) {
        
        return service.save(nombre,precio,tipoIngrediente);
    }
}

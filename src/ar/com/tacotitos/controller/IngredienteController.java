/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.controller;
import ar.com.tacotitos.service.IngredienteService;
import ar.com.tacotitos.views.NuevoIngredienteView;


/**
 *
 * @author Due
 */
public class IngredienteController {
    
    IngredienteService service = new IngredienteService();
    
    public Integer nuevoIngrediente(String nombre, String precio, String tipoIngrediente) {
        
        return service.save(nombre,precio,tipoIngrediente);
    }
}

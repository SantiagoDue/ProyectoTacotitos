/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dto;

/**
 *
 * @author Due
 */
public class IngredienteDTO {
    public Long id;
    public String nombre;
    public Long tipoIngrediente;//ID de la tabla a la que hace referencia
    public Integer precio; 
    
    public IngredienteDTO (String nombre, Long tipoIngrediente, Integer precio){
        this.nombre = nombre;
        this.tipoIngrediente = tipoIngrediente;
        this.precio = precio;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId (Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    
    public Long getTipoIngrediente() {
        return tipoIngrediente;
    }
    
    public void setTipoIngrediente (Long tipoIngrediente) {
        this.tipoIngrediente = tipoIngrediente;
    }
    
    public Integer getPrecio() {
        return precio;
    }
    
    public void setPrecio (Integer precio) {
        this.precio = precio;
    }
}

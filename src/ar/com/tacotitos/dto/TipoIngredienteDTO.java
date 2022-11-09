/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dto;

/**
 *
 * @author Due
 */
public class TipoIngredienteDTO {
    public Long id;
    public String nombre;
    public Integer cantMax;
    
    public TipoIngredienteDTO (Long id, String nombre, Integer cantMax){
        this.id = id;
        this.nombre = nombre;
        this.cantMax = cantMax;
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
    
    public Integer getCantidad() {
        return cantMax;
    }
    
    protected void setCantidad (Integer cantidad) {
        this.cantMax = cantidad;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dto;

/**
 *
 * @author Due
 */
public class IngredienteTacoDTO {
    private Long  idIngrediente;
    private Long  idTaco;
    
    public IngredienteTacoDTO (Long idIngrediente, Long idTaco) {
        this.idIngrediente = idIngrediente;
        this.idTaco = idTaco;
    }
 
    
    public Long getIdIngrediente() {
        return idIngrediente;
    }
    
    public void setIdIngrediente (Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }
    
    public Long getIdTaco() {
        return idTaco;
    }
    
    public void setIdTaco (Long idTaco) {
        this.idTaco = idTaco;
    }

}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dto;

/**
 *
 * @author Due
 */
public class TacoDTO {
    private Long  id;
    private Long  costo;
    private Long idPedido;
    
    
    
    public Long getId() {
        return id;
    }
    
    public void setId (Long id) {
        this.id = id;
    }
    
    public Long getCosto() {
        return costo;
    }
    
    public void setCosto (Long costo) {
        this.costo = costo;
    }
    public Long getIdPedido() {
        return idPedido;
    }
    
    public void setIdPedido (Long idPedido) {
        this.idPedido = idPedido;
    }
}


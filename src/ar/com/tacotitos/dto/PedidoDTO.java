/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.dto;

import java.util.Date;

/**
 *
 * @author Due
 */
public class PedidoDTO {
    private Long id;
    private Date fecha;
    private Long precioTotal;
    
    
    public PedidoDTO(Long id, Date fecha, Long precioTotal) {
     this.id = id;
     this.fecha = fecha;
     this.precioTotal = precioTotal;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId (Long id) {
        this.id = id;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha (Date fecha) {
        this.fecha = fecha;
    }
    
     public Long getPrecioTotal() {
        return precioTotal;
    }
    
    public void setPrecioTotal (Long precioTotal) {
        this.precioTotal = precioTotal;
    }
}

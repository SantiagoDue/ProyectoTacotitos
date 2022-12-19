/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.controller;

import ar.com.tacotitos.dto.PedidoDTO;
import ar.com.tacotitos.service.PedidoService;
import java.util.Date;

/**
 *
 * @author Due
 */
public class PedidoController {
    
    PedidoService service = new PedidoService();
    
    public PedidoDTO getNuevoPedido() {
        return service.getNuevoPedido();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.service;

import ar.com.tacotitos.dao.IngredienteDao;
import ar.com.tacotitos.dao.PedidoDao;
import ar.com.tacotitos.dao.TipoIngredienteDao;
import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.PedidoDTO;
import ar.com.tacotitos.dto.TipoIngredienteDTO;
import java.util.List;

/**
 *
 * @author Due
 */
public class PedidoService {
    
    PedidoDao pDao = new PedidoDao();

    public PedidoDTO getNuevoPedido() {
        PedidoDTO dto = pDao.saveAndGetPedido();

        if (dto != null) {
            return dto;
        } else {
          return null; 
        }
    }
}

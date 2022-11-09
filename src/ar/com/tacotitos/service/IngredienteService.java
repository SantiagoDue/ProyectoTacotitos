/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.tacotitos.service;

import ar.com.tacotitos.dao.IngredienteDao;
import ar.com.tacotitos.dao.TipoIngredienteDao;
import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.TipoIngredienteDTO;
import java.util.List;

/**
 *
 * @author Due
 */
public class IngredienteService {
    
    TipoIngredienteDao tiDao = new TipoIngredienteDao();
    IngredienteDao iDao = new IngredienteDao();
    
    public Integer save(String nombre, String precio, String tipoIngrediente) {
        IngredienteDTO data = null;
        List<TipoIngredienteDTO> lista = tiDao.getAll();
        for (TipoIngredienteDTO dto : lista) {
            if (dto.getNombre().equals(tipoIngrediente)) {
                data = new IngredienteDTO(
                        nombre,
                        dto.getId(),
                        Integer.parseInt(precio));
            }
        }
        if (data != null) {
            return iDao.save(data);
        } else {
          return 0; 
        }
    }
}

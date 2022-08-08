
package com.alkemy.challenge.mapper;

import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.entity.PeliculaEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author alejandro
 */

@Component
public class PeliculaMapper {
    
    
    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto){
        
        PeliculaEntity entity = new PeliculaEntity();
        entity.setTitulo(dto.getTitulo());
        entity.setCalificacion(dto.getCalificacion());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setImagen(dto.getImagen());
        return entity;
        
    }
    
    
    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity){
        
        PeliculaDTO peliculadto = new PeliculaDTO();
        peliculadto.setId(entity.getId());
        peliculadto.setTitulo(entity.getTitulo());
        peliculadto.setImagen(entity.getImagen());
        peliculadto.setCalificacion(entity.getCalificacion());
        peliculadto.setFechaCreacion(entity.getFechaCreacion());
        return peliculadto;
  
    }
    
    
    
    public List<PeliculaDTO> listaEntity2DTO(List<PeliculaEntity> peliculasEntity){
        
        List<PeliculaDTO> listaDTO = new ArrayList<>();
        for(PeliculaEntity pelEntity : peliculasEntity){
            listaDTO.add(this.peliculaEntity2DTO(pelEntity));
        }
        return listaDTO;
        
    }
    
    
    
    
    
}


package com.alkemy.challenge.mapper;

import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.entity.PeliculaEntity;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author alejandro
 */

@Component
public class PeliculaMapper {
    
    @Autowired
    PersonajeMapper persoMapper;
    
    
    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto){
        
        PeliculaEntity entity = new PeliculaEntity();
        entity.setTitulo(dto.getTitulo());
        entity.setCalificacion(dto.getCalificacion());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setImagen(dto.getImagen());
        return entity;
        
    }
    
    
    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity, boolean loadPersonajes){

        PeliculaDTO peliculadto = new PeliculaDTO();
        peliculadto.setId(entity.getId());
        peliculadto.setTitulo(entity.getTitulo());
        peliculadto.setImagen(entity.getImagen());
        peliculadto.setCalificacion(entity.getCalificacion());
        peliculadto.setFechaCreacion(entity.getFechaCreacion());
        if(loadPersonajes){
            List<PersonajeDTO> personajeDTOS = this.persoMapper.personajeEntitySet2DTOList(entity.getPersonajes(), false);
            peliculadto.setPersonajes(personajeDTOS);
        }
        return peliculadto;

    }
    
    public List<PeliculaDTO> peliculaEntityList2DTOList(List<PeliculaEntity> entities, boolean loadPersonajes){
        List<PeliculaDTO> dtos = new ArrayList<>();
        for(PeliculaEntity entity : entities){
            dtos.add(this.peliculaEntity2DTO(entity, loadPersonajes));
        }
        return dtos;
    }
    
    public List<PeliculaDTO> listaEntity2DTO(List<PeliculaEntity> peliculasEntity, boolean loadPersonajes){
        
        List<PeliculaDTO> listaDTO = new ArrayList<>();
        for(PeliculaEntity pelEntity : peliculasEntity){
            listaDTO.add(this.peliculaEntity2DTO(pelEntity, loadPersonajes));
        }
        return listaDTO;
        
    }

    public Set<PeliculaEntity> peliculaDTOList2Entity(List<PeliculaDTO> dtos){
        Set<PeliculaEntity> entities = new HashSet<>();
        for (PeliculaDTO dto : dtos){
            entities.add(this.peliculaDTO2Entity(dto));
        }
        return entities;
    }


    public List<PeliculaDTO> peliculaEntitySet2DTOList(Collection<PeliculaEntity> entities, boolean loadPersonajes){
        List<PeliculaDTO> dtos = new ArrayList<>();
        for(PeliculaEntity entity : entities){
            dtos.add(this.peliculaEntity2DTO(entity, loadPersonajes));
        }

        return dtos;

    }

    public void peliculaEntityRefreshValues(PeliculaEntity entity, PeliculaDTO dto){
        entity.setImagen(dto.getImagen());
        entity.setTitulo(dto.getTitulo());
        entity.setCalificacion(dto.getCalificacion());
        entity.setFechaCreacion(dto.getFechaCreacion());
    }


    
    
    
    
    
}


package com.alkemy.challenge.mapper;

import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.dto.PersonajeBasicDTO;
import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.entity.PersonajeEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author alejandro
 */

@Component
public class PersonajeMapper {
    
    @Autowired
    PeliculaMapper peliMapper;
    
    
    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto){
        
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setHistoria(dto.getHistoria());
        personajeEntity.setPeso(dto.getPeso());
        return personajeEntity;
    
    }
    
    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity, boolean loadPeliculas){
        
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setId(entity.getId());
        personajeDTO.setNombre(entity.getNombre());
        personajeDTO.setImagen(entity.getImagen());
        personajeDTO.setHistoria(entity.getHistoria());
        personajeDTO.setEdad(entity.getEdad());
        personajeDTO.setPeso(entity.getPeso());
        if(loadPeliculas){
            List<PeliculaDTO> peliculasdto = this.peliMapper.peliculaEntityList2DTOList(entity.getPeliculasSeries(), false);
            personajeDTO.setPeliculasSeries(peliculasdto);
        }
        return personajeDTO;

    }
    
    public Set<PersonajeEntity> personajeDTOList2Entity(List<PersonajeDTO> dtos){
        Set<PersonajeEntity> entities = new HashSet<>();
        for (PersonajeDTO dto : dtos){
            entities.add(this.personajeDTO2Entity(dto));
        }
        return entities;
    }
    
    
    public List<PersonajeDTO> personajeEntitySet2DTOList(Collection<PersonajeEntity> entities, boolean loadPeliculas){
        List<PersonajeDTO> dtos = new ArrayList<>();
        for(PersonajeEntity entity : entities){
            dtos.add(this.personajeEntity2DTO(entity, loadPeliculas));
        }
        
        return dtos;
         
    }
    
    public List<PersonajeBasicDTO> personajeEntitySetBasicDTOList(Collection<PersonajeEntity> entities){
            List<PersonajeBasicDTO> dtos = new ArrayList<>();
            PersonajeBasicDTO basicDTO;
            for(PersonajeEntity entity: entities){
                basicDTO = new PersonajeBasicDTO();
                basicDTO.setId(entity.getId());
                basicDTO.setImagen(entity.getImagen());
                basicDTO.setNombre(entity.getNombre());
                dtos.add(basicDTO);
            }
            return dtos;
    }
    
    public void personajeEntityRefreshValues(PersonajeEntity entity, PersonajeDTO dto){
        entity.setImagen(dto.getImagen());
        entity.setHistoria(dto.getHistoria());
        entity.setEdad(dto.getEdad());
        entity.setNombre(dto.getNombre());
        entity.setPeso(dto.getPeso()); 
    }
    
    
    
}

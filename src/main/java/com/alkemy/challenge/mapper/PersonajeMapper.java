
package com.alkemy.challenge.mapper;

import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.entity.PersonajeEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author alejandro
 */
@Component
public class PersonajeMapper {
    
    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto){
        
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setHistoria(dto.getHistoria());
        personajeEntity.setPeso(dto.getPeso());
        return personajeEntity;
    
    }
    
    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity){
        
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setId(entity.getId());
        personajeDTO.setNombre(entity.getNombre());
        personajeDTO.setImagen(entity.getImagen());
        personajeDTO.setHistoria(entity.getHistoria());
        personajeDTO.setEdad(entity.getEdad());
        personajeDTO.setPeso(entity.getPeso());
        return personajeDTO;

    }
    
    
    
        public List<PersonajeDTO> personajeEntityList2DTOList(List<PersonajeEntity> entities){
        List<PersonajeDTO> dtos = new ArrayList<>();
        for(PersonajeEntity entity : entities){
            dtos.add(this.personajeEntity2DTO(entity));
        }
        return dtos;
        

        
        
    }
    
    
    
    
    
}

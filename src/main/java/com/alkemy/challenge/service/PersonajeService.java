
package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.entity.PersonajeEntity;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author alejandro
 */

public interface PersonajeService {
    
    PersonajeDTO save(PersonajeDTO dto);
    List<PersonajeDTO> getAllPersonajes();
    void delete(Long id);
    public PersonajeDTO getOne(Long id);
         
     
    
}

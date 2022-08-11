
package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.PersonajeDTO;
import java.util.List;


/**
 *
 * @author alejandro
 */

public interface PersonajeService {
    
    PersonajeDTO save(PersonajeDTO dto);
    List<PersonajeDTO> getAllPersonajes();
    void delete(Long id);

         
     
    
}

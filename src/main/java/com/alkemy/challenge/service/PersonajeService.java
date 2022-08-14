
package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.PersonajeDTO;
import java.util.List;
import java.util.Set;


/**
 *
 * @author alejandro
 */

public interface PersonajeService {
    
    PersonajeDTO save(PersonajeDTO dto);
    List<PersonajeDTO> getAllPersonajes();
    void delete(Long id);
    PersonajeDTO getDetailsById(Long id);
    PersonajeDTO update(Long id, PersonajeDTO dto);
    List<PersonajeDTO> getByFilters(String name, String date, Set<Long> peliculas, String order);
     
    
}

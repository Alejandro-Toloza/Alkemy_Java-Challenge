
package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.dto.PersonajeDTO;

import java.util.List;
import java.util.Set;

/**
 *
 * @author alejandro
 */
public interface PeliculaService {
    
    PeliculaDTO save(PeliculaDTO dto);
    void delete(Long id);
    PeliculaDTO getDetailsById(Long id);
    PeliculaDTO update(Long id, PeliculaDTO dto);
    List<PeliculaDTO> getByFilters(String titulo, String genero, String order);
    
}

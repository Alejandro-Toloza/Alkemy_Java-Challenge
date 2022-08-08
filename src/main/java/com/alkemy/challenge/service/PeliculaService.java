
package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.PeliculaDTO;
import java.util.List;

/**
 *
 * @author alejandro
 */
public interface PeliculaService {
    
    PeliculaDTO save(PeliculaDTO dto);
    List<PeliculaDTO> getAllPeliculas();
    void delete(Long id);
    
}

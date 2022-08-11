
package com.alkemy.challenge.dto;

import com.alkemy.challenge.entity.PeliculaEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alejandro
 */

@Getter
@Setter
public class PersonajeDTO {
    
    private Long id;
    
    private String imagen;
    
    private String nombre;
     
    private int edad;
    
    private double peso;
    
    private String historia;
    
    private List<PeliculaDTO> peliculasSeries;

    
}

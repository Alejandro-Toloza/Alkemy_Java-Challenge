package com.alkemy.challenge.dto;

import com.alkemy.challenge.entity.PersonajeEntity;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alejandro
 */

@Getter
@Setter
public class PeliculaDTO {
    
    private Long id;
    
    private String imagen;
    
    private String titulo;
    
    private LocalDate fechaCreacion;
    
    private double calificacion;

    private List<PersonajeEntity> personajes;
}

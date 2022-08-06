
package com.alkemy.challenge.dto;

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
    
}


package com.alkemy.challenge.dto;


import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alejandro
 */
@Getter
@Setter
public class PersonajeFilterDTO {
    
    private String nombre;
    private Integer edad;
    private List<Long> peliculasSeries;
    private String order;

    public PersonajeFilterDTO(String nombre, Integer edad, List<Long> peliculasSeries, String order) {

        this.nombre = nombre;
        this.edad = edad;
        this.peliculasSeries = peliculasSeries;
        this.order = order;
    }
    
    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC") == 0;
    }
        public boolean isADESC(){
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
    
}

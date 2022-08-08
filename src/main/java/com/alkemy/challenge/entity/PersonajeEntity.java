
package com.alkemy.challenge.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author alejandro
 */
@Entity
@Table (name = "personajes")
@Getter
@Setter
public class PersonajeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String imagen;
    
    private String nombre;
     
    private int edad;
    
    private double peso;
    
    private String historia;

    @ManyToMany(mappedBy = "personajes")
    private List<PeliculaEntity> peliculasSeries = new ArrayList<>();
    
    
    
}

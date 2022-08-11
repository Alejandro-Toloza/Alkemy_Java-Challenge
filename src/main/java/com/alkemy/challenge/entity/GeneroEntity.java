
package com.alkemy.challenge.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alejandro
 */

@Entity
@Table(name = "genero")
@Getter @Setter
public class GeneroEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String imagen;
    
    @OneToMany()
    private List<PeliculaEntity> peliculas = new ArrayList<>();
    
    
}


package com.alkemy.challenge.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "pelicula")
@Getter @Setter
public class PeliculaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String imagen;
    
    private String titulo;
    
    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd") 
    private LocalDate fechaCreacion;
    
    private double calificacion;
   
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<PersonajeEntity> personajes;
    
    
}

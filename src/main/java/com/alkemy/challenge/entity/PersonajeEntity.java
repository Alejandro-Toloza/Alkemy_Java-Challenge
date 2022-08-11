
package com.alkemy.challenge.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


/**
 *
 * @author alejandro
 */
@Entity
@Table (name = "personajes")
@Getter
@Setter
@SQLDelete(sql = "UPDATE personajes SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PersonajeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String imagen;
    
    private String nombre;
     
    private int edad;
    
    private double peso;
    
    private String historia;
    
    private boolean deleted = Boolean.FALSE;
    
    @ManyToMany(mappedBy = "personajes")
    private List<PeliculaEntity> peliculasSeries = new ArrayList<>();
 
    public void addPelicula(PeliculaEntity peli){this.peliculasSeries.add(peli);}
    
}

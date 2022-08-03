
package com.alkemy.challenge.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table (name = "personaje")
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
    
    //private boolean deleted = Boolean.FALSE;
    
    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculasSeries = new ArrayList<>();
    
    public void addPais(PeliculaEntity peliserie) {this.peliculasSeries.add(peliserie);}
    public void removePais(PeliculaEntity peliserie) {this.peliculasSeries.remove(peliserie);}
    
    
}
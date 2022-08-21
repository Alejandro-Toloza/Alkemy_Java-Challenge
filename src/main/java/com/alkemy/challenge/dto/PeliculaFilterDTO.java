package com.alkemy.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PeliculaFilterDTO {
    private String titulo;
    private String imagen;
    private Set<Long> personajes;
    private String order;

    public PeliculaFilterDTO(String titulo, String imagen, Set<Long> personajes, String order) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.personajes = personajes;
        this.order = order;
    }

    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

}

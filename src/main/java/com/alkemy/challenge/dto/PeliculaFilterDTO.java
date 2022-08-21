package com.alkemy.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PeliculaFilterDTO {
    private String titulo;
    private String genero;
    private String order;

    public PeliculaFilterDTO(String titulo, String genero,  String order) {
        this.titulo = titulo;
        this.genero = genero;
        this.order = order;
    }

    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

}

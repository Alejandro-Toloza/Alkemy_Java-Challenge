package com.alkemy.challenge.mapper;

import com.alkemy.challenge.dto.GeneroDTO;
import com.alkemy.challenge.entity.GeneroEntity;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTO2Entity(GeneroDTO generoDTO){
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setNombre(generoDTO.getNombre());
        generoEntity.setImagen(generoDTO.getImagen());
        return generoEntity;
    }

    public GeneroDTO generoEntity2DTO(GeneroEntity generoEntity){
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setNombre(generoEntity.getNombre());
        generoDTO.setImagen(generoEntity.getImagen());
        return generoDTO;
    }


}

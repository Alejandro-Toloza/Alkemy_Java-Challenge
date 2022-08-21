package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dto.GeneroDTO;
import com.alkemy.challenge.entity.GeneroEntity;
import com.alkemy.challenge.mapper.GeneroMapper;
import com.alkemy.challenge.repository.GeneroRepository;
import com.alkemy.challenge.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroMapper generoMapper;
    @Autowired
    GeneroRepository generoRepository;

    @Override
    public GeneroDTO save(GeneroDTO dto) {
        GeneroEntity entity = generoMapper.generoDTO2Entity(dto);
        GeneroEntity entitySave = generoRepository.save(entity);
        GeneroDTO dtoSave = generoMapper.generoEntity2DTO(entitySave);
        return dtoSave;
    }
}

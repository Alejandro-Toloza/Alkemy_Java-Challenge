package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.entity.PersonajeEntity;
import com.alkemy.challenge.mapper.PersonajeMapper;
import com.alkemy.challenge.repository.PersonajeRepository;
import com.alkemy.challenge.service.PersonajeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro
 */

@Service
public class PersonajeServiceImpl implements PersonajeService{

    
    @Autowired
    PersonajeMapper personajeMapper;
    @Autowired
    PersonajeRepository personajeRepository;
    
    
    @Override
    public PersonajeDTO save(PersonajeDTO dto) { 
        PersonajeEntity entity = personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity entitySave = personajeRepository.save(entity);
        PersonajeDTO dtoSave = personajeMapper.personajeEntity2DTO(entitySave);
        return dtoSave;   
    }

    
    @Override
    public List<PersonajeDTO> getAllPersonajes() {  
        List<PersonajeEntity> personajes = personajeRepository.findAll();
        List<PersonajeDTO> result = personajeMapper.personajeEntityList2DTOList(personajes);
        return result;        
    }

    @Override
    public void delete(Long id) {
        this.personajeRepository.deleteById(id);
    }

    @Override
    public PersonajeDTO getOne(Long id) {
        
        Optional<PersonajeEntity> entity = personajeRepository.findById(id);
        if(!entity.isPresent()){
            System.out.println("Id no identificado");
        }
        PersonajeEntity entitySave = personajeRepository.save(entity.get());
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(entitySave);
        return result;
        
    }
   
    
 
     

    
}

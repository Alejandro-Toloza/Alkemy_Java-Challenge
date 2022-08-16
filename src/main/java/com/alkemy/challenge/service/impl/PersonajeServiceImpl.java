package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.dto.PersonajeFilterDTO;
import com.alkemy.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.entity.PersonajeEntity;
import com.alkemy.challenge.exception.ParamNotFound;
import com.alkemy.challenge.mapper.PersonajeMapper;
import com.alkemy.challenge.repository.PersonajeRepository;
import com.alkemy.challenge.repository.specification.PersonajeSpecification;
import com.alkemy.challenge.service.PersonajeService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro
 */

@Service
public class PersonajeServiceImpl implements PersonajeService{

    
    
    PersonajeMapper personajeMapper;
    
    PersonajeRepository personajeRepository;
    
    PersonajeSpecification persoSpecification;

    @Autowired
    public PersonajeServiceImpl(PersonajeMapper personajeMapper, PersonajeRepository personajeRepository, PersonajeSpecification persoSpecification) {
        this.personajeMapper = personajeMapper;
        this.personajeRepository = personajeRepository;
        this.persoSpecification = persoSpecification;
    }

   
    @Override
    public PersonajeDTO getDetailsById(Long id){
        Optional<PersonajeEntity> entity = this.personajeRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id no valido");
        }
        PersonajeDTO PersonajeDTO = this.personajeMapper.personajeEntity2DTO(entity.get(), true);
        return PersonajeDTO;
    }

    
    @Override
    public List<PersonajeDTO> getByFilters(String nombre, String imagen, Set<Long> peliculas, String order){
        PersonajeFilterDTO filtersDTO = new PersonajeFilterDTO(nombre, imagen, peliculas, order);
        List<PersonajeEntity> entities = this.personajeRepository.findAll(this.persoSpecification.getByFilters(filtersDTO));
        List<PersonajeDTO> dtos = this.personajeMapper.personajeEntitySet2DTOList(entities, true);
        return dtos;
    }
    
    
    @Override
    public PersonajeDTO save(PersonajeDTO dto) { 
        PersonajeEntity entity = personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity entitySave = personajeRepository.save(entity);
        PersonajeDTO dtoSave = personajeMapper.personajeEntity2DTO(entitySave, false);
        return dtoSave;   
    }

    
    @Override
    public List<PersonajeDTO> getAllPersonajes() {  
        List<PersonajeEntity> personajes = personajeRepository.findAll();
        List<PersonajeDTO> result = personajeMapper.personajeEntitySet2DTOList(personajes, true);
        return result;        
    }

    @Override
    public void delete(Long id) {
        this.personajeRepository.deleteById(id);
    }

    @Override
    public PersonajeDTO update(Long id, PersonajeDTO dto) {
        Optional<PersonajeEntity> entity = personajeRepository.findById(id);
        if(!entity.isPresent()){
            System.out.println("Id no valido");
        }
        personajeMapper.personajeEntityRefreshValues(entity.get(), dto);
        PersonajeEntity entitySave = personajeRepository.save(entity.get());
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(entitySave, true);
        return result;
    }





   
 
   
    
 
     

    
}

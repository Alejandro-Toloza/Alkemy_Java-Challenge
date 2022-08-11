
package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.entity.Mensaje;
import com.alkemy.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.mapper.PeliculaMapper;
import com.alkemy.challenge.repository.PeliculaRepository;
import com.alkemy.challenge.service.PeliculaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro
 */
@Service
public class PeliculaServiceImpl implements PeliculaService{
    
    @Autowired
    PeliculaMapper mapper;
    @Autowired
    PeliculaRepository peliRepo;
    
    public PeliculaDTO save(PeliculaDTO dto){
        
        PeliculaEntity entity = mapper.peliculaDTO2Entity(dto);
        PeliculaEntity saveEntity = peliRepo.save(entity);
        PeliculaDTO result = mapper.peliculaEntity2DTO(saveEntity, false);
        return result;
    }
    
    
    public List<PeliculaDTO> getAllPeliculas() {  
        List<PeliculaEntity> peliculas = peliRepo.findAll();
        List<PeliculaDTO> result = mapper.peliculaEntityList2DTOList(peliculas, false);
        return result;        
    }

    
    public void delete(Long id) {
        this.peliRepo.deleteById(id);
    }


    
    
    
    
 
}

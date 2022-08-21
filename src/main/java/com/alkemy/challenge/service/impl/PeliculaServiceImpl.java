
package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.dto.PeliculaFilterDTO;
import com.alkemy.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.exception.ParamNotFound;
import com.alkemy.challenge.mapper.PeliculaMapper;
import com.alkemy.challenge.repository.PeliculaRepository;
import com.alkemy.challenge.repository.specification.PeliculaSpecification;
import com.alkemy.challenge.service.PeliculaService;
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
public class PeliculaServiceImpl implements PeliculaService{
    
    @Autowired
    PeliculaMapper mapper;
    @Autowired
    PeliculaRepository peliRepo;
    @Autowired
    PeliculaSpecification peliculaSpecification;
    
    public PeliculaDTO save(PeliculaDTO dto){
        
        PeliculaEntity entity = mapper.peliculaDTO2Entity(dto);
        PeliculaEntity saveEntity = peliRepo.save(entity);
        PeliculaDTO result = mapper.peliculaEntity2DTO(saveEntity, false);
        return result;
    }

    public List<PeliculaDTO> getAllPeliculas() {  
        List<PeliculaEntity> peliculas = peliRepo.findAll();
        List<PeliculaDTO> result = mapper.peliculaEntityList2DTOList(peliculas, true);
        return result;        
    }

    public void delete(Long id) {
        this.peliRepo.deleteById(id);
    }

    @Override
    public PeliculaDTO getDetailsById(Long id) {
        Optional<PeliculaEntity> entity = this.peliRepo.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id no valido");
        }
        PeliculaDTO PeliculaDTO = this.mapper.peliculaEntity2DTO(entity.get(), true);
        return PeliculaDTO;
    }

    @Override
    public PeliculaDTO update(Long id, PeliculaDTO dto) {
        Optional<PeliculaEntity> entity = peliRepo.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id no valido");
        }
        mapper.peliculaEntityRefreshValues(entity.get(), dto);
        PeliculaEntity entitySave = peliRepo.save(entity.get());
        PeliculaDTO result = mapper.peliculaEntity2DTO(entitySave, true);
        return result;
    }

    @Override
    public List<PeliculaDTO> getByFilters(String titulo, String imagen, Set<Long> personajes, String order) {
        PeliculaFilterDTO filtersDTO = new PeliculaFilterDTO(titulo, imagen, personajes, order);
        List<PeliculaEntity> entities = this.peliRepo.findAll(this.peliculaSpecification.getByFilters(filtersDTO));
        List<PeliculaDTO> dtos = this.mapper.peliculaEntitySet2DTOList(entities, true);
        return dtos;
    }


}

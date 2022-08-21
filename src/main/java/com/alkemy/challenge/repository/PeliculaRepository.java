package com.alkemy.challenge.repository;

import com.alkemy.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.entity.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author alejandro
 */
@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long>, JpaSpecificationExecutor<PeliculaEntity> {
    List<PeliculaEntity> findAll(Specification<PeliculaEntity> spec);
}

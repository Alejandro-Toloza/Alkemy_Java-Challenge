package com.alkemy.challenge.repository;

import com.alkemy.challenge.entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandro
 */
@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long>{
    
}

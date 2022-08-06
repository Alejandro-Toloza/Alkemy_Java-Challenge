
package com.alkemy.challenge.repository;

import com.alkemy.challenge.entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandro
 */

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long>{
    
}

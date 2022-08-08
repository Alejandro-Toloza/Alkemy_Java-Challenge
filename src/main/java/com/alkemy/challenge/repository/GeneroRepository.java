
package com.alkemy.challenge.repository;

import com.alkemy.challenge.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandro
 */

@Repository
public interface GeneroRepository extends JpaRepository<GeneroEntity, Long>{
    
}


package com.alkemy.challenge.auth.repository;

import com.alkemy.challenge.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alejandro
 */

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserEntity findByUsername(String username);
}

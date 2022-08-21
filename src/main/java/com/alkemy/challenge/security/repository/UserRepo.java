package com.alkemy.challenge.security.repository;

import com.alkemy.challenge.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

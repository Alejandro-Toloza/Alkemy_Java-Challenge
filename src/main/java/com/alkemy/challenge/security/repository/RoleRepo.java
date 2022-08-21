package com.alkemy.challenge.security.repository;

import com.alkemy.challenge.security.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo  extends JpaRepository<Role, Long> {
    Role findByname(String name);
}

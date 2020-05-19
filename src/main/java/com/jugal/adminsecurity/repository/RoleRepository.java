package com.jugal.adminsecurity.repository;

import com.jugal.adminsecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String username);
}

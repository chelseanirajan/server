package com.jugal.adminsecurity.repository;

import com.jugal.adminsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAllByRoles(String username);
}

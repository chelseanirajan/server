package com.jugal.adminsecurity.service;

import com.jugal.adminsecurity.model.Role;
import com.jugal.adminsecurity.repository.RoleRepository;
import com.jugal.adminsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findByRole(String username) {
        return roleRepository.findByName(username);
    }
}
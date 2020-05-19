package com.jugal.adminsecurity.service;

import com.jugal.adminsecurity.model.User;
import com.jugal.adminsecurity.repository.RoleRepository;
import com.jugal.adminsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       // user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }
    @Override
    public User getCurrentUser() {
        return findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

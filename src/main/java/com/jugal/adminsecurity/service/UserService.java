package com.jugal.adminsecurity.service;

import com.jugal.adminsecurity.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    User getCurrentUser();

    List<User> findAll();
}

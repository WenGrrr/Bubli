package com.example.bubli.service;

import com.example.bubli.domain.User;

import java.util.UUID;

public interface UserService {


    User findByUsername(String username);

    User findByEmail (String email);

    User findById(String id);

    User createUser(User user) throws Exception;

    User save(User user);
}

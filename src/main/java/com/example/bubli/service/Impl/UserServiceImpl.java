package com.example.bubli.service.Impl;

import com.example.bubli.domain.User;
import com.example.bubli.repository.ShopCartRepository;
import com.example.bubli.repository.UserRepository;
import com.example.bubli.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ShopCartRepository shopCartRepository;

    public UserServiceImpl(UserRepository userRepository, ShopCartRepository shopCartRepository) {
        this.userRepository = userRepository;
        this.shopCartRepository = shopCartRepository;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public User createUser(User user) throws Exception {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }
}

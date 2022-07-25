package com.example.bubli.repository;

import com.example.bubli.domain.ShopCart;
import com.example.bubli.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, String> {
    
    User findByEmail(String email);

    
}

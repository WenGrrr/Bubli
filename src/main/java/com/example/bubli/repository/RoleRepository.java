package com.example.bubli.repository;

import com.example.bubli.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface RoleRepository extends MongoRepository<Role, String> {
    
    Role findByRole(String role);
}

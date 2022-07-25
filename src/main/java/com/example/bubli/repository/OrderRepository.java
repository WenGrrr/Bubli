package com.example.bubli.repository;

import com.example.bubli.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderRepository extends MongoRepository<Order, String> {
}

package com.example.bubli.repository;

import com.example.bubli.domain.ShopCart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ShopCartRepository extends MongoRepository<ShopCart, String> {
    ShopCart findShopCartById(String id);
}

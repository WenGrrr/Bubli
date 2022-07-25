package com.example.bubli.repository;

import com.example.bubli.domain.CartItem;
import com.example.bubli.domain.Order;
import com.example.bubli.domain.Product;
import com.example.bubli.domain.ShopCart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface CartItemRepository extends MongoRepository<CartItem, String> {
    List<CartItem> findByShopCart(ShopCart shopCart);
    List<CartItem> findByOrder(Order order);

    void deleteAllByProduct(Product product);
}

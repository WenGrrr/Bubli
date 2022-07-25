package com.example.bubli.service;

import com.example.bubli.domain.Order;
import com.example.bubli.domain.ShopCart;
import com.example.bubli.domain.User;

import java.util.UUID;

public interface OrderService {
    Order createOrder(User user);

    Order findById(String id);
}

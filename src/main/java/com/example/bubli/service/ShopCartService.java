package com.example.bubli.service;

import com.example.bubli.domain.ShopCart;
import com.example.bubli.domain.User;

public interface ShopCartService {

    ShopCart updateShoppingCart(ShopCart shopCart);

    ShopCart findShopCartById(String id);
}

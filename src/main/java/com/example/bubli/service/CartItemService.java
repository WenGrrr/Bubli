package com.example.bubli.service;

import com.example.bubli.domain.*;

import java.util.List;

public interface CartItemService {

    List<CartItem> findByShoppingCart(ShopCart shoppingCart);

    CartItem updateCartItem(CartItem cartItem);

    CartItem addProductToCartItem(Product product, User user, int qty);

    CartItem findById(String id);

    void deleteAllByProduct(Product product);

    void removeCartItem(CartItem cartItem);

    CartItem save(CartItem cartItem);

    List<CartItem> findByOrder(Order order);
}

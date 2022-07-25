package com.example.bubli.service.Impl;

import com.example.bubli.domain.*;
import com.example.bubli.repository.CartItemRepository;
import com.example.bubli.service.CartItemService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {


    public CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<CartItem> findByShoppingCart(ShopCart shopCart) {
        return cartItemRepository.findByShopCart(shopCart);
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem addProductToCartItem(Product product, User user, int qty) {
        List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());

        for (CartItem cartItem : cartItemList) {
            if(product.getId() == cartItem.getProduct().getId()) {
                cartItem.setCount(cartItem.getCount()+qty);
                cartItem.setSubtotal(product.getPrice().multiply(new BigDecimal(qty)));
                cartItemRepository.save(cartItem);
                return cartItem;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setShopCart(user.getShoppingCart());
        cartItem.setProduct(product);

        cartItem.setCount(qty);
        cartItem.setSubtotal(product.getPrice().multiply(new BigDecimal(qty)));
        cartItem = cartItemRepository.save(cartItem);

        return cartItem;
    }

    @Override
    public CartItem findById(String id) {
        return cartItemRepository.findById(id).get();
    }

    @Override
    public void deleteAllByProduct(Product product) {
        cartItemRepository.deleteAllByProduct(product);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> findByOrder(Order order) {
        return cartItemRepository.findByOrder(order);
    }
}

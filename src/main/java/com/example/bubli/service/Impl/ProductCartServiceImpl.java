package com.example.bubli.service.Impl;

import com.example.bubli.domain.CartItem;
import com.example.bubli.domain.ShopCart;
import com.example.bubli.domain.User;
import com.example.bubli.repository.ShopCartRepository;
import com.example.bubli.repository.UserRepository;
import com.example.bubli.service.CartItemService;
import com.example.bubli.service.ShopCartService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class ProductCartServiceImpl implements ShopCartService {

    private ShopCartRepository shopCartRepository;

    private CartItemService cartItemService;
    private UserRepository userRepository;

    public ProductCartServiceImpl(ShopCartRepository shopCartRepository, CartItemService cartItemService) {
        this.shopCartRepository = shopCartRepository;
        this.cartItemService = cartItemService;
    }

    @Override
    public ShopCart updateShoppingCart(ShopCart shopCart) {
        BigDecimal cartTotal = new BigDecimal(0);

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shopCart);

        for (CartItem cartItem : cartItemList) {
            if(cartItem.getProduct().getCount() > 0) {
                cartItemService.updateCartItem(cartItem);
                cartTotal = cartTotal.add(cartItem.getSubtotal());
            }
        }

        shopCart.setGrandTotal(cartTotal);

        shopCartRepository.save(shopCart);

        return shopCart;
    }

    @Override
    public ShopCart findShopCartById(String id) {
        return shopCartRepository.findShopCartById(id);
    }
}

package com.example.bubli.service.Impl;

import com.example.bubli.domain.*;
import com.example.bubli.repository.OrderRepository;
import com.example.bubli.service.CartItemService;
import com.example.bubli.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartItemService cartItemService;

    public OrderServiceImpl(OrderRepository orderRepository, CartItemService cartItemService) {
        this.orderRepository = orderRepository;
        this.cartItemService = cartItemService;
    }

    @Override
    public Order createOrder(User user) {
        ShopCart shoppingCart = user.getShoppingCart();
        Order order = new Order();
        order.setOrderStatus("created");

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        for(CartItem cartItem : cartItemList) {
            Product product = cartItem.getProduct();
            cartItem.setOrder(order);
            product.setCount(product.getCount() - cartItem.getCount());
        }

        order.setCartItemList(cartItemList);
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setOrderTotal(shoppingCart.getGrandTotal());
        order.setUser(user);
        order = orderRepository.save(order);

        return order;
    }

    @Override
    public Order findById(String id) {
        return null;
    }
}

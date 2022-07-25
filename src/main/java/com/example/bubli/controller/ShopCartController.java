package com.example.bubli.controller;

import com.example.bubli.domain.*;
import com.example.bubli.service.CartItemService;
import com.example.bubli.service.Impl.CustomUserDetailsService;
import com.example.bubli.service.OrderService;
import com.example.bubli.service.ShopCartService;
import com.example.bubli.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShopCartController {
    private final ShopCartService shopCartService;
    private final CartItemService cartItemService;
    private final ProductsService productsService;
    private final CustomUserDetailsService userService;
    private final OrderService orderService;

    public ShopCartController(ShopCartService shopCartService, CartItemService cartItemService, ProductsService productsService, CustomUserDetailsService userService, OrderService orderService) {
        this.shopCartService = shopCartService;
        this.cartItemService = cartItemService;
        this.productsService = productsService;
        this.userService = userService;
        this.orderService = orderService;
    }


    @RequestMapping("/shopcart")
    public ModelAndView shopCart(@Validated User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the username provided");
        }
        ShopCart shopCart = new ShopCart();
        user.setShoppingCart(shopCart);
        shopCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shopCart);
        shopCartService.updateShoppingCart(shopCart);
        modelAndView.addObject("cartItemList", cartItemList);
        modelAndView.addObject("shopcart", shopCart);
        System.out.println(user.getFullname());

        return modelAndView;
    }
    @RequestMapping("/updateCartItem")
    public String updateShoppingCart(@ModelAttribute("id") String cartItemId, @ModelAttribute("count") int count) {
        CartItem cartItem = cartItemService.findById(cartItemId);
        cartItem.setCount(count);
        cartItemService.updateCartItem(cartItem);

        return "forward:/shopcart";
    }
    @PostMapping("/shopcart/addcartItem")
    public String addItem(@ModelAttribute("id") String id, @ModelAttribute("count") int count, @Validated User user, BindingResult bindingResult){
        Product product = productsService.getProductByID(id);
        cartItemService.addProductToCartItem(product, user, count);
        System.out.println(user.getFullname());
        return "forward:/shopcart";
    }
    @PostMapping("/shopcart/deleteItem")
    public String deleteItem(@ModelAttribute("id") String uuid, @Validated User user, BindingResult bindingResult){
        CartItem cartItem = cartItemService.findById(uuid);
        cartItemService.removeCartItem(cartItem);
        System.out.println(user.getFullname());
        return "forward:/shopcart";
    }

    @PostMapping("/shopcart/orderset")
    public String orderSet(@ModelAttribute("id") String id, @Validated User user, BindingResult bindingResult){

        return "forward:/shopcart";
    }
}

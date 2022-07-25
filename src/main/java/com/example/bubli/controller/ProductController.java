package com.example.bubli.controller;

import com.example.bubli.domain.Product;
import com.example.bubli.service.CartItemService;
import com.example.bubli.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
public class ProductController {
    private final ProductsService productService;

    private final CartItemService cartItemService;

    public ProductController(ProductsService productService, CartItemService cartItemService) {
        this.productService = productService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("dashboard/product/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", productService.getProductByID(id));
        return "product";
    }


    @PostMapping("dashboard/create")
    public String createProduct(String name, String price, int count){
        Product product = new Product();
        product.setName(name);
        product.setCount(count);
        product.setPrice(BigDecimal.valueOf(Double.valueOf(price)));
        productService.createProduct(product);
        return "redirect:/dashboard";
    }

    @PostMapping("dashboard/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id){
        cartItemService.deleteAllByProduct(productService.getProductByID(id));
        productService.deleteProduct(id);

        return "redirect:/dashboard";
    }
    @PostMapping("dashboard/clear")
    public String deleteAllProducts(){
        productService.clearProducts();
        return "redirect:/dashboard";
    }
}

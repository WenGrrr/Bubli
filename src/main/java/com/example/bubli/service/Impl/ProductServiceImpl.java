package com.example.bubli.service.Impl;

import com.example.bubli.domain.Product;
import com.example.bubli.repository.CartItemRepository;
import com.example.bubli.repository.ProductRepository;
import com.example.bubli.repository.ShopCartRepository;
import com.example.bubli.service.ProductsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductsService {


    private ProductRepository productRepository;
    private CartItemRepository cartItemRepository;
    private ShopCartRepository shopCartRepository;

    public ProductServiceImpl(ProductRepository productsRepository, CartItemRepository cartItemRepository, ShopCartRepository shopCartRepository) {
        this.productRepository = productsRepository;
        this.cartItemRepository = cartItemRepository;
        this.shopCartRepository = shopCartRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductByID(String uuid){
        return  productRepository.findById(uuid).get();
    }
    public void createProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(String uuid){
        productRepository.delete(getProductByID(uuid));
    }
    public void clearProducts(){
        productRepository.deleteAll();
        cartItemRepository.deleteAll();
    }
}

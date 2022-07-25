package com.example.bubli.service;

import com.example.bubli.domain.Product;

import java.util.List;
import java.util.UUID;


public interface ProductsService {
    List<Product> getAllProducts();
    Product getProductByID(String uuid);
    void createProduct(Product product);
    void deleteProduct(String uuid);
    void clearProducts();

}

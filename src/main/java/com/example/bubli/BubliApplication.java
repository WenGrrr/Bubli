package com.example.bubli;

import com.example.bubli.domain.*;
import com.example.bubli.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
public class BubliApplication {

    public static void main(String[] args) {
        SpringApplication.run(BubliApplication.class, args);
    }
    @Bean
    CommandLineRunner init(RoleRepository roleRepository,
                           CartItemRepository cartItemRepository,
                           UserRepository userRepository,
                           ProductRepository productRepository,
                           ShopCartRepository shopCartRepository, OrderRepository orderRepository) {

        return args -> {

            Role adminRole = roleRepository.findByRole("ADMIN");
            if (adminRole == null) {
                Role newAdminRole = new Role();
                newAdminRole.setRole("ADMIN");
                roleRepository.save(newAdminRole);
            }

            Role userRole = roleRepository.findByRole("USER");
            if (userRole == null) {
                Role newUserRole = new Role();
                newUserRole.setRole("USER");
                roleRepository.save(newUserRole);
            }
            var list = orderRepository.findAll();
            for (Order part:list) {
                System.out.println(part.getCartItemList());
                System.out.println(part.getOrderTotal());;
            }
        };

    }
}

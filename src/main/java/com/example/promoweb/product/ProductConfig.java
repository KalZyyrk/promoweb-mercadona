package com.example.promoweb.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
          Product product = new Product(1L, "Cerise", "petit fruit rouge", 1.99, "image de cerise", "fruit");

          repository.save(product);
        };
    }
}

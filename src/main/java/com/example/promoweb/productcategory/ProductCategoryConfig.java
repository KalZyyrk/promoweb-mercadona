package com.example.promoweb.productcategory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductCategoryConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductCategoryRepository repository) {
        return args -> {
            ProductCategory category = new ProductCategory(1L, "fruit");

            repository.save(category);
        };
    }
}

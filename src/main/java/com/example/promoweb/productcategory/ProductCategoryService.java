package com.example.promoweb.productcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository repository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    public List<ProductCategory> getAllCategorie () {
        return repository.findAll();
    }
    public void addNewCategory(ProductCategory category) {
        repository.save(category);
    }

}

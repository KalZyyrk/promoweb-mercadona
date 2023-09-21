package com.example.promoweb.product;

import com.example.promoweb.productcategory.ProductCategory;
import com.example.promoweb.productcategory.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductCategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        List<ProductCategory> categoryList = categoryService.getAllCategory();

        if (categoryList.contains(product.getCategory())) {
            categoryService.addNewCategory(product.getCategory());
        }

        productRepository.save(product);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}

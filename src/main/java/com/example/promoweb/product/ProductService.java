package com.example.promoweb.product;

import com.example.promoweb.productcategory.ProductCategory;
import com.example.promoweb.productcategory.ProductCategoryService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        List<ProductCategory> categoryList = categoryService.getAllCategorie();

        if (this.getAllProduct().stream().anyMatch(p -> p.getName().equals(product.getName()))){
            throw new EntityExistsException("Product Already register");
        }

        if (categoryList.stream().noneMatch(c -> c.getName().equals(product.getCategory().getName()))) {
            categoryService.addNewCategory(product.getCategory());
        }
        product.setCategory(categoryList.stream()
                .filter(c-> c.getName().equals(product.getCategory().getName()))
                .findFirst().orElse(product.getCategory()));

        productRepository.save(product);
    }

    public void deleteProduct(long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Item dont exist");
        } else {
            productRepository.deleteById(id);
        }
    }
}

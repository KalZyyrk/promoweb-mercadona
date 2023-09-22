package com.example.promoweb.promotion;

import com.example.promoweb.product.Product;
import com.example.promoweb.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {
    private PromotionRepository repository;
    private ProductRepository productRepository;
    @Autowired
    public PromotionService(PromotionRepository repository) {
        this.repository = repository;
    }

    public List<Promotion> getAllPromotion() {
        return repository.findAll();
    }

    public void createPromotionforArticle(Long id, Promotion promotion) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresentOrElse(promotion::setProduct,() -> {throw new EntityNotFoundException("This product doesn't exist");});

        repository.save(promotion);
    }

    public Promotion getPromotionFromProduct (Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new EntityNotFoundException("this product doesn't exist");
        }

        return repository.findByProduct(id);
    }

}

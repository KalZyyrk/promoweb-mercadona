package com.example.promoweb.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/promotion")
public class PromotionController {

    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public List<Promotion> getAllPromotion() {
        return promotionService.getAllPromotion();
    }

    @PostMapping(value = "/{id}")
    public void addPromotionToProduct(@PathVariable("id") Long id, @RequestBody Promotion promotion) {

    }

    @GetMapping(value = "/{id}")
    public Promotion getPromotionFromProduct(@PathVariable("id") Long id) {
        return promotionService.getPromotionFromProduct(id);
    }
}

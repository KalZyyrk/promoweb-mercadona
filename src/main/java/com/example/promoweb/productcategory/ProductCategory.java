package com.example.promoweb.productcategory;

import com.example.promoweb.product.Product;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "category")
public class ProductCategory {

    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Long category_id;
    private String name;

    public ProductCategory() {
    }

    public ProductCategory(Long category_id, String name) {
        this.category_id = category_id;
        this.name = name;
    }

    public ProductCategory(String name) {
        this.name = name;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

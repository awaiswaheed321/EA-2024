package com.example.demo;

import com.example.demo.entity.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;

public class ProductSpecifications {
    public static Specification<Product> priceBetween(Double priceMin, Double priceMax) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), 50, 300);
    }

    public static Specification<Product> categoryIn(String... categories) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.or(
                Arrays.stream(categories)
                        .map(category -> criteriaBuilder.equal(root.get("category"), category))
                        .toArray(Predicate[]::new)
        );
    }
}

package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("SELECT p from Product p where p.manufacturer.country = 'Germany' AND p.price > 100")
    List<Product> getProductsMadeInGermanyWithPriceOver100();

    @Query("select p from Product p where p.category = :category AND p.price >= :minPrice AND p.price <= :maxPrice AND p.name like :name")
    List<Product> getProductByCategoryAndPriceRangeAndNameIn(String category, Double minPrice, Double maxPrice, String name);

    List<Product> findByCategoryOrderByPriceDesc(String category);

    List<Product> getProductByManufacturerName(String manufacturerName);
}

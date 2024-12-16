package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    @Query("SELECT o from Order o JOIN o.products p where o.customer.name LIKE 'A%' AND  p.category = 'Electronics'")
    List<Order> getOrderByCustomerWithNameAAndCategory();


    List<Order> getByProductsContaining(Product product);
}

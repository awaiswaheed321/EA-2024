package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DataPopulationService {

    private final EntityManager entityManager;

    public DataPopulationService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void populateData() {
        // Create Manufacturers
        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setName("TechCorp");
        manufacturer1.setCountry("USA");

        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setName("HomeGoods Inc.");
        manufacturer2.setCountry("Germany");

        Manufacturer manufacturer3 = new Manufacturer();
        manufacturer3.setName("FashionCo");
        manufacturer3.setCountry("Italy");

        // Persist Manufacturers
        entityManager.persist(manufacturer1);
        entityManager.persist(manufacturer2);
        entityManager.persist(manufacturer3);

        // Create Products
        Product product1 = new Product();
        product1.setName("Smartphone");
        product1.setPrice(300.0);
        product1.setCategory("Electronics");
        product1.setManufacturer(manufacturer1);

        Product product2 = new Product();
        product2.setName("Coffee Maker");
        product2.setPrice(120.0);
        product2.setCategory("Home Appliances");
        product2.setManufacturer(manufacturer2);

        Product product3 = new Product();
        product3.setName("T-shirt");
        product3.setPrice(25.0);
        product3.setCategory("Clothing");
        product3.setManufacturer(manufacturer3);

        Product product4 = new Product();
        product4.setName("Laptop");
        product4.setPrice(950.0);
        product4.setCategory("Electronics");
        product4.setManufacturer(manufacturer1);

        Product product5 = new Product();
        product5.setName("Blender");
        product5.setPrice(50.0);
        product5.setCategory("Home Appliances");
        product5.setManufacturer(manufacturer2);

        // Persist Products
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(product3);
        entityManager.persist(product4);
        entityManager.persist(product5);

        // Create Customers
        Customer customer1 = new Customer();
        customer1.setName("Alice");
        customer1.setEmail("alice@example.com");

        Customer customer2 = new Customer();
        customer2.setName("Bob");
        customer2.setEmail("bob@example.com");

        // Persist Customers
        entityManager.persist(customer1);
        entityManager.persist(customer2);

        // Create Orders for Alice
        Order order1 = new Order();
        order1.setOrderDate(LocalDate.now());
        order1.setCustomer(customer1);
        order1.setProducts(Arrays.asList(product1, product2)); // Alice orders Smartphone and Coffee Maker
        entityManager.persist(order1);

        Order order2 = new Order();
        order2.setOrderDate(LocalDate.now());
        order2.setCustomer(customer1);
        order2.setProducts(Arrays.asList(product3, product4)); // Alice orders T-shirt and Laptop
        entityManager.persist(order2);

        // Create Orders for Bob
        Order order3 = new Order();
        order3.setOrderDate(LocalDate.now());
        order3.setCustomer(customer2);
        order3.setProducts(Arrays.asList(product2, product5)); // Bob orders Coffee Maker and Blender
        entityManager.persist(order3);

        Order order4 = new Order();
        order4.setOrderDate(LocalDate.now());
        order4.setCustomer(customer2);
        order4.setProducts(Arrays.asList(product4, product1)); // Bob orders Laptop and Smartphone
        entityManager.persist(order4);
    }
}


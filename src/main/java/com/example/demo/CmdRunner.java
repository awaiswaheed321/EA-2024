package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CmdRunner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    private final DataPopulationService dataPopulationService;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final Producer producer;

    public CmdRunner(DataPopulationService dataPopulationService, ProductRepository productRepository,
                     OrderRepository orderRepository, CustomerRepository customerRepository, Producer producer) {
        this.dataPopulationService = dataPopulationService;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
//        dataPopulationService.populateData();
//        runQueries();
//        cqQ1();

//        cqQ2();
//        cqQ3();
//        cqQ4();
//        producer.send();
//            cqQ5();
//        cqQ6();
//        cqQ7();
//        cqQ8();

        cqQ9();

//        System.out.println(cqQ10("Clothing"));
    }

    public Double cqQ10(String category) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Double> query = criteriaBuilder.createQuery(Double.class);
        Root<Product> root = query.from(Product.class);

        // Filter by category
        Predicate categoryPredicate = criteriaBuilder.equal(root.get("category"), category);

        // Select max price
        Expression<Double> maxPrice = criteriaBuilder.max(root.get("price"));
        query.select(maxPrice).where(categoryPredicate);

        return entityManager.createQuery(query).getSingleResult();
    }


    public void cqQ9() {
        Specification<Customer> specification = (root, query, criteriaBuilder) -> {
            // Subquery to find orders with 2 or more products
            Subquery<Long> subquery = query.subquery(Long.class);
            Root<Order> orderRoot = subquery.from(Order.class);
            Join<Order, Product> productJoin = orderRoot.join("products", JoinType.LEFT);

            // Group by order ID and having count of products >= 2
            subquery.select(orderRoot.get("customer").get("id"))
                    .groupBy(orderRoot.get("id"))
                    .having(criteriaBuilder.ge(criteriaBuilder.count(productJoin), 2)); // Greater than or equal to 2

            // Match customers whose IDs are in the subquery
            return criteriaBuilder.in(root.get("id")).value(subquery);
        };

        List<Customer> customers = customerRepository.findAll(specification);

        customers.forEach(order -> System.out.println("Order: " + order));
    }

    public void cqQ8() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Double> query = criteriaBuilder.createQuery(Double.class);
        Root<Product> root = query.from(Product.class);
        Predicate categoryPredicate = criteriaBuilder.equal(root.get("category"), "Home Appliances");
        Expression<Double> avg = criteriaBuilder.avg(root.get("price"));
        query.select(avg).where(categoryPredicate);

        Double res = entityManager.createQuery(query).getSingleResult();
        System.out.println("Avg: " + res);
    }

    public void cqQ7() {
        Specification<Order> specs = Specification.where(null);

        specs = specs.and(((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("orderDate"),
                LocalDate.now().minusMonths(1), LocalDate.now())));

        specs = specs.and(((root, query, criteriaBuilder) -> {
            Join<Order, Product> productJoin = root.join("products");
            return productJoin.get("category").in("Electronics", "Clothing");
        }));

        orderRepository.findAll(specs).forEach(System.out::println);
    }

    public void cqQ6() {
        Specification<Product> specs = Specification.where(null);

        specs = specs.and(((root, query, criteriaBuilder) -> {
            Join<Product, Manufacturer> manufacturerJoin = root.join("manufacturer");
            return criteriaBuilder.equal(manufacturerJoin.get("name"), "TechCorp");
        }));

        specs.and(((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), 50, 300)));

        productRepository.findAll(specs).forEach(System.out::println);
    }

    public void cqQ5() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // Create a CriteriaQuery for the desired result (Tuple: customer ID and product count)
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Customer> root = query.from(Customer.class);
        Join<Customer, Order> orderJoin = root.join("orders");
        Join<Order, Product> productJoin = orderJoin.join("products");
        Predicate namePredicate = criteriaBuilder.equal(root.get("name"), "Bob");

        Expression<Long> orderProductsPriceSum = criteriaBuilder.sum(productJoin.get("price"));

        query.multiselect(root.get("name"), orderProductsPriceSum).where(namePredicate);
        List<Tuple> results = entityManager.createQuery(query).getResultList();
        for (Tuple tuple : results) {
            String customerId = tuple.get(0, String.class); // First element is customer ID
            Double oSum = tuple.get(1, Double.class); // Second element is product count
            System.out.println("Customer ID: " + customerId + ", Total Products Ordered: " + oSum);
        }
    }

    public void cqQ4() {
        // Create a CriteriaBuilder instance
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // Create a CriteriaQuery for the desired result (Tuple: customer ID and product count)
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);

        // Create the root for the Order entity
        Root<Order> root = query.from(Order.class);

        // Join with the products in the order
        Join<Order, Product> productJoin = root.join("products", JoinType.LEFT);

        // Group by the customer
        query.groupBy(root.get("customer").get("id"));

        // Count the products for each order
        Expression<Long> productCount = criteriaBuilder.count(productJoin);

        // Select the customer ID and the total count of products
        query.multiselect(root.get("customer").get("id"), productCount);

        // Execute the query using the EntityManager
        List<Tuple> results = entityManager.createQuery(query).getResultList();

        // Process the results
        for (Tuple tuple : results) {
            Long customerId = tuple.get(0, Long.class); // First element is customer ID
            Long pCount = tuple.get(1, Long.class); // Second element is product count
            System.out.println("Customer ID: " + customerId + ", Total Products Ordered: " + pCount);
        }
    }


    public void cqQ3() {
        Specification<Customer> specs = Specification.where(null);

        specs = specs.and(((root, query, criteriaBuilder) -> {
            Join<Customer, Order> orderJoin = root.join("orders");
            Join<Order, Product> productJoin = orderJoin.join("products");
            return criteriaBuilder.greaterThan(productJoin.get("price"), 100);
        }));

        customerRepository.findAll(specs).forEach(System.out::println);
    }

    public void cqQ2() {
        Specification<Order> specs = Specification.where(null);
        specs = specs.and(((root, query, criteriaBuilder) -> {
            Join<Order, Customer> customerJoin = root.join("customer");
            return criteriaBuilder.equal(customerJoin.get("name"), "Alice");
        }));

        specs = specs.and(((root, query, criteriaBuilder) -> {
            Join<Order, Product> productJoin = root.join("products");
            return criteriaBuilder.equal(productJoin.get("category"), "Electronics");
        }));

        orderRepository.findAll(specs).forEach(System.out::println);
    }

    public void cqQ1() {
        Specification<Product> specs = Specification.where(null);
        specs = specs.and((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), 50, 300));
        specs = specs.and((root, query, criteriaBuilder) -> root.get("category").in("Home Appliances"));
        List<Product> p = productRepository.findAll(specs);
        p.forEach(System.out::println);
    }

    public void runQueries() throws Exception {
//        List<Product> productsMadeInGermany = productRepository.getProductsMadeInGermanyWithPriceOver100();
//        productsMadeInGermany.forEach(System.out::println);

        List<Order> orders = orderRepository.getOrderByCustomerWithNameAAndCategory();
        orders.forEach(System.out::println);

    }

}

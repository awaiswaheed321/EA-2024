package edu.miu.ea.springbeans;

import edu.miu.ea.IdGenerator;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements Vehicle, InitializingBean, DisposableBean {
    private final Integer id;

    @PreDestroy
    public void preDestroy() {
        System.out.println("Car Pre Destroy: " + id);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Disposable Car: " + id);
    }

    public void destroyCar() {
        System.out.println("Car Destroy from XML: " + id);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct for Car: " + id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean for Car: " + id);
    }

    public void init() {
        System.out.println("Init for Car: " + id);
    }
    
    public Car() {
        super();
        this.id = IdGenerator.getId();
    }

    @Override
    public void move() {
        System.out.println("Car is moving at 50 MPH. ID: " + id);
    }
}

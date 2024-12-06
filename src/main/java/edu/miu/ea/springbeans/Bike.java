package edu.miu.ea.springbeans;

import edu.miu.ea.IdGenerator;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bike implements Vehicle, InitializingBean, DisposableBean {
    private final Integer id;

    @PreDestroy
    public void preDestroy() {
        System.out.println("Bike Pre Destroy: " + id);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Disposable Bike: " + id);
    }

    public void destroyBike() {
        System.out.println("Bike Destroy from XML: " + id);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct for Bike: " + id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean for Bike: " + id);
    }

    public void init() {
        System.out.println("Init for Bike: " + id);
    }

    public Bike() {
        super();
        id = IdGenerator.getId();
    }

    @Override
    public void move() {
        System.out.println("Bike is moving at 10 MPH. ID: " + id);
    }
}

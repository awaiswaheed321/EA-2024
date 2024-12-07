package edu.miu.ea.config;

import edu.miu.ea.aspect.Task2Aspect;
import edu.miu.ea.springbeans.*;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public Task2Aspect gameAspect() {
        return new Task2Aspect();
    }

    @Bean
    public BeanCounter beanCounter() {
        return new BeanCounter();
    }

    @Bean
    public Bike bike() {
        return new Bike();
    }

    @Bean
    public Car car() {
        return new Car();
    }

    @Bean(name = "carGameProxy")
    public ProxyFactoryBean carGame() {
        ProxyFactoryBean proxy = new ProxyFactoryBean();
        proxy.setTarget(new Game(car()));
        proxy.setInterceptorNames("gameAspect");
        return proxy;
    }

    @Bean(name = "bikeGameProxy")
    public ProxyFactoryBean bikeGame() {
        ProxyFactoryBean proxy = new ProxyFactoryBean();
        proxy.setTarget(new Game(bike()));
        proxy.setInterceptorNames("gameAspect");
        return proxy;
    }

//    @Bean(name = "carGame")
//    public Game carGame() {
//        return new Game(car());
//    }
//
//    @Bean(name = "bikeGame")
//    public Game bikeGame() {
//        return new Game(bike());
//    }
//
//    @Bean(name = "carGameProxy")
//    public ProxyFactoryBean carGameProxy() {
//        ProxyFactoryBean proxy = new ProxyFactoryBean();
//        proxy.setTarget(carGame());
//        proxy.setInterceptorNames("gameAspect");
//        return proxy;
//    }
//
//    @Bean(name = "bikeGameProxy")
//    public ProxyFactoryBean bikeGameProxy() {
//        ProxyFactoryBean proxy = new ProxyFactoryBean();
//        proxy.setTarget(bikeGame());
//        proxy.setInterceptorNames("gameAspect");
//        return proxy;
//    }
}

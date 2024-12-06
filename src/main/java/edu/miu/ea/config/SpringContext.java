package edu.miu.ea.config;

import edu.miu.ea.springbeans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringContext {
    @Bean
    public static PostProcessor postProcessor() {
        return new PostProcessor();
    }

    @Bean(name = "bike", initMethod = "init", destroyMethod = "destroyBike")
    @Scope(scopeName = "prototype")
    public Bike getBike() {
        return new Bike();
    }

    @Bean(name = "car",initMethod = "init", destroyMethod = "destroyCar")
    @Scope(scopeName = "prototype")
    public Car getCar() {
        return new Car();
    }

    @Bean(name = "bikeGame")
    public Game getBikeGame() {
        return new Game(getBike()) {
            @Override
            public Vehicle getVehicle() {
                return getBike();
            }
        };
    }

    @Bean(name = "carGame")
    public Game getCarGame() {
        return new Game(getCar()) {
            @Override
            public Vehicle getVehicle() {
                return getCar();
            }
        };
    }
}

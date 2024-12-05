package edu.miu.ea.config;

import edu.miu.ea.springbeans.Bike;
import edu.miu.ea.springbeans.Car;
import edu.miu.ea.springbeans.Game;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContext {
    @Bean(name = "bike")
    public Bike getBike() {
        return new Bike();
    }

    @Bean(name = "car")
    public Car getCar() {
        return new Car();
    }

    @Bean(name = "bikeGame")
    public Game getBikeGame() {
        return new Game(getBike());
    }

    @Bean(name = "carGame")
    public Game getCarGame() {
        return new Game(getCar());
    }
}

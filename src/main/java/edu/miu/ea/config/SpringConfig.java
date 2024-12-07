package edu.miu.ea.config;

import edu.miu.ea.springbeans.Bike;
import edu.miu.ea.springbeans.Car;
import edu.miu.ea.springbeans.Game;
import edu.miu.ea.springbeans.Vehicle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public Bike bike() {
        return new Bike();
    }

    @Bean
    public Car car() {
        return new Car();
    }

    @Bean(name = "carGame")
    public Game getCarGame(@Qualifier("car") Vehicle vehicle) {
        return new Game(vehicle);
    }

    @Bean(name = "bikeGame")
    public Game getBikeGame(@Qualifier("bike") Vehicle vehicle) {
        return new Game(vehicle);
    }
}

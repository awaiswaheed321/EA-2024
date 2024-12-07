package edu.miu.ea.config;

import edu.miu.ea.springbeans.Bike;
import edu.miu.ea.springbeans.Car;
import edu.miu.ea.springbeans.Game;
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

    @Bean
    public Game getGame() {
        return new Game() {
            @Override
            public Car getCar() {
                return car();
            }

            @Override
            public Bike getBike() {
                return bike();
            }
        };
    }
}

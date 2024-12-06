package edu.miu.ea.springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class Game {
    final Vehicle car;
    final Vehicle bike;

    @Autowired
    public Game(Car car, Bike bike) {
        this.car = car;
        this.bike = bike;
    }

    public void play() {
        System.out.println("Autowired Car and Bike");
        car.move();
        bike.move();

        System.out.println("\nLookup Vehicles");
        Car car1 = getCar();
        Bike bike1 = getBike();
        car1.move();
        bike1.move();
    }

    @Lookup
    abstract Car getCar();

    @Lookup
    abstract Bike getBike();
}

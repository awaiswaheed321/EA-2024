package edu.miu.ea.springbeans;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class Game {
    Vehicle car;
    Vehicle bike;

    public Game() {
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public void play() {
        System.out.println("Autowired Vehicles");
        car.move();
        bike.move();

        System.out.println("\nLookup Vehicles");
        Car car1 = getCar();
        Bike bike1 = getBike();
        car1.move();
        bike1.move();
    }

    @Lookup
    abstract public Car getCar();

    @Lookup
    abstract public Bike getBike();
}

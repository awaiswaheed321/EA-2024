package edu.miu.ea.springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;

public class Game {
    Vehicle vehicle;

    public Game(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void play() {
        System.out.println("Game Started...");
        vehicle.move();
        System.out.println("Game Finished...");
    }
}

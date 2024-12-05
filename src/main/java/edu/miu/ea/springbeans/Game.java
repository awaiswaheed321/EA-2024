package edu.miu.ea.springbeans;

public class Game {
    private Vehicle vehicle;

    public Game(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void play() {
        vehicle.move();
    }
}

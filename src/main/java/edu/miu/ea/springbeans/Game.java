package edu.miu.ea.springbeans;

public abstract class Game {
    private Vehicle vehicle;

    public Game(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void play() {
        vehicle.move();
    }

    abstract public Vehicle getVehicle();
}

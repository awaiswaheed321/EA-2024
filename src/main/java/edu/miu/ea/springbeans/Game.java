package edu.miu.ea.springbeans;

public class Game {
    private final Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Game(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void play() {
        System.out.println("Game Started...");
        vehicle.move();
        System.out.println("Game Finished...");
    }
}

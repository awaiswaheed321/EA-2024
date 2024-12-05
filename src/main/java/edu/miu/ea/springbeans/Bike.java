package edu.miu.ea.springbeans;

public class Bike implements Vehicle {
    @Override
    public void move() {
        System.out.println("Bike is moving at 10 MPH.");
    }
}

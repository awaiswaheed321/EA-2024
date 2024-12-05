package edu.miu.ea.springbeans;

public class Car implements Vehicle {

    @Override
    public void move() {
        System.out.println("Car is moving at 50 MPH.");
    }
}

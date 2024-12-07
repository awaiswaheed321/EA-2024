package edu.miu.ea.springbeans;

import java.util.UUID;

public class Car implements Vehicle {
    private final String id = UUID.randomUUID().toString();

    @Override
    public void move() {
        System.out.println("Car: " + id + " is moving.");
    }
}

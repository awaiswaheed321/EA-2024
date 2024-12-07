package edu.miu.ea.springbeans;

import java.util.UUID;

public class Bike implements Vehicle {
    private final String id = UUID.randomUUID().toString();

    @Override
    public void move() {
        System.out.println("Bike: " + id + " is moving.");
    }
}

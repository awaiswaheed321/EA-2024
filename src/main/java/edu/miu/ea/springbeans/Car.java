package edu.miu.ea.springbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(scopeName = "prototype")
public class Car implements Vehicle {
    private final String id = UUID.randomUUID().toString();
    @Override
    public void move() {
        System.out.println("Car: " + id);
    }
}

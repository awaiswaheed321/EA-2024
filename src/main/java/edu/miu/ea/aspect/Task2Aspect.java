package edu.miu.ea.aspect;

import edu.miu.ea.springbeans.Bike;
import edu.miu.ea.springbeans.Game;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class Task2Aspect implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        Game game = (Game) target;
        if(game.getVehicle() instanceof Bike) {
            System.out.println("Aspect says Bike is moving");
        } else {
            System.out.println("Aspect says Car is moving");
        }
    }
}

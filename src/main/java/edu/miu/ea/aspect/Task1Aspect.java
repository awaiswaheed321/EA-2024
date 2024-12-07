package edu.miu.ea.aspect;


import edu.miu.ea.springbeans.Car;
import edu.miu.ea.springbeans.Game;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Task1Aspect {

    @Pointcut("execution (* edu.miu.ea.springbeans.Game.play())")
    public void executionAroundPlay(){}

    @Around("executionAroundPlay()")
    public void aroundPlay(ProceedingJoinPoint joinPoint) throws Throwable {
        Game game = (Game) joinPoint.getTarget();
        if(game.getVehicle() instanceof Car) {
            joinPoint.proceed();
        } else {
            System.out.println("Can not play bike Game");
        }
    }
}

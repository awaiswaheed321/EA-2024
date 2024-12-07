package edu.miu.ea;

import edu.miu.ea.config.SpringConfig;
import edu.miu.ea.springbeans.BeanCounter;
import edu.miu.ea.springbeans.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running with Java based Configuration.\nAdded UUID to Car and Bike to distinguish objects" +
                ".\n");
        ApplicationContext javaBasedContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Game carGame = javaBasedContext.getBean("carGameProxy", Game.class);
        carGame.play();
        Game bikeGame = javaBasedContext.getBean("bikeGameProxy", Game.class);
        bikeGame.play();

        BeanCounter beanCounter = javaBasedContext.getBean("beanCounter", BeanCounter.class);
        System.out.println("Total Beans Created: " + beanCounter.getCounter());
    }
}

package edu.miu.ea;

import edu.miu.ea.springbeans.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running with XML based Configuration.\nAdded UUID to Car and Bike to distinguish objects.\n");
        ApplicationContext xmlBasedContext = new ClassPathXmlApplicationContext("config.xml");
        Game game = xmlBasedContext.getBean(Game.class);
       game.play();
    }
}

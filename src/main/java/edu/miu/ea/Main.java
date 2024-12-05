package edu.miu.ea;

import edu.miu.ea.config.SpringContext;
import edu.miu.ea.springbeans.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running with Java based Configuration...");
        ApplicationContext javaBasedContext = new AnnotationConfigApplicationContext(SpringContext.class);
        Game javaCarGame = javaBasedContext.getBean("carGame", Game.class);
        Game javaBikeGame = javaBasedContext.getBean("bikeGame", Game.class);
        javaCarGame.play();
        javaBikeGame.play();

        System.out.println("\n\nRunning with XML based Configuration");
        ApplicationContext xmlBasedContext = new ClassPathXmlApplicationContext("config.xml");
        Game xmlCarGame = xmlBasedContext.getBean("carGame", Game.class);
        Game xmlBikeGame = xmlBasedContext.getBean("bikeGame", Game.class);
        xmlCarGame.play();
        xmlBikeGame.play();
    }
}

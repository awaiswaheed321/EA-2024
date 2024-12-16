package edu.miu.ea.day12task4subscriber1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Day12Task4Subscriber1Application {

    public static void main(String[] args) {
        SpringApplication.run(Day12Task4Subscriber1Application.class, args);
    }

}

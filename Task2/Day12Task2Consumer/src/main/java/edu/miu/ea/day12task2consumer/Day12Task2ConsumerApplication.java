package edu.miu.ea.day12task2consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Day12Task2ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day12Task2ConsumerApplication.class, args);
    }

}

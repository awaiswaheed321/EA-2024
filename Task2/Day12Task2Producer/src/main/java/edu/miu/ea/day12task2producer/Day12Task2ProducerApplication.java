package edu.miu.ea.day12task2producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Day12Task2ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day12Task2ProducerApplication.class, args);
    }

}

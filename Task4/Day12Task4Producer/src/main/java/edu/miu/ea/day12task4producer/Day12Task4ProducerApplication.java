package edu.miu.ea.day12task4producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Day12Task4ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day12Task4ProducerApplication.class, args);
    }

}

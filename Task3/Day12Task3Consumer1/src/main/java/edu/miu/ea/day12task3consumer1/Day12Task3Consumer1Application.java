package edu.miu.ea.day12task3consumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Day12Task3Consumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(Day12Task3Consumer1Application.class, args);
    }

}

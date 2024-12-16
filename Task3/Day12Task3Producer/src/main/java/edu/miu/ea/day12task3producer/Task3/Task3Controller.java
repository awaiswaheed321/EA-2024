package edu.miu.ea.day12task3producer.Task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task3Controller {

    private final Task3Service task3Service;

    @Autowired
    public Task3Controller(Task3Service task3Service) {
        this.task3Service = task3Service;
    }

    @GetMapping("/send/queue1/{message}")
    public String sendToQueue1(@PathVariable String message) {
        System.out.println("Sending message");
        task3Service.sendToQueue1(message);
        return "Message sent";
    }

    @GetMapping("/send/queue2/{message}")
    public String sendToQueue2(@PathVariable String message) {
        System.out.println("Sending message");
        task3Service.sendToQueue2(message);
        return "Message sent";
    }
}

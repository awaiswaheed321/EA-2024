package edu.miu.ea.day12task4producer.Task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task4Controller {

    private final Task4Service task4Service;

    @Autowired
    public Task4Controller(Task4Service task4Service) {
        this.task4Service = task4Service;
    }

    @GetMapping("/send/{message}")
    public String sendToQueue1(@PathVariable String message) {
        System.out.println("Sending message");
        task4Service.sendToQueue(message);
        return "Message sent";
    }
}

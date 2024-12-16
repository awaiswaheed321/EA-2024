package edu.miu.ea.day12task1producer.Task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task1Controller {

    private final Task1Service task1Service;

    @Autowired
    public Task1Controller(Task1Service task1Service) {
        this.task1Service = task1Service;
    }

    @GetMapping("/send/{message}")
    public String send(@PathVariable String message) {
        System.out.println("Sending message");
        task1Service.send(message);
        return "Message sent";
    }
}

package edu.miu.ea.day12task1consumer;

import jakarta.jms.JMSException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Task1Consumer {
    @JmsListener(destination = "${springjms.cs544Queue}")
    public void receive(String message) throws JMSException {
        System.out.println("Message Received: " + message);
    }
}

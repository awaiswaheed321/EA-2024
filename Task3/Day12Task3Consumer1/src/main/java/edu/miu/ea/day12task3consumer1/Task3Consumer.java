package edu.miu.ea.day12task3consumer1;

import jakarta.jms.JMSException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Task3Consumer {
    @JmsListener(destination = "${springjms.cs544Queue1}")
    public void receive(String message) throws JMSException {
        System.out.println("Message Received: " + message);
    }
}

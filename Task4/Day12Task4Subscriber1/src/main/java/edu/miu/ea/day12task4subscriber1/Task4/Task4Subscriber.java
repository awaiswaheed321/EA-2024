package edu.miu.ea.day12task4subscriber1.Task4;

import jakarta.jms.JMSException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Task4Subscriber {
    @JmsListener(destination = "${springjms.cs544Queue1}")
    public void receive(String message) throws JMSException {
        System.out.println("Message Received: " + message);
    }
}

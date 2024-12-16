package edu.miu.ea.day12task1producer.Task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Task1Service {
    @Value(value = "${springjms.cs544Queue}")
    private String queueName;

    private final JmsTemplate jmsTemplate;

    @Autowired
    public Task1Service(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String message) {
        jmsTemplate.convertAndSend(queueName, message);
    }
}

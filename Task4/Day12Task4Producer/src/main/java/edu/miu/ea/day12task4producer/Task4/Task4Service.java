package edu.miu.ea.day12task4producer.Task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Task4Service {
    @Value(value = "${springjms.cs544Queue1}")
    private String queue1Name;

    private final JmsTemplate jmsTemplate;

    @Autowired
    public Task4Service(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendToQueue(String message) {
        jmsTemplate.convertAndSend(queue1Name, message);
    }
}

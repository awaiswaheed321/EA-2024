package edu.miu.ea.day12task3producer.Task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Task3Service {
    @Value(value = "${springjms.cs544Queue1}")
    private String queue1Name;
    @Value(value = "${springjms.cs544Queue2}")
    private String queue2Name;

    private final JmsTemplate jmsTemplate;

    @Autowired
    public Task3Service(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendToQueue1(String message) {
        jmsTemplate.convertAndSend(queue1Name, message);
    }

    public void sendToQueue2(String message) {
        jmsTemplate.convertAndSend(queue2Name, message);
    }
}

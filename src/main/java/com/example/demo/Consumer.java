package com.example.demo;

import com.example.demo.entity.Student;
import jakarta.jms.JMSException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {
    @JmsListener(destination = "${queue1.name}")
    public void receiveQueue1(Map<String, ?> map) throws JMSException {
        Student student = new Student();
        student.setName((String) map.get("name"));
        student.setAge((Integer) map.get("age"));
        student.setId((Long) map.get("id"));
        student.setGpa((Integer) map.get("gpa"));

        System.out.println("Student Received: " + student);
    }

    @JmsListener(destination = "${queue2.name}")
    public void receiveQueue2(String message) throws JMSException {
        System.out.println("Student Received: " + message);
    }
}

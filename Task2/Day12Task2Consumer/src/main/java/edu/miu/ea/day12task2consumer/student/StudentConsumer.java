package edu.miu.ea.day12task2consumer.student;

import jakarta.jms.JMSException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StudentConsumer {
    @JmsListener(destination = "${springjms.cs544Queue}")
    public void receive(Map<String, ?> map) throws JMSException {
        Student student = new Student();
        student.setName((String) map.get("name"));
        student.setAge((Integer) map.get("age"));
        student.setId((Long) map.get("id"));
        student.setGpa((Integer) map.get("gpa"));

        System.out.println("Student Received: " + student);
    }
}

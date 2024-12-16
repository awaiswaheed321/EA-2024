package com.example.demo;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Producer {
    @Value("${queue1.name}")
    private String queue1Name;

    @Value("${queue2.name}")
    private String queue2Name;

    final JmsTemplate jmsTemplate;

    public Producer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send() {
        Map<String, Object> studentMap = getStudentMap(new Student(10, "assa", 20, 30));
        jmsTemplate.convertAndSend(queue1Name, studentMap);
        jmsTemplate.convertAndSend(queue2Name, "Message");
    }

    private Map<String, Object> getStudentMap(Student student) {
        Map<String, Object> studentMap = new HashMap<>();
        studentMap.put("id", student.getId());
        studentMap.put("name", student.getName());
        studentMap.put("age", student.getAge());
        studentMap.put("gpa", student.getGpa());
        return studentMap;
    }
}

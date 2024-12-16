package edu.miu.ea.day12task2producer.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class StudentService {
    @Value(value = "${springjms.cs544Queue}")
    private String queueName;

    private final JmsTemplate jmsTemplate;

    @Autowired
    public StudentService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send() {
        Map<String, Object> studentMap = getStudentMap(generateRandomStudent());
        jmsTemplate.convertAndSend(queueName, studentMap);
        System.out.println("Sent student: " + studentMap);
    }

    private Map<String, Object> getStudentMap(Student student) {
        Map<String, Object> studentMap = new HashMap<>();
        studentMap.put("id", student.getId());
        studentMap.put("name", student.getName());
        studentMap.put("age", student.getAge());
        studentMap.put("gpa", student.getGpa());
        return studentMap;
    }

    private Student generateRandomStudent() {
        Random random = new Random();
        int id = random.nextInt(1000);
        String[] names = {"Jack", "Emily", "Sophia", "Michael", "Olivia"};
        String name = names[random.nextInt(names.length)];
        int age = 18 + random.nextInt(8);
        int gpa = (int) Math.round(random.nextDouble() * 4.0 * 10);
        return new Student(id, name, age, gpa);
    }
}

package edu.miu.ea.day12task2producer.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/send")
    public String send() {
        System.out.println("Sending message");
        studentService.send();
        return "Message sent";
    }
}

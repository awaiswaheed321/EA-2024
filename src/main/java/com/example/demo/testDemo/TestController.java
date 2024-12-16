package com.example.demo.testDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/hello/{message}")
    public ResponseEntity<TestObject> hello(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale,
            @PathVariable String message) {
        return testService.run(locale, message);
    }
}

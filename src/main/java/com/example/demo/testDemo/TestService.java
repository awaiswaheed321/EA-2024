package com.example.demo.testDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TestService {
    private final ResourceBundleMessageSource messageSource;

    @Autowired
    public TestService(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public ResponseEntity<TestObject> run(Locale locale, String message) {
        String responseString = messageSource.getMessage("greetings", null, locale) + " " + message;
//        System.out.println(responseString);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.valueOf("text/plain;charset=UTF-8"));
//
//        return new ResponseEntity<>(responseString + " " + message, headers, HttpStatus.OK);
        return ResponseEntity.ok(new TestObject(responseString));
    }
}

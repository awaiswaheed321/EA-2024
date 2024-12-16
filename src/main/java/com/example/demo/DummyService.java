package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DummyService {
    @Value("${app.info.test}")
    AppInfo appInfo;

    @PostConstruct
    public void init() {
        System.out.println("\n\n" + appInfo + "\n\n");
    }
}

package com.example.serviceLocator;

import org.springframework.stereotype.Component;

@Component
public class SomeHelloService implements SomeService {
    @Override
    public void someAction() {
        System.out.println("Hello");
    }
}

package com.example.serviceLocator;

import org.springframework.stereotype.Component;

@Component
public class SomeGoodByeService implements SomeService {
    @Override
    public void someAction() {
        System.out.println("Good bye");
    }
}

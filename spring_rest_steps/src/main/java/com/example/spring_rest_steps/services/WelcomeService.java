package com.example.spring_rest_steps.services;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

    public String retrieveWelcomeMessage() {
        //Complex Method
        return "Good Morning updated";
    }
}

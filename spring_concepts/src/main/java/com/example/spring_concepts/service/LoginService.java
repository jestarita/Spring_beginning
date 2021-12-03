package com.example.spring_concepts.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public Boolean checkUser(String user, String pass){
        return  user.equalsIgnoreCase("in28Minutes") && pass.equalsIgnoreCase("clero");
    }
}

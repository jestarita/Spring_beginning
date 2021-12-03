package com.example.spring_concepts.controller;

import com.example.spring_concepts.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LoginMessage(ModelMap model, @RequestParam String name,@RequestParam String password){
        Boolean checkLogin = loginService.checkUser(name, password);

        if (!checkLogin){
            model.put("message", "invalid credentials");
            return "login";
        }




        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }
}

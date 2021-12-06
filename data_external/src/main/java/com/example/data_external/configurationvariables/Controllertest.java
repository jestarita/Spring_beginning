package com.example.data_external.configurationvariables;

import com.example.data_external.configurationvariables.ConfigurationExtenal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controllertest {

    @Autowired
    ConfigurationExtenal configurationExtenal;

    @GetMapping("hello")
    public String saludo(){
        return "Hello peter";
    }

    @GetMapping("/responsePerson")
    public Map ConfigurationExtenal(){
        Map map = new HashMap();
        map.put("name", configurationExtenal.getName());
        map.put("age", configurationExtenal.getAge());
        return  map;
    }

}

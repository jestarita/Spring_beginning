package com.starting.aprendiendo_spring_again;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@RestController
public class Metodos {

    @GetMapping("/Hello")
    public String hello() {
        return "Hello people";
    }


    @Autowired
    HolaService servicio;

    @RequestMapping("/hola")
    public Mono<String> hola() {

        return servicio.hola();
    }

    @RequestMapping("/hola2")
    public Mono<String> hola2() {

        return servicio.hola2();
    }

    @RequestMapping("/holas")
    public Flux<String> holas() {

        Mono<String> mono1 = servicio.hola();
        Mono<String> mono2 = servicio.hola2();

        Flux<String> flujo = Flux.merge(mono1, mono2);

        return flujo;
    }


    @PostMapping("/some_data")
    @ResponseBody
    public Map<String, Object> GetPerson(@RequestParam(name = "player") String person) {

        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("inVal", 20);
        paramsMap.put("longVal", 45);
        paramsMap.put("str", person);
        paramsMap.put("array", intArray);
        return paramsMap;
    }
}

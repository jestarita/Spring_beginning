package com.starting.aprendiendo_spring_again;

import org.springframework.stereotype.Service;

import java.time.Duration;

import reactor.core.publisher.Mono;

@Service
public class HolaService {

    public Mono<String> hola() {
        return Mono.just("hola asincrono").delayElement(Duration.ofSeconds(3));
    }

    public Mono<String> hola2() {

        return Mono.just("hola asincrono").delayElement(Duration.ofSeconds(3));
    }
}

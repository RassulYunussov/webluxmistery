package com.example.webfluxexperiments.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author rassulyunussov
 */
@RestController
@Slf4j
public class HelloWorldController {
    @GetMapping("hello")
    public Mono<String> sayHello() {
        return Mono.just("Hello").delayElement(Duration.ofSeconds(30));
    }
}

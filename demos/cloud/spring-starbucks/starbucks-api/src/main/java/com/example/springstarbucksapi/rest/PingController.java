package com.example.springstarbucksapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* See:  https://spring.io/guides/gs/rest-service/ */

@RestController
public class PingController {

    class Ping {
        private String test;

        public Ping(String msg) {
            this.test = msg;
        }

        public String getTest() {
            return this.test;
        }
    }

    @GetMapping("/ping")
    public Ping ping() {
        return new Ping("Starbucks API version 3.1 alive!");
    }
}
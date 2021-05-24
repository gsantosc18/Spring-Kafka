package com.example.controller;

import com.example.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.service.User;

@RestController
@RequestMapping("/user")
public class UserController {

    private ProducerService producerService;

    @Autowired
    public UserController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/{name}/{age}")
    @ResponseStatus(HttpStatus.OK)
    public void pushUser(@PathVariable("name") String name, @PathVariable("age") int age) {
        producerService.sendMessage(new User(name, age));
    }
}

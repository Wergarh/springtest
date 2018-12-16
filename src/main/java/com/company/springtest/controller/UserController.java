package com.company.springtest.controller;

import com.company.springtest.model.User;
import com.company.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user")
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(path = "/user/{id}")
    public Optional<User> findById(@PathVariable(name = "id") Integer id) {
        return userService.findById(id);
    }
}

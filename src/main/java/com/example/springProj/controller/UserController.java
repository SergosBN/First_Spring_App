package com.example.springProj.controller;

import com.example.springProj.model.User;
import org.springframework.web.bind.annotation.*;
import com.example.springProj.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService){this.userService = userService;}

    @PostMapping
    public User create(@RequestBody User user) {return userService.create(user);}

    @GetMapping
    public List<User> getAll() {return userService.getAll();}
}

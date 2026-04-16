package com.example.springProj.controller;

import com.example.springProj.dto.UserDto;
import com.example.springProj.model.User;
import org.springframework.web.bind.annotation.*;
import com.example.springProj.service.UserService;

import java.util.List;

@RestController     // works with http requests, returns JSON, also works with service
@RequestMapping("/users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {    // returns JSON. DTO → Entity → DB → Entity → DTO
        return userService.create(dto);
    }

    @GetMapping // show (GET/users)
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")    // id = variable
    public User getById(@PathVariable Long id) {  // Take variable Long id
        return userService.getById(id);
    }

    @PutMapping("/{id}")   // completely changing the object
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}


//CONTROLLER: JUST RETURNS THE RESULT OF REQUEST
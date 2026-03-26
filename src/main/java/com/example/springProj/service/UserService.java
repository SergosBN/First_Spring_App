package com.example.springProj.service;

import com.example.springProj.model.User;
import org.springframework.stereotype.Service;
import com.example.springProj.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;           // connection

    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public User create(User user){return userRepository.save(user);}

    public List<User> getAll(){return userRepository.findAll();}
}

package com.example.springProj.service;

import com.example.springProj.dto.UserDto;
import com.example.springProj.exception.UserNotFoundException;
import com.example.springProj.model.User;
import org.springframework.stereotype.Service;
import com.example.springProj.repository.UserRepository;

import java.util.List;

@Service
public class UserService {      // logic, works with repo

    private final UserRepository userRepository;           // connection

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto create(UserDto dto) {
        User user = toEntity(dto);
        User saved = userRepository.save(user);
        return toDto(saved);
    }

    public User getById(Long id) {
        return userRepository.findById(id)                                     //findById returns OPTIONAL<User>
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User update(Long id, User updatedUser) {            // change
        User user = getById(id);                              // get id
        user.setName(updatedUser.getName());                  // change name of id person
        user.setEmail(updatedUser.getEmail());                // change email of id person
        return userRepository.save(user);                     // save changes
    }

    public void delete(Long id) {
        User user = getById(id);              // has orElseThrow
        userRepository.delete(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    private UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    private User toEntity(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}


// DTO → Entity → DB → Entity → DTO
// SERVICE: MUST BE RESULT OR MISTAKE
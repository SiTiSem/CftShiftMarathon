package com.cftbackend.group5.controllers;

import com.cftbackend.group5.ResourceNotFoundException;
import com.cftbackend.group5.repositories.UserRepository;
import com.cftbackend.group5.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("111"));
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody User userRequest) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(userRequest.getEmail());
                    user.setType(userRequest.getType());
                    return userRepository.save(user);
                }).orElseThrow(() -> new ResourceNotFoundException(String.format("Пользователь c ID %d не найден", id)));
    }
}
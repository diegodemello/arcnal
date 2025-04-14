package com.arcnal.controllers;

import com.arcnal.entity.User;
import com.arcnal.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User created = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<User>> findUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @DeleteMapping
    public void deleteUser(Long id){
        userService.delete(id);
    }
}

package com.breno.tasksync.controllers;

import com.breno.tasksync.dto.users.UserRequestDTO;
import com.breno.tasksync.dto.users.UserResponseDTO;
import com.breno.tasksync.entities.users.User;
import com.breno.tasksync.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<UserResponseDTO> users = repository.findAll()
                .stream().map(UserResponseDTO::new)
                .toList();

        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO data) {
        User newUser = new User(data);
        User savedUser = repository.save(newUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new UserResponseDTO(savedUser));
    }
}

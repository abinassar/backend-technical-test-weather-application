package com.cursos.springsecuritycourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.springsecuritycourse.dto.UserRegistrationRequest;
import com.cursos.springsecuritycourse.entity.User;
import com.cursos.springsecuritycourse.repository.UserRepository;
import com.cursos.springsecuritycourse.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UsersController {
 
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User userFound = userService.getUserByEmail(email);
        return ResponseEntity.ok(userFound);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRegistrationRequest user) {
        User userCreated = userService.registerNewUser(user);
        return ResponseEntity.ok(userCreated);
    }

    @PatchMapping
    public ResponseEntity<User> updateUser(@RequestBody UserRegistrationRequest user) {
        User userCreated = userService.updateUser(user);
        return ResponseEntity.ok(userCreated);
    }
}

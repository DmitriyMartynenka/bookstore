package org.example.bookstore.controllers;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.model.request.UserCreateRequest;
import org.example.bookstore.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserCreateRequest request) {
        userService.register(request);
        return ResponseEntity.ok().build();
    }
}
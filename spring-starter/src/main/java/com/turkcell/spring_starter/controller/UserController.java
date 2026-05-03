package com.turkcell.spring_starter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.spring_starter.dto.LoginRequest;
import com.turkcell.spring_starter.dto.RegisterRequest;
import com.turkcell.spring_starter.service.UserServiceImpl;

import jakarta.validation.Valid;

@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @PostMapping
    public void register(@RequestBody @Valid RegisterRequest registerRequest) {
        this.userService.registerUser(registerRequest);
    }

    @PostMapping("login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return this.userService.login(loginRequest);
    }
    
}

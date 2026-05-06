package com.turkcell.kutuphane_hw_spring_starter.controller;

import org.springframework.web.bind.annotation.*;

import com.turkcell.kutuphane_hw_spring_starter.dto.LoginRequest;
import com.turkcell.kutuphane_hw_spring_starter.dto.RegisterRequest;
import com.turkcell.kutuphane_hw_spring_starter.service.StaffServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/staff")
public class StaffController {
    private final StaffServiceImpl staffServiceImpl;

    public StaffController(StaffServiceImpl staffServiceImpl) {
        this.staffServiceImpl = staffServiceImpl;
    }

    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterRequest request) {
        return staffServiceImpl.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return staffServiceImpl.login(request);
    }
}
package com.turkcell.spring_starter.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.Repository.UserRepository;
import com.turkcell.spring_starter.dto.LoginRequest;
import com.turkcell.spring_starter.dto.RegisterRequest;
import com.turkcell.spring_starter.entity.User;

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterRequest registerRequest) {
        User userWithSameEmail = userRepository.findByEmail(registerRequest.getEmail()).orElse(null);
        if (userWithSameEmail != null) {
            throw new RuntimeException("Bu e-posta adresiyle zaten bir kullanıcı var.");
        }
        

        User user = new User();
        user.setEmail(registerRequest.getEmail());

        String encodedPassword = this.passwordEncoder.encode(registerRequest.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
    }

    public String login(LoginRequest loginRequest  ){
        String errorMessage = "*************Login Failed****************";

        User user = this.userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException(errorMessage));
        boolean passwordMatches = this.passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());

        if (!passwordMatches) {
            throw new RuntimeException(errorMessage);
        }

        return "*************Login Successful****************";

    }
}

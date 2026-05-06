package com.turkcell.kutuphane_hw_spring_starter.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.turkcell.kutuphane_hw_spring_starter.Repository.StaffRepository;
import com.turkcell.kutuphane_hw_spring_starter.dto.LoginRequest;
import com.turkcell.kutuphane_hw_spring_starter.dto.RegisterRequest;
import com.turkcell.kutuphane_hw_spring_starter.entity.Staff;

@Service
public class StaffServiceImpl {
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;

    public StaffServiceImpl(StaffRepository staffRepository, PasswordEncoder passwordEncoder) {
        this.staffRepository = staffRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request) {
        Staff staffWithSameEmail = staffRepository.findByEmail(request.getEmail()).orElse(null);
        if (staffWithSameEmail != null) {
            throw new RuntimeException("Bu e-posta adresiyle zaten bir görevli var.");
        }

        Staff staff = new Staff();
        staff.setFirstName(request.getFirstName());
        staff.setLastName(request.getLastName());
        staff.setEmail(request.getEmail());
        staff.setPhone(request.getPhone());
        staff.setPassword(passwordEncoder.encode(request.getPassword()));

        staffRepository.save(staff);
        return "Görevli başarıyla kaydedildi.";
    }

    public String login(LoginRequest request) {
        String errorMessage = "Giriş başarısız. Lütfen bilgilerinizi kontrol edin.";

        Staff staff = staffRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException(errorMessage));
                
        boolean passwordMatches = passwordEncoder.matches(request.getPassword(), staff.getPassword());

        if (!passwordMatches) {
            throw new RuntimeException(errorMessage);
        }

        return "Giriş başarılı! Kütüphane sistemine hoş geldiniz.";
    }
}
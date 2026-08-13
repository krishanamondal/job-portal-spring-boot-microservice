package com.mondal.job.service.impl;

import com.mondal.job.domain.UserRole;
import com.mondal.job.domain.UserStatus;
import com.mondal.job.mapper.UserMapper;
import com.mondal.job.model.User;
import com.mondal.job.payload.AuthResponse;
import com.mondal.job.payload.LoginRequest;
import com.mondal.job.payload.SignupRequest;
import com.mondal.job.repository.UserRepository;
import com.mondal.job.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//151
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    @Override
    public AuthResponse signup(SignupRequest request) throws Exception {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new Exception("User Already Exists with email: " + request.getEmail());
        }
        if (request.getRole()== UserRole.ROLE_ADMIN) {
            throw new Exception("user cannot self-register as role admin");
        }
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(request.getPassword())
                .roles(request.getRole())
                .phone(request.getPhone())
                .lastLogin(LocalDateTime.now())
                .status(UserStatus.ACTIVE)
                .build();
        User savedUser = userRepository.save(user);
        AuthResponse response = new AuthResponse();
        response.setTitle("Registered User :  "+savedUser.getFullName());
        response.setMessage("User Registered Successfully ");
        response.setJwt("jwt");
        response.setUserResponse(UserMapper.toDTO(savedUser));
        return response;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}

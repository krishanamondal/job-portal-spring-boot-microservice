package com.mondal.job.service;


import com.mondal.job.payload.AuthResponse;
import com.mondal.job.payload.LoginRequest;
import com.mondal.job.payload.SignupRequest;

//135
public interface AuthService {
    AuthResponse signup(SignupRequest request) throws Exception;
    AuthResponse login (LoginRequest request) throws Exception;
}

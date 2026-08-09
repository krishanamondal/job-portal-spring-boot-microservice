package com.mondal.job.controller;

import com.mondal.job.domain.UserRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Welcome to the Job Portal User Service With MicroService!"+ UserRole.ROLE_JOB_SEEKER;
    }
}

package com.collegeprep.placement.controller;

import com.collegeprep.placement.dto.LoginRequest;
import com.collegeprep.placement.dto.RegisterRequest;
import com.collegeprep.placement.model.User;
import com.collegeprep.placement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://placement-frontend-hwv4wpnpp-manisha-gundlapallys-projects.vercel.app")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
    @GetMapping("/test")
public String test() {
    return "Backend working 🚀";
}

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
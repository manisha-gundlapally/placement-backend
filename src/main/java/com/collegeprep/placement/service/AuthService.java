package com.collegeprep.placement.service;

import com.collegeprep.placement.dto.LoginRequest;
import com.collegeprep.placement.dto.RegisterRequest;
import com.collegeprep.placement.model.User;
import com.collegeprep.placement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User register(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setCollege(request.getCollege());
        return userRepository.save(user);
    }

    public User login(LoginRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent() && user.get().getPassword().equals(request.getPassword())) {
            return user.get();
        }
        return null;
    }
}
package com.collegeprep.placement.service;

import com.collegeprep.placement.model.Experience;
import com.collegeprep.placement.model.User;
import com.collegeprep.placement.repository.ExperienceRepository;
import com.collegeprep.placement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeniorService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private UserRepository userRepository;
public Experience addExperience(Experience exp, Long userId) {

    System.out.println("Received Data: " + exp);
    System.out.println("User ID: " + userId);

    User user = userRepository.findById(userId).orElse(null);

    if (user == null) {
        System.out.println("❌ USER NOT FOUND");
        throw new RuntimeException("User not found");
    }

    exp.setUser(user);

    // FORCE VALUE
    exp.setStatus("PENDING");

    exp.setBranch(exp.getBranch().toUpperCase());
    exp.setJobType(exp.getJobType().toUpperCase());

    Experience saved = experienceRepository.save(exp);

    System.out.println("✅ SAVED DATA: " + saved);

    return saved;
}
}
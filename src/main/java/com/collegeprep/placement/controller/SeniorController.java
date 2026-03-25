package com.collegeprep.placement.controller;

import com.collegeprep.placement.model.Experience;
import com.collegeprep.placement.service.SeniorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/senior")

public class SeniorController {

    @Autowired
    private SeniorService seniorService;

    @PostMapping("/add/{userId}")
    public Experience addExperience(@RequestBody Experience exp, @PathVariable Long userId) {
        return seniorService.addExperience(exp, userId);
    }
}
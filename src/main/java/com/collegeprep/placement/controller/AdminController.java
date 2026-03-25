package com.collegeprep.placement.controller;

import com.collegeprep.placement.model.Experience;
import com.collegeprep.placement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // ✅ GET ONLY PENDING (IMPORTANT FOR APPROVAL)
    @GetMapping("/pending")
    public List<Experience> getPending() {
        return adminService.getPending();
    }

    @GetMapping("/users")
public List<User> getUsers() {
    return userRepository.findAll();
}

    // ✅ GET ALL DATA
    @GetMapping("/all")
    public List<Experience> getAll() {
        return adminService.getAll();
    }

    // ✅ APPROVE
    @PostMapping("/approve/{id}")
    public Experience approve(@PathVariable Long id) {
        return adminService.approve(id);
    }

    // ✅ REJECT
    @PostMapping("/reject/{id}")
    public Experience reject(@PathVariable Long id) {
        return adminService.reject(id);
    }

    // ✅ DELETE
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        adminService.delete(id);
    }
}
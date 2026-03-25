package com.collegeprep.placement.service;

import com.collegeprep.placement.model.Experience;
import com.collegeprep.placement.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private ExperienceRepository experienceRepository;

    // ✅ GET PENDING
    public List<Experience> getPending() {
        List<Experience> list = experienceRepository.findByStatus("PENDING");
        System.out.println("PENDING DATA: " + list);
        return list;
    }

    // ✅ GET ALL
    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    // ✅ APPROVE
    public Experience approve(Long id) {
        return experienceRepository.findById(id).map(exp -> {
            exp.setStatus("APPROVED");
            return experienceRepository.save(exp);
        }).orElse(null);
    }

    // ✅ REJECT
    public Experience reject(Long id) {
        return experienceRepository.findById(id).map(exp -> {
            exp.setStatus("REJECTED");
            return experienceRepository.save(exp);
        }).orElse(null);
    }

    // ✅ DELETE
    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }
}
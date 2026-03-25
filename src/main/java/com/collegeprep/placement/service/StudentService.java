package com.collegeprep.placement.service;

import com.collegeprep.placement.model.Experience;
import com.collegeprep.placement.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private ExperienceRepository experienceRepository;

    // ✅ FILTER METHOD (FIXED)
    public List<Experience> getFilteredExperiences(String branch, String jobType) {

        // ✅ FIX CASE MATCH
        branch = branch.toUpperCase();
        jobType = jobType.toUpperCase();

        List<Experience> list = experienceRepository
                .findByStatusAndBranchAndJobType("APPROVED", branch, jobType);

        System.out.println("FILTER RESULT: " + list);

        return list;
    }
}
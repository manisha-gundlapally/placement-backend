package com.collegeprep.placement.controller;

import com.collegeprep.placement.model.Experience;
import com.collegeprep.placement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "https://placement-frontend-hwv4wpnpp-manisha-gundlapallys-projects.vercel.app")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ✅ NEW API (IMPORTANT)
    @GetMapping("/filter")
    public List<Experience> filter(
            @RequestParam String branch,
            @RequestParam String jobType
    ) {
        return studentService.getFilteredExperiences(branch, jobType);
    }
}
package com.collegeprep.placement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String role;
    private String questions;
    private String rounds;
    private String status;

    // ✅ ADD THESE TWO FIELDS
    private String branch;   // ECE, CSE, AIML
    private String jobType;  // CORE, IT

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
package com.collegeprep.placement.repository;

import com.collegeprep.placement.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    List<Experience> findByStatus(String status);
    

    // ✅ NEW FILTER METHOD
    List<Experience> findByStatusAndBranchAndJobType(
            String status,
            String branch,
            String jobType
    );
}
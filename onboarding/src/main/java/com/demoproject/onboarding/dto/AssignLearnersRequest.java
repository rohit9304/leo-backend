package com.demoproject.onboarding.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.demoproject.onboarding.entity.AssociateTracker;

@Data
@Getter
@Setter
public class AssignLearnersRequest {
    private Long cohortId;
    private List<AssociateTracker> learners;  // Full learner data
    // Getters and setters
}


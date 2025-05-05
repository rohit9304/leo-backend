package com.demoproject.onboarding.dto;


import lombok.Data;
import java.util.List;
import java.util.Optional;

import com.demoproject.onboarding.entity.Cohort;
import com.demoproject.onboarding.entity.Population;

@Data
public class CohortWithLearnersResponse {
    private Cohort cohort;
    private List<Population> learners;
}
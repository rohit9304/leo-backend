package com.demoproject.onboarding.service;

import com.demoproject.onboarding.entity.Cohort;
import java.util.List;
import java.util.Optional;

public interface CohortService {
    Cohort createCohort(Cohort cohort);
    List<Cohort> getAllCohorts();
    Optional<Cohort> getCohortById(Long id);
    Cohort updateCohort(Long id, Cohort cohort);
    void deleteCohort(Long id);
}

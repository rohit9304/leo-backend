package com.demoproject.onboarding.service;

import java.util.List;

import com.demoproject.onboarding.entity.Population;

public interface AssociateTrackerService {
    void assignLearnersToCohort(List<String> cnums, Long cohortId);
    List<Population> getLearnersByCohortId(Long cohortId);
}

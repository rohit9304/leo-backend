package com.demoproject.onboarding.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.demoproject.onboarding.entity.AssociateTracker;
import com.demoproject.onboarding.entity.Population;

public interface AssociateTrackerService {
    void assignLearnersToCohort(List<AssociateTracker> learners, Long cohortId);
    List<Population> getLearnersByCohortId(Long cohortId);
    Map<String, Object> getLearnersByCohortIds(Long cohortId);
    void uploadLearnersFromExcel(MultipartFile file);

}

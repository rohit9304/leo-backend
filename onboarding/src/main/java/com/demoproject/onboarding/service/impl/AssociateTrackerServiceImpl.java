package com.demoproject.onboarding.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.demoproject.onboarding.entity.AssociateTracker;
import com.demoproject.onboarding.entity.Cohort;
import com.demoproject.onboarding.entity.Population;
import com.demoproject.onboarding.helper.ExcelHelper;
import com.demoproject.onboarding.repository.AssociateTrackerRepository;
import com.demoproject.onboarding.repository.CohortRepository;
import com.demoproject.onboarding.repository.PopulationRepository;
import com.demoproject.onboarding.service.AssociateTrackerService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AssociateTrackerServiceImpl implements AssociateTrackerService {

    @Autowired
    private AssociateTrackerRepository associateTrackerRepository;

    @Autowired
    private CohortRepository cohortRepository;

    @Autowired
    private PopulationRepository learnerRepository;

    @Override
    public void assignLearnersToCohort(List<AssociateTracker> learners, Long cohortId) {
        for (AssociateTracker learner : learners) {
            learner.setCohortId(cohortId);
            learner.setStatus("Assigned");
            learner.setLastUpdatedBy("System");
            learner.setLastUpdateDate(LocalDate.now());
        }
        associateTrackerRepository.saveAll(learners);
    }
    @Override
    public void uploadLearnersFromExcel(MultipartFile file) {
        try {
            List<AssociateTracker> learners = ExcelHelper.convertExcelToAssociates(file.getInputStream());
            associateTrackerRepository.saveAll(learners);
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload Excel file: " + e.getMessage());
        }
    }

    @Override
    public List<Population> getLearnersByCohortId(Long cohortId) {
        List<AssociateTracker> trackers = associateTrackerRepository.findByCohortId(cohortId);

        List<String> cnums = trackers.stream()
                .map(AssociateTracker::getCnum)
                .collect(Collectors.toList());

        return learnerRepository.findAllById(cnums);
    }

    @Override
    @GetMapping("/cohort/{cohortId}/learners")
    public Map<String, Object> getLearnersByCohortIds(@PathVariable Long cohortId) {
        List<AssociateTracker> learners = associateTrackerRepository.findByCohortId(cohortId);
        Cohort cohort = cohortRepository.findById(cohortId).orElseThrow();

        Map<String, Object> response = new HashMap<>();
        response.put("cohort", cohort);
        response.put("learners", learners);
        return response;
    }

}

package com.demoproject.onboarding.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.onboarding.entity.AssociateTracker;
import com.demoproject.onboarding.entity.Population;
import com.demoproject.onboarding.repository.AssociateTrackerRepository;
import com.demoproject.onboarding.repository.PopulationRepository;
import com.demoproject.onboarding.service.AssociateTrackerService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssociateTrackerServiceImpl implements AssociateTrackerService {

    @Autowired
    private AssociateTrackerRepository associateTrackerRepository;

    @Autowired
    private PopulationRepository learnerRepository;

    @Override
    public void assignLearnersToCohort(List<String> cnums, Long cohortId) {
        for (String cnum : cnums) {
            AssociateTracker tracker = new AssociateTracker();
            tracker.setCnum(cnum);
            tracker.setCohortId(cohortId);
            tracker.setStatus("Assigned");
            tracker.setLastUpdateDate(LocalDate.now());
            tracker.setLastUpdatedBy("System"); // Replace with logged-in user if needed
            associateTrackerRepository.save(tracker);
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
}

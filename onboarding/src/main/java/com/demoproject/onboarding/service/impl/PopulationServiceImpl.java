package com.demoproject.onboarding.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.onboarding.entity.AssociateTracker;
import com.demoproject.onboarding.entity.Population;
import com.demoproject.onboarding.repository.AssociateTrackerRepository;
import com.demoproject.onboarding.repository.PopulationRepository;
import com.demoproject.onboarding.service.PopulationService;

import java.util.List;

@Service
public class PopulationServiceImpl implements PopulationService {

   
    @Autowired
    private PopulationRepository populationRepository;

    @Autowired
    private AssociateTrackerRepository associateRepository;

    
    @Override
    public List<Population> getLearnersNotInAssociate() {
        List<Population> allLearners = populationRepository.findAll();
        List<String> associateCnums = associateRepository.findAll()
                                            .stream()
                                            .map(AssociateTracker::getCnum)
                                            .toList();

        return allLearners.stream()
                .filter(learner -> !associateCnums.contains(learner.getCnum()))
                .toList();
    }


}


package com.demoproject.onboarding.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.onboarding.entity.Population;
import com.demoproject.onboarding.repository.PopulationRepository;
import com.demoproject.onboarding.service.PopulationService;

import java.util.List;

@Service
public class PopulationServiceImpl implements PopulationService {

   
    @Autowired
    private PopulationRepository populationRepository;
    
     @Override
    public List<Population> getAllLearners() {
        return populationRepository.findAll();
    }

}


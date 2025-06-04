package com.demoproject.onboarding.service.impl;

import com.demoproject.onboarding.entity.Cohort;
import com.demoproject.onboarding.repository.CohortRepository;
import com.demoproject.onboarding.service.CohortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CohortServiceImpl implements CohortService {

    @Autowired
    private CohortRepository cohortRepository;

    @Override
    public Cohort createCohort(Cohort cohort) {
        return cohortRepository.save(cohort);
    }

    @Override
    public List<Cohort> getAllCohorts() {
        return cohortRepository.findAll();
    }

     @Override
    public List<Cohort> getCohortsByMarket(String market) {
        return cohortRepository.findByMarketIgnoreCase(market);
    }

    @Override
    public Optional<Cohort> getCohortById(Long id) {
        return cohortRepository.findById(id);
    }

    @Override
    public Cohort updateCohort(Long id, Cohort cohortDetails) {
        Cohort cohort = cohortRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cohort not found with id " + id));
        
        cohort.setCohortName(cohortDetails.getCohortName());
        cohort.setGeo(cohortDetails.getGeo());
        cohort.setMarket(cohortDetails.getMarket());
        cohort.setEducationManager(cohortDetails.getEducationManager());
        cohort.setStartDate(cohortDetails.getStartDate());
        cohort.setEndDate(cohortDetails.getEndDate());
        cohort.setStatus(cohortDetails.getStatus());
        
        return cohortRepository.save(cohort);
    }

    @Override
    public void deleteCohort(Long id) {
        cohortRepository.deleteById(id);
    }
}

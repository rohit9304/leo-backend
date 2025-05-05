package com.demoproject.onboarding.service;
import org.springframework.stereotype.Service;
import com.demoproject.onboarding.entity.Population;
import java.util.List;

@Service
public interface PopulationService {
    List<Population> getAllLearners();
    
} 

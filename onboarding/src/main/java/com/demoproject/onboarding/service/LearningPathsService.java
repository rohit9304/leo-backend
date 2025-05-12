package com.demoproject.onboarding.service;

import java.util.List;

import com.demoproject.onboarding.dto.LearningPathsDTO;

public interface LearningPathsService {
    LearningPathsDTO createUserRole(LearningPathsDTO learningPathsDTO);

    List<LearningPathsDTO> getAllLearningPaths();

}

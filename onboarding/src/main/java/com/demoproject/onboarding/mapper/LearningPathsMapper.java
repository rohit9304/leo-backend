package com.demoproject.onboarding.mapper;

import com.demoproject.onboarding.dto.LearningPathsDTO;
import com.demoproject.onboarding.entity.LearningPaths;

public class LearningPathsMapper {

    public static LearningPathsDTO mapToLearningPathsDTO(LearningPaths learningPaths){
        return new LearningPathsDTO(
            learningPaths.getTalentId(),
            learningPaths.getJrs(),
            learningPaths.getPlanId(),
            learningPaths.getLearningPathName(),
            learningPaths.getStatus(),
            learningPaths.getUrl()
        );
    }

    public static LearningPaths mapToLearningPaths(LearningPathsDTO learningPathsDTO){
        return new LearningPaths(
            learningPathsDTO.getTalentId(),
            learningPathsDTO.getJrs(),
            learningPathsDTO.getPlanId(),
            learningPathsDTO.getLearningPathName(),
            learningPathsDTO.getStatus(),
            learningPathsDTO.getUrl()
        );
    }

}

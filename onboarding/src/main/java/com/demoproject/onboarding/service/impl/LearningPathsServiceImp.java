package com.demoproject.onboarding.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demoproject.onboarding.dto.LearningPathsDTO;
import com.demoproject.onboarding.entity.LearningPaths;
import com.demoproject.onboarding.mapper.LearningPathsMapper;
import com.demoproject.onboarding.repository.LearningPathsRepository;
import com.demoproject.onboarding.service.LearningPathsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LearningPathsServiceImp implements LearningPathsService{

    private LearningPathsRepository learningPathsRepository;

    @Override
    public LearningPathsDTO createUserRole(LearningPathsDTO learningPathsDTO) {
        LearningPaths learningPaths = LearningPathsMapper.mapToLearningPaths(learningPathsDTO);
        LearningPaths saveLearningPaths = learningPathsRepository.save(learningPaths);
        return LearningPathsMapper.mapToLearningPathsDTO(saveLearningPaths);
    }

    @Override
    public List<LearningPathsDTO> getAllLearningPaths() {
        List<LearningPaths> learningPaths = learningPathsRepository.findAll();
        return learningPaths.stream().map((learningPath)-> LearningPathsMapper.mapToLearningPathsDTO(learningPath))
        .collect(Collectors.toList());
    }

}

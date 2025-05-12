package com.demoproject.onboarding.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.onboarding.dto.LearningPathsDTO;
import com.demoproject.onboarding.service.LearningPathsService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin
@RequestMapping("/api/learningPath")
@AllArgsConstructor
public class LearningPathsController {
    private LearningPathsService learningPathsService;

    // post user role api
    @PostMapping
    public ResponseEntity<LearningPathsDTO> createUserRole(@RequestBody LearningPathsDTO learningPathsDTO){
        LearningPathsDTO savedLearningPaths = learningPathsService.createUserRole(learningPathsDTO);
        return new ResponseEntity<>(savedLearningPaths, HttpStatus.CREATED);
    }

    //get ALl learning paths
    @GetMapping
    public ResponseEntity<List<LearningPathsDTO>> getAllLearningPaths(){
        List<LearningPathsDTO> learningPaths = learningPathsService.getAllLearningPaths();
        return ResponseEntity.ok(learningPaths);
    }
}

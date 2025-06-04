package com.demoproject.onboarding.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.demoproject.onboarding.dto.AssignLearnersRequest;
import com.demoproject.onboarding.entity.AssociateTracker;
import com.demoproject.onboarding.entity.Cohort;
import com.demoproject.onboarding.repository.AssociateTrackerRepository;
import com.demoproject.onboarding.service.AssociateTrackerService;

@RestController
@RequestMapping("/api/associates")
@CrossOrigin
public class AssociateTrackerController {
    @Autowired
    private AssociateTrackerService associateTrackerService;

    @Autowired
    private AssociateTrackerRepository associateTrackerRepository;

    @PostMapping("/assign")
    public ResponseEntity<String> assignLearnersToCohort(@RequestBody AssignLearnersRequest request) {
        associateTrackerService.assignLearnersToCohort(request.getLearners(), request.getCohortId());
        return ResponseEntity.ok("Learners assigned successfully");
    }

    @GetMapping
    public List<AssociateTracker> getLearners() {
        return associateTrackerRepository.findAll();
    }

    @GetMapping("/{cohortId}/learners")
    public Map<String, Object> getLearnersByCohort(@PathVariable Long cohortId) {
        return associateTrackerService.getLearnersByCohortIds(cohortId);
    }

    @PostMapping
    public ResponseEntity<AssociateTracker> addLearner(@RequestBody AssociateTracker learner) {
        AssociateTracker savedLearner = associateTrackerRepository.save(learner);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLearner);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".xlsx")) {
            return ResponseEntity.badRequest().body("Please upload a valid Excel (.xlsx) file!");
        }

        associateTrackerService.uploadLearnersFromExcel(file);
        return ResponseEntity.ok("Excel data uploaded successfully.");
    }

}


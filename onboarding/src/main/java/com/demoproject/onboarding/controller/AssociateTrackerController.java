package com.demoproject.onboarding.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demoproject.onboarding.dto.AssignLearnersRequest;
import com.demoproject.onboarding.service.AssociateTrackerService;

@RestController
@RequestMapping("/api/associates")
@CrossOrigin
public class AssociateTrackerController {
    @Autowired
    private AssociateTrackerService associateTrackerService;

    @PostMapping("/assign")
    public ResponseEntity<String> assignLearnersToCohort(@RequestBody AssignLearnersRequest request) {
        associateTrackerService.assignLearnersToCohort(request.getCnums(), request.getCohortId());
        return ResponseEntity.ok("Learners assigned successfully");
    }
}


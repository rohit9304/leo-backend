package com.demoproject.onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.onboarding.entity.Population;
import com.demoproject.onboarding.service.PopulationService;

@RestController
@RequestMapping("/api/learners")
@CrossOrigin
public class PopulationController {
    @Autowired
    private PopulationService learnerService;

    @GetMapping
    public List<Population> getAllLearners() {
        return learnerService.getLearnersNotInAssociate();
    }
}

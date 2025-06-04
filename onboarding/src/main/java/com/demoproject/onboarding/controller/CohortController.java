package com.demoproject.onboarding.controller;

import com.demoproject.onboarding.dto.CohortWithLearnersResponse;
import com.demoproject.onboarding.entity.Cohort;
import com.demoproject.onboarding.entity.Population;
import com.demoproject.onboarding.service.AssociateTrackerService;
import com.demoproject.onboarding.service.CohortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/cohorts")
public class CohortController {

    @Autowired
    private CohortService cohortService;

     @Autowired
    private AssociateTrackerService associateTrackerService;

    @PostMapping
    public ResponseEntity<Cohort> createCohort(@RequestBody Cohort cohort) {
        Cohort savedCohort = cohortService.createCohort(cohort);
        return ResponseEntity.ok(savedCohort);
    }

    @GetMapping
    public ResponseEntity<List<Cohort>> getCohortsByMarket(@RequestParam(defaultValue = "ALL") String market) {
        List<Cohort> cohorts;

        if ("ALL".equalsIgnoreCase(market)) {
            cohorts = cohortService.getAllCohorts();
        } else {
            cohorts = cohortService.getCohortsByMarket(market);
        }

        return ResponseEntity.ok(cohorts);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cohort> getCohortById(@PathVariable Long id) {
        return cohortService.getCohortById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cohort> updateCohort(@PathVariable Long id, @RequestBody Cohort cohort) {
        Cohort updatedCohort = cohortService.updateCohort(id, cohort);
        return ResponseEntity.ok(updatedCohort);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCohort(@PathVariable Long id) {
        cohortService.deleteCohort(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{cohortId}/learners")
    public CohortWithLearnersResponse getCohortWithLearners(@PathVariable Long cohortId) {
        Cohort cohort = cohortService.getCohortById(cohortId)
                .orElseThrow(() -> new RuntimeException("Cohort not found with id: " + cohortId));

        List<Population> learners = associateTrackerService.getLearnersByCohortId(cohortId);

        CohortWithLearnersResponse response = new CohortWithLearnersResponse();
        response.setCohort(cohort); 
        response.setLearners(learners);
        return response;
    }

}

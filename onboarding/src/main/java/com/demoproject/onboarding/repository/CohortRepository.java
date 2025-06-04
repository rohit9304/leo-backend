package com.demoproject.onboarding.repository;

import com.demoproject.onboarding.entity.Cohort;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository extends JpaRepository<Cohort, Long> {
    List<Cohort> findByMarketIgnoreCase(String market);
}

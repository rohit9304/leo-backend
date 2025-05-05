package com.demoproject.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.onboarding.entity.AssociateTracker;

import java.util.List;

public interface AssociateTrackerRepository extends JpaRepository<AssociateTracker, Long> {
    List<AssociateTracker> findByCohortId(Long cohortId);
}

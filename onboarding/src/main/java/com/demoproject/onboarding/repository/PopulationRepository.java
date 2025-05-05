package com.demoproject.onboarding.repository;


import com.demoproject.onboarding.entity.Population;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopulationRepository extends JpaRepository<Population, String> {
}


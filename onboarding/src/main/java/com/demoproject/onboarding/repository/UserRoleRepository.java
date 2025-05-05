package com.demoproject.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.onboarding.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

}

package com.demoproject.onboarding.repository;

import com.demoproject.onboarding.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByEmailId(String emailId);
    List<UserRole> findByEmailIdAndStatus(String emailId, String status);
}

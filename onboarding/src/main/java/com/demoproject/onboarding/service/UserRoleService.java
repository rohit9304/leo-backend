package com.demoproject.onboarding.service;

import com.demoproject.onboarding.entity.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {

    UserRole createUserRole(UserRole userRole);

    List<UserRole> getUserRolesByEmail(String emailId);

    Optional<UserRole> getUserByEmail(String emailId);

    List<UserRole> getAllUsers();

    UserRole getUserById(Long id);

    UserRole updateUserRole(Long id, UserRole updatedUser);
    
    void deleteUserRole(Long id);

}

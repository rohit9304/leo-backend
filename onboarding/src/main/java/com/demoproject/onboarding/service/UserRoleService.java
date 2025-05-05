package com.demoproject.onboarding.service;

import java.util.List;

import com.demoproject.onboarding.dto.UserRoleDTO;

public interface UserRoleService {
    UserRoleDTO createUserRole(UserRoleDTO userRoleDTO);

    List<UserRoleDTO> getAllLearningPaths();

}

package com.demoproject.onboarding.mapper;

import com.demoproject.onboarding.dto.UserRoleDTO;
import com.demoproject.onboarding.entity.UserRole;

public class UserRoleMapper {

    public static UserRoleDTO mapToUserRoleDTO(UserRole userRole){
        return new UserRoleDTO(
            userRole.getTalentId(),
            userRole.getJrs(),
            userRole.getPlanId(),
            userRole.getLearningPathName(),
            userRole.getStatus(),
            userRole.getUrl()
        );
    }

    public static UserRole mapToUserRole(UserRoleDTO userRoleDTO){
        return new UserRole(
            userRoleDTO.getTalentId(),
            userRoleDTO.getJrs(),
            userRoleDTO.getPlanId(),
            userRoleDTO.getLearningPathName(),
            userRoleDTO.getStatus(),
            userRoleDTO.getUrl()
        );
    }

}

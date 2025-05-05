package com.demoproject.onboarding.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demoproject.onboarding.dto.UserRoleDTO;
import com.demoproject.onboarding.entity.UserRole;
import com.demoproject.onboarding.mapper.UserRoleMapper;
import com.demoproject.onboarding.repository.UserRoleRepository;
import com.demoproject.onboarding.service.UserRoleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserRoleServiceImp implements UserRoleService{

    private UserRoleRepository userRoleRepository;

    @Override
    public UserRoleDTO createUserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = UserRoleMapper.mapToUserRole(userRoleDTO);
        UserRole saveUserRole = userRoleRepository.save(userRole);
        return UserRoleMapper.mapToUserRoleDTO(saveUserRole);
    }

    @Override
    public List<UserRoleDTO> getAllLearningPaths() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles.stream().map((userRole)-> UserRoleMapper.mapToUserRoleDTO(userRole))
        .collect(Collectors.toList());
    }

}

package com.demoproject.onboarding.service.impl;

import com.demoproject.onboarding.entity.UserRole;
import com.demoproject.onboarding.repository.UserRoleRepository;
import com.demoproject.onboarding.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole createUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> getUserRolesByEmail(String emailId) {
        return userRoleRepository.findByEmailIdAndStatus(emailId, "Active");
    }

    @Override
    public Optional<UserRole> getUserByEmail(String emailId) {
        return userRoleRepository.findByEmailId(emailId);
    }

    @Override
    public List<UserRole> getAllUsers() {
        return userRoleRepository.findAll();
    }

    public UserRole getUserById(Long id) {
        Optional<UserRole> optional = userRoleRepository.findById(id);
        return optional.orElse(null); // or throw custom NotFoundException
    }

    public UserRole updateUserRole(Long id, UserRole updatedUser) {
        Optional<UserRole> existing = userRoleRepository.findById(id);
        if (existing.isPresent()) {
            UserRole user = existing.get();
            user.setEmailId(updatedUser.getEmailId());
            user.setRole(updatedUser.getRole());
            user.setProgram(updatedUser.getProgram());
            user.setStatus(updatedUser.getStatus());
            user.setMarket(updatedUser.getMarket());
            return userRoleRepository.save(user);
        } else {
            return null; // or throw NotFoundException
        }
    }

    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}
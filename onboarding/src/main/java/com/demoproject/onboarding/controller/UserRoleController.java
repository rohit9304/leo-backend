package com.demoproject.onboarding.controller;

import com.demoproject.onboarding.entity.UserRole;
import com.demoproject.onboarding.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
@CrossOrigin(origins = "*")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    // Admin: Create User Role
    @PostMapping
    public UserRole createUser(@RequestBody UserRole userRole) {
        return userRoleService.createUserRole(userRole);
    }

    // Get roles by email (for login dropdown)
    @GetMapping("/email/{emailId}")
    public List<UserRole> getRolesByEmail(@PathVariable String emailId) {
        return userRoleService.getUserRolesByEmail(emailId);
    }

    // Admin: Get all users
    @GetMapping
    public List<UserRole> getAllUsers() {
        return userRoleService.getAllUsers();
    }
}

package com.demoproject.onboarding.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.onboarding.dto.UserRoleDTO;
import com.demoproject.onboarding.service.UserRoleService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin
@RequestMapping("/api/learningPath")
@AllArgsConstructor
public class UserRoleController {
    private UserRoleService userRoleService;

    // post user role api
    @PostMapping
    public ResponseEntity<UserRoleDTO> createUserRole(@RequestBody UserRoleDTO userRoleDTO){
        UserRoleDTO savedUserRole = userRoleService.createUserRole(userRoleDTO);
        return new ResponseEntity<>(savedUserRole, HttpStatus.CREATED);
    }

    //get ALl learning paths
    @GetMapping
    public ResponseEntity<List<UserRoleDTO>> getAllLearningPaths(){
        List<UserRoleDTO> userRoles = userRoleService.getAllLearningPaths();
        return ResponseEntity.ok(userRoles);
    }
}

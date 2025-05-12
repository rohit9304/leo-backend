package com.demoproject.onboarding.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LearningPathsDTO {

    private Long talentId;

    private String planId;
    
    private String jrs;
    
    private String learningPathName;
    
    private String url;

    private String status;

}

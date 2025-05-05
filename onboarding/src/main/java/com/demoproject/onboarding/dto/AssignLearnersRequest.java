package com.demoproject.onboarding.dto;

import lombok.Data;
import java.util.List;

@Data
public class AssignLearnersRequest {
    private List<String> cnums;
    private Long cohortId;
}

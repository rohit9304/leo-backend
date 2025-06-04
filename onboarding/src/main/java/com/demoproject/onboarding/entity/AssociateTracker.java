package com.demoproject.onboarding.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "associate_tracker")
public class AssociateTracker {
    @Id
    private String cnum;
    private String name; 
    private String internetEmail;
    private String jrs;
    private String status;
    private LocalDate sentToDefDate;
    private LocalDate lastUpdateDate;
    private String lastUpdatedBy;
    private Long cohortId;
}


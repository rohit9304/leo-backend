package com.demoproject.onboarding.entity;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "cohort")
public class Cohort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cohortName;
    private String geo;
    private String market;
    private String educationManager;
    private LocalDate endDate;
    private LocalDate startDate;
    private String status; 
    private LocalDate indctionProjectedEndDate;
    private LocalDate indctionProjectedStartDate;
    private LocalDate specialityTrainingStartDate;
    private LocalDate essentialProjectedndDate;
    private LocalDate essentialStartDate;
    private LocalDate y1GrowthSurveyEndDate;
    private LocalDate y1GrowthSurveyStartDate;
    private LocalDate stayAheadEventEndDate;
    private LocalDate stayAHeadEventStartDate;

//     Induction start date
// Induction projected end date
// Speciality training starts date
// Essential start date
// Essential projected end date
// Y1 growth survey start date
// Y1 growth survey end date
// Stay ahead start date
// Stay ahead end date
}

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
@Table(name = "population")
public class Population {
    @Id
    private String cnum;
    private String name;
    private String preferredFirstName;
    private String preferredLastName;
    private String internetEmail;
    private String geo;
    private String market;
    private String geoLnk;
    private String marketLnk;
    private String country;
    private String bandCd;
    private String jrs;
    private LocalDate hireDate;
}

package com.saathi.eHostel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leaves")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentCollegeRegistrationNo;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;
    private String status;
    private Long approvedByWarden;
    private Long approvedByTeacher;
    private LocalDate appliedDate;
}
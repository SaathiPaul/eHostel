package com.saathi.eHostel.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LeaveDTO {
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
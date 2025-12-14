package com.saathi.eHostel.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LeaveDTO {
    private long id;
    private long studentCollegeRegistrationNo;
    private long studentUniversityRollNo;

    private LocalDate fromDate;
    private LocalDate toDate;

    private String reason;

    private String status;

    private long approvedByWarden;
    private long approvedByTeacher;

    private LocalDate appliedDate;
}

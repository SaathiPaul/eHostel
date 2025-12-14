package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.LeaveDTO;
import com.saathi.eHostel.entity.Leave;

public class LeaveMapper {

    public static LeaveDTO toDTO(Leave leave) {
        if (leave == null) {
            return null;
        }

        return LeaveDTO.builder()
                .id(leave.getId())
                .studentCollegeRegistrationNo(leave.getStudentCollegeRegistrationNo())
                .fromDate(leave.getFromDate())
                .toDate(leave.getToDate())
                .reason(leave.getReason())
                .status(leave.getStatus())
                .approvedByWarden(leave.getApprovedByWarden())
                .approvedByTeacher(leave.getApprovedByTeacher())
                .appliedDate(leave.getAppliedDate())
                .build();
    }

    public static Leave toEntity(LeaveDTO dto) {
        if (dto == null) {
            return null;
        }

        return Leave.builder()
                .id(dto.getId())
                .studentCollegeRegistrationNo(dto.getStudentCollegeRegistrationNo())
                .fromDate(dto.getFromDate())
                .toDate(dto.getToDate())
                .reason(dto.getReason())
                .status(dto.getStatus())
                .approvedByWarden(dto.getApprovedByWarden())
                .approvedByTeacher(dto.getApprovedByTeacher())
                .appliedDate(dto.getAppliedDate())
                .build();
    }
}
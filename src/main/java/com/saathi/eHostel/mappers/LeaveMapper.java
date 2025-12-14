package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.LeaveDTO;
import com.saathi.eHostel.entity.Leave;

public class LeaveMapper {
    public static LeaveDTO toDTO(Leave leave) {
        if (leave == null) return null;

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

    public static Leave toEntity(LeaveDTO leaveDTO) {
        if (leaveDTO == null) return null;

        return Leave.builder()
//                .id(leaveDTO.getId())
                .studentCollegeRegistrationNo(leaveDTO.getStudentCollegeRegistrationNo())
                .fromDate(leaveDTO.getFromDate())
                .toDate(leaveDTO.getToDate())
                .reason(leaveDTO.getReason())
                .status(leaveDTO.getStatus())
                .approvedByWarden(leaveDTO.getApprovedByWarden())
                .approvedByTeacher(leaveDTO.getApprovedByTeacher())
                .appliedDate(leaveDTO.getAppliedDate())
                .build();
    }
}
package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.ComplaintDTO;
import com.saathi.eHostel.entity.Complaint;

public class ComplaintMapper {
    public static ComplaintDTO toDTO(Complaint complaint) {
        if (complaint == null) return null;

        return ComplaintDTO.builder()
                .id(complaint.getId())
                .createdByStudentId(complaint.getCreatedByStudentId())
                .message(complaint.getMessage())
                .status(complaint.getStatus())
                .createdAt(complaint.getCreatedAt())
                .build();
    }

    public static Complaint toEntity(ComplaintDTO complaintDTO) {
        if (complaintDTO == null) return null;

        return Complaint.builder()
//                .id(dto.getId())
                .createdByStudentId(complaintDTO.getCreatedByStudentId())
                .message(complaintDTO.getMessage())
                .status(complaintDTO.getStatus())
                .createdAt(complaintDTO.getCreatedAt())
                .build();
    }
}
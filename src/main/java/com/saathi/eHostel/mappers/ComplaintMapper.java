package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.ComplaintDTO;
import com.saathi.eHostel.entity.Complaint;

public class ComplaintMapper {
    public static ComplaintDTO toDTO(Complaint complaint)
    {
        if(complaint == null)
        {
            return null;
        }

        return ComplaintDTO.builder()
                .id(complaint.getId())
                .message(complaint.getMessage())
                .status(complaint.getStatus())
                .createdAt(complaint.getCreatedAt())
                .build();
    }

    public static Complaint toEntity(ComplaintDTO dto)
    {
        if(dto==null)
        {
            return null;
        }

        return Complaint.builder()
                .id(dto.getId())
                .message(dto.getMessage())
                .status(dto.getStatus())
                .createdAt(dto.getCreatedAt())
                .build();
    }


}

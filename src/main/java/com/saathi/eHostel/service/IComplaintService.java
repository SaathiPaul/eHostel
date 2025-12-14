package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.ComplaintDTO;
import java.util.List;

public interface IComplaintService {
    ComplaintDTO createComplaint(ComplaintDTO complaintDTO) throws Exception;

    List<ComplaintDTO> getAllComplaint() throws Exception;

    ComplaintDTO getComplaintById(Long id) throws Exception;
}
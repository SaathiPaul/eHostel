package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.ComplaintDTO;
import com.saathi.eHostel.repository.ComplaintRepository;

import java.util.List;


public class ComplaintService implements IComplaintService {
    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository)
    {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public ComplaintDTO createComplaint(ComplaintDTO complaintDTO) throws Exception {
        return null;
    }

    @Override
    public List<ComplaintDTO> getAllComplaint() throws Exception {
        return List.of();
    }
}
package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.ComplaintDTO;
import com.saathi.eHostel.entity.Complaint;
import com.saathi.eHostel.mappers.ComplaintMapper;
import com.saathi.eHostel.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintService implements IComplaintService {
    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository)
    {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public ComplaintDTO createComplaint(ComplaintDTO complaintDTO) throws Exception {
        Complaint entityToSave = ComplaintMapper.toEntity(complaintDTO);
        Complaint saved = complaintRepository.save(entityToSave);
        ComplaintDTO savedToDTO = ComplaintMapper.toDTO(saved);
        return savedToDTO;
    }

    @Override
    public List<ComplaintDTO> getAllComplaint() throws Exception {
        List<Complaint> allComplaintEntities = complaintRepository.findAll();
        List<ComplaintDTO> entitiesToDTO = new ArrayList<>();
        for(int i=0 ; i<allComplaintEntities.size() ; i++)
        {
            Complaint c = allComplaintEntities.get(i);
            ComplaintDTO converted = ComplaintMapper.toDTO(c);
            entitiesToDTO.add(converted);
        }
        return entitiesToDTO;

    }
}
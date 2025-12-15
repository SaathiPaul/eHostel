package com.saathi.eHostel.controller;

import com.saathi.eHostel.dto.ComplaintDTO;
import com.saathi.eHostel.service.IComplaintService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final IComplaintService complaintService;

    public ComplaintController(IComplaintService complaintService)
    {
        this.complaintService = complaintService;
    }

    @PostMapping
    public ComplaintDTO createComplaint(@RequestBody ComplaintDTO complaintDTO) throws Exception
    {
        return complaintService.createComplaint(complaintDTO);
    }

    @GetMapping
    public List<ComplaintDTO> getAllComplaints() throws Exception
    {
        return complaintService.getAllComplaint();
    }
}
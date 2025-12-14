package com.saathi.eHostel.controller;

import com.saathi.eHostel.dto.LeaveDTO;
import com.saathi.eHostel.service.ILeaveService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    private final ILeaveService leaveService;

    public LeaveController(ILeaveService _leaveService) {
        this.leaveService = _leaveService;
    }

    //Apply Leave
    @PostMapping("/apply")
    public LeaveDTO applyLeave(@RequestBody LeaveDTO leaveDTO) throws Exception {
        LeaveDTO dto = leaveService.applyLeave(leaveDTO);
        return dto;
    }

    //get all leaves
    @GetMapping
    public List<LeaveDTO> getAllLeaves() throws Exception {
        List<LeaveDTO> listOfAllLeaves = leaveService.getAllLeaves();
        return listOfAllLeaves;
    }

    // Get leave by LeaveId
    @GetMapping("/{id}")
    public LeaveDTO getLeaveById(@PathVariable Long id) throws Exception {
        LeaveDTO dto = leaveService.getLeaveById(id);
        return dto;
    }

    // Get Leaves By StudentId
    @GetMapping("/student/{studentId}")
    public List<LeaveDTO> getLeavesByStudentId(@PathVariable Long studentId) throws Exception {
        List<LeaveDTO> dto = leaveService.getLeavesByStudentId(studentId);
        return dto;
    }

    //delete leave - @Saathi write this

    // approve / reject leave by warden

    // approve / reject  leave by teacher
}
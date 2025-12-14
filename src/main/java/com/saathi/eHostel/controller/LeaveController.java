package com.saathi.eHostel.controller;


import com.saathi.eHostel.dto.LeaveDTO;
import com.saathi.eHostel.dto.StudentDTO;
import com.saathi.eHostel.service.ILeaveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {
    private final ILeaveService leaveService;
    public LeaveController(ILeaveService _leaveService)
    {
        this.leaveService = _leaveService;
    }

    //Apply Leave
    @PostMapping("/apply")
        public LeaveDTO applyLeave(@ResponseBody LeaveDTO leaveDTO) throws Exception
        {
            LeaveDTO dto = leaveService.applyLeave(leaveDTO);
            return dto;
        }


    //get all leaves
    @GetMapping
    public List<LeaveDTO> getAllLeaves() throws Exception
    {
        List<LeaveDTO> ListOfAllLeaves = leaveService.getAllLeaves();
        return ListOfAllLeaves;

    }

    //get Leaves By StudentId
    @GetMapping("/{studentId}")
    public LeaveDTO getLeavesByStudentId(@PathVariable Long studentId) throws Exception {
        LeaveDTO dto = leaveService.getLeavesByStudentId(studentId);
        return dto;
    }


    //get leave by Id
    @GetMapping("/{Id}")
    public LeaveDTO getLeaveById(@PathVariable Long id) throws Exception
    {
        LeaveDTO dto = leaveService.getLeaveById(id);
        return dto;
    }


    // approve / reject leave by warden





    // approve / reject  leave by teacher



    //delete leave






}

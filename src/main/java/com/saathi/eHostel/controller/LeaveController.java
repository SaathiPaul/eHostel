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

    // Apply Leave
    @PostMapping("/apply")
    public LeaveDTO applyLeave(@RequestBody LeaveDTO leaveDTO) throws Exception {
        return leaveService.applyLeave(leaveDTO);
    }

    // Get all leaves
    @GetMapping
    public List<LeaveDTO> getAllLeaves() throws Exception {
        return leaveService.getAllLeaves();
    }

    // Get leave by LeaveId
    @GetMapping("/{id}")
    public LeaveDTO getLeaveById(@PathVariable Long id) throws Exception {
        return leaveService.getLeaveById(id);
    }

    // Get Leaves By StudentId
    @GetMapping("/student/{studentId}")
    public List<LeaveDTO> getLeavesByStudentId(@PathVariable Long studentId) throws Exception {
        return leaveService.getLeavesByStudentId(studentId);
    }

    // Delete leave
    @DeleteMapping("/{id}")
    public String deleteLeave(@PathVariable Long id) throws Exception {
        boolean isDeleted = leaveService.deleteLeave(id);
        if (isDeleted) {
            return "Leave deleted successfully";
        }
        return "Leave not found";
    }

    // Approve / Reject leave by Teacher
    // Example: PUT /api/leaves/1/teacher/10?isApproved=true
    @PutMapping("/{id}/teacher/{teacherId}")
    public LeaveDTO approveRejectByTeacher(
            @PathVariable Long id,
            @PathVariable Long teacherId,
            @RequestParam boolean isApproved) throws Exception {
        return leaveService.updateLeaveStatusByTeacher(id, teacherId, isApproved);
    }

    // Approve / Reject leave by Warden
    // Example: PUT /api/leaves/1/warden/5?isApproved=false
    @PutMapping("/{id}/warden/{wardenId}")
    public LeaveDTO approveRejectByWarden(
            @PathVariable Long id,
            @PathVariable Long wardenId,
            @RequestParam boolean isApproved) throws Exception {
        return leaveService.updateLeaveStatusByWarden(id, wardenId, isApproved);
    }
}
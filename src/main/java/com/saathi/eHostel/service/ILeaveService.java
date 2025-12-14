package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.LeaveDTO;
import java.util.List;

public interface ILeaveService {
    LeaveDTO applyLeave(LeaveDTO leaveDTO);

    List<LeaveDTO> getAllLeaves();

    List<LeaveDTO> getLeavesByStudentId(Long studentId);

    LeaveDTO getLeaveById(Long leaveId);

    LeaveDTO approveLeaveByWarden(Long leaveId, Long wardenId);

    LeaveDTO approveLeaveByTeacher(Long leaveId, Long teacherId);

    boolean deleteLeave(Long leaveId);
}
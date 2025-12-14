package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.LeaveDTO;
import java.util.List;

public interface ILeaveService {
    LeaveDTO applyLeave(LeaveDTO leaveDTO) throws Exception;

    List<LeaveDTO> getAllLeaves() throws Exception;

    LeaveDTO getLeaveById(Long leaveId) throws Exception;

    boolean deleteLeave(Long leaveId) throws Exception;

    List<LeaveDTO> getLeavesByStudentId(Long studentId) throws Exception;

    LeaveDTO approveLeaveByWarden(Long leaveId, Long wardenId) throws Exception;

    LeaveDTO approveLeaveByTeacher(Long leaveId, Long teacherId) throws Exception;
}
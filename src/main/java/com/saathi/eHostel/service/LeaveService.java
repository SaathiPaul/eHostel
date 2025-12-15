package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.LeaveDTO;
import com.saathi.eHostel.entity.Leave;
import com.saathi.eHostel.mappers.LeaveMapper;
import com.saathi.eHostel.repository.LeaveRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveService implements ILeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Override
    public LeaveDTO applyLeave(LeaveDTO leaveDTO) throws Exception {
        // Default status when applying
        leaveDTO.setStatus("Applied");
        leaveDTO.setAppliedDate(LocalDate.now());
        Leave entityToSave = LeaveMapper.toEntity(leaveDTO);
        Leave saved = leaveRepository.save(entityToSave);
        return LeaveMapper.toDTO(saved);
    }

    @Override
    public List<LeaveDTO> getAllLeaves() {
        List<Leave> allLeaveEntities = leaveRepository.findAll();
        List<LeaveDTO> entitiesToDto = new ArrayList<>();
        for (Leave l : allLeaveEntities) {
            LeaveDTO converted = LeaveMapper.toDTO(l);
            entitiesToDto.add(converted);
        }
        return entitiesToDto;
    }

    @Override
    public LeaveDTO getLeaveById(Long leaveId) throws Exception {
        Leave entity = leaveRepository.findById(leaveId).orElse(null);
        return LeaveMapper.toDTO(entity);
    }

    @Override
    public List<LeaveDTO> getLeavesByStudentId(Long studentId) throws Exception {
        List<Leave> leaveEntities = leaveRepository.findByStudentCollegeRegistrationNo(studentId);
        List<LeaveDTO> entitiesToDto = new ArrayList<>();
        for (Leave l : leaveEntities) {
            LeaveDTO converted = LeaveMapper.toDTO(l);
            entitiesToDto.add(converted);
        }
        return entitiesToDto;
    }

    @Override
    public boolean deleteLeave(Long leaveId) {
        if (leaveRepository.existsById(leaveId)) {
            leaveRepository.deleteById(leaveId);
            return true;
        }
        return false;
    }

    @Override
    public LeaveDTO updateLeaveStatusByTeacher(Long leaveId, Long teacherId, boolean isApproved) throws Exception {
        Leave leave = leaveRepository.findById(leaveId).orElse(null);
        if (leave == null) {
            throw new Exception("Leave Application not found with ID: " + leaveId);
        }
        leave.setApprovedByTeacher(teacherId);
        if (isApproved) {
            leave.setStatus("Approved by Teacher");
        } else {
            leave.setStatus("Rejected by Teacher");
        }
        Leave saved = leaveRepository.save(leave);
        return LeaveMapper.toDTO(saved);
    }

    @Override
    public LeaveDTO updateLeaveStatusByWarden(Long leaveId, Long wardenId, boolean isApproved) throws Exception {
        Leave leave = leaveRepository.findById(leaveId).orElse(null);
        if (leave == null) {
            throw new Exception("Leave Application not found with ID: " + leaveId);
        }
        leave.setApprovedByWarden(wardenId);
        if (isApproved) {
            leave.setStatus("Approved by Warden");
        } else {
            leave.setStatus("Rejected by Warden");
        }
        Leave saved = leaveRepository.save(leave);
        return LeaveMapper.toDTO(saved);
    }
}
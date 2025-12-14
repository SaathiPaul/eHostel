package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.LeaveDTO;
import com.saathi.eHostel.entity.Leave;
import com.saathi.eHostel.mappers.LeaveMapper;
import com.saathi.eHostel.repository.LeaveRepository;
import org.springframework.stereotype.Service;
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
        // convert leaveDTO to leave ENTITY -- for convert use mapper
        // save to database -- for saving use leaveRepository
        // reconvert leave entity to leaveDTO -- -- for convert use mapper
        //return the DTO
        Leave entityToSave = LeaveMapper.toEntity(leaveDTO);
        Leave saved = leaveRepository.save(entityToSave);
        LeaveDTO savedToDto = LeaveMapper.toDTO(saved);
        return savedToDto;
    }

    @Override
    public List<LeaveDTO> getAllLeaves() {
        // the database contains entities not dtos
        // first get the list of all leave entities from the database
        // then convert each leave entity in the list to LeaveDTO
        // return the List of leaveDTO
        List<Leave> allLeaveEntities = leaveRepository.findAll();
        List<LeaveDTO> entitiesToDto = new ArrayList<>();
        for (int i = 0; i < allLeaveEntities.size(); i++) {
            Leave l = allLeaveEntities.get(i);
            LeaveDTO converted = LeaveMapper.toDTO(l);
            entitiesToDto.add(converted);
        }
        return entitiesToDto;
    }

    @Override
    public LeaveDTO getLeaveById(Long leaveId) throws Exception {
        // find the student entity in the repository/database;
        // convert to leaveDTO if found;
        // return the dto
        Leave entity = leaveRepository.findById(leaveId).orElse(null);
        LeaveDTO dto = LeaveMapper.toDTO(entity);
        return dto;
    }

    @Override
    public List<LeaveDTO> getLeavesByStudentId(Long studentId) throws Exception {
        // find the student entity in the repository/database;
        // convert to leaveDTO if found;
        // return the dto
        List<Leave> leaveEntities = leaveRepository.findByStudentCollegeRegistrationNo(studentId);
        List<LeaveDTO> entitiesToDto = new ArrayList<>();
        for (int i = 0; i < leaveEntities.size(); i++) {
            Leave l = leaveEntities.get(i);
            LeaveDTO converted = LeaveMapper.toDTO(l);
            entitiesToDto.add(converted);
        }
        return entitiesToDto;
    }

    @Override
    public boolean deleteLeave(Long leaveId) {
        return false;
    }

    @Override
    public LeaveDTO approveLeaveByWarden(Long leaveId, Long wardenId) {
        return null;
    }

    @Override
    public LeaveDTO approveLeaveByTeacher(Long leaveId, Long teacherId) {
        return null;
    }
}
package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.AuthenticateDTO;
import com.saathi.eHostel.dto.AuthenticateResponseDTO;
import com.saathi.eHostel.dto.TeacherDTO;
import com.saathi.eHostel.entity.Teacher;
import com.saathi.eHostel.mappers.TeacherMapper;
import com.saathi.eHostel.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements ITeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public AuthenticateResponseDTO authenticateTeacher(AuthenticateDTO dto) throws Exception {
        Teacher teacherEntity = teacherRepository.findByEmail(dto.getEmail());
        if (teacherEntity == null) {
            return AuthenticateResponseDTO.builder()
                    .message("User not found.")
                    .userId(0L)
                    .isCorrectPass(false)
                    .userType("teacher")
                    .build();
        }
        if (teacherEntity.getPassword().equals(dto.getPassword())) {
            return AuthenticateResponseDTO.builder()
                    .message("User Logged in Successfully.")
                    .userId(teacherEntity.getId())
                    .isCorrectPass(true)
                    .userType("teacher")
                    .build();
        }
        return AuthenticateResponseDTO.builder()
                .message("Invalid Password for user " + teacherEntity.getEmail() + ".")
                .userId(teacherEntity.getId())
                .isCorrectPass(false)
                .userType("teacher")
                .build();
    }

    @Override
    public TeacherDTO addTeacher(TeacherDTO teacherDTO) throws Exception {
        Teacher entityToSave = TeacherMapper.toEntity(teacherDTO);
        Teacher saved = teacherRepository.save(entityToSave);
        TeacherDTO savedToDto = TeacherMapper.toDTO(saved);
        return savedToDto;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() throws IOException {
        List<Teacher> allTeacherEntities = teacherRepository.findAll();
        List<TeacherDTO> entitiesToDto = new ArrayList<>();
        for (int i = 0; i < allTeacherEntities.size(); i++) {
            Teacher t = allTeacherEntities.get(i);
            TeacherDTO converted = TeacherMapper.toDTO(t);
            entitiesToDto.add(converted);
        }
        return entitiesToDto;
    }

    @Override
    public TeacherDTO getTeacherById(Long id) throws Exception {
        Teacher entity = teacherRepository.findById(id).orElse(null);
        TeacherDTO dto = TeacherMapper.toDTO(entity);
        return dto;
    }

    @Override
    public TeacherDTO deleteTeacher(Long id) throws Exception {
        Teacher entity = teacherRepository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        TeacherDTO dto = TeacherMapper.toDTO(entity);
        teacherRepository.deleteById(id);
        return dto;
    }
}
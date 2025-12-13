package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.StudentDTO;
import com.saathi.eHostel.dto.TeacherDTO;
import com.saathi.eHostel.entity.Student;
import com.saathi.eHostel.entity.Teacher;
import com.saathi.eHostel.mappers.StudentMapper;
import com.saathi.eHostel.mappers.TeacherMapper;
import com.saathi.eHostel.repository.StudentRepository;
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
        for(int i = 0; i < allTeacherEntities.size(); i++) {
            Teacher t = allTeacherEntities.get(i);
            TeacherDTO converted = TeacherMapper.toDTO(t);
            entitiesToDto.add(converted);
        }
        return entitiesToDto;
    }

    @Override
    public boolean deleteTeacher(Long id) throws Exception {
        return false;
    }

    @Override
    public TeacherDTO getTeacherById(Long id) throws IOException {
        return null;
    }
}
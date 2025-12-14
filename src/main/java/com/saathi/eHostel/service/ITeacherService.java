package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.AuthenticateDTO;
import com.saathi.eHostel.dto.AuthenticateResponseDTO;
import com.saathi.eHostel.dto.TeacherDTO;
import java.util.List;

public interface ITeacherService {
    TeacherDTO getTeacherById(Long id) throws Exception;

    TeacherDTO addTeacher(TeacherDTO dto) throws Exception;

    List<TeacherDTO> getAllTeachers() throws Exception;

    TeacherDTO deleteTeacher(Long id) throws Exception;

    AuthenticateResponseDTO authenticateTeacher(AuthenticateDTO dto) throws Exception;
}
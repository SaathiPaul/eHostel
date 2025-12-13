package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.StudentDTO;
import jdk.jfr.Category;

import java.io.IOException;
import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAllStudents() throws IOException;

    StudentDTO addStudent(StudentDTO studentDTO) throws Exception;

    StudentDTO getStudentById(Long id) throws Exception;

    StudentDTO deleteStudent(Long id) throws Exception;
}
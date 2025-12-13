package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.StudentDTO;
import com.saathi.eHostel.entity.Student;

public class StudentMapper {
    public static StudentDTO toDTO(Student student)
    {
        return StudentDTO.builder()
                .id(student.getId())
                .email(student.getEmail())
                .phone(student.getPhone())
                .name(student.getName())
                .roomNumber(student.getRoomNumber())
                .build();
    }

    public static Student toEntity(StudentDTO studentDTO)
    {
        return Student.builder()
                .name(studentDTO.getName())
//                .id(studentDTO.getId())
                .email(studentDTO.getEmail())
                .phone(studentDTO.getPhone())
                .roomNumber(studentDTO.getRoomNumber())
                .build();
    }
}
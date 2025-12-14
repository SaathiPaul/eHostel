package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.TeacherDTO;
import com.saathi.eHostel.entity.Teacher;

public class TeacherMapper {
    public static TeacherDTO toDTO(Teacher teacher)
    {
        return TeacherDTO.builder()
                .id(teacher.getId())
                .email(teacher.getEmail())
                .phone(teacher.getPhone())
                .name(teacher.getName())
                .department(teacher.getDepartment())
                .build();
    }

    public static Teacher toEntity(TeacherDTO teacherDTO)
    {
        return Teacher.builder()
                .name(teacherDTO.getName())
               // .id(teacherDTO.getId())
                .email(teacherDTO.getEmail())
                .phone(teacherDTO.getPhone())
                .department(teacherDTO.getDepartment())
                .build();
    }
}
package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.TeacherDTO;
import com.saathi.eHostel.entity.Teacher;

public class TeacherMapper {
    public static TeacherDTO toDTO(Teacher teacher) {
        if (teacher == null) return null;

        return TeacherDTO.builder()
                .id(teacher.getId())
                .email(teacher.getEmail())
                .phone(teacher.getPhone())
                .name(teacher.getName())
                .department(teacher.getDepartment())
//                .password(teacher.getPassword())
                .build();
    }

    public static Teacher toEntity(TeacherDTO teacherDTO) {
        if (teacherDTO == null) return null;

        return Teacher.builder()
                .name(teacherDTO.getName())
                // .id(teacherDTO.getId())
                .email(teacherDTO.getEmail())
                .phone(teacherDTO.getPhone())
                .department(teacherDTO.getDepartment())
                .password(teacherDTO.getPassword())
                .build();
    }
}
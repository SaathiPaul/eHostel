package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.StudentDTO;
import com.saathi.eHostel.entity.Student;

public class StudentMapper {

    // Entity → DTO
    public static StudentDTO toDTO(Student student) {
        if (student == null) return null;

        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .registrationNumber(student.getRegistrationNumber())
                .department(student.getDepartment())
                .email(student.getEmail())
                .phone(student.getPhone())
                .guardianPhone(student.getGuardianPhone())
                .roomNumber(student.getRoomNumber())
//                .password(student.getPassword())
                .build();
    }

    // DTO → Entity
    public static Student toEntity(StudentDTO studentDTO) {
        if (studentDTO == null) return null;

        return Student.builder()
                // id is intentionally NOT set
                .name(studentDTO.getName())
                .registrationNumber(studentDTO.getRegistrationNumber())
                .department(studentDTO.getDepartment())
                .email(studentDTO.getEmail())
                .phone(studentDTO.getPhone())
                .guardianPhone(studentDTO.getGuardianPhone())
                .roomNumber(studentDTO.getRoomNumber())
                .password(studentDTO.getPassword())
                .build();
    }
}
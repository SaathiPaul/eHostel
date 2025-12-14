package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.AuthenticateDTO;
import com.saathi.eHostel.dto.AuthenticateResponseDTO;
import com.saathi.eHostel.dto.StudentDTO;
import com.saathi.eHostel.entity.Student;
import com.saathi.eHostel.mappers.StudentMapper;
import com.saathi.eHostel.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public AuthenticateResponseDTO authenticateStudent(AuthenticateDTO dto) throws Exception {
        Student studentEntity = studentRepository.findByEmail(dto.getEmail());
        if(studentEntity == null) {
            return AuthenticateResponseDTO.builder()
                    .message("User not found.")
                    .userId(0L)
                    .isCorrectPass(false)
                    .userType("student")
                    .build();
        }
        if(studentEntity.getPassword().equals(dto.getPassword())) {
            return AuthenticateResponseDTO.builder()
                    .message("User Logged in Successfully.")
                    .userId(studentEntity.getId())
                    .isCorrectPass(true)
                    .userType("student")
                    .build();
        }
        return AuthenticateResponseDTO.builder()
                .message("Invalid Password for user " + studentEntity.getEmail() + ".")
                .userId(studentEntity.getId())
                .isCorrectPass(false)
                .userType("student")
                .build();
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) throws Exception {
        // convert studentDTO to Student ENTITY -- for convert use mapper
        // save to database -- for saving use studentRepository
        // reconvert Student entity to studentDTO -- -- for convert use mapper
        //return the DTO
        Student entityToSave = StudentMapper.toEntity(studentDTO);
        Student saved = studentRepository.save(entityToSave);
        StudentDTO savedToDto = StudentMapper.toDTO(saved);
        return savedToDto;
    }

    @Override
    public List<StudentDTO> getAllStudents() throws IOException {
        // the database contains entities not dtos
        // first get the list of all Student entities from the database
        // then convert each Student entity in the list to StudentDTO
        // return the List of studentDTO
        List<Student> allStudentEntities = studentRepository.findAll(); // A. B. C
        List<StudentDTO> entitiesToDto = new ArrayList<>();
        for(int i = 0; i < allStudentEntities.size(); i++) {
            Student s = allStudentEntities.get(i); //A entity
            StudentDTO converted = StudentMapper.toDTO(s); // A dto
            entitiesToDto.add(converted);
        }
        return entitiesToDto;
    }

    @Override
    public StudentDTO getStudentById(Long id) throws Exception {
        // find the student entity in the repository/database;
        // convert to studentDTO if found;
        // return the dto
        Student entity = studentRepository.findById(id).orElse(null);
        StudentDTO dto = StudentMapper.toDTO(entity);
        return dto;
    }

    @Override
    public StudentDTO deleteStudent(Long id) throws Exception {
        Student entity = studentRepository.findById(id).orElse(null); // 1,2, ,4
        if(entity == null) {
            return null;
        }
        StudentDTO dto = StudentMapper.toDTO(entity);
        studentRepository.deleteById(id);
        return dto;
    }
}
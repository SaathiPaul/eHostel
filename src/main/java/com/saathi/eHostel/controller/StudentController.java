package com.saathi.eHostel.controller;

import com.saathi.eHostel.dto.AuthenticateDTO;
import com.saathi.eHostel.dto.AuthenticateResponseDTO;
import com.saathi.eHostel.dto.StudentDTO;
import com.saathi.eHostel.service.IStudentService;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService _studentService) {
        this.studentService = _studentService;
    }

    // Register or add a Student
    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        // you will receive a studentDTO
        // YOU WILL PASS THE DTO to the service layer
        // the service layer will return you back a DTO
        StudentDTO dto = studentService.addStudent(studentDTO);
        return dto;
    }

    // Login a student using email and password
    @PostMapping("/login")
    public AuthenticateResponseDTO authenticateStudent(@RequestBody AuthenticateDTO dto) throws Exception {
        return studentService.authenticateStudent(dto);
    }

    // Get All Students
    @GetMapping
    public List<StudentDTO> getAllStudents() throws IOException { // (1) -> (2')
        List<StudentDTO> listOfAllStudents = studentService.getAllStudents();
        return listOfAllStudents;
    }

    // Get Student By ID
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) throws Exception { // 1,2,3, null
        StudentDTO studentDTO = studentService.getStudentById(id);
        return studentDTO;
    }

    // Get Student By College ID
    @GetMapping("/cldId/{id}")
    public StudentDTO getStudentByCollegeId(@PathVariable String clgId) throws Exception { // 1,2,3, null
        StudentDTO studentDTO = studentService.getStudentByCollegeId(clgId);
        return studentDTO;
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) throws Exception {
        StudentDTO dto = studentService.deleteStudent(id);
        if (dto == null) {
            return "Student not found.";
        }
        return "Student deleted successfully";
    }
}
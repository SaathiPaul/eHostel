package com.saathi.eHostel.controller;

import com.saathi.eHostel.dto.TeacherDTO;
import com.saathi.eHostel.entity.Teacher;
import com.saathi.eHostel.repository.TeacherRepository;
import com.saathi.eHostel.service.ITeacherService;
import com.saathi.eHostel.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private final ITeacherService teacherService;

    public TeacherController(ITeacherService teacherService)
    {
        this.teacherService = teacherService;
    }

    @PostMapping
    public TeacherDTO addTeacher(@RequestBody TeacherDTO teacherDTO) throws Exception {
        TeacherDTO dto = teacherService.addTeacher(teacherDTO);
        return dto;
    }


    @GetMapping
    public List<TeacherDTO> getAllTeachers() throws Exception {
        List<TeacherDTO> listOfAllTeachers = teacherService.getAllTeachers();
        return listOfAllTeachers;
    }


    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id) throws Exception {
        TeacherDTO teacherDTO = teacherService.getTeacherById(id);
        return teacherDTO;
    }


    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) throws Exception {
        TeacherDTO dto = teacherService.deleteTeacher(id);
        if(dto == null) {
            return "Teacher not found.";
        }
        return "Teacher deleted successfully";
    }

}

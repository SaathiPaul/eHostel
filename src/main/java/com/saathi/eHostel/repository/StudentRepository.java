package com.saathi.eHostel.repository;

import com.saathi.eHostel.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
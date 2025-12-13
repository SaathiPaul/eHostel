package com.saathi.eHostel.repository;

import com.saathi.eHostel.entity.Teacher;
import com.saathi.eHostel.entity.Warden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}

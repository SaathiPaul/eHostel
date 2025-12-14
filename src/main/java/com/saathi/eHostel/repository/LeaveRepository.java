package com.saathi.eHostel.repository;

import com.saathi.eHostel.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
    List<Leave> findByStudentCollegeRegistrationNo(Long studentId);
}
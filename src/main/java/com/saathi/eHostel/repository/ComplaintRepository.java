package com.saathi.eHostel.repository;

import com.saathi.eHostel.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
   // List<Complaint> findAll(Long ComplaintId);
}

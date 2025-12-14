package com.saathi.eHostel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository<Complaint> extends JpaRepository<Complaint, Long> {
}

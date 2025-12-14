package com.saathi.eHostel.repository;

import com.saathi.eHostel.entity.Warden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardenRepository extends JpaRepository<Warden, Long> {
    Warden findByEmail(String email);
}
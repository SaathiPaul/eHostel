package com.saathi.eHostel.repository;

import com.saathi.eHostel.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("""
            SELECT n FROM Notice n
            JOIN FETCH n.createdByWarden
            WHERE n.id = :id
    """)
    Optional<Notice> findByIdWithWarden(Long id);
}
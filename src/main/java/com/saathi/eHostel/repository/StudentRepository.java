package com.saathi.eHostel.repository;

import com.saathi.eHostel.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail(String email);

//    @Query(value = "SELECT * FROM students WHERE email = :email AND password = :password", nativeQuery = true)
//    Student authenticate(@Param("email") String email, @Param("password") String password);
}
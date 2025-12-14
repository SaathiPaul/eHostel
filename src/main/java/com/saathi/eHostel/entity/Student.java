package com.saathi.eHostel.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String registrationNumber;
    private String department;
    private String email;
    private String phone;
    private String guardianPhone;
    private String roomNumber;
    private String password;
}
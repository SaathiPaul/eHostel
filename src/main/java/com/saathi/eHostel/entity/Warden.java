package com.saathi.eHostel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wardens")
public class Warden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @OneToMany(mappedBy = "createdByWarden", fetch = FetchType.LAZY)
    private List<Notice> notices = new ArrayList<>();
}
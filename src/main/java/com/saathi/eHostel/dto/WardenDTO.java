package com.saathi.eHostel.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class WardenDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
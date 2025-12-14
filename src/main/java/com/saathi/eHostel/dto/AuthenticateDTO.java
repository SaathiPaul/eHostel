package com.saathi.eHostel.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateDTO {
    private String email;
    private String password;
}
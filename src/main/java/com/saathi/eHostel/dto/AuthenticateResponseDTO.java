package com.saathi.eHostel.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateResponseDTO {
    private boolean isCorrectPass;
    public String userType;
    public Long userId;
}
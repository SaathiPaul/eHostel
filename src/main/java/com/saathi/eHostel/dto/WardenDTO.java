package com.saathi.eHostel.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class WardenDTO {
    private long id;
    private String name;
    private String email;
    private String number;
}

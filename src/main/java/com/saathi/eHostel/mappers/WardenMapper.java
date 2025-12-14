package com.saathi.eHostel.mappers;


import com.saathi.eHostel.dto.WardenDTO;
import com.saathi.eHostel.entity.Warden;

public class WardenMapper {
    public static WardenDTO toDTO(Warden warden)
    {
        return WardenDTO.builder()
                .id(warden.getId())
                .email(warden.getEmail())
                .phone(warden.getPhone())
                .name(warden.getName())
                .build();
    }

    public static Warden toEntity(WardenDTO wardenDTO)
    {
        return Warden.builder()
                .name(wardenDTO.getName())
               // .id(wardenDTO.getId())
                .email(wardenDTO.getEmail())
                .phone(wardenDTO.getPhone())
                .build();
    }
}

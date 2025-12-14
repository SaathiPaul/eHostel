package com.saathi.eHostel.mappers;

import com.saathi.eHostel.dto.WardenDTO;
import com.saathi.eHostel.entity.Warden;

public class WardenMapper {
    public static WardenDTO toDTO(Warden warden) {
        if(warden == null) return null;

        return WardenDTO.builder()
                .id(warden.getId())
                .email(warden.getEmail())
                .phone(warden.getPhone())
                .name(warden.getName())
//                .password(warden.getPassword())
                .build();
    }

    public static Warden toEntity(WardenDTO wardenDTO) {
        if(wardenDTO == null) return null;

        return Warden.builder()
                .name(wardenDTO.getName())
                // .id(wardenDTO.getId())
                .email(wardenDTO.getEmail())
                .phone(wardenDTO.getPhone())
                .password(wardenDTO.getPassword())
                .build();
    }
}
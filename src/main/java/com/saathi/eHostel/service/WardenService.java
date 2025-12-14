package com.saathi.eHostel.service;


import com.saathi.eHostel.dto.WardenDTO;
import com.saathi.eHostel.entity.Warden;
import com.saathi.eHostel.mappers.WardenMapper;
import com.saathi.eHostel.repository.WardenRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WardenService implements IWardenService {

    private final WardenRepository wardenRepository;

    public WardenService(WardenRepository wardenRepository) {
        this.wardenRepository = wardenRepository;
    }


    @Override
    public WardenDTO addWarden(WardenDTO wardenDTO) throws Exception {
        Warden entityToSave = WardenMapper.toEntity(wardenDTO);
        Warden saved = wardenRepository.save(entityToSave);
        WardenDTO savedToDto = WardenMapper.toDTO(saved);
        return savedToDto;
    }


    @Override
    public List<WardenDTO> getAllWardens() throws IOException {
        List<Warden> allWardenEntities = wardenRepository.findAll();
        List<WardenDTO> entitiesToDto = new ArrayList<>();

        for (int i = 0; i < allWardenEntities.size(); i++) {
            Warden w = allWardenEntities.get(i);
            WardenDTO converted = WardenMapper.toDTO(w);
            entitiesToDto.add(converted);
        }
        return entitiesToDto;
    }


    @Override
    public WardenDTO getWardenById(Long id) throws Exception {
        Warden entity = wardenRepository.findById(id).orElse(null);
        WardenDTO dto = WardenMapper.toDTO(entity);
        return dto;
    }


    @Override
    public WardenDTO deleteWarden(Long id) throws Exception {
        Warden entity = wardenRepository.findById(id).orElse(null);

        if (entity == null) {
            return null;
        }
        WardenDTO dto = WardenMapper.toDTO(entity);
        wardenRepository.deleteById(id);
        return dto;
    }
}


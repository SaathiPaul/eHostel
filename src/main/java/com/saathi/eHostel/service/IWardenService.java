package com.saathi.eHostel.service;

import com.saathi.eHostel.controller.WardenController;
import com.saathi.eHostel.dto.WardenDTO;

import java.util.List;

public interface IWardenService {
    WardenDTO getWardenById(Long id) throws Exception;
    WardenDTO addWarden(WardenDTO dto) throws Exception;
    List<WardenDTO> getAllWardens() throws Exception;
    WardenDTO deleteWarden(Long id) throws Exception;

}
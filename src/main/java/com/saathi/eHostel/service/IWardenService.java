package com.saathi.eHostel.service;

import com.saathi.eHostel.dto.AuthenticateDTO;
import com.saathi.eHostel.dto.AuthenticateResponseDTO;
import com.saathi.eHostel.dto.WardenDTO;
import java.util.List;

public interface IWardenService {
    AuthenticateResponseDTO authenticateWarden(AuthenticateDTO dto) throws Exception;

    WardenDTO getWardenById(Long id) throws Exception;

    WardenDTO addWarden(WardenDTO dto) throws Exception;

    List<WardenDTO> getAllWardens() throws Exception;

    WardenDTO deleteWarden(Long id) throws Exception;
}
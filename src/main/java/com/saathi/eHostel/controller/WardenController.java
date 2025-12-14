package com.saathi.eHostel.controller;

import com.saathi.eHostel.dto.WardenDTO;
import com.saathi.eHostel.service.IWardenService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/wardens")


public class WardenController {

    private final IWardenService wardenService;

    public WardenController(IWardenService _wardenService) {
        this.wardenService = _wardenService;
    }

    // Add Warden
    @PostMapping
    public WardenDTO addWarden(@RequestBody WardenDTO wardenDTO) throws Exception {
        WardenDTO dto = wardenService.addWarden(wardenDTO);
        return dto;
    }

    // Get All Wardens
    @GetMapping
    public List<WardenDTO> getAllWardens() throws Exception {
        List<WardenDTO> listOfAllWardens = wardenService.getAllWardens();
        return listOfAllWardens;
    }

    // Get Warden By ID
    @GetMapping("/{id}")
    public WardenDTO getWardenById(@PathVariable Long id) throws Exception {
        WardenDTO wardenDTO = wardenService.getWardenById(id);
        return wardenDTO;
    }

    // Delete Warden
    @DeleteMapping("/{id}")
    public String deleteWarden(@PathVariable Long id) throws Exception {
        WardenDTO dto = wardenService.deleteWarden(id);
        if (dto == null) {
            return "Warden not found.";
        }
        return "Warden deleted successfully";
    }
}


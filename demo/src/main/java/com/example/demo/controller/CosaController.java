package com.example.demo.controller;

import com.example.demo.controller.dto.CosaDTO;
import com.example.demo.service.CosaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cosas")
@Tag(name = "Cosa Controller", description = "Controller for managing Cosa entities")

public class CosaController {

        private final CosaService cosaService;

        @Autowired
        public CosaController(CosaService cosaService) {
            this.cosaService = cosaService;
        }

    @Operation(summary = "Get Cosa by ID", description = "Fetch a Cosa entity by its ID")
    @GetMapping("/{id}")  // Este es el endpoint para obtener una Cosa por su ID
    public CosaDTO getCosa(
            @Parameter(description = "ID of the Cosa to fetch", required = true) @PathVariable Long id) {
        return cosaService.getCosa(id);
    }
    @Operation(summary = "Get Cosas by Propietario", description = "Fetch Cosas associated with a Propietario")
    @GetMapping
    public List<CosaDTO> getCosasPorPropietario(@RequestParam("propietario") Long propietario) {
        return cosaService.getCosasPorPropietario(propietario);
    }

    @Operation(summary = "Create or update a Cosa", description = "Create a new Cosa or update an existing one")
        @PostMapping
        public CosaDTO createCosa(
                @Parameter(description = "Cosa object to create or update", required = true) @RequestBody CosaDTO cosa) {
            return cosaService.setCosa(cosa);
        }

        @Operation(summary = "Create or update a Cosa", description = "Create a new Cosa or update an existing one")
        @PutMapping
        public CosaDTO updateCosa(
                @Parameter(description = "Cosa object to create or update", required = true) @RequestBody CosaDTO cosa) {
            return cosaService.setCosa(cosa);
        }

        @Operation(summary = "Delete a Cosa by ID", description = "Delete an existing Cosa entity by its ID")
        @DeleteMapping("/{id}")
        public void deleteCosa(
                @Parameter(description = "ID of the Cosa to delete", required = true) @PathVariable Long id) {
            cosaService.deleteCosa(id);
        }

}

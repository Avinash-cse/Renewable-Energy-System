package com.skillfirstlab.windservice.controller;

import com.skillfirstlab.windservice.dto.WindTurbineDTO;
import com.skillfirstlab.windservice.entity.WindTurbine;
import com.skillfirstlab.windservice.service.WindTurbineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wind-turbines")
public class WindTurbineController {

    private final WindTurbineService service;

    public WindTurbineController(WindTurbineService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WindTurbine> addWindTurbine(@Valid @RequestBody WindTurbineDTO dto) {

        return new ResponseEntity<>(service.addWindTurbine(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WindTurbine>> getAllWindTurbines() {

        return ResponseEntity.ok(service.getAllWindTurbines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WindTurbine> getWindTurbineById(@PathVariable Long id) {

        return ResponseEntity.ok(service.getWindTurbineById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WindTurbine> updateWindTurbine(@PathVariable Long id,
                                                         @Valid @RequestBody WindTurbineDTO dto) {

        return ResponseEntity.ok(service.updateWindTurbine(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWindTurbine(@PathVariable Long id) {

        service.deleteWindTurbine(id);

        return ResponseEntity.ok("Wind Turbine deleted successfully.");
    }
}
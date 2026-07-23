package com.skillfirstlab.solarservice.controller;

import com.skillfirstlab.solarservice.dto.SolarPanelDTO;
import com.skillfirstlab.solarservice.entity.SolarPanel;
import com.skillfirstlab.solarservice.service.SolarPanelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solar-panels")
public class SolarPanelController {

    private final SolarPanelService service;

    public SolarPanelController(SolarPanelService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SolarPanel> addSolarPanel(@Valid @RequestBody SolarPanelDTO dto) {
        return new ResponseEntity<>(service.addSolarPanel(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SolarPanel>> getAllSolarPanels() {
        return ResponseEntity.ok(service.getAllSolarPanels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolarPanel> getSolarPanelById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSolarPanelById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolarPanel> updateSolarPanel(@PathVariable Long id,
                                                       @Valid @RequestBody SolarPanelDTO dto) {
        return ResponseEntity.ok(service.updateSolarPanel(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSolarPanel(@PathVariable Long id) {
        service.deleteSolarPanel(id);
        return ResponseEntity.ok("Solar Panel deleted successfully.");
    }

    @GetMapping("/faults")
    public ResponseEntity<List<String>> getFaults() {
        return ResponseEntity.ok(service.getFaults());
    }

    @GetMapping("/report")
    public ResponseEntity<String> generateDailyReport() {
        return ResponseEntity.ok(service.generateDailyReport());
    }

    @GetMapping("/generation")
    public ResponseEntity<Double> getTotalEnergyGenerated() {
        return ResponseEntity.ok(service.getTotalEnergyGenerated());
    }
}
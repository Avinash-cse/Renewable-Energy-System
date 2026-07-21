package com.skillfirstlab.batteryservice.controller;

import com.skillfirstlab.batteryservice.dto.BatteryDTO;
import com.skillfirstlab.batteryservice.entity.Battery;
import com.skillfirstlab.batteryservice.service.BatteryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battery")
public class BatteryController {

    private final BatteryService service;

    public BatteryController(BatteryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Battery> addBattery(@Valid @RequestBody BatteryDTO dto) {
        return new ResponseEntity<>(service.addBattery(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Battery>> getAllBatteries() {
        return ResponseEntity.ok(service.getAllBatteries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Battery> getBatteryById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBatteryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Battery> updateBattery(@PathVariable Long id,
                                                 @Valid @RequestBody BatteryDTO dto) {
        return ResponseEntity.ok(service.updateBattery(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBattery(@PathVariable Long id) {

        service.deleteBattery(id);

        return ResponseEntity.ok("Battery deleted successfully.");
    }

    @PostMapping("/charge/{id}")
    public ResponseEntity<Battery> chargeBattery(@PathVariable Long id,
                                                 @RequestParam double percentage) {

        return ResponseEntity.ok(service.chargeBattery(id, percentage));
    }

    @PostMapping("/discharge/{id}")
    public ResponseEntity<Battery> dischargeBattery(@PathVariable Long id,
                                                    @RequestParam double percentage) {

        return ResponseEntity.ok(service.dischargeBattery(id, percentage));
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<Double> getBatteryStatus(@PathVariable Long id) {

        return ResponseEntity.ok(service.getBatteryStatus(id));
    }
}
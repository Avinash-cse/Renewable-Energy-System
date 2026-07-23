package com.skillfirstlab.batteryservice.controller;

import com.skillfirstlab.batteryservice.dto.BatteryDTO;
import com.skillfirstlab.batteryservice.entity.Battery;
import com.skillfirstlab.batteryservice.service.BatteryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battery")
public class BatteryController {

    private final BatteryService batteryService;

    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    // Add Battery
    @PostMapping
    public ResponseEntity<Battery> addBattery(@RequestBody BatteryDTO dto) {
        return new ResponseEntity<>(
                batteryService.addBattery(dto),
                HttpStatus.CREATED
        );
    }

    // Get All Batteries
    @GetMapping
    public ResponseEntity<List<Battery>> getAllBatteries() {
        return ResponseEntity.ok(
                batteryService.getAllBatteries()
        );
    }

    // Get Battery By Id
    @GetMapping("/{id}")
    public ResponseEntity<Battery> getBatteryById(@PathVariable Long id) {
        return ResponseEntity.ok(
                batteryService.getBatteryById(id)
        );
    }

    // Update Battery
    @PutMapping("/{id}")
    public ResponseEntity<Battery> updateBattery(
            @PathVariable Long id,
            @RequestBody BatteryDTO dto) {

        return ResponseEntity.ok(
                batteryService.updateBattery(id, dto)
        );
    }

    // Delete Battery
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBattery(@PathVariable Long id) {

        batteryService.deleteBattery(id);

        return ResponseEntity.ok("Battery deleted successfully");
    }

    // Charge Battery
    @PutMapping("/{id}/charge")
    public ResponseEntity<Battery> chargeBattery(
            @PathVariable Long id,
            @RequestParam double percentage) {

        return ResponseEntity.ok(
                batteryService.chargeBattery(id, percentage)
        );
    }

    // Discharge Battery
    @PutMapping("/{id}/discharge")
    public ResponseEntity<Battery> dischargeBattery(
            @PathVariable Long id,
            @RequestParam double percentage) {

        return ResponseEntity.ok(
                batteryService.dischargeBattery(id, percentage)
        );
    }

    // Battery Status
    @GetMapping("/{id}/status")
    public ResponseEntity<Double> getBatteryStatus(@PathVariable Long id) {

        return ResponseEntity.ok(
                batteryService.getBatteryStatus(id)
        );
    }

    // Battery Faults
    @GetMapping("/{id}/faults")
    public ResponseEntity<Object> getBatteryFaults(@PathVariable Long id) {

        return ResponseEntity.ok(
                batteryService.getBatteryFaults(id)
        );
    }

}
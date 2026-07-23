package com.skillfirstlab.distributionservice.controller;

import com.skillfirstlab.distributionservice.entity.DistributionRecord;
import com.skillfirstlab.distributionservice.service.DistributionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distribution")
public class DistributionController {

    private final DistributionService service;

    public DistributionController(DistributionService service) {
        this.service = service;
    }

    // Generate Distribution Record Automatically
    @PostMapping
    public ResponseEntity<DistributionRecord> generateDistribution() {

        DistributionRecord record = service.generateDistribution();

        return ResponseEntity.ok(record);
    }

    // Get All Distribution Records
    @GetMapping
    public ResponseEntity<List<DistributionRecord>> getAllRecords() {

        return ResponseEntity.ok(service.getAllRecords());
    }

    // Get Distribution Record By ID
    @GetMapping("/{id}")
    public ResponseEntity<DistributionRecord> getRecordById(@PathVariable Long id) {

        return ResponseEntity.ok(service.getRecordById(id));
    }

    // Delete Distribution Record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {

        service.deleteRecord(id);

        return ResponseEntity.ok("Distribution Record Deleted Successfully");
    }
}
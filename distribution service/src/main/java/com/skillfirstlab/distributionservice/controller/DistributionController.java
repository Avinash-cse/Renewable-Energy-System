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

    // POST - Add Distribution Record
    @PostMapping
    public ResponseEntity<DistributionRecord> addRecord(@RequestBody DistributionRecord record) {
        return ResponseEntity.ok(service.addRecord(record));
    }

    // Generate Final Output
    @GetMapping("/generate")
    public ResponseEntity<DistributionRecord> generateDistribution() {
        return ResponseEntity.ok(service.generateDistribution());
    }

    // Get All Records
    @GetMapping
    public ResponseEntity<List<DistributionRecord>> getAllRecords() {
        return ResponseEntity.ok(service.getAllRecords());
    }

    // Get Record By ID
    @GetMapping("/{id}")
    public ResponseEntity<DistributionRecord> getRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRecordById(id));
    }

    // Delete Record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
        return ResponseEntity.ok("Record deleted successfully.");
    }
}
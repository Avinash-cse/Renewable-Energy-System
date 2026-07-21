package com.skillfirstlab.distributionservice.service;

import com.skillfirstlab.distributionservice.entity.DistributionRecord;

import java.util.List;

public interface DistributionService {

    // Add new record
    DistributionRecord addRecord(DistributionRecord record);

    // Generate final output
    DistributionRecord generateDistribution();

    // Get all records
    List<DistributionRecord> getAllRecords();

    // Get record by ID
    DistributionRecord getRecordById(Long id);

    // Delete record
    void deleteRecord(Long id);
}
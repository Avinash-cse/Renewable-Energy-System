package com.skillfirstlab.distributionservice.service;

import com.skillfirstlab.distributionservice.entity.DistributionRecord;

import java.util.List;

public interface DistributionService {

    DistributionRecord generateDistribution();

    List<DistributionRecord> getAllRecords();

    DistributionRecord getRecordById(Long id);

    void deleteRecord(Long id);

}
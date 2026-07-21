package com.skillfirstlab.distributionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributionRecordDTO {

    private double totalSolarGeneration;

    private double totalWindGeneration;

    private double totalGeneration;

    private double batteryPercentage;

    private double energyDistributed;

    private String status;
}
package com.skillfirstlab.distributionservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "distribution_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistributionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalSolarGeneration;

    private double totalWindGeneration;

    private double totalGeneration;

    private double batteryPercentage;

    private double energyDistributed;

    private String status;
}
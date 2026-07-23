package com.skillfirstlab.distributionservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
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

    public DistributionRecord() {
    }

    public DistributionRecord(Long id,
                              double totalSolarGeneration,
                              double totalWindGeneration,
                              double totalGeneration,
                              double batteryPercentage,
                              double energyDistributed,
                              String status) {
        this.id = id;
        this.totalSolarGeneration = totalSolarGeneration;
        this.totalWindGeneration = totalWindGeneration;
        this.totalGeneration = totalGeneration;
        this.batteryPercentage = batteryPercentage;
        this.energyDistributed = energyDistributed;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotalSolarGeneration(double totalSolarGeneration) {
        this.totalSolarGeneration = totalSolarGeneration;
    }

    public void setTotalWindGeneration(double totalWindGeneration) {
        this.totalWindGeneration = totalWindGeneration;
    }

    public void setTotalGeneration(double totalGeneration) {
        this.totalGeneration = totalGeneration;
    }

    public void setBatteryPercentage(double batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public void setEnergyDistributed(double energyDistributed) {
        this.energyDistributed = energyDistributed;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
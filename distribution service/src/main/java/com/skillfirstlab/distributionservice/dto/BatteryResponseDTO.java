package com.skillfirstlab.distributionservice.dto;

import lombok.Data;

@Data
public class BatteryResponseDTO {

    private Long id;

    private String deviceName;

    private String location;

    private double capacity;

    private double batteryPercentage;

    private String status;
}
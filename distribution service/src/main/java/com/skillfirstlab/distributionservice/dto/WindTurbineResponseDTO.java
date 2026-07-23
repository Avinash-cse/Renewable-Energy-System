package com.skillfirstlab.distributionservice.dto;

import lombok.Data;

@Data
public class WindTurbineResponseDTO {

    private Long id;

    private String deviceName;

    private String location;

    private double capacity;

    private double generation;

    private String status;
}
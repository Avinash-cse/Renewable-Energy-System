package com.skillfirstlab.solarservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolarPanelDTO {

    @NotBlank(message = "Device name is required")
    private String deviceName;

    @NotBlank(message = "Location is required")
    private String location;

    @Positive(message = "Capacity must be greater than zero")
    private double capacity;

    @PositiveOrZero(message = "Generation cannot be negative")
    private double generation;

    private String status;
}
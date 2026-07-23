package com.skillfirstlab.solarservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solar_panels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolarPanel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
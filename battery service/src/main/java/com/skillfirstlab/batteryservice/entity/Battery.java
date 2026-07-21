package com.skillfirstlab.batteryservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "batteries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Device name is required")
    private String deviceName;

    @NotBlank(message = "Location is required")
    private String location;

    @Positive(message = "Capacity must be greater than 0")
    private double capacity;

    @Min(value = 0, message = "Battery percentage cannot be less than 0")
    @Max(value = 100, message = "Battery percentage cannot exceed 100")
    private double batteryPercentage;

    private String status;
}
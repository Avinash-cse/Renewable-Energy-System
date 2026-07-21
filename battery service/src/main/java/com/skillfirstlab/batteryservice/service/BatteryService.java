package com.skillfirstlab.batteryservice.service;

import com.skillfirstlab.batteryservice.dto.BatteryDTO;
import com.skillfirstlab.batteryservice.entity.Battery;

import java.util.List;

public interface BatteryService {

    Battery addBattery(BatteryDTO batteryDTO);

    List<Battery> getAllBatteries();

    Battery getBatteryById(Long id);

    Battery updateBattery(Long id, BatteryDTO batteryDTO);

    void deleteBattery(Long id);

    Battery chargeBattery(Long id, double percentage);

    Battery dischargeBattery(Long id, double percentage);

    double getBatteryStatus(Long id);
}
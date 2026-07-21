package com.skillfirstlab.batteryservice.service;

import com.skillfirstlab.batteryservice.dto.BatteryDTO;
import com.skillfirstlab.batteryservice.entity.Battery;
import com.skillfirstlab.batteryservice.exception.BatteryNotFoundException;
import com.skillfirstlab.batteryservice.repository.BatteryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository repository;

    public BatteryServiceImpl(BatteryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Battery addBattery(BatteryDTO dto) {

        Battery battery = new Battery();

        battery.setDeviceName(dto.getDeviceName());
        battery.setLocation(dto.getLocation());
        battery.setCapacity(dto.getCapacity());
        battery.setBatteryPercentage(dto.getBatteryPercentage());
        battery.setStatus(dto.getStatus());

        return repository.save(battery);
    }

    @Override
    public List<Battery> getAllBatteries() {
        return repository.findAll();
    }

    @Override
    public Battery getBatteryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new BatteryNotFoundException("Battery not found with id : " + id));
    }

    @Override
    public Battery updateBattery(Long id, BatteryDTO dto) {

        Battery battery = getBatteryById(id);

        battery.setDeviceName(dto.getDeviceName());
        battery.setLocation(dto.getLocation());
        battery.setCapacity(dto.getCapacity());
        battery.setBatteryPercentage(dto.getBatteryPercentage());
        battery.setStatus(dto.getStatus());

        return repository.save(battery);
    }

    @Override
    public void deleteBattery(Long id) {

        Battery battery = getBatteryById(id);

        repository.delete(battery);
    }

    @Override
    public Battery chargeBattery(Long id, double percentage) {

        Battery battery = getBatteryById(id);

        battery.setBatteryPercentage(
                Math.min(100, battery.getBatteryPercentage() + percentage));

        return repository.save(battery);
    }

    @Override
    public Battery dischargeBattery(Long id, double percentage) {

        Battery battery = getBatteryById(id);

        battery.setBatteryPercentage(
                Math.max(0, battery.getBatteryPercentage() - percentage));

        return repository.save(battery);
    }

    @Override
    public double getBatteryStatus(Long id) {

        return getBatteryById(id).getBatteryPercentage();
    }
}
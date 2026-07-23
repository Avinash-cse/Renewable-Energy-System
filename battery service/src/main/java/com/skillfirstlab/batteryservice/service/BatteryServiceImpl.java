package com.skillfirstlab.batteryservice.service;

import com.skillfirstlab.batteryservice.dto.BatteryDTO;
import com.skillfirstlab.batteryservice.entity.Battery;
import com.skillfirstlab.batteryservice.exception.BatteryNotFoundException;
import com.skillfirstlab.batteryservice.repository.BatteryRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class BatteryServiceImpl implements BatteryService {


    private final BatteryRepository repository;

    private final RestTemplate restTemplate;


    public BatteryServiceImpl(
            BatteryRepository repository,
            RestTemplate restTemplate) {

        this.repository = repository;
        this.restTemplate = restTemplate;
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
                        new BatteryNotFoundException(
                                "Battery not found with id : " + id
                        ));
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


        double current =
                battery.getBatteryPercentage();


        double updated =
                Math.min(100, current + percentage);


        battery.setBatteryPercentage(updated);


        return repository.save(battery);
    }



    @Override
    public Battery dischargeBattery(Long id, double percentage) {

        Battery battery = getBatteryById(id);


        double current =
                battery.getBatteryPercentage();


        double updated =
                Math.max(0, current - percentage);


        battery.setBatteryPercentage(updated);


        return repository.save(battery);
    }



    @Override
    public double getBatteryStatus(Long id) {

        Battery battery = getBatteryById(id);

        return battery.getBatteryPercentage();
    }



    // ============================
    // Retrieve Faults using REST
    // ============================

    @Override
    public Object getBatteryFaults(Long id) {


        // Fault microservice URL
        String url =
                "http://localhost:8082/api/faults/battery/" + id;


        return restTemplate.getForObject(
                url,
                Object.class
        );
    }

}
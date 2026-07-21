package com.skillfirstlab.distributionservice.service;

import com.skillfirstlab.distributionservice.dto.BatteryResponseDTO;
import com.skillfirstlab.distributionservice.dto.SolarPanelResponseDTO;
import com.skillfirstlab.distributionservice.dto.WindTurbineResponseDTO;
import com.skillfirstlab.distributionservice.entity.DistributionRecord;
import com.skillfirstlab.distributionservice.exception.DistributionNotFoundException;
import com.skillfirstlab.distributionservice.repository.DistributionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DistributionServiceImpl implements DistributionService {

    private final DistributionRepository repository;
    private final RestTemplate restTemplate;

    public DistributionServiceImpl(DistributionRepository repository,
                                   RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    // POST - Add Distribution Record
    @Override
    public DistributionRecord addRecord(DistributionRecord record) {
        return repository.save(record);
    }

    // Generate Final Distribution
    @Override
    public DistributionRecord generateDistribution() {

        SolarPanelResponseDTO[] solar =
                restTemplate.getForObject(
                        "http://localhost:8081/solar-panels",
                        SolarPanelResponseDTO[].class);

        WindTurbineResponseDTO[] wind =
                restTemplate.getForObject(
                        "http://localhost:8082/wind-turbines",
                        WindTurbineResponseDTO[].class);

        BatteryResponseDTO battery =
                restTemplate.getForObject(
                        "http://localhost:8083/battery/1",
                        BatteryResponseDTO.class);

        double totalSolar = Arrays.stream(solar)
                .mapToDouble(SolarPanelResponseDTO::getGeneration)
                .sum();

        double totalWind = Arrays.stream(wind)
                .mapToDouble(WindTurbineResponseDTO::getGeneration)
                .sum();

        double totalGeneration = totalSolar + totalWind;

        DistributionRecord record = new DistributionRecord();

        record.setTotalSolarGeneration(totalSolar);
        record.setTotalWindGeneration(totalWind);
        record.setTotalGeneration(totalGeneration);

        if (battery != null) {
            record.setBatteryPercentage(battery.getBatteryPercentage());
        } else {
            record.setBatteryPercentage(0);
        }

        record.setEnergyDistributed(totalGeneration);

        if (totalGeneration > 0) {
            record.setStatus("ENERGY DISTRIBUTED");
        } else {
            record.setStatus("NO GENERATION");
        }

        return repository.save(record);
    }

    @Override
    public List<DistributionRecord> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public DistributionRecord getRecordById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new DistributionNotFoundException(
                                "Record not found with id : " + id));
    }

    @Override
    public void deleteRecord(Long id) {
        DistributionRecord record = getRecordById(id);
        repository.delete(record);
    }
}
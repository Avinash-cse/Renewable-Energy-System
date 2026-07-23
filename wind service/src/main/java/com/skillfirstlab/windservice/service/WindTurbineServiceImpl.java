package com.skillfirstlab.windservice.service;

import com.skillfirstlab.windservice.dto.WindTurbineDTO;
import com.skillfirstlab.windservice.entity.WindTurbine;
import com.skillfirstlab.windservice.exception.WindTurbineNotFoundException;
import com.skillfirstlab.windservice.repository.WindTurbineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WindTurbineServiceImpl implements WindTurbineService {

    private final WindTurbineRepository repository;

    public WindTurbineServiceImpl(WindTurbineRepository repository) {
        this.repository = repository;
    }

    @Override
    public WindTurbine addWindTurbine(WindTurbineDTO dto) {

        WindTurbine turbine = new WindTurbine();

        turbine.setDeviceName(dto.getDeviceName());
        turbine.setLocation(dto.getLocation());
        turbine.setCapacity(dto.getCapacity());
        turbine.setGeneration(dto.getGeneration());
        turbine.setStatus(dto.getStatus());

        return repository.save(turbine);
    }

    @Override
    public List<WindTurbine> getAllWindTurbines() {
        return repository.findAll();
    }

    @Override
    public WindTurbine getWindTurbineById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new WindTurbineNotFoundException("Wind Turbine not found with id : " + id));
    }

    @Override
    public WindTurbine updateWindTurbine(Long id, WindTurbineDTO dto) {

        WindTurbine turbine = repository.findById(id)
                .orElseThrow(() ->
                        new WindTurbineNotFoundException("Wind Turbine not found with id : " + id));

        turbine.setDeviceName(dto.getDeviceName());
        turbine.setLocation(dto.getLocation());
        turbine.setCapacity(dto.getCapacity());
        turbine.setGeneration(dto.getGeneration());
        turbine.setStatus(dto.getStatus());

        return repository.save(turbine);
    }

    @Override
    public void deleteWindTurbine(Long id) {

        WindTurbine turbine = repository.findById(id)
                .orElseThrow(() ->
                        new WindTurbineNotFoundException("Wind Turbine not found with id : " + id));

        repository.delete(turbine);
    }

    // =========================
    // New Functionalities
    // =========================

    @Override
    public List<String> getFaults() {

        return repository.findAll()
                .stream()
                .filter(turbine -> turbine.getStatus().equalsIgnoreCase("FAULT"))
                .map(turbine -> "Turbine ID: " + turbine.getId()
                        + ", Device: " + turbine.getDeviceName()
                        + ", Location: " + turbine.getLocation())
                .collect(Collectors.toList());
    }

    @Override
    public String generateDailyReport() {

        List<WindTurbine> turbines = repository.findAll();

        int totalTurbines = turbines.size();

        double totalGeneration = turbines.stream()
                .mapToDouble(WindTurbine::getGeneration)
                .sum();

        long faultyTurbines = turbines.stream()
                .filter(turbine -> turbine.getStatus().equalsIgnoreCase("FAULT"))
                .count();

        return "Daily Wind Report\n"
                + "---------------------------\n"
                + "Total Turbines    : " + totalTurbines + "\n"
                + "Total Generation : " + totalGeneration + " kWh\n"
                + "Faulty Turbines  : " + faultyTurbines;
    }

    @Override
    public double getTotalEnergyGenerated() {

        return repository.findAll()
                .stream()
                .mapToDouble(WindTurbine::getGeneration)
                .sum();
    }
}
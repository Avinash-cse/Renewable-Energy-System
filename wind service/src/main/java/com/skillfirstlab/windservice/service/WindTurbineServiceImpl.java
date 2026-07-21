package com.skillfirstlab.windservice.service;

import com.skillfirstlab.windservice.dto.WindTurbineDTO;
import com.skillfirstlab.windservice.entity.WindTurbine;
import com.skillfirstlab.windservice.exception.WindTurbineNotFoundException;
import com.skillfirstlab.windservice.repository.WindTurbineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WindTurbineServiceImpl implements WindTurbineService {

    private final WindTurbineRepository repository;

    public WindTurbineServiceImpl(WindTurbineRepository repository) {
        this.repository = repository;
    }

    @Override
    public WindTurbine addWindTurbine(WindTurbineDTO dto) {

        WindTurbine wind = new WindTurbine();

        wind.setDeviceName(dto.getDeviceName());
        wind.setLocation(dto.getLocation());
        wind.setCapacity(dto.getCapacity());
        wind.setGeneration(dto.getGeneration());
        wind.setStatus(dto.getStatus());

        return repository.save(wind);
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

        WindTurbine wind = repository.findById(id)
                .orElseThrow(() ->
                        new WindTurbineNotFoundException("Wind Turbine not found with id : " + id));

        wind.setDeviceName(dto.getDeviceName());
        wind.setLocation(dto.getLocation());
        wind.setCapacity(dto.getCapacity());
        wind.setGeneration(dto.getGeneration());
        wind.setStatus(dto.getStatus());

        return repository.save(wind);
    }

    @Override
    public void deleteWindTurbine(Long id) {

        WindTurbine wind = repository.findById(id)
                .orElseThrow(() ->
                        new WindTurbineNotFoundException("Wind Turbine not found with id : " + id));

        repository.delete(wind);
    }
}
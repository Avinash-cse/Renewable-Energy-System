package com.skillfirstlab.windservice.service;

import com.skillfirstlab.windservice.dto.WindTurbineDTO;
import com.skillfirstlab.windservice.entity.WindTurbine;

import java.util.List;

public interface WindTurbineService {

    WindTurbine addWindTurbine(WindTurbineDTO windTurbineDTO);

    List<WindTurbine> getAllWindTurbines();

    WindTurbine getWindTurbineById(Long id);

    WindTurbine updateWindTurbine(Long id, WindTurbineDTO windTurbineDTO);

    void deleteWindTurbine(Long id);

    List<String> getFaults();

    String generateDailyReport();

    double getTotalEnergyGenerated();
}
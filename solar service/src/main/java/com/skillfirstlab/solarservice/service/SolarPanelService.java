package com.skillfirstlab.solarservice.service;

import com.skillfirstlab.solarservice.dto.SolarPanelDTO;
import com.skillfirstlab.solarservice.entity.SolarPanel;

import java.util.List;

public interface SolarPanelService {

    // CRUD Operations
    SolarPanel addSolarPanel(SolarPanelDTO solarPanelDTO);

    List<SolarPanel> getAllSolarPanels();

    SolarPanel getSolarPanelById(Long id);

    SolarPanel updateSolarPanel(Long id, SolarPanelDTO solarPanelDTO);

    void deleteSolarPanel(Long id);

    // Retrieve all faults in solar panels
    List<String> getFaults();

    // Generate daily solar production report
    String generateDailyReport();

    // Calculate total energy produced
    double getTotalEnergyGenerated();
}
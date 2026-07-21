package com.skillfirstlab.solarservice.service;

import com.skillfirstlab.solarservice.dto.SolarPanelDTO;
import com.skillfirstlab.solarservice.entity.SolarPanel;

import java.util.List;

public interface SolarPanelService {

    SolarPanel addSolarPanel(SolarPanelDTO solarPanelDTO);

    List<SolarPanel> getAllSolarPanels();

    SolarPanel getSolarPanelById(Long id);

    SolarPanel updateSolarPanel(Long id, SolarPanelDTO solarPanelDTO);

    void deleteSolarPanel(Long id);
}
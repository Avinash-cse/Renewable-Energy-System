package com.skillfirstlab.solarservice.service;

import com.skillfirstlab.solarservice.dto.SolarPanelDTO;
import com.skillfirstlab.solarservice.entity.SolarPanel;
import com.skillfirstlab.solarservice.exception.SolarPanelNotFoundException;
import com.skillfirstlab.solarservice.repository.SolarPanelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolarPanelServiceImpl implements SolarPanelService {

    private final SolarPanelRepository repository;

    public SolarPanelServiceImpl(SolarPanelRepository repository) {
        this.repository = repository;
    }

    @Override
    public SolarPanel addSolarPanel(SolarPanelDTO dto) {

        SolarPanel solarPanel = new SolarPanel();

        solarPanel.setDeviceName(dto.getDeviceName());
        solarPanel.setLocation(dto.getLocation());
        solarPanel.setCapacity(dto.getCapacity());
        solarPanel.setGeneration(dto.getGeneration());
        solarPanel.setStatus(dto.getStatus());

        return repository.save(solarPanel);
    }

    @Override
    public List<SolarPanel> getAllSolarPanels() {
        return repository.findAll();
    }

    @Override
    public SolarPanel getSolarPanelById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new SolarPanelNotFoundException("Solar Panel not found with id : " + id));
    }

    @Override
    public SolarPanel updateSolarPanel(Long id, SolarPanelDTO dto) {

        SolarPanel solarPanel = repository.findById(id)
                .orElseThrow(() ->
                        new SolarPanelNotFoundException("Solar Panel not found with id : " + id));

        solarPanel.setDeviceName(dto.getDeviceName());
        solarPanel.setLocation(dto.getLocation());
        solarPanel.setCapacity(dto.getCapacity());
        solarPanel.setGeneration(dto.getGeneration());
        solarPanel.setStatus(dto.getStatus());

        return repository.save(solarPanel);
    }

    @Override
    public void deleteSolarPanel(Long id) {

        SolarPanel solarPanel = repository.findById(id)
                .orElseThrow(() ->
                        new SolarPanelNotFoundException("Solar Panel not found with id : " + id));

        repository.delete(solarPanel);
    }

    // ==========================
    // New Functionality
    // ==========================

    @Override
    public List<String> getFaults() {

        return repository.findAll()
                .stream()
                .filter(panel -> panel.getStatus().equalsIgnoreCase("FAULT"))
                .map(panel -> "Panel ID: " + panel.getId()
                        + ", Device: " + panel.getDeviceName()
                        + ", Location: " + panel.getLocation())
                .collect(Collectors.toList());
    }

    @Override
    public String generateDailyReport() {

        List<SolarPanel> panels = repository.findAll();

        int totalPanels = panels.size();

        double totalGeneration = panels.stream()
                .mapToDouble(SolarPanel::getGeneration)
                .sum();

        long faultyPanels = panels.stream()
                .filter(panel -> panel.getStatus().equalsIgnoreCase("FAULT"))
                .count();

        return "Daily Solar Report\n"
                + "---------------------------\n"
                + "Total Panels      : " + totalPanels + "\n"
                + "Total Generation  : " + totalGeneration + " kWh\n"
                + "Faulty Panels     : " + faultyPanels;
    }

    @Override
    public double getTotalEnergyGenerated() {

        return repository.findAll()
                .stream()
                .mapToDouble(SolarPanel::getGeneration)
                .sum();
    }
}
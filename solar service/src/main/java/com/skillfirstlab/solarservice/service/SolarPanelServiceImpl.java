package com.skillfirstlab.solarservice.service;

import com.skillfirstlab.solarservice.dto.SolarPanelDTO;
import com.skillfirstlab.solarservice.entity.SolarPanel;
import com.skillfirstlab.solarservice.exception.SolarPanelNotFoundException;
import com.skillfirstlab.solarservice.repository.SolarPanelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
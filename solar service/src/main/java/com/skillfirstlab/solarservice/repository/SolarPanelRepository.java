package com.skillfirstlab.solarservice.repository;

import com.skillfirstlab.solarservice.entity.SolarPanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarPanelRepository extends JpaRepository<SolarPanel, Long> {

}
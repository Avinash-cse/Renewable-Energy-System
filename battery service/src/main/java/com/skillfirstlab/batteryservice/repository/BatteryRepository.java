package com.skillfirstlab.batteryservice.repository;

import com.skillfirstlab.batteryservice.entity.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {
}
package com.skillfirstlab.distributionservice.repository;

import com.skillfirstlab.distributionservice.entity.DistributionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionRepository extends JpaRepository<DistributionRecord, Long> {

}